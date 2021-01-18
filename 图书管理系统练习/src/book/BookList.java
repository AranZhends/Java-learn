package book;

public class BookList {

    private Book[] books;
    private int usedSized;

    public BookList() {
        this.books = new Book[10];
        books[0] = new Book("三国演义","罗贯中",72,"小说");
        books[1] = new Book("西游记","吴承恩",32,"小说");
        books[2] = new Book("水浒传","施耐庵",52,"小说");
        this.usedSized = 3;
    }


    public void setBook(int pos,Book book){
        this.books[pos] = book;
    }

    public Book getBook(int pos) {
        return this.books[pos];
    }
    public int getUsedSized() {
        return usedSized;
    }

    public void setUsedSized(int usedSized) {
        this.usedSized = usedSized;
    }

}
