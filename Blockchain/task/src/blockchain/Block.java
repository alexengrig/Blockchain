package blockchain;

import java.util.StringJoiner;

public class Block {
    public final int id;
    public final long timestamp;
    public final String hash;
    public final String previous;

    public Block(int id, long timestamp, String hash) {
        this(id, timestamp, hash, "0");
    }

    public Block(int id, long timestamp, String hash, String previous) {
        this.id = id;
        this.timestamp = timestamp;
        this.hash = hash;
        this.previous = previous;
    }

    @Override
    public String toString() {
        return new StringJoiner("\n")
                .add("Block:")
                .add("Id: " + id)
                .add("Timestamp: " + timestamp)
                .add("Hash of the previous block:")
                .add(previous)
                .add("Hash of the block:")
                .add(hash)
                .toString();
    }
}
