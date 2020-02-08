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
        int variant = random.nextInt(10);
        if (count > 0 && variant == 3) {
            --count;
            increasedCount = 0;
            return "N was decreased by " + ++decreasedCount;
        } else if (variant == 6) {
            increasedCount = 0;
            decreasedCount = 0;
            return "N stays the same";
        } else {
            ++count;
            decreasedCount = 0;
            return "N was increased to " + ++increasedCount;
        }
    }
}
