import java.util.Arrays;
import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[SmartArray.INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = SmartArray.INITIAL_CAPACITY;
    }

    public int size() {
        return this.size;
    }

    public void add(int element) {
        if (this.size == this.capacity) {
            this.grow();
        }
        this.data[this.size++] = element;
    }

    private void grow() {
        this.capacity *= 2;
        int[] newData = new int[this.capacity];

        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    public int removeAt(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("Remove called for index" +
                    index + ". For smartArray with size:" + this.size);
        }
        int removedElement = this.data[index];

        this.shiftLeft(index);
        this.data[this.size - 1] = 0;
        this.size--;

        if (this.size <= this.capacity / 4) {
            this.shrink();
        }

        return removedElement;
    }

    private void shrink() {
        this.capacity /= 2;
        int[] newData = new int[capacity];
        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
    }

    private void insertAt(int index, int element) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("Insert called for index" +
                    index + ". For smartArray with size:" + this.size);
        }

        if (index == this.size - 1) {
            int temp = this.data[this.size - 1];
            this.data[this.size - 1] = element;
            this.add(temp);
        } else {
            if (this.size == this.capacity) {
                this.grow();
            }
            this.shiftRight(index);
            this.data[index] = element;
            this.size++;
        }
    }

    private void shiftRight(int index) {
        for (int i = this.size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void forEach(Consumer<Integer> consumer) {
        Arrays.stream(this.data).limit(this.size)
                .forEach(consumer::accept);
    }
}
