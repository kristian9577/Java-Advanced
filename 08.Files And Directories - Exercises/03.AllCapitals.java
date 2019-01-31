import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\Krisko\\Documents\\JAVA\\JavaFund\\" +
                "08.Files And Directories - Exercises\\resources";
        String inputPath = basePath + "\\input.txt";
        String outPath = basePath + "\\output.txt";

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(new File(inputPath))));
             PrintWriter out = new PrintWriter(new FileWriter(outPath))) {


            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line.toUpperCase());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
