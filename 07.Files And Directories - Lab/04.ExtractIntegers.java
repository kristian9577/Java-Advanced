import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String basePath = "C:\\Users\\Krisko\\Documents\\JAVA\\JavaFund\\" +
                "07.Files And Directories - Lab\\resources";
        String inputPath = basePath + "\\input.txt";
        String outPath = basePath + "\\4output.txt";

        Scanner inputStream = null;
        FileOutputStream outputStream = null;


        try {
            inputStream = new Scanner(new FileInputStream(inputPath));
            outputStream = new FileOutputStream(outPath);

            while (inputStream.hasNext()) {
                if (inputStream.hasNextInt()) {
                    System.out.println(inputStream.nextInt());
                }
                inputStream.next();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
