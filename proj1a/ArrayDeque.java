public class ArrayDeque<T> {

    private T[] array;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {

        array = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private int minusOne(int index) {
        if (index == 0) {
            return (array.length - 1);
        } else {
            return (index - 1);
        }
    }

    private int plusOne(int index) {
        if (index == array.length - 1) {
            return 0;
        } else {
            return (index + 1);
        }
    }

    // only resize is tricky here.

    private void checkSize() {
        if (size == array.length) {
            T[] temp = (T[]) new Object[size * 2];
            System.arraycopy(array, nextLast, temp, 0, size - nextLast);
            System.arraycopy(array, 0, temp, size - nextLast, nextLast);
            array = temp;
            nextFirst = array.length - 1;
            nextLast = size;

        }
    }

    private void decreaseSize() {
        if (array.length >= 16 && size / (double) array.length < 0.25) {
            T[] temp = (T[]) new Object[array.length / 2];
            if (array[0] == null) {
                System.arraycopy(array, plusOne(nextFirst), temp, 0, size);
            } else {
                System.arraycopy(array, plusOne(nextFirst), temp, 0, array.length - plusOne(nextFirst));
                System.arraycopy(array, 0, temp, array.length - plusOne(nextFirst), nextLast);
            }

            array = temp;
            nextFirst = array.length - 1;
            nextLast = size;
        }
    }


    public void addFirst(T item) {
        checkSize();
        array[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public void addLast(T item) {
        checkSize();
        array[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        if (size <= 0) {
            return 0;
        }
        return size;
    }


    public void printDeque() {
        int temp = 0;
        while (temp <= size) {
            int first = plusOne(nextFirst);
            System.out.print(array[first] + " ");
            temp++;
        }

    }

    public T removeFirst() {
        int first = plusOne(nextFirst);
        T res = array[first];
        array[first] = null;
        nextFirst = first;
        size--;
        decreaseSize();
        return res;
    }

    public T removeLast() {
        int last = minusOne(nextLast);
        T res = array[last];
        array[last] = null;
        nextLast = last;
        size--;
        decreaseSize();
        return res;
    }

    public T get(int index) {
        int first = plusOne(nextFirst);
        T res = array[(index + first) % (array.length)];
        return res;

    }







}
