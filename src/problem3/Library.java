package problem3;
import java.util.ArrayList;

class Library {
    private int capacity;
    private ArrayList<Document> docs;

    public Library(int capacity) {
        this.capacity = capacity;
        docs = new ArrayList<>();
    }

    public boolean add(Document d) {
        if (docs.size() < capacity) {
            docs.add(d);
            return true;
        }
        return false;
    }

    public void displayDocuments() {
        for (Document d : docs) System.out.println(d);
    }

    public void displayAuthors() {
        for (Document d : docs)
            if (d instanceof Book)
                System.out.println(((Book)d).getAuthor());
    }
}
