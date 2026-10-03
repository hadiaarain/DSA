public class HashTable {

    // Node of linked list
    private static class Entry {

        private Object key;
        private Object value;
        private Entry next;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    // Array of linked lists
    private Entry[] a = new Entry[10];

    private int size;

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

        Entry entry = a[index];

        // If bucket is empty
        if (entry == null) {

            a[index] = new Entry(key, value);

            size++;

            return null;
        }

        // Search linked list
        while (entry != null) {

            // Key already exists
            if (entry.key.equals(key)) {

                Object oldValue = entry.value;

                entry.value = value;

                return oldValue;
            }

            entry = entry.next;
        }

        // Add new entry at beginning
        Entry newEntry = new Entry(key, value);

        newEntry.next = a[index];

        a[index] = newEntry;

        size++;

        return null;
    }

    // GET
    public Object get(Object key) {

        int index = hash(key);

        Entry entry = a[index];

        // Search linked list
        while (entry != null) {

            if (entry.key.equals(key)) {
                return entry.value;
            }

            entry = entry.next;
        }

        return null;
    }

    // REMOVE
    public Object remove(Object key) {

        int index = hash(key);

        Entry entry = a[index];

        Entry previous = null;

        // Search linked list
        while (entry != null) {

            if (entry.key.equals(key)) {

                // If first node
                if (previous == null) {
                    a[index] = entry.next;
                }

                // If middle or last node
                else {
                    previous.next = entry.next;
                }

                size--;

                return entry.value;
            }

            previous = entry;
            entry = entry.next;
        }

        return null;
    }

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

        // REMOVE
        System.out.println("\nRemoved: " + ht.remove("CAN"));

        System.out.println("Size: " + ht.size());

        System.out.println("CAN: " + ht.get("CAN"));
    }
}