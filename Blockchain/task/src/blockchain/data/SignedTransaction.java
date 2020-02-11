package blockchain.data;

import blockchain.reward.Reward;

import java.security.PublicKey;

public class SignedTransaction implements Transaction, SignedData {
    private final long id;
    private final String from;
    private final String to;
    private final Reward reward;
    private final String sign;
    private final PublicKey key;

    public SignedTransaction(long id, String from, String to, Reward reward, String sign, PublicKey key) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.reward = reward;
        this.sign = sign;
        this.key = key;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public Reward getReward() {
        return reward;
    }

    @Override
    public String getSign() {
        return sign;
    }

    @Override
    public PublicKey getKey() {
        return key;
    }
}
