import java.util.function.Supplier;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        final int[] cache = new int[]{0};
        return () -> {
            int value = cache[0];
            cache[0] = value + 1;
            return value;
        };
    }

}