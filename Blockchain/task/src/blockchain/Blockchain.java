package blockchain;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.StringJoiner;

public class Blockchain {
    private final Deque<Block> blocks = new ArrayDeque<>();

    private int blockId = 1;

    public void generateNewBlock() {
        Block last = getLast();
        Block next;
        if (last == null) {
            next = new Block(getId(), getTimestamp(), getHash());
        } else {
            next = new Block(getId(), getTimestamp(), getHash(), last.hash);
        }
        blocks.add(next);
    }

    protected Block getLast() {
        return blocks.peekLast();
    }

    protected int getId() {
        return blockId++;
    }

    protected long getTimestamp() {
        return new Date().getTime();
    }

    protected String getHash() {
        return StringUtil.applySha256(String.valueOf(new Date().getTime() + blockId));
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
