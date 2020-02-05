package blockchain.mining;

import blockchain.block.PartBlockParams;
import blockchain.hash.HashApprover;
import blockchain.hash.HashFunction;

public interface MinerParams {
    String getName();

    HashFunction getHashFunction();

    HashApprover getHashApprover();

    PartBlockParams getBlockParams();
}
