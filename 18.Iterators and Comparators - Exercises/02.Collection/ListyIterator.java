package Collection;

import java.util.*;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {
    private List<String> collection;
    private int position;


    public ListyIterator() {
        this.collection = new ArrayList<>();
        this.position = 0;

    }

    public ListyIterator(String... strings) {
        this();
        this.collection = Arrays.asList(strings);
    }


    public void create(String[] lines) {
        for (int i = 1; i < lines.length; i++) {
            this.collection.add(lines[i]);
        }
    }

    public void print() {
        if (this.position >= this.collection.size()) {
            System.out.println("Invalid Operation");
            return;
        }
        System.out.println(this.collection.get(this.position));
    }

    public boolean move() {
        if(this.hasNext()){
            this.position++;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean hasNext() {
        return this.position + 1 < this.collection.size();
    }

    public void printAll() {
        if (this.collection.isEmpty()) {
            System.out.println("Invalid Operation");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        this.forEach(str -> stringBuilder.append(str).append(" "));
        System.out.println(stringBuilder.toString().trim());
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIterator();
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        Iterator<String> iterator = new ListIterator();

        while (iterator.hasNext()) {
            action.accept(iterator.next());
        }
    }

    private class ListIterator implements Iterator<String> {

        private int position;


        @Override
        public boolean hasNext() {
            return this.position + 1 <= collection.size();
        }

        @Override
        public String next() {
            return collection.get(this.position++);
        }
    }
}