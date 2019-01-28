import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WritetoFile {
    public static void main(String[] args) throws IOException {
        String basePath = "C:\\Users\\Krisko\\Documents\\JAVA\\JavaFund\\" +
                "07.Files And Directories - Lab\\resources";
        String inputPath = basePath + "\\input.txt";
        String outPath = basePath + "\\output.txt";

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        List<Character> punctuation = Arrays.asList(',', '.', '?', '!');

        try {
            inputStream = new FileInputStream(inputPath);
            outputStream = new FileOutputStream(outPath);
            int byteData = inputStream.read();

            while (byteData >= 0) {
                if (!punctuation.contains((char) byteData)) {
                    outputStream.write(byteData);
                }

                byteData = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

    }
}
