package blockchain;

import blockchain.block.Block;
import blockchain.block.PartBlockParams;
import blockchain.hash.HashApprover;
import blockchain.hash.HashFunction;
import blockchain.hash.SHA256HashFunction;
import blockchain.mining.ComputeMiner;
import blockchain.mining.SimpleMinerParams;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    private static final int NUMBER_OF_MINERS = 4;
    private static final int NUMBER_OF_BLOCKS = 5;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final NZerosBlockchain blockchain = new NZerosBlockchain();
        final ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_MINERS);
        final HashFunction hashFunction = new SHA256HashFunction();
        final SimpleMinerParams minerParams = new SimpleMinerParams();
        minerParams.setHashFunction(hashFunction);
        for (int count = 0; count < NUMBER_OF_BLOCKS; count++) {
            final HashApprover hashApprover = blockchain.getApprover();
            minerParams.setHashApprover(hashApprover);
            PartBlockParams blockParams = blockchain.getNextParams();
            minerParams.setBlockParams(blockParams);
            final List<Callable<Block>> tasks = new ArrayList<>(NUMBER_OF_MINERS);
            for (int j = 0; j < NUMBER_OF_MINERS; j++) {
                minerParams.setName("# " + j);
                final ComputeMiner miner = new ComputeMiner(minerParams);
                tasks.add(miner::mine);
            }
            final Block block = executorService.invokeAny(tasks);
            if (!blockchain.accept(block)) {
                --count;
            }
        }
        System.out.println(blockchain);
        executorService.shutdown();
        if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}
