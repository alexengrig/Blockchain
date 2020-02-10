package blockchain;

import blockchain.block.Block;
import blockchain.block.PartBlockParams;
import blockchain.data.Data;
import blockchain.data.DataParams;
import blockchain.hash.HashApprover;

public interface Blockchain<B extends Block, D extends Data> {
    HashApprover getApprover();

    PartBlockParams getNextBlockParams();

    DataParams getNextDataParams();

    boolean include(B block);

    boolean store(D data);
}
