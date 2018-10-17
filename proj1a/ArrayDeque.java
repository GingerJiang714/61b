public class ArrayDeque<T> {

    private T[] array;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {

        array = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    // only resize is tricky here.

    public void checkSize() {
        if (size == array.length) {
            T[] temp = (T[]) new Object[size *2];
            System.arraycopy(array,0,temp,0,nextLast);
            System.arraycopy(array, nextLast, temp,temp.length - (size - nextLast) ,size-nextLast);
            array = temp;
            nextFirst = temp.length - (size - nextLast) -1;

        }
    }

    public void decreaseSize() {
        if (array.length >=16 && size / (double)array.length < 0.25) {
            T[] temp = (T[]) new Object[array.length /2];
            if (nextFirst < nextLast ) {
                System.arraycopy(array, nextFirst + 1, temp, (nextFirst + 1) / 2, size);
                nextLast = nextFirst+ 1 +size;
            }else {
                System.arraycopy(array,0 ,temp, 0, nextLast);
                System.arraycopy(array,nextFirst + 1 , temp,(nextFirst + 1) / 2 ,size - nextLast);

            }
            nextFirst = nextFirst/2;
        }
    }


    public void addFirst(T item) {
        checkSize();
        array[nextFirst] = item;
        nextFirst --;
        if (nextFirst < 0) {
            nextFirst = array.length - 1;
        }
        size ++;
    }

    public void addLast(T item) {
        checkSize();
        array[nextLast] = item;
        nextLast ++;
        if (nextLast >= array.length) {
            nextLast = 0;
        }
        size ++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

   
    public void printDeque() {
        int first = nextFirst++;

        int temp = 0;
        while (temp < size) {
            if (first >= array.length) {
                first = 0;
            }
            System.out.print(array[first]+" ");
            first ++;
            temp ++;
        }

    }

    public T removeFirst() {
        decreaseSize();
         T res = array[nextFirst];
         array[nextFirst] = null;
         nextFirst ++;
         if (nextFirst >= array.length) {
             nextFirst = 0;
         }
         size --;
         return res;
    }

    public T removeLast() {
        decreaseSize();
        T res = array[nextLast];
        array[nextLast] = null;
        nextLast --;
        if (nextLast < 0) {
            nextLast = array.length - 1;
        }
        size --;
        return res;
    }

    public T get(int index) {
        int first = nextFirst++;
        if (first >= array.length) {
            first = 0;
        }
        T res = array[(index+first)%array.length];
        return res;

    }







}
