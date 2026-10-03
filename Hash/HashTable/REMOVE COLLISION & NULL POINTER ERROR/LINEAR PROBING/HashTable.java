public class HashTable {

    // Entry class
    private static class Entry {

        private Object key;
        private Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    // Array of Entries
    private Entry[] a = new Entry[10];

    // Number of actual elements
    private int size;

    // Special marker for deleted entries
    public static final Entry NIL = new Entry(null, null);

    // Hash function
    private int hash(Object key) {
        return (key.hashCode() & 0x7fffffff) % a.length;
    }

    // Size
    private int size() {
        return size;
    }

    // PUT
    private Object put(Object key, Object value) {

        int index = hash(key);

        // Linear probing
        for (int i = 0; i < a.length; i++) {

            int j = (index + i) % a.length;

            Entry entry = a[j];

            // Empty OR deleted slot
            if (entry == null || entry == NIL) {

                a[j] = new Entry(key, value);

                size++;

                return null;
            }
        }

        throw new IllegalStateException("Table is full");
    }

    // GET
    public Object get(Object key) {

        int index = hash(key);

        // Linear probing
        for (int i = 0; i < a.length; i++) {

            int j = (index + i) % a.length;

            Entry entry = a[j];

            // Never occupied -> stop searching
            if (entry == null) {
                break;
            }

            // Deleted -> keep searching
            if (entry == NIL) {
                continue;
            }

            // Key found
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        // Key not found
        return null;
    }

    // REMOVE
    public Object remove(Object key) {

        int index = hash(key);

        // Linear probing
        for (int i = 0; i < a.length; i++) {

            int j = (index + i) % a.length;

            Entry entry = a[j];

            // Never occupied -> stop searching
            if (entry == null) {
                break;
            }

            // Deleted -> keep searching
            if (entry == NIL) {
                continue;
            }

            // Key found
            if (entry.key.equals(key)) {

                Object temp = entry.value;

                // Mark as deleted
                a[j] = NIL;

                size--;

                return temp;
            }
        }

        // Key not found
        return null;
    }

    // MAIN
    public static void main(String[] args) {

        Country country1 = new Country("United States of America",
                "English",
                331000000);

        Country country2 = new Country("Canada",
                "English/French",
                38000000);

        Country country3 = new Country("Mexico",
                "Spanish",
                128000000);

        Country country4 = new Country("Germany",
                "German",
                83000000);

        Country country5 = new Country("France",
                "French",
                67000000);

        HashTable ht = new HashTable();

        // PUT
        ht.put("USA", country1);
        ht.put("CAN", country2);
        ht.put("MEX", country3);
        ht.put("GER", country4);
        ht.put("FRA", country5);

        // GET
        System.out.println(ht.get("USA"));
        System.out.println(ht.get("CAN"));
        System.out.println(ht.get("MEX"));
        System.out.println(ht.get("GER"));
        System.out.println(ht.get("FRA"));

        // REMOVE Canada
        System.out.println("\nRemoved: " + ht.remove("CAN"));

        // Size
        System.out.println("Size: " + ht.size());

        // Try to get removed country
        System.out.println("CAN: " + ht.get("CAN"));

        // Add Canada again to test NIL reuse
        ht.put("CAN", country2);

        System.out.println("\nAfter adding Canada again:");
        System.out.println(ht.get("CAN"));
        System.out.println("Size: " + ht.size());
    }
}