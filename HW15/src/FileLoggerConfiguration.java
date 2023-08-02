import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class FileLoggerConfiguration {

    private static double maxFileSize = 0.3;
    private static String filePath = "src/";
    private static File file = createFile();
    private LoggingLevel loggingLevel;
    private LogStructure logStructure;

    public FileLoggerConfiguration() {
    }

    public FileLoggerConfiguration(String filePath, String loggingLevel, double maxFileSize, LogStructure logStructure) {
        FileLoggerConfiguration.filePath = filePath;
        this.loggingLevel = LoggingLevel.valueOf(loggingLevel);
        FileLoggerConfiguration.maxFileSize = maxFileSize;
        this.logStructure = logStructure;
    }

    public LogStructure getLogStructure(String message, LoggingLevel loggingLevel) {
        logStructure = new LogStructure(new Date(), loggingLevel.getLoggingLevel(), message);
        return logStructure;
    }

    public boolean isMaxFileSizeExceeded() throws FileMaxSizeReachedException {
        double currentFileSize = (double) file.length() / 1024;
        BigDecimal roundedCurrentFileSize = new BigDecimal(currentFileSize).setScale(2, RoundingMode.HALF_UP);

        if (currentFileSize >= maxFileSize) {
            File newFile = createFile();
            file = newFile;
            //throw new FileMaxSizeReachedException(
            System.out.println(
                "Current file size " + roundedCurrentFileSize + " Kb is exceeded the max size " + maxFileSize + " Kb. Path to file: " + file.getAbsolutePath());
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nFILE: " + filePath +
               "\nLEVEL: " + loggingLevel +
               "\nMAX-SIZE: " + maxFileSize +
               "\nFORMAT: " + logStructure;
    }

    public static File getFile() {
        return file;
    }

    public static String getFilePath() {
        return filePath;
    }

    public static double getMaxFileSize() {
        return maxFileSize;
    }

    private static File createFile() {
        return new File(filePath, "Log_" + new LogStructure().getSimpleDateFormat().format(new Date()) + ".txt");
    }


    public enum LoggingLevel {

        INFO("INFO"),
        DEBUG("DEBUG");

        private final String loggingLevel;

        LoggingLevel(String loggingLevel) {
            this.loggingLevel = loggingLevel;
        }

        public String getLoggingLevel() {
            return loggingLevel;
        }
    }
}
