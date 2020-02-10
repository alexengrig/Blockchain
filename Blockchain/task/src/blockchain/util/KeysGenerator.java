package blockchain.util;

import java.security.PrivateKey;
import java.security.PublicKey;

public interface KeysGenerator {
    void generateKeys();

    PrivateKey getPrivateKey();

    PublicKey getPublicKey();
}
