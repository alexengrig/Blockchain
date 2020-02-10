package blockchain.block;

import blockchain.data.Data;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class NZerosBlock extends ImmutableBlock {
    protected final String nStatus;
    protected final List<Data> dataSet;

    public NZerosBlock(Block block, String nStatus, List<Data> dataSet) {
        super(block);
        this.nStatus = nStatus;
        this.dataSet = dataSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NZerosBlock that = (NZerosBlock) o;
        return Objects.equals(nStatus, that.nStatus) &&
                Objects.equals(dataSet, that.dataSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nStatus, dataSet);
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
                .add(String.format("Block data:%s", dataSet.isEmpty()
                        ? " no messages"
                        : "\n" + dataSet.stream().map(Objects::toString).collect(Collectors.joining("\n"))))
                .add("Block was generating for " + runtime / 1000 + " seconds")
                .add(nStatus)
                .toString();
    }
}
