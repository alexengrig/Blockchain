package blockchain;

public class SimpleBlock extends BaseBlock {
    public SimpleBlock(int id, long timestamp, long magicNumber, String previousHash, String hash, long runtime) {
        super(id, timestamp, magicNumber, previousHash, hash, runtime);
    }
}
