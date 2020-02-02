import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        LocalDate date = LocalDate.of(year, month, 1);
        for (LocalDate d = date; d.getMonth() == d.plusDays(1).getMonth(); d = d.plusDays(1)) {
            if (d.getDayOfWeek() == DayOfWeek.MONDAY) {
                System.out.println(d);
            }
        }
    }
}