public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    //public methods

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }//Creates a heap by initializing an internal list

    public boolean empty() {
        if(heap.size() == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        if(heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.size();
    }

    public T getMin() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }//returns a min element without deleting it

    public T extractMin() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = heap.get(0);
        T last = heap.get(heap.size() - 1);
        heap.set(0, last);
        heap.removeLast();
        heapify(0);
        return min;
    }//returns a min element with deleting it

    public void insert(T item) {
        heap.add(item);
        traverseUp(heap.size() - 1);
    }


    //private methods
    private void heapify(int index) {
        int left = leftChildOf(index);
        int right = rightChildOf(index);
        int smallest = index;//suppose that current element is smallest

        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }//if smallest changed swap
    }

    private void traverseUp(int index) {
        while (index > 0 && heap.get(index).compareTo(heap.get(parentOf(index))) < 0) { //while we did not get to root(index > 0) and our element less than parent
            swap(index, parentOf(index));
            index = parentOf(index);
        }
    }

    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public Object[] toArray() {
        return heap.toArray();
    }
    public void printHeap() {
        Object[] array = this.toArray();
        if (array.length == 0) {
            System.out.println("[]");
            return;
        }
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













