package pl.coderslab.app.book;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(long id) {
        Book bookById = findById(id);
        entityManager.remove(entityManager.contains(bookById) ? bookById : entityManager.merge(bookById));
    }

}
