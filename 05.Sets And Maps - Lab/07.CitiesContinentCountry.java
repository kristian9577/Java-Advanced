import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class CitiesContinentCountry {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> continentData = new LinkedHashMap<>();
        int rowCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < rowCount; i++) {
            String[] parts = reader.readLine().split(" ");
            String continent = parts[0];
            String country = parts[1];
            String city = parts[2];
            if (continentData.containsKey(continent)) {
                LinkedHashMap<String, List<String>> countriesData = continentData.get(continent);
                if (countriesData.containsKey(country)) {
                    List<String> cities = countriesData.get(country);
                    cities.add(city);
                    countriesData.put(country, cities);
                } else {
                    List<String> cities = new ArrayList<>();
                    cities.add(city);
                    countriesData.put(country, cities);

                }
                continentData.put(continent, countriesData);
            } else {
                LinkedHashMap<String, List<String>> countriesData = new LinkedHashMap<>();
                List<String> cities = new ArrayList<>();
                cities.add(city);
                countriesData.put(country, cities);
                continentData.put(continent, countriesData);

            }
        }
        for (String continentName : continentData.keySet()) {
            System.out.println(continentName + ":");
            LinkedHashMap<String, List<String>> countriesData = continentData.get(continentName);
            for (String countryName : countriesData.keySet()) {
                System.out.print(countryName + " -> ");
                System.out.println(String.join(", ", countriesData.get(countryName)));
            }
        }
    }
}
