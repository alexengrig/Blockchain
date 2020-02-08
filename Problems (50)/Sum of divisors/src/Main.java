import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(IntStream.rangeClosed(a, b)
                .filter(i -> i % n == 0 || i % m == 0)
                .sum());
    }
}