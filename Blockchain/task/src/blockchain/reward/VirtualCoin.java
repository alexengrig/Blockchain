package blockchain.reward;

import java.util.Objects;

public class VirtualCoin implements Reward {
    public static final VirtualCoin ZERO = new VirtualCoin(0);

    private final long amount;
    private final String currency;

    public VirtualCoin(long amount) {
        this.amount = amount;
        this.currency = "VC";
    }

    @Override
    public long getAmount() {
        return amount;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualCoin that = (VirtualCoin) o;
        return amount == that.amount &&
                Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
