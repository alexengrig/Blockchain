package blockchain.data;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public class MessageProducer<T extends Message> implements DataProducer<T>, Runnable {
    protected static final AtomicLong idGenerator = new AtomicLong();

    protected final String name;
    protected final List<String> texts;
    protected final Consumer<T> consumer;
    protected final Random random;

    public MessageProducer(String name, List<String> texts, Consumer<T> consumer) {
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

    @SuppressWarnings("unchecked")
    @Override
    public T get() {
        String text = getRandomText();
        String message = say(text);
        return (T) new Message(idGenerator.getAndIncrement(), message);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            T data = get();
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
