import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\Krisko\\Documents\\JAVA\\JavaFund\\" +
                "07.Files And Directories - Lab\\resources";
        String inputPath = basePath + "\\input.txt";
        String outPath = basePath + "\\3output.txt";

        try (
                FileInputStream fileInputStream = new FileInputStream(inputPath);
                FileOutputStream fileOutputStream = new FileOutputStream(outPath)
        ) {
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                String digits = String.valueOf(oneByte);
                if (oneByte == 32) {
                    fileOutputStream.write(' ');
                } else if (oneByte == 10) {
                    fileOutputStream.write('\n');
                } else {
                    for (int i = 0; i < digits.length(); i++) {
                        fileOutputStream.write(digits.charAt(i));
                    }
                }
                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
