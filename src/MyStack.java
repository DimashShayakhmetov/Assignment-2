public class MyStack<T> {
    private MyList<T> list = new MyArrayList<>();

    public T push(T item) {
        list.addLast(item);
        return item;
    }

    public T pop() {
        if (list.size() == 0)
            throw new IllegalStateException("Stack is empty");
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    public T peek() {
        if (list.size() == 0)
            throw new IllegalStateException("Stack is empty");
        return list.getLast();
    }//chose peek element(will be chosen the last added element) because Stack - LIFO

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public Object[] toArray() {
        return list.toArray();
    }//converts elements to array in order to print stack
    public void printStack() {
        Object[] array = this.toArray();
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

