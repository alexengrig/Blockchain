import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OptionalInt max = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .mapToInt(Math::abs)
                .max();
        System.out.println(max.orElse(0));
    }
}