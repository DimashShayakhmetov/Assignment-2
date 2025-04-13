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
        return true;//enqueue but returns false if item null
    }
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Null items are not allowed");
        }
        list.addLast(item);
    }//same as offer but throws an exception


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
    }//dequeue but checks if the queue is empty and only then removes the element
    public T remove() {
        if (list.size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }//same as poll but throws an exception



    public T peek() {
        if (list.size() == 0){
            return null;
            }
        return list.getFirst();
    }//chosse peek element(will be chosen the first added element) because Queue - FIFO
    public T element() {
        if (list.size() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }//same as peek but throws an exceptin if queue is empty

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
    public Object[] toArray() {
        return list.toArray();
    }//converts the elements to array in order to print the queue
    public void printQueue(){
        Object[] arr = list.toArray();
        System.out.print("[");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
}
