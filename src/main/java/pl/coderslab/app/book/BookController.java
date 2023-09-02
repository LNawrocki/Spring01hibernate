package pl.coderslab.app.book;


import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.publisher.Publisher;
import pl.coderslab.app.publisher.PublisherDao;

//@Controller
@RestController
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    public BookController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }
    @GetMapping("/books/add")
    public String add() {
        PublisherDao publisherDao1 = new PublisherDao();
        Publisher publisher = publisherDao1.findById(1L);
        Book book = new Book();
        book.setTitle("title1");
        book.setRating(5);
        book.setDescription("desc1");
        book.setPublisher(publisher);
        bookDao.saveBook(book);
        return "Dodano book1";
    }

    @GetMapping("/book/get/{id}")
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @PostMapping("/book/update/{id}/{title}")
    public String updateBook(@PathVariable long id, @PathVariable String title) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

    @PostMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable long id) {
//        Book book = bookDao.findById(id);
        bookDao.delete(id);
        return "deleted";
    }
}
