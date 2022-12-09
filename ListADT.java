public interface ListADT {
    public void List();
    public void insert(Person e ) throws Exception;
    public Object retrieve() throws  Exception;
    public boolean isEmpty();
    public void findFirst() throws Exception;
    public void findNext() throws Exception;
    public void delete() throws Exception;
    public void update(Person e) throws  Exception;
    public boolean isFull();
}

