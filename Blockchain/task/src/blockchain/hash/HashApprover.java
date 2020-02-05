package blockchain.hash;

@FunctionalInterface
public interface HashApprover {
    boolean approve(String hash);
}
