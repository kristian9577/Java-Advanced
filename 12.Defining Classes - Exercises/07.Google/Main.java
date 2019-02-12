package Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Map<String, Person> people=new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        gatherPersonalInformation();

        String person = reader.readLine();

        if (people.containsKey(person)) {
            System.out.print(people.get(person));
        }


    }
    private static void gatherPersonalInformation() throws IOException {
        String input;
        while (! "End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            people.putIfAbsent(personName, new Person(personName));

            Person person = people.get(personName);
            String command = tokens[1];
            switch (command) {
                case "company":
                    person.setCompany(new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4])));
                    break;
                case "pokemon":
                    person.add(new Pokemon(tokens[2], tokens[3]));
                    break;
                case "parents":
                    person.add(new Parent(tokens[2], tokens[3]));
                    break;
                case "children":
                    person.add(new Child(tokens[2], tokens[3]));
                    break;
                case "car":
                    person.setCar(new Car(tokens[2], tokens[3]));
                    break;
            }
        }
    }
}
