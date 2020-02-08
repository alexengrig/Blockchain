package blockchain.data;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DataProducer implements Supplier<String>, Runnable {
    protected final String name;
    protected final List<String> texts;
    protected final Consumer<String> consumer;
    protected final Random random;

    public DataProducer(String name, List<String> texts, Consumer<String> consumer) {
        this.name = name;
        this.texts = texts;
        this.consumer = consumer;
        this.random = new Random();
    }

    protected String say(String text) {
        return name + ": " + text;
    }

    protected String getRandomText() {
        return texts.get(random.nextInt(texts.size()));
    }

    @Override
    public String get() {
        String text = getRandomText();
        return say(text);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            String data = get();
            consumer.accept(data);
            int timeout = random.nextInt(10);
            try {
                TimeUnit.MILLISECONDS.sleep(timeout);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
