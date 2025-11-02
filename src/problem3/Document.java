package problem3;
abstract class Document {
    private static int counter = 0;
    protected int numRec;
    protected String title;

    public Document(String title) {
        this.title = title;
        this.numRec = ++counter;
    }

    public String toString() {
        return "Document #" + numRec + " - " + title;
    }
}
