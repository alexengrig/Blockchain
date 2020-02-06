public static <T> void findMinMax(
        Stream<? extends T> stream,
        Comparator<? super T> order,
        BiConsumer<? super T, ? super T> minMaxConsumer) {
    Deque<T> deque = stream.sorted(order).collect(Collectors.toCollection(ArrayDeque::new));
    T min = deque.peekFirst();
    T max = deque.peekLast();
    minMaxConsumer.accept(min, max);
}