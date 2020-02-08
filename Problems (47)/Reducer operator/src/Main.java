/**
 * The operator combines all values in the given range into one value
 * using combiner and initial value (seed)
 */
public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator =
        (initValue, combiner) -> (left, right) -> {
            int value = initValue;
            for (int i = left; i <= right; i++) {
                value = combiner.applyAsInt(value, i);
            }
            return value;
        };

/**
 * The operator calculates the sum in the given range (inclusively)
 */
public static final IntBinaryOperator sumOperator =
        (left, right) -> {
            int value= 0;
            for(int i = left; i <= right; i++){
                value += i;
            }
            return value;
        };

/**
 * The operator calculates the product in the given range (inclusively)
 */
public static final IntBinaryOperator productOperator =
        (left, right) -> {
            int value = 1;
            for(int i = left; i <= right; i++){
                value *= i;
            }
            return value;
        };