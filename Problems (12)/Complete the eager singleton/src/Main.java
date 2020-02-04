class Counter {
    private static Counter instance = new Counter();

    public int counter;

    private Counter() {
    }

    public static Counter getInstance() {
        return instance;
    }
}