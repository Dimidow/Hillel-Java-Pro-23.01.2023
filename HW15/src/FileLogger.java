import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {

    private final FileLoggerConfiguration fileLoggerConfiguration;


    public FileLogger(){
        fileLoggerConfiguration = new FileLoggerConfiguration();
    }


    public void info(String message) throws IOException, FileMaxSizeReachedException {
        if(!fileLoggerConfiguration.isMaxFileSizeExceeded()) {
            writeLog(message, FileLoggerConfiguration.LoggingLevel.INFO);
        }
    }

    public void debug(String message) throws IOException, FileMaxSizeReachedException {
        if(fileLoggerConfiguration.isMaxFileSizeExceeded()) {
            writeLog(message, FileLoggerConfiguration.LoggingLevel.INFO);
            writeLog(message, FileLoggerConfiguration.LoggingLevel.DEBUG);
        }
    }

    private void writeLog(String message, FileLoggerConfiguration.LoggingLevel loggingLevel) throws IOException {
        try (FileWriter logsFileWriter = new FileWriter(fileLoggerConfiguration.getFile(), true)) {
            logsFileWriter.write(fileLoggerConfiguration.getLogStructure(message, loggingLevel).toString());
        }
    }
}
