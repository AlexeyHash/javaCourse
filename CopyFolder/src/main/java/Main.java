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

    private static void copyDir(String sourceFolder, String destFolder) throws IOException {

        File folder = new File(sourceFolder);
        File[] listOfFiles = folder.listFiles();
        Path destDir = Paths.get(destFolder);

            for (File file : listOfFiles) {
                if (file.isDirectory()) {
                    Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
                    copyDir(file.getAbsolutePath(), destDir.resolve(file.getName()).toString());
                }
                if (file.exists() && file.isDirectory()) {
                    continue;
                }
                Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
            }
    }

}
