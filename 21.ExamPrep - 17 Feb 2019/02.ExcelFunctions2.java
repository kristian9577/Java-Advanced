import java.util.ArrayList;

import java.util.*;

public class ExcelFunctions2 { // solution with Lists

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        ArrayList<ArrayList<String>> matrix = new ArrayList<>();

        while (n-- > 0) {
            String[] data = sc.nextLine().split("[,\\s]+");
            matrix.addAll(
                    Collections.singleton(
                            new ArrayList<>(Arrays.asList(data))));
        }

        String[] line = sc.nextLine().split(" ");

        switch (line[0]) {
            case "sort":
                sortMatrix(matrix, line[1]);
                break;
            case "hide":
                hide(matrix, line[1]);
                break;
            case "filter":
                filter(matrix, line[1], line[2]);
                break;
            default:
                break;
        }
    }

    private static void sortMatrix(ArrayList<ArrayList<String>> matrix, String param) {
        int headerIndex = matrix.get(0).indexOf(param);
        System.out.println(print(matrix.get(0)));

        matrix
                .stream()
                .skip(1)
                .sorted(Comparator.comparing(o -> o.get(headerIndex)))
                .forEach(rows -> System.out.println(print(rows)));
    }

    private static void filter(ArrayList<ArrayList<String>> matrix, String headerName, String param) {
        int headerIndex = matrix.get(0).indexOf(headerName);
        System.out.println(print(matrix.get(0)));

        matrix
                .stream()
                .skip(1)
                .filter(rows -> rows.get(headerIndex).contains(param))
                .forEach(row -> System.out.println(print(row)));
    }

    private static void hide(ArrayList<ArrayList<String>> matrix, String param) {
        int colToHide = matrix.get(0).indexOf(param);

        for (ArrayList<String> rows : matrix) {
            rows.remove(colToHide);
        }

        for (ArrayList<String> rows : matrix) {
            System.out.println(print(rows));
        }
    }

    private static String print(ArrayList<String> matrix) {
        return String.join(" | ", matrix);
    }
}

