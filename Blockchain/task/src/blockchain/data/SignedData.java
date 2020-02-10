package blockchain.data;

import java.security.PublicKey;

public interface SignedData extends Data {
    String getSign();

    PublicKey getKey();
}
