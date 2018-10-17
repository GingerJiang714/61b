public class LinkedListDeque<T> {

    private DequeNode sentinel;
    private int size;

    private class DequeNode {

        T key;
        DequeNode next;
        DequeNode prev;

        DequeNode(T d, DequeNode p, DequeNode n) {

            key = d;
            next = n;
            prev = p;

        }
    }

    public LinkedListDeque() {

        sentinel = new DequeNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {

        DequeNode temp = sentinel.next;
        DequeNode dump = sentinel.next.prev;
        sentinel.next = new DequeNode(item, dump, temp);
        sentinel.next.next.prev = sentinel.next;
        size++;

    }
    public void addLast(T item) {

        DequeNode temp = sentinel.prev;
        DequeNode dump = sentinel.next.prev;
        sentinel.prev = new DequeNode(item, temp, dump);
        sentinel.prev.prev.next = sentinel.prev;
        size++;

    }

    public boolean isEmpty() {

        return size == 0;
    }

    public int size() {

        return size;

    }

    public void printDeque() {

        DequeNode temp = sentinel.next;
        while (temp.key != null) {
            System.out.print(temp.key);
            System.out.print(" ");
            temp = temp.next;
        }

    }

    public T removeFirst() {

        T res = sentinel.next.key;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return res;

    }

    public T removeLast() {

        T res = sentinel.prev.key;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return res;

    }

    public T get(int index) {

        int cur = 0;
        DequeNode temp = sentinel.next;
        while (cur != index) {
            temp = temp.next;
            cur++;
        }
        return temp.key;

    }

    public T getRecursive(int index) {
        DequeNode temp = sentinel.next;
        return getRecursiveHelp(index, 0, temp);

    }

    private T getRecursiveHelp(int index, int cur, DequeNode copy) {
        if (cur == index) {
            return copy.key;
        } else {
            cur++;
            return getRecursiveHelp(index, cur, copy.next);
        }

    }


}
