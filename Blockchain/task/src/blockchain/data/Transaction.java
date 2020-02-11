package blockchain.data;

import blockchain.reward.Reward;

public interface Transaction {
    String getFrom();

    String getTo();

    Reward getReward();
}
