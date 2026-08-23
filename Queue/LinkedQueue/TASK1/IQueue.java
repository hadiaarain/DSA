public interface IQueue {
    public int size();

    public void add(Object o);

    public Object remove();

    public Object first();

}