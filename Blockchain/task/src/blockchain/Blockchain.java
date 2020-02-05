package blockchain;

import blockchain.block.Block;
import blockchain.block.PartBlockParams;
import blockchain.hash.HashApprover;

public interface Blockchain {
    HashApprover getApprover();

    PartBlockParams getNextParams();

    boolean accept(Block block);
}
