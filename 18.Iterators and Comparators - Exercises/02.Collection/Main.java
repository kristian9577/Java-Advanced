package Collection;

import Collection.ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = bufferedReader.readLine().split("\\s+");

        ListyIterator listyIterator = new ListyIterator();

        listyIterator.create(lines);

        String command = bufferedReader.readLine();

        while (!command.equals("END")) {
            switch (command) {
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
                default:
                    break;

            }
            command = bufferedReader.readLine();
        }
    }
}