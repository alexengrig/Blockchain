package blockchain.data;

import blockchain.util.KeysGenerator;
import blockchain.util.RSACryptographer;
import blockchain.util.RSAGenerator;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SignedMessageProducer extends MessageProducer<SignedMessage> {
    protected final Supplier<DataParams> params;
    protected final KeysGenerator keysGenerator;
    protected final PublicKey publicKey;
    protected final PrivateKey privateKey;

    public SignedMessageProducer(String name, List<String> texts,
                                 Consumer<SignedMessage> consumer, Supplier<DataParams> params) {
        super(name, texts, consumer);
        this.params = params;
        this.keysGenerator = getKeysGenerator();
        this.keysGenerator.generateKeys();
        this.publicKey = keysGenerator.getPublicKey();
        this.privateKey = keysGenerator.getPrivateKey();
    }

    protected KeysGenerator getKeysGenerator() {
        return new RSAGenerator(1024);
    }

    @Override
    public SignedMessage get() {
        try {
            DataParams dataParams = params.get();
            long id = dataParams.getId();
            String text = getRandomText();
            String message = say(text);
            String sign = RSACryptographer.getInstance().sign(privateKey, message);
            return new SignedMessage(id, message, publicKey, sign);
        } catch (InvalidKeyException | SignatureException e) {
            throw new IllegalStateException(e);
        }
    }
}
