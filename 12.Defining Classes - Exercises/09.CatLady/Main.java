package CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Cat> cats = new HashMap<>();
        String input;

        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String type = tokens[0];
            String name = tokens[1];
            double value = Double.parseDouble(tokens[2]);

            Cat cat = null;
            switch (type) {
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, value);
                    break;
                case "Siamese":
                    cat = new Siamese(name, value);
                    break;
                case "Cymric":
                    cat = new Cymric(name, value);
            }
            if (cat != null) {
                cats.put(name, cat);
            }
        }
        String catName = reader.readLine();

        if (cats.containsKey(catName)) {
            System.out.println(cats.get(catName));
        }
    }
}
