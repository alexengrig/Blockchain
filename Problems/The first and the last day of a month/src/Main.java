import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        LocalDate first = LocalDate.of(year, month, 1);
        System.out.print(first);
        System.out.print(" ");
        System.out.println(first.withDayOfMonth(first.lengthOfMonth()));
    }
}