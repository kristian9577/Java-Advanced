package Library;

import java.util.Iterator;
import java.util.function.Consumer;

public class Library<Book> implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    @Override
    public void forEach(Consumer action) {
        for (int i = 0; i < this.books.length; i++) {
            action.accept(books[i]);
        }
    }



    private class LibIterator implements Iterator<Book>{

        private int counter;

        @Override
        public boolean hasNext() {
            return counter < books.length;
        }

        @Override
        public Book next() {
            return books[counter++];
        }
    }
}