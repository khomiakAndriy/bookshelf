package com.javarush.service;

import com.javarush.dao.BookDAO;
import com.javarush.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Transactional
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }

    @Transactional
    public void saveBook(Book book) {
        bookDAO.saveBook(book);
    }

    @Transactional
    public Book getBook(int id) {
        return bookDAO.getBook(id);
    }

    @Transactional
    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }

    @Transactional
    public List<Book> getBooksByPage(int pageid, int total) {
        return bookDAO.getBooksByPage(pageid, total);
    }

    @Transactional
    public List<Book> searchBooks(String searchText) {
        return bookDAO.searchBooks(searchText);
    }
}
