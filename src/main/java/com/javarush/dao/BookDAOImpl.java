package com.javarush.dao;

import com.javarush.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
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

    public List<Book> getBooksByPage(int pageid, int total) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Book> query = currentSession.createQuery("from Book order by title", Book.class);
        int from = pageid - 1;
        int to = pageid + total - 1;


        List<Book> books = query.getResultList();
        int booksSize = books.size();

        if (booksSize>to){
            return books.subList(from, to);
        } else {
            return books.subList(from, booksSize);
        }


    }

    public List<Book> searchBooks(String searchText) {
        Session currentSession = sessionFactory.getCurrentSession();

        String sql = "from Book where title like '%" + searchText + "%'";
        Query<Book> query = currentSession.createQuery(sql, Book.class);

        List<Book> books = query.getResultList();
        return books;

    }
}
