package blockchain;

import java.util.Date;
import java.util.Random;

public class SimpleBlockFactory implements BlockFactory {
    protected int id;
    protected Block previous;
    protected int numberOfZeros;
    protected Random random;

    public SimpleBlockFactory(int numberOfZeros) {
        this(0, null, numberOfZeros, new Random());
    }

    protected SimpleBlockFactory(int id, Block previous, int numberOfZeros, Random random) {
        this.id = id;
        this.previous = previous;
        this.numberOfZeros = numberOfZeros;
        this.random = random;
    }

    @Override
    public Block generate() {
        int id = getId();
        long timestamp = getTimestamp();
        String previousHash = getPreviousHash();
        String hash;
        long magicNumber;
        long start = getTimestamp();
        do {
            magicNumber = getMagicNumber();
            hash = getHash(String.valueOf(magicNumber));
        } while (!isProved(hash));
        long end = getTimestamp();
        long runtime = end - start;
        Block block = new SimpleBlock(id, timestamp, magicNumber, previousHash, hash, runtime);
        previous = block;
        return block;
    }

    protected int getId() {
        return id++;
    }

    protected long getTimestamp() {
        return new Date().getTime();
    }

    protected long getMagicNumber() {
        return random.nextLong();
    }

    protected String getPreviousHash() {
        if (previous != null) {
            return previous.getHash();
        } else {
            return "0";
        }
    }

    protected String getHash(String input) {
        return StringUtil.applySha256(input);
    }

    protected boolean isProved(String hash) {
        return hash.startsWith("0".repeat(numberOfZeros));
    }
}
