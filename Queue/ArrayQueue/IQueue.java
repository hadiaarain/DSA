public interface IQueue {

    // Returns number of elements in queue
    int size();

    // Adds an element to the rear
    void add(Object o);

    // Removes and returns the front element
    Object remove();

    // Returns the front element without removing it
    Object first();
}