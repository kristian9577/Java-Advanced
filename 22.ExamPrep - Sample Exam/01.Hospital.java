import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hospital {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String[][]> departments = new HashMap<>();
        Map<String, TreeSet<String>> doctorsAndPatients = new HashMap<>();

        String line;

        while (!"Output".equals(line = reader.readLine())) {
            String[] tokens = line.split(" ");
            String department = tokens[0];
            String doctor = tokens[1] + " " + tokens[2];
            String patient = tokens[3];

            if (!departments.containsKey(department)) {
                departments.put(department, new String[20][3]);
            }
            boolean patientAdded = false;
            for (int i = 0; i < departments.get(department).length; i++) {
                for (int j = 0; j < departments.get(department)[i].length; j++) {
                    if (departments.get(department)[i][j] == null) {
                        departments.get(department)[i][j] = patient;
                        patientAdded = true;
                        break;
                    }
                }
                if (patientAdded) {
                    break;
                }
            }

            if (!doctorsAndPatients.containsKey(doctor)) {
                doctorsAndPatients.put(doctor, new TreeSet<>());
            }
            if (patientAdded) {
                doctorsAndPatients.get(doctor).add(patient);
            }
        }
        while (!"End".equals(line = reader.readLine())) {
            String[] tokens = line.split(" ");
            if (tokens.length == 1) {
                String department = tokens[0];
                for (int i = 0; i < departments.get(department).length; i++) {
                    for (int j = 0; j < departments.get(department)[i].length; j++) {
                        if (departments.get(department)[i][j] != null) {
                            System.out.println(departments.get(department)[i][j]);
                        }
                    }
                }

            } else if (tokens.length == 2) {
                if (Character.isDigit(tokens[1].charAt(0))) {
                    String department = tokens[0];
                    int room = Integer.parseInt(tokens[1])-1;

                    String[] patients = departments.get(department)[room];
                    Arrays.stream(patients)
                            .filter(Objects::nonNull)
                            .sorted(String::compareTo)
                            .forEach(System.out::println);

                } else {
                    String doctor = tokens[0] + " " + tokens[1];

                    doctorsAndPatients.get(doctor)
                            .forEach(System.out::println);
                }
            }
        }
    }
}
