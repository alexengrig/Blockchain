package blockchain;

import blockchain.block.Block;
import blockchain.block.ImmutablePartBlockParams;
import blockchain.block.NZerosBlock;
import blockchain.block.PartBlockParams;
import blockchain.data.Data;
import blockchain.data.DataParams;
import blockchain.data.ImmutableDataParams;
import blockchain.data.SignedData;
import blockchain.hash.HashApprover;
import blockchain.hash.NZerosHashApprover;

import java.util.*;

public class NZerosBlockchain implements Blockchain<Block, SignedData> {
    protected final Deque<Block> blocks;
    protected final Deque<SignedData> dataSet;
    protected final Object lock = new Object();
    protected long blockId;
    protected long dataId;
    protected NZeros nZeros;
    protected NZerosHashApprover approver;
    protected PartBlockParams blockParams;

    public NZerosBlockchain() {
        blocks = new ArrayDeque<>();
        dataSet = new ArrayDeque<>();
        blockId = 1;
        dataId = 1;
        nZeros = new NZeros(0);
        prepareNext();
    }

    protected void prepareNext() {
        dataSet.clear();
        approver = new NZerosHashApprover(nZeros.getCount());
        blockParams = new ImmutablePartBlockParams(blockId++, getLastHash());
    }

    protected String getLastHash() {
        Block last = blocks.peekLast();
        return last != null ? last.getHash() : "0";
    }

    @Override
    public HashApprover getApprover() {
        return approver;
    }

    @Override
    public PartBlockParams getNextBlockParams() {
        return blockParams;
    }

    @Override
    public synchronized DataParams getNextDataParams() {
        return new ImmutableDataParams(dataId++);
    }

    @Override
    public boolean include(Block block) {
        synchronized (lock) {
            String previousHash = getLastHash();
            if (!previousHash.equals(block.getPreviousHash())) {
                return false;
            }
            String nStatus = nZeros.getNextStatus();
            List<Data> data = new ArrayList<>(dataSet);
            NZerosBlock nextBlock = new NZerosBlock(block, nStatus, data);
            blocks.add(nextBlock);
            prepareNext();
            lock.notifyAll();
        }
        return true;
    }

    @Override
    public boolean store(SignedData data) {
        synchronized (lock) {
            while (blocks.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    return false;
                }
            }
            if (data.getId() >= blockId) {
                return dataSet.add(data);
            } else {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n\n");
        for (Block block : blocks) {
            joiner.add(block.toString());
        }
        return joiner.toString();
    }
}
