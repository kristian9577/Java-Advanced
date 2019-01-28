import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Krisko\\Documents\\JAVA\\JavaFund\\" +
                "07.Files And Directories - Lab\\resources\\input.txt";

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
            int byteData = inputStream.read();

            while (byteData >= 0) {
                System.out.print(Integer.toBinaryString(byteData) + " ");
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
