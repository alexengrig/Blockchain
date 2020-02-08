package blockchain;

import blockchain.block.Block;
import blockchain.block.ImmutablePartBlockParams;
import blockchain.block.NZerosBlock;
import blockchain.block.PartBlockParams;
import blockchain.hash.HashApprover;
import blockchain.hash.NZerosHashApprover;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

public class NZerosBlockchain implements Blockchain {
    protected final Deque<Block> blocks = new ArrayDeque<>();

    protected long id;
    protected NZeros nZeros;
    protected NZerosHashApprover approver;
    protected PartBlockParams params;
    protected StringJoiner dataStore;

    public NZerosBlockchain() {
        this.id = 0;
        this.nZeros = new NZeros(0);
        prepareNext();
    }

    private void prepareNext() {
        this.approver = new NZerosHashApprover(nZeros.getCount());
        this.params = new ImmutablePartBlockParams(id++, getLastHash());
        this.dataStore = new StringJoiner("\n");
    }

    @Override
    public HashApprover getApprover() {
        return approver;
    }

    @Override
    public PartBlockParams getNextParams() {
        return params;
    }

    @Override
    public boolean accept(Block block) {
        String previousHash = getLastHash();
        if (!previousHash.equals(block.getPreviousHash())) {
            return false;
        }
        synchronized (this) {
            String nStatus = nZeros.getNextStatus();
            String data = dataStore.toString();
            NZerosBlock nextBlock = new NZerosBlock(block, nStatus, data);
            blocks.add(nextBlock);
            prepareNext();
        }
        return true;
    }

    private String getLastHash() {
        Block last = blocks.peekLast();
        return last != null ? last.getHash() : "0";
    }

    @Override
    public synchronized void include(String data) {
        if (!blocks.isEmpty()) {
            dataStore.add(data);
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
