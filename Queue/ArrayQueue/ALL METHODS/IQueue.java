public interface IQueue {

    int size();

    void add(Object o);

    Object remove();

    Object first();
}