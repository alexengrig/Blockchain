public static long rangeQuadraticSum(int fromIncl, int toExcl) {
    return IntStream.range(fromIncl, toExcl)
        .map(i -> i * i)
        .sum();
}