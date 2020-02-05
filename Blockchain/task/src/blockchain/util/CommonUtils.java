package blockchain.util;

import java.util.Date;

public class CommonUtils {
    public static long getTimestamp() {
        return new Date().getTime();
    }
}
