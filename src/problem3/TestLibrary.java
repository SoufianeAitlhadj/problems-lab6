package problem3;
public class TestLibrary {
    public static void main(String[] args) {
        Library lib = new Library(3);
        lib.add(new Book("The Alchemist", "Paulo Coelho"));
        lib.add(new Book("Clean Code", "Robert C. Martin"));

        lib.displayDocuments();
        lib.displayAuthors();
    }
}
