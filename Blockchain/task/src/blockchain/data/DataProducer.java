package blockchain.data;

@FunctionalInterface
public interface DataProducer<T extends Data> {
    T get();
}
