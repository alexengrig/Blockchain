package blockchain;

import java.util.StringJoiner;

public abstract class BaseBlock implements Block {
    protected int id;
    protected long timestamp;
    protected long magicNumber;
    protected String previousHash;
    protected String hash;
    protected long runtime;

    public BaseBlock(int id, long timestamp, long magicNumber, String previousHash, String hash, long runtime) {
        this.id = id;
        this.timestamp = timestamp;
        this.magicNumber = magicNumber;
        this.previousHash = previousHash;
        this.hash = hash;
        this.runtime = runtime;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public long getMagicNumber() {
        return magicNumber;
    }

    @Override
    public String getPreviousHash() {
        return previousHash;
    }

    @Override
    public String getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return new StringJoiner("\n")
                .add("Block:")
                .add("Id: " + id)
                .add("Timestamp: " + timestamp)
                .add("Magic number: " + magicNumber)
                .add("Hash of the previous block:")
                .add(previousHash)
                .add("Hash of the block:")
                .add(hash)
                .add("Block was generating for " + runtime + " seconds")
                .toString();
    }
}
