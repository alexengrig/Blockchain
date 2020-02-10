package blockchain.util;

import java.security.*;

public final class RSACryptographer implements Cryptographer {
    private final Signature signature;

    private RSACryptographer() {
        try {
            signature = Signature.getInstance("SHA1withRSA");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public static RSACryptographer getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public String sign(PrivateKey key, String text) throws InvalidKeyException, SignatureException {
        signature.initSign(key);
        signature.update(text.getBytes());
        return new String(signature.sign());
    }

    @Override
    public boolean verify(PublicKey key, String text) throws InvalidKeyException, SignatureException {
        signature.initVerify(key);
        return signature.verify(text.getBytes());
    }

    private static class Holder {
        private static RSACryptographer INSTANCE = new RSACryptographer();
    }
}
