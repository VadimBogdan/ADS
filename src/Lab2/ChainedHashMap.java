package Lab2;

import java.util.Arrays;

public class ChainedHashMap {

    final int TABLE_SIZE;
    ChainedHashEntry[] table;
    public ChainedHashMap(int size) {
        TABLE_SIZE = size;
        table = new ChainedHashEntry[size];
        Arrays.fill(table, null);
    }

    public boolean put(Triangle value) {
        Integer key = extractKey(value);
        int index = hash(key);

        if (table[index] == null) {

            table[index] = new ChainedHashEntry(key, value);

        } else {

            ChainedHashEntry entry = table[index];

            while (entry.next != null && !entry.key.equals(key)) {
                entry = entry.next;
            }


            if (entry.key.equals(key))
                entry.value = value;
            else
                entry.next = new ChainedHashEntry(key, value);
        }
        return true;
    }

    private int extractKey(Triangle elem) {
        if (elem == null) return 0;
        return ((int) elem.perimeter());
    }

    private int hash(Integer key) {
        return key % TABLE_SIZE;
    }

    public void show() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, size = table.length; i < size; i++) {
            stringBuilder.append(String.format("Postion %1$d, %2$s\n", i, table[i]));
        }
        System.out.println(stringBuilder.toString());
        System.out.println();
    }

    private static class ChainedHashEntry {
        Integer key;
        Triangle value;
        ChainedHashEntry next;

        ChainedHashEntry(int key, Triangle value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            ChainedHashEntry entry = this;
            StringBuilder stringBuilder = new StringBuilder();
            while (entry != null) {
                stringBuilder.append(String.format("Key: %1$d, Value: %2$s || ", entry.key, entry.value));
                entry = entry.next;
            }
            return stringBuilder.toString();
        }
    }
}
