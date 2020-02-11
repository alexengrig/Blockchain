package blockchain.block;

import blockchain.data.Data;
import blockchain.reward.Reward;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class NZerosBlock extends ImmutableBlock {
    protected final String nStatus;
    protected final List<Data> dataSet;
    protected final Reward reward;

    public NZerosBlock(Block block, String nStatus, List<Data> dataSet, Reward reward) {
        super(block);
        this.nStatus = nStatus;
        this.dataSet = dataSet;
        this.reward = reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NZerosBlock that = (NZerosBlock) o;
        return reward == that.reward &&
                Objects.equals(nStatus, that.nStatus) &&
                Objects.equals(dataSet, that.dataSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nStatus, dataSet, reward);
    }

    @Override
    public String toString() {
        return new StringJoiner("\n")
                .add("Block:")
                .add("Created by: " + owner)
                .add(owner + " gets " + reward)
                .add("Id: " + id)
                .add("Timestamp: " + timestamp)
                .add("Magic number: " + magicNumber)
                .add("Hash of the previous block:")
                .add(previousHash)
                .add("Hash of the block:")
                .add(hash)
                .add("Block data:")
                .add(dataSet.isEmpty()
                        ? "No transactions"
                        : dataSet.stream().map(Objects::toString).collect(Collectors.joining("\n")))
                .add("Block was generating for " + runtime / 1000 + " seconds")
                .add(nStatus)
                .toString();
    }
}
