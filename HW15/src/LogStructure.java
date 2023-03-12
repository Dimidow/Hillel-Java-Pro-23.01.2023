import java.text.SimpleDateFormat;
import java.util.Date;

public class LogStructure {


    private final String pattern = "dd.MM.YYYY-HH-mm.SSS";
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    private String dateLogging;
    private String loggingLevel;
    private String message;



    public LogStructure(Date date, String loggingLevel, String message) {
        this.loggingLevel = loggingLevel;
        this.message = message;
        dateLogging = simpleDateFormat.format(date);
    }

    public LogStructure() {
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    @Override
    public String toString() {
        return dateLogging + " " + loggingLevel + " " + message + "\n";
    }
}
