/**
 * Calculates the factorial of the given number n
 *
 * @param n >= 0
 *
 * @return factorial value
 */
public static long factorial(long n) {
    return LongStream.rangeClosed(1, n)
        .reduce(1, (acc, i) -> acc * i);
}