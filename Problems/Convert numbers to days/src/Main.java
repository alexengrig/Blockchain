import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int one = scanner.nextInt();
        int two = scanner.nextInt();
        int three = scanner.nextInt();
        System.out.println(LocalDate.ofYearDay(year, one));
        System.out.println(LocalDate.ofYearDay(year, two));
        System.out.println(LocalDate.ofYearDay(year, three));
    }
}