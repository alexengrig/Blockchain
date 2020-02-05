package blockchain.block;

import java.util.Objects;
import java.util.StringJoiner;

public class NZerosBlock extends ImmutableBlock {
    protected final String nStatus;

    public NZerosBlock(Block block, String nStatus) {
        super(block);
        this.nStatus = nStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NZerosBlock that = (NZerosBlock) o;
        return Objects.equals(nStatus, that.nStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nStatus);
    }

    @Override
    public String toString() {
        return new StringJoiner("\n")
                .add("Block:")
                .add("Created by miner " + owner)
                .add("Id: " + id)
                .add("Timestamp: " + timestamp)
                .add("Magic number: " + magicNumber)
                .add("Hash of the previous block:")
                .add(previousHash)
                .add("Hash of the block:")
                .add(hash)
                .add("Block was generating for " + runtime / 1000 + " seconds")
                .add(nStatus)
                .toString();
    }
}
