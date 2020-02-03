import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] splits = line.split("\\s+");
        for (int i = 1; i < splits.length; i++) {
            String prev = splits[i-1];
            String curr = splits[i];
            if (prev.length() > curr.length()) {
                System.out.println(false);
                return;
            } else if (prev.length() == curr.length()) {
                for (int j = 0; j < prev.length(); j++) {
                    if (prev.charAt(j) > curr.charAt(j)) {
                        System.out.println(false);
                        return;
                    }
                }
            }
        }
        System.out.println(true);
    }
}