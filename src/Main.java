import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);

//        Path filePath = FileSystems.getDefault().getPath("files\\SubdirectoryFile.txt");
        Path filePath = Paths.get(".\\files\\SubdirectoryFile.txt");
        printFile(filePath);

        //Note: below includes special file outside the working directory
        //Note2: this absolute path is also for one device
//        filePath = Paths.get("C:\\Users\\lance\\Documents\\CodingJava\\OutThere.txt");
//        printFile(filePath);

        filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());

        Path path2 = FileSystems.getDefault().getPath(".\\files\\..\\files\\SubdirectoryFile.txt");
        System.out.println(path2.normalize().toAbsolutePath());
        printFile(path2.normalize());
    }

    private static void printFile(Path path) {
        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
