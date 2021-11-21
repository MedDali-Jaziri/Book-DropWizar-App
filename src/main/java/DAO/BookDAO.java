package DAO;
import Entity.Book;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class BookDAO extends AbstractDAO<Book> {
    public BookDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Book getBook(int id){
        return get(id);
    }

    public Book addBook(Book book){
        return persist(book);
    }

    public List<Book> getBooks(){
        return list(currentSession().createQuery("SELECT b FROM Book b"));
    }

    public String deleteBooks(int id){
        Book bookDele = getBook(id);
        currentSession().delete(bookDele);
        return "Delete book with sucess";
    }

    public String updateBook(Book book){
        currentSession().update(book);
        return "Update book with sucess";
    }
}
