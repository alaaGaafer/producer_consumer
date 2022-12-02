public class buffer {
    public int size = 10;
    private String[] store = new String[size];

    public buffer() {
    }

    private int inptr = 0;
    private int outptr = 0;
    semaphore spaces = new semaphore(size);
    semaphore elements = new semaphore(0);

    public void produce(String value) {
        spaces.P();
        store[inptr] = value;
        inptr = (inptr + 1) % size;
        elements.V();
    }

    public String consume() {
        String value;
        elements.P();
        value = store[outptr];
        outptr = (outptr + 1) % size;
        spaces.V();
        return value;
    }
}