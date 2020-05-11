import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.text.DecimalFormat;

public class Main
{
    private static long size;
    private static Logger logger;
    public static void main(String[] args)
    {
        File folder = new File("C:/Downloads");
        logger = LogManager.getRootLogger();
        try {
            long folderSize = listFilesForFolder(folder);
            System.out.println("\nОбщий размер папки " + folder.getName() + ": "
                    + calculateFileSize(folderSize));
        }
        catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }
    private static long listFilesForFolder(File folder) {

        for (final File file : folder.listFiles()) {

            if (file.isDirectory()) {
                listFilesForFolder(file);
            }
            else {
                if (file.length() < Math.pow(2.0, 20.0) * 100){
                    logger.info(file.getName() + " - " + calculateFileSize(file.length()));
                }
                if (file.length() > (Math.pow(2.0, 20.0) * 100) && file.length() < Math.pow(2.0, 30.0)){
                    logger.warn(file.getName() + " - " + calculateFileSize(file.length()));
                }
                if (file.length() > Math.pow(2.0, 30.0)){
                    logger.error(file.getName() + " - " + calculateFileSize(file.length()));
                }
                System.out.println(file.getName() + " - " + calculateFileSize(file.length()));
            }
            size = size + file.length();

        }
        return size;
    }

    private static String calculateFileSize(long fileSize){
        Double size = 0.0;
        DecimalFormat format = new DecimalFormat("#0.0#");
        if (fileSize > Math.pow(2.0, 30.0)){
            size = fileSize / Math.pow(2.0, 30.0);
            return format.format(size) + " Гбайт";
        }
        else if (fileSize > Math.pow(2.0, 20.0)){
            size = fileSize / Math.pow(2.0, 20.0);
            return format.format(size) + " Мбайт";
        }
        else if (fileSize > Math.pow(2.0, 10.0)){
            size = fileSize / Math.pow(2.0, 10.0);
            return format.format(size) + " Кбайт";
        }
        else if (fileSize < Math.pow(2.0, 10.0)){
            size = (double) fileSize;
            return format.format(size) + " байт";
        }
        return format.format(size);
    }
}
