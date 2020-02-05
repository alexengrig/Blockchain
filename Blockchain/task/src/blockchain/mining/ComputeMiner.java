package blockchain.mining;

import blockchain.block.Block;
import blockchain.block.ImmutableBlock;
import blockchain.block.PartBlockParams;
import blockchain.block.SimpleBlockParams;
import blockchain.hash.HashApprover;
import blockchain.hash.HashFunction;

import java.util.Random;

import static blockchain.util.CommonUtils.getTimestamp;

public class ComputeMiner implements Miner {
    private final String name;
    private final HashFunction hashFunction;
    private final HashApprover hashApprover;
    private final PartBlockParams blockParams;
    private final Random random;

    public ComputeMiner(MinerParams params) {
        this.name = params.getName();
        this.hashFunction = params.getHashFunction();
        this.hashApprover = params.getHashApprover();
        this.blockParams = params.getBlockParams();
        this.random = getRandom();
    }

    protected Random getRandom() {
        return new Random();
    }

    @Override
    public Block mine() {
        long magicNumber;
        String hash;
        long start = getTimestamp();
        do {
            magicNumber = random.nextLong();
            hash = hashFunction.hash(magicNumber);
            if (Thread.currentThread().isInterrupted()) {
                return ImmutableBlock.EMPTY;
            }
        } while (!hashApprover.approve(hash));
        long end = getTimestamp();
        SimpleBlockParams params = new SimpleBlockParams(blockParams);
        params.setTimestamp(getTimestamp());
        params.setRuntime(end - start);
        params.setMagicNumber(magicNumber);
        params.setHash(hash);
        params.setOwner(name);
        return new ImmutableBlock(params);
    }
}
