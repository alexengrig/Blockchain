package blockchain;

import blockchain.block.Block;
import blockchain.block.PartBlockParams;
import blockchain.data.Data;
import blockchain.data.DataParams;
import blockchain.hash.HashApprover;
import blockchain.reward.Reward;

public interface Blockchain<B extends Block, D extends Data> {
    HashApprover getApprover();

    PartBlockParams getNextBlockParams();

    DataParams getNextDataParams();

    Reward include(B block);

    boolean store(D data);
}
