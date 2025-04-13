import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[10];
        size = 0;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];    //checks if the array is full or extends it's 2 times
            }
            data = newData;
        }
    }

    @Override
    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity();//check if the array is full
        for (int i = size; i > index; i--) {//сдвиг элементов вправо - с конца
            data[i] = data[i - 1];
        }
        data[index] = item;
        size++;
    }
    //        MyArrayList<String> list = new MyArrayList<>();
//        list.add("A");
//        list.add("B");
//        list.add("D");
//        list.add(2, "C"); // вставим "C" на позицию 2
//
// результат: ["A", "B", "C", "D"]

    @Override
    public void addFirst(T item) {
        add(0, item);//at this point we put the value to any position under the index в начало списка
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        data[index] = item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return (T) data[index];
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
            }
        for (int i = index; i < size - 1; i++) { //удаляет элемент и сдваигет все в лево
            data[i] = data[i + 1];
        }
        data[--size] = null;//удаление(ССЫЛКИ) после сдвига
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
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) data[j];
                T b = (T) data[j + 1];
                if (a.compareTo(b) > 0) {
                    Object tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

//    @Override
//    public boolean exists(Object object) {
//        return indexOf(object) != -1;
//    }
    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(object)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = data[i];
        }
        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++){
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {   //for each loop
            int cursor = 0; //points to current object in array

            public boolean hasNext() { //checks if there exists the next element
                return cursor < size;
            }

            public T next() {
                return (T) data[cursor++];
            }
        };
    }
}
