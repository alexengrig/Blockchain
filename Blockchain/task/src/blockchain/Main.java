package blockchain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter how many zeros the hash must starts with: ");
        System.out.println();
        int n = scanner.nextInt();
        Blockchain blockchain = new SimpleBlockchain(n);
        for (int i = 0; i < 5; i++) {
            blockchain.generateNewBlock();
        }
        System.out.println(blockchain);
    }
}
