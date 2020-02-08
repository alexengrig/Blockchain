/**
 * Calculates the general sum of canceled transactions for all non empty accounts in the list
 */
public static long calcSumOfCanceledTransOnNonEmptyAccounts(List<Account> accounts) {
    return accounts.stream()
        .filter(a -> a.getBalance() > 0)
        .flatMap(a -> a.getTransactions().stream())
        .filter(t -> State.CANCELED == t.getState())
        .mapToLong(t -> t.getSum())
        .sum();
}