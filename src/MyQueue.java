public class MyQueue<T> {
    private MyList<T> list = new MyLinkedList<>();

//    public T enqueue(T item) {
//        list.addLast(item);
//        return item;
//    }
    public boolean offer(T item) {
        if (item == null) {
            return false;
        }
        list.addLast(item);
        return true;
    }
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Null items are not allowed");
        }
        list.addLast(item);
    }


    //    public T dequeue() {
//        T item = list.getFirst();
//        list.removeFirst();
//        return item;
//    }


    public T poll() {
        if (list.size() == 0)
            return null;
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }
    public T remove() {
        if (list.size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }



    public T peek() {
        if (list.size() == 0){
            return null;
            }
        return list.getFirst();
    }
    public T element() {
        if (list.size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
    public Object[] toArray() {
        return list.toArray();
    }
    public void printQueue(){
        Object[] arr = list.toArray();
        System.out.print("[");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
}
