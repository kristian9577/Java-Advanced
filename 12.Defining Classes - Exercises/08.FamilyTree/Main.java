package FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String END_COMMAND = "End";
    private static FamilyTree familyTree;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        readDescendent();
        String input;
        while (! END_COMMAND.equals(input = reader.readLine())) {
            String[] tokens = input.split(" - ");

            if (tokens.length == 2) {
                String parent = tokens[0];
                String child = tokens[1];
                familyTree.addRelation(parent, child);
            } else {
                String[] tie = tokens[0].split("\\s+");
                String givenName = tie[0];
                String familyName = tie[1];
                String birthDate = tie[2];
                familyTree.addFamilyMember(givenName, familyName, birthDate);
            }
        }

        familyTree.tieInformation();
        System.out.println(familyTree.toString());
    }

    private static void readDescendent() throws IOException {
        familyTree = new FamilyTree();
        Person descendent = initPerson(reader.readLine());
        familyTree.setDescendent(descendent);
    }

    private static Person initPerson(String token) {
        String[] tokens = token.split("\\s+");
        if (tokens.length == 2) {
            String givenName = tokens[0];
            String familyName = tokens[1];
            return new Person(givenName, familyName);
        } else {
            String birthDate = tokens[0];
            return new Person(birthDate);
        }
    }
}