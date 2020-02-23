package Lab2;

import java.util.Arrays;

public class OpenAdressingHashMap {
    final Triangle FREE = null;
    final int size;
    Triangle[] table;

    OpenAdressingHashMap(int size) {
        this.size = size;
        table = new Triangle[size];
        Arrays.fill(table, FREE);
    }


    public boolean put(Triangle elem) {
        int index = hash(extractKey(elem));
        if (table[index] == FREE) {
            table[index] = elem;
            return true;
        }
        return false;
    }

    private int extractKey(Triangle elem) {
        if (elem == null) return 0;
        return ((int) elem.perimeter());
    }

    private int hash(int key) {
        return key % size;
    }

    public void show() {
        StringBuilder stringBuilder = new StringBuilder();
        int key;
        for (int i = 0, size = table.length; i < size; i++) {
            key = extractKey(table[i]);
            stringBuilder.append(String.format("Position %1$d, Key: %2$d, Value: %3$s\n", i, key, table[i]));
        }
        System.out.println(stringBuilder.toString());
        System.out.println();
    }
}
