public class OccuranceEntity {


    private String name;
    private int occurrence;

    public OccuranceEntity(String name, int occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }

    @Override
    public String toString() {
        return "{" +
               "name:\"" + name + '\"' +
               ", occurrence=" + occurrence +
               '}';
    }
}
