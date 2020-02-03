import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        HashTable<String> table = new HashTable<>(count);
        for (int i = 0; i < count; i++) {
            String command = scanner.next();
            if ("put".equals(command)) {
                int key = scanner.nextInt();
                String value = scanner.nextLine().trim();
                table.put(key, value);
            } else if ("get".equals(command)) {
                int key = scanner.nextInt();
                String value = table.get(key);
                if (value != null) {
                    System.out.println(value);
                } else {
                    System.out.println(-1);
                }
            } else if ("remove".equals(command)) {
                int key = scanner.nextInt();
                table.remove(key);
            }
        }
    }

    private static class TableEntry<T> {
        private final int key;
        private final T value;
        private boolean removed;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        public void remove() {
            removed = true;
        }

        public boolean isRemoved() {
            return removed;
        }
    }

    private static class HashTable<T> {
        private int size;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            int hash = findKey(key);
            if (hash == -1) {
                return false;
            }
            table[hash] = new TableEntry(key, value);
            return true;
        }

        public T get(int key) {
            int hash = findKey(key);
            if (hash == -1) {
                return null;
            }
            TableEntry entry = table[hash];
            if (entry != null && !entry.isRemoved()) {
                return (T) entry.getValue();
            } else {
                return null;
            }
        }

        public void remove(int key) {
            int hash = findKey(key);
            if (hash != -1 && table[hash] != null) {
                table[hash].remove();
            }
        }

        private int findKey(int key) {
            int hash = key % size;
            while (!(table[hash] == null || table[hash].getKey() == key)) {
                hash = (hash + 1) % size;
                if (hash == key % size) {
                    return -1;
                }
            }
            return hash;
        }

        private void rehash() {
            TableEntry[] target = table;
            table = new TableEntry[size];
            for (TableEntry entry : target) {
                int hash = findKey(entry.getKey());
                table[hash] = entry;
            }
        }
    }
}