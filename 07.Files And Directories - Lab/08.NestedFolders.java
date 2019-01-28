import java.io.File;
import java.util.*;

public class NestedFolders {
    public static void main(String[] args) {
        String path = "C:\\Users\\Krisko\\Documents\\JAVA\\JavaFund\\" +
                "07.Files And Directories - Lab\\resources\\Files-and-Streams";

        File dir = new File(path);

        Deque<File> files = new ArrayDeque<>();
        files.addLast(dir);
        List<String> folders = new ArrayList<>();

        while (! files.isEmpty()) {
            File currentDir = files.removeFirst();
            if (currentDir.isDirectory()) {
                for (File file : Objects.requireNonNull(currentDir.listFiles())) {
                    if (file.isDirectory()) {
                        files.addLast(file);
                    }
                }
                folders.add(currentDir.getName());
            }
        }
        folders.forEach(System.out::println);
        System.out.println(String.format("%d folders", folders.size()));

    }
}