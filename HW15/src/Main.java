import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        FileLogger fileLogger = new FileLogger();
        System.out.println("\n result of adding/reading logs. If max file size is exceeded than creating new one:");
        try {
            for (int i = 0; i < 20; i++) {
                fileLogger.debug("Logs 321321 321321213");
                System.out.println(new FileLoggerConfigurationLoader().load().toString());
                Thread.sleep(1000);
            }
        } catch (FileMaxSizeReachedException fileMaxSizeReachedException) {
            System.out.println(fileMaxSizeReachedException.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}