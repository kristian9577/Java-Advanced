import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String path = "C:\\Users\\Krisko\\Documents\\JAVA\\JavaFund\\" +
                "07.Files And Directories - Lab\\resources\\Files-and-Streams";

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null) {
            return;
        }

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(String.format("%s: [%d]", file.getName(), file.length()));
            }
        }
    }
}

