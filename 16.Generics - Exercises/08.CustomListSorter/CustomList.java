package CustomListSorter;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable> {
    private List<T> collection;

    public CustomList() {
        this.collection = new ArrayList<>();
    }

    public void add(T element) {
        this.collection.add(element);
    }

    public T remove(int index) {
        return this.collection.remove(index);
    }

    public boolean contains(T element) {
        return this.collection.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstItem = this.collection.get(firstIndex);
        T secondItem = this.collection.get(secondIndex);

        this.collection.set(secondIndex, firstItem);
        this.collection.set(firstIndex, secondItem);
    }

    public long countGreaterThan(T element) {
        return this.collection.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return this.collection.stream().max(T::compareTo).get();
    }

    public T getMin() {
        return this.collection.stream().min(T::compareTo).get();
    }

    public List<T> getCollection() {
        return new ArrayList<>(this.collection);
    }

    public void setCollection(List<T> collection) {
        this.collection = collection;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < this.collection.size(); i++) {
            output.append(this.collection.get(i)).append("\n");
        }
        output.deleteCharAt(output.length() - 1);
        return output.toString();
    }
}
