import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<String> inputArray = Arrays.asList(line.split(" "));
        int size = inputArray.size();
        List<String> outputArray = new ArrayList<>(size / 2);
        int lastIndex = size - 1;
        int endIndex = lastIndex % 2 == 0 ? lastIndex - 1 : lastIndex;
        for (int i = endIndex; i > 0; i -= 2) {
            outputArray.add(inputArray.get(i));
        }
        for (String string : outputArray) {
            System.out.print(string + " ");
        }
    }
}