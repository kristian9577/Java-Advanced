package GenericSwapMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> collection;

    public Box() {
        this.collection = new ArrayList<>();
    }

    public List<T> getCollection() {
        return collection;
    }

    public static <T> void swapper(List<T> collection, int first, int second) {
        T firstItem = collection.get(first);
        T secondItem = collection.get(second);
        collection.set(second, firstItem);
        collection.set(first, secondItem);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < this.collection.size(); i++) {
            output.append(String.format("%s: %s%n",
                    this.collection.get(i).getClass().getCanonicalName(),
                    this.collection.get(i)));
        }
        return output.toString();
    }
}