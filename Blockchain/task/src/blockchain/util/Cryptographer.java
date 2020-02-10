package blockchain.util;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;

public interface Cryptographer {
    String sign(PrivateKey key, String text) throws InvalidKeyException, SignatureException;

    boolean verify(PublicKey key, String text) throws InvalidKeyException, SignatureException;
}
