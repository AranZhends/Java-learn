package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class FindOperation implements IOperation {
    @Override
    public void works(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要查找的书名");
        String name = scanner.nextLine();

        for (int i = 0; i < bookList.getUsedSized(); i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)) {
                System.out.println("有这本书！");
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有这本书！");
    }
}
