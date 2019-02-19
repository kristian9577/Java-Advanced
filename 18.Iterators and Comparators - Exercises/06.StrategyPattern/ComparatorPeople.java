package StrategyPattern;

import java.util.Comparator;

public class ComparatorPeople implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {
        int result = first.getName().length() - second.getName().length();

        if (result == 0) {
            result = first.getName().toLowerCase().charAt(0) - second.getName().toLowerCase().charAt(0);
        }
        return result;
    }
}
