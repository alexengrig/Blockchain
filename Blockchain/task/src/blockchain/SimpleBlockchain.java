package blockchain;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

public class SimpleBlockchain implements Blockchain {
    private final BlockFactory blockFactory;
    private final Deque<Block> blocks;

    public SimpleBlockchain(int n) {
        blockFactory = new SimpleBlockFactory(n);
        blocks = new ArrayDeque<>();
    }

    @Override
    public Block generateNewBlock() {
        Block block = blockFactory.generate();
        blocks.add(block);
        return block;
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
