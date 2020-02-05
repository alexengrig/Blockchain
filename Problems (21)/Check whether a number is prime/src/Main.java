import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newCachedThreadPool();

        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            executor.execute(new PrintIfPrimeTask(number));
        }
        executor.shutdown();
        executor.awaitTermination(3, TimeUnit.SECONDS);
        executor.invokeAll(List.of());
    }
}

class PrintIfPrimeTask implements Runnable {
    private final int number;

    public PrintIfPrimeTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        if (number > 1) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return;
                }
            }
            System.out.println(number);
        }
    }
}