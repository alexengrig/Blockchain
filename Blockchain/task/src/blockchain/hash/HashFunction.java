package blockchain.hash;

@FunctionalInterface
public interface HashFunction {
    String hash(String input);

    default String hash(long input) {
        return hash(Long.toString(input));
    }
}
