import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void addFirst(T item) {
        MyNode node = new MyNode(item);
        if (head == null) { //check if the list is empty
            head = tail = node;
        } else {
            node.next = head;  //the new node points to the current first
            head.prev = node;  //the current first node now knows who is in front of it
            head = node;       //and now the head of the list is our new node.
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode node = new MyNode(item);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(item);
        }
        else if (index == size) {
            addLast(item);
        }
        else {
            MyNode curr = head;
            for (int i = 0; i < index; i++){
                curr = curr.next;

            }
            MyNode node = new MyNode(item);
            node.prev = curr.prev;
            node.next = curr;
            curr.prev.next = node;
            curr.prev = node;
            size++;
        }
    }

    @Override
    public void set(int index, T item) {
        getNode(index).data = item;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    private MyNode getNode(int index) { //for finding current element we need to analyze if the index is closer to head of tail
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyNode curr;
        if (index < size / 2) {
            curr = head;
            for (int i = 0; i < index; i++){
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }
        return curr;
    }

    @Override
    public T getFirst() {
        if (head == null) {
            throw new IllegalStateException("Empty");
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null) {
            throw new IllegalStateException("Empty");
        }
        return tail.data;
    }

    @Override
    public void remove(int index) {
        MyNode node = getNode(index);
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        else{
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        else {
            tail = node.prev;
        }
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {
        if (size <= 1) {
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            MyNode curr = head;
            for (int j = 0; j < size - 1 - i; j++) {
                Comparable<T> a = (Comparable<T>) curr.data;
                if (a.compareTo(curr.next.data) > 0) {
                    T temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
                curr = curr.next;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode curr = head;
        for (int i = 0; i < size; i++) {
            if (curr.data.equals(object)) {
                return i;
            }
            curr = curr.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode curr = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (curr.data.equals(object)) {
                return i;
            }
            curr = curr.prev;
        }
        return -1;
    }


    @Override
    public boolean exists(Object object) {
        MyNode curr = head;
        while (curr != null) {
            if (curr.data.equals(object)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyNode curr = head;
        for (int i = 0; i < size; i++) {
            arr[i] = curr.data;
            curr = curr.next;
        }
        return arr;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyNode curr = head;

            @Override
            public boolean hasNext() {
                if (curr != null) {
                    return true; // if there is one element
                } else {
                    return false;
                }
            }


            @Override
            public T next() {
                T data = curr.data;
                curr = curr.next;
                return data;
            }
        };
    }
}
