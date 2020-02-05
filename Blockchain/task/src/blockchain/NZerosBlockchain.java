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

    public NZerosBlockchain() {
        this.id = 0;
        this.nZeros = new NZeros(0);
        this.approver = new NZerosHashApprover(nZeros.getCount());
        this.params = new ImmutablePartBlockParams(id, getLastHash());
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
        String nStatus = nZeros.getNextStatus();
        NZerosBlock nextBlock = new NZerosBlock(block, nStatus);
        blocks.add(nextBlock);
        prepareNext();
        return true;
    }

    private void prepareNext() {
        ++id;
        approver = new NZerosHashApprover(nZeros.getCount());
        params = new ImmutablePartBlockParams(id, getLastHash());
    }

    private String getLastHash() {
        Block last = blocks.peekLast();
        return last != null ? last.getHash() : "0";
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
