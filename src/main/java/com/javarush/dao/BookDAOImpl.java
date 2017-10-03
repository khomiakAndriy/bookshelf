package com.javarush.dao;

import com.javarush.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Book> getBooks() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Book> query = currentSession.createQuery("from Book order by title", Book.class);

        return query.getResultList();
    }

    public void saveBook(Book book) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(book);
    }

    public Book getBook(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.get(Book.class, id);
    }

    public void deleteBook(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query =
                currentSession.createQuery("delete from Book where id=:bookId");

        query.setParameter("bookId", id);

        query.executeUpdate();
    }
}
