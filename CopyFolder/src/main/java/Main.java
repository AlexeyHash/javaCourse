import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main
{
    public static void main(String[] args)
    {

        Path srcDir = Paths.get("C:/Downloads");
        Path destDir = Paths.get("C:/Download");

        try {
            Files.walkFileTree(srcDir, new CopyDirVisitor(srcDir, destDir, StandardCopyOption.REPLACE_EXISTING));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class CopyDirVisitor extends SimpleFileVisitor<Path>
    {
        private Path srcDir;
        private Path destDir;
        private CopyOption copyOption;

        public CopyDirVisitor(Path srcDir, Path destDir, CopyOption copyOption)
        {
            this.srcDir = srcDir;
            this.destDir = destDir;
            this.copyOption = copyOption;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
        {
            Path targetPath = destDir.resolve(srcDir.relativize(dir));
            if (!Files.exists(targetPath)){
                Files.createDirectory(targetPath);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
        {
         Files.copy(srcDir, destDir.resolve(srcDir.relativize(file)));
         return FileVisitResult.CONTINUE;
        }

    }
}


//try {
//        copyDir("C:/Downloads", "C:/Download");
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//private static void copyDir(String sourceFolder, String destFolder) throws IOException {
//
//        File folder = new File(sourceFolder);
//        File[] listOfFiles = folder.listFiles();
//        Path destDir = Paths.get(destFolder);
//
//        for (File file : listOfFiles) {
//        if (file.isDirectory()) {
//        Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
//        copyDir(file.getAbsolutePath(), destDir.resolve(file.getName()).toString());
//        }
//        if (file.exists() && file.isDirectory()) {
//        continue;
//        }
//        Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
//        }
//        }
