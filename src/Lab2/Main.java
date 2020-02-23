package Lab2;

public class Main {
    public static void main(String[] args) {
        int openHashMapSize = 7;
        int chainedHashMapSize = 4;
        int chainedHashMapWithRemoveSize = 7;

        OpenAdressingHashMap openAdressingHashMap = new OpenAdressingHashMap(openHashMapSize);

        openAdressingHashMap.put(new Triangle());
        openAdressingHashMap.show();
        while (!openAdressingHashMap.put(new Triangle())) ;
        openAdressingHashMap.show();
        while (!openAdressingHashMap.put(new Triangle())) ;
        openAdressingHashMap.show();


        ChainedHashMap chainedHashMap = new ChainedHashMap(chainedHashMapSize);
        for (int i = 0; i < 10; i++)
            chainedHashMap.put(new Triangle());

        chainedHashMap.show();


        ChainedHashMapWithRemove chainedHashMapWithRemove = new ChainedHashMapWithRemove(chainedHashMapWithRemoveSize);
        for (int i = 0; i < 10; i++)
            chainedHashMapWithRemove.put(new Triangle());

        chainedHashMapWithRemove.show();

        chainedHashMapWithRemove.remove(500);

        chainedHashMapWithRemove.show();
    }
}
