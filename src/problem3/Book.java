package problem3;
class Book extends Document {
    private String author;

    public Book(String title, String author) {
        super(title);
        this.author = author;
    }

    public String getAuthor() { return author; }

    public String toString() {
        return super.toString() + " | Author: " + author;
    }
}
