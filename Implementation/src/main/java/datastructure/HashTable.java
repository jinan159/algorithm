package datastructure;

/*
    참고
        - https://d2.naver.com/helloworld/831311
 */
public class HashTable<K, V> {
    /*
        - hash function
        - key, value
        - hash collision
          - Seperate chaining 방식

        java hashtable 은 크기를 받는 방식
        java hashmap 은 기본 크기(16)을 갖고, 2의 배수로 커지는 방식이다.
            put 할때마다 계속 확인하다가, 한계점(최대 크기)를 넘을 때 resize 함
     */

    private static final int DEFAULT_CAPACITY = 16;

    private final LinkedPair<K, V>[] table;
    private final int capacity;
    private int size = 0;

    public HashTable() {
        this.table = new LinkedPair<>[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public HashTable(int capacity) {
        this.table = new LinkedPair<>[capacity];
        this.capacity = capacity;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(K key) {
        int i = getHash(key);
        return table[i] != null && table[i].containsKey(key);
    }

    public V get(K key) {
        int i = getHash(key);

        LinkedPair<K, V> pair = table[i];


        if (pair.key == key) return pair.value;
        else {
            LinkedPair<K, V> nextPair = table[i].next;
            while (nextPair != null) {
                if (nextPair.key == key) {
                    return nextPair.value;
                }
                nextPair = nextPair.next;
            }
        }

        return null;
    }

    public void put(K key, V value) {
        int i = getHash(key);

        if (table[i] == null) table[i] = getNew(key, value);
        else {
            LinkedPair<K, V> pair = table[i];

            while (pair != null) {
                if (pair.key == key) {
                    pair.value = value;
                    break;
                } else if (pair.next == null) {
                    pair.next = getNew(key, value);
                    break;
                }
                pair = pair.next;
            }
        }
    }

    private LinkedPair<K, V> getNew(K key, V value) {
        size++;
        return new LinkedPair<>(key, value);
    }

    public V remove(K key) {
        int i = getHash(key);

        LinkedPair<K, V> pair = table[i];

        if (pair.key == key) {
            table[i] = null;
            size--;
            return pair.value;
        }
        else {
            LinkedPair<K, V> pre = pair;
            LinkedPair<K, V> curr = pair.getNext();

            while (curr != null) {
                if (curr.key == key) {
                    pre.next = curr.next;
                    size--;
                    return curr.value;
                }
                pre = curr;
                curr = curr.getNext();
            }
        }

        return null;
    }

    private int getHash(K key) {
        return key.hashCode() % capacity;
    }

    private static class LinkedPair<K, V> {

        final K key;
        V value;
        LinkedPair<K, V> next;

        public LinkedPair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public LinkedPair<K, V> getNext() {
            return next;
        }

        public boolean containsKey(K key) {
            if (this.key == key) return true;
            else if (next == null) return false;
            else
                return next.containsKey(key);
        }
    }
}

