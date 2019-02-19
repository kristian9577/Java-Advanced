package ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        ArrayList<Person> people = new ArrayList<>();

        while (!input.equals("END")) {

            String[] tokens = input.split(" ");

            Person p = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            people.add(p);

            input = reader.readLine();
        }
        int n = Integer.parseInt(reader.readLine());

        Person comparePerson = people.get(n - 1);

        int equalPeople = (int) people.stream()
                .filter(p -> p.compareTo(comparePerson) == 0)
                .count();

        if(equalPeople==1){
            System.out.println("No matches");
        }else{
            System.out.println(String.format("%d %d %d",equalPeople,people.size()-equalPeople,people.size()));
        }
    }
}
