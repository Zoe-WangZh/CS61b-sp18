public class ArrayDeque<T> {

    private T[] array;
    private int front;
    private int rear;
    private int size;

    public ArrayDeque() {
        // Java does not allow to create new generic array directly. So need cast.
        array = (T[]) new Object[8];
        this.front = 0;   //point to the first element of array, treat it as circular
        this.rear = 1;
        size = 0;
    }


    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (rear > front && rear - front - 1 == size) {
            System.arraycopy(array, front + 1, a, 0, size);
        } else {
            System.arraycopy(array, front + 1, a, 0, array.length - front - 1);
            System.arraycopy(array, 0, a, array.length - front - 1, size - (array.length - front - 1));
        }

        array = a;
        if (array.length > 0) {
            front = (array.length - 1) % array.length; //(array.length - 1) % array.length
            rear = size;
        } else {
            ArrayDeque<T> array = new ArrayDeque<>();
        }
    }

    public void addFirst(T item) {

        if (size == array.length) {
            resize(2 * array.length);
        }
        array[front] = item;
        front = (front - 1 + array.length) % array.length;
        size += 1;
    }

    public void addLast(T item) {
        if (size == array.length) {
            resize(2 * array.length);
        }
        array[rear] = item;
        rear = (rear + 1) % array.length;
        size += 1;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        front = (front + 1) % array.length;
        T remove = array[front];
        size -= 1;
        array[front] = null;

        if (array.length == 1) {
            array = (T[]) new Object[8];
            this.front = 0;   //point to the first element of array, treat it as circular
            this.rear = 1;
            return remove;
        }

        if (array.length <= 16 && array.length >= 4 * size) {
            resize(array.length / 2);
        }

        return remove;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        rear = (rear - 1 + array.length) % array.length;
        T remove = array[rear];
        size -= 1;
        array[rear] = null;

        if (array.length == 1) {
            array = (T[]) new Object[8];
            this.front = 0;   //point to the first element of array, treat it as circular
            this.rear = 1;
            return remove;
        }

        if (array.length <= 16 && array.length >= 4 * size) {
            resize(array.length / 2);
        }

        return remove;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int curr = (front + 1) % array.length;

        while (curr != rear) {
            System.out.print(array[curr]);
            curr = (curr + 1) % array.length;
        }
        System.out.println();
    }

    // If no such item exists, returns null. Must not alter the deque! index starts with 0
    public T get(int index) {
        if (!isEmpty()) {
            return array[(front + index + 1) % array.length];
        }
        return null;

    }


}
