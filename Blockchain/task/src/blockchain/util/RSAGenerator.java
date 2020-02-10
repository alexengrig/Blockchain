package blockchain.util;

import java.security.*;

public class RSAGenerator implements KeysGenerator {
    private final KeyPairGenerator generator;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public RSAGenerator(int length) {
        try {
            generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(length);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void generateKeys() {
        KeyPair pair = generator.generateKeyPair();
        privateKey = pair.getPrivate();
        publicKey = pair.getPublic();
    }

    @Override
    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    @Override
    public PublicKey getPublicKey() {
        return publicKey;
    }
}
