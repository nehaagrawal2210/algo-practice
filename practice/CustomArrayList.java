package practice;

public class CustomArrayList {

    private static final int DEFAULT_BUFFER_SIZE = 10;
    private static final int DEFAULT_BUFFER_MULTIPLIER = 2;
    private Object[] buffer;

    private int size;
    private int bufferMultiplier;
    private int usedBufferLength;

    public CustomArrayList() {
        this.size = DEFAULT_BUFFER_SIZE;
        this.bufferMultiplier = DEFAULT_BUFFER_MULTIPLIER;
        this.buffer = new Object[this.size];
        this.usedBufferLength = 0;
    }

    public Object get(int index) {
        if (index < usedBufferLength) {
            return buffer[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void add(Object data) {
        if (isBufferFull()) {
            resizeBuffer();
        }
        buffer[usedBufferLength] = data;
        usedBufferLength++;
    }

    private void resizeBuffer() {
        size = size * bufferMultiplier;
        Object[] tempBuffer = new Object[size];
        System.arraycopy(buffer, 0, tempBuffer, 0, usedBufferLength);
        buffer = tempBuffer;
    }

    private boolean isBufferFull() {
        if (usedBufferLength == size) {
            return true;
        }
        return false;
    }
}
