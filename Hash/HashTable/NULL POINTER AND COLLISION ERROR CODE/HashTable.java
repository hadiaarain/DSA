public class HashTable {
    private class Entry {
        private Object key, value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(Object key) {
        return (key.hashCode() & 0x7fffffff) % a.length;
    }

    private Entry[] a = new Entry[10];
    private int size;

    private int size() {
        return size;
    }

    // COLLISION PROBLEM:
    // will give Null Pointer exception bz 2 keys of diff values might get same
    // hashcode and index.

    private void put(Object key, Object value) {
        int index = hash(key);
        for (int i = 0; i < a.length; i++) {
            int j = (index + i) % a.length;
            Entry entry = a[j];
            if (entry == null) {
                a[j] = new Entry(key, value);
            }
            size++;
            return;
        }
    }
    // private void put(Object key, Object value) {
    // a[hash(key)] = new Entry(key, value);
    // size++;
    // }

    // will give Null Pointer exception if the key is not present in the hash
    // table(after we did remove method)
    private Object get(Object key) {
        if (a[hash(key)] == null) {
            return null;
        }
        return a[hash(key)].value;
    }

    // NULL PROBLEM:
    // cause of null pointer exception bcz it gives null to the removed key
    // which then messes up the get method
    private Object remove(Object key) {
        int index = hash(key);
        Object temp = a[index].value;
        a[index] = null;
        size--;
        return temp;
    }

    public static void main(String[] args) {
        Country country1 = new Country("United States of America", "English", 331000000);
        Country country2 = new Country("Canada", "English/French", 38000000);
        Country country3 = new Country("Mexico", "Spanish", 128000000);
        Country country4 = new Country("Germany", "German", 83000000);
        Country country5 = new Country("France", "French", 67000000);

        HashTable ht = new HashTable();
        ht.put("USA", country1);
        ht.put("CAN", country2);
        ht.put("MEX", country3);
        ht.put("GER", country4);
        ht.put("FRA", country5);

        System.out.println(ht.get("USA"));
        System.out.println(ht.get("CAN"));
        System.out.println(ht.get("MEX"));
        System.out.println(ht.get("GER"));
        System.out.println(ht.get("FRA"));

        ht.remove("CAN");
        System.out.println(ht.size()); // Should print 2
        System.out.println(ht.get("CAN")); // Should print null

        // Gives Null Pointer Exception because the key is not present in the hash table
        // To fix this, we can add a change "put" "get" and "remove" methods to check if
        // the key is present in the hash table before performing any operations on it.
        // If the key is not present, we can return null or throw an exception.
    }
}
