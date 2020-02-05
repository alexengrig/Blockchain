package blockchain;

import java.util.Random;

public class NZeros {
    Random random;
    private int count;
    private int increasedCount;
    private int decreasedCount;

    public NZeros(int count) {
        this.count = count;
        random = new Random();
        increasedCount = 0;
        decreasedCount = 0;
    }

    public int getCount() {
        return count;
    }

    public String getNextStatus() {
        String status = "N stays the same";
        int variant = random.nextInt();
        if (variant % 4 == 0) {
            increasedCount = 0;
            decreasedCount = 0;
        } else if (variant % 2 == 0) {
            ++count;
            status = "N was increased to " + ++increasedCount;
            decreasedCount = 0;
        } else if (count > 0) {
            --count;
            status = "N was decreased by " + ++decreasedCount;
            increasedCount = 0;
        }
        return status;
    }
}
