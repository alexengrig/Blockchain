public class Main {

    public static void main(String[] args) {
        Runnable runnable = new RunnableWorker();
        new Thread(runnable, "worker-1").start();
        new Thread(runnable, "worker-2").start();
        new Thread(runnable, "worker-3").start();
    }
}