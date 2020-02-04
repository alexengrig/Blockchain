package blockchain;

public interface Block {
    int getId();

    long getTimestamp();

    long getMagicNumber();

    String getPreviousHash();

    String getHash();
}
