package ListUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtils {
    private ListUtils() {

    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list!");
        }
        return Collections.max(list);
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list!");
        }
        return Collections.min(list);
    }
}
