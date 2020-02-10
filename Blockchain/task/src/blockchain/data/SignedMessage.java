package blockchain.data;

import java.security.PublicKey;
import java.util.Objects;

public class SignedMessage extends Message implements SignedData {
    protected final PublicKey key;
    protected final String sign;

    public SignedMessage(long id, String text, PublicKey key, String sign) {
        super(id, text);
        this.key = key;
        this.sign = sign;
    }

    @Override
    public PublicKey getKey() {
        return key;
    }

    @Override
    public String getSign() {
        return sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SignedMessage that = (SignedMessage) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(sign, that.sign);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, sign);
    }
}
