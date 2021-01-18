package operation;

import book.Book;
import book.BookList;

public class DisplayOperation implements IOperation {
    @Override
    public void works(BookList bookList) {
        for (int i = 0; i < bookList.getUsedSized(); i++) {
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
    }
}
