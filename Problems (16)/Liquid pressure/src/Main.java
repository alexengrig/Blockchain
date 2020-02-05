import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        double g = 9.8d;
        Scanner scanner = new Scanner(System.in);
        double p = scanner.nextDouble();
        double h = scanner.nextDouble();
        System.out.println(p * g * h);
    }
}