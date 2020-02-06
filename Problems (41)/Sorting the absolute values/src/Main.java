import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .mapToInt(Math::abs)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}