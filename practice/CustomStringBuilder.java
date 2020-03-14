package practice;

import java.io.Serializable;

public class CustomStringBuilder implements Serializable, CharSequence {

    private static final int DEFAULT_BUFFER_SIZE = 10;
    private static final int DEFAULT_BUFFER_MULTIPLIER = 2;
    private char[] buffer;
    private int size;
    private int bufferMultiplier;
    private int usedBufferLength;

    public CustomStringBuilder() {
        this.size = DEFAULT_BUFFER_SIZE;
        this.bufferMultiplier = DEFAULT_BUFFER_MULTIPLIER;
        this.buffer = new char[size];
        this.usedBufferLength = 0;
    }

    public CustomStringBuilder(String currentString) {
        this();
        append(currentString);
    }

    public void append(String wordToAppend) {
        while (isResizeRequired(wordToAppend)) {
            resizeBuffer();
        }
        appendString(wordToAppend);
    }

    public String getString() {
        return new String(buffer, 0, usedBufferLength);
    }

    @Override
    public int length() {
        return usedBufferLength;
    }

    @Override
    public char charAt(int index) {
        return buffer[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new String(buffer, start, end - start + 1);
    }

    private boolean isResizeRequired(String wordToAppend) {
        int capacityRequired = wordToAppend.length();

        if (usedBufferLength + capacityRequired > size) {
            return true;
        }
        return false;
    }


    private void appendString(String wordToAppend) {

        System.arraycopy(wordToAppend.toCharArray(), 0, buffer, usedBufferLength, wordToAppend.length());
        usedBufferLength += wordToAppend.length();
    }

    private void resizeBuffer() {
        size = size * bufferMultiplier;
        char[] tempBuffer = new char[size];
        System.arraycopy(buffer, 0, tempBuffer, 0, usedBufferLength);
        buffer = tempBuffer;
    }

    public static void main(String[] args) {

        CustomStringBuilder customStringBuilder = new CustomStringBuilder();
        for (int i = 0; i < 40; i++) {
            customStringBuilder.append(String.valueOf(i));
        }

        System.out.println(customStringBuilder.getString());

        System.out.println("Character at 15: " + customStringBuilder.charAt(15));
        System.out.println("Length of string: " + customStringBuilder.length());
        System.out.println("Subsequence: " + customStringBuilder.subSequence(5, 10));

    }
}


