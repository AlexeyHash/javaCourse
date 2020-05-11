import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main
{
    public static void main(String[] args)
    {

        try {
            copyDir("C:/Downloads", "C:/Download");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyDir(String sourceDir, String DestDir) throws IOException {

        File folder = new File(sourceDir);
        File[] listOfFiles = folder.listFiles();
        Path destDir = Paths.get(DestDir);

            for (File file : listOfFiles) {
                if (file.isDirectory()) {
                    Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
                    copyDir(file.getAbsolutePath(), DestDir);
                }
                Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
            }
    }

}
