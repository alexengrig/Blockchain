package blockchain.mining;

import blockchain.block.Block;

@FunctionalInterface
public interface Miner {
    Block mine();
}
