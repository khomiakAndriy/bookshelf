package com.javarush.service;

import com.javarush.dao.BookDAO;
import com.javarush.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;


    public List<Book> getCustomers() {
        return bookDAO.getBooks();
    }

    public void saveCustomer(Book book) {
        bookDAO.saveBook(book);
    }

    public Book getCustomer(int id) {
        return bookDAO.getBook(id);
    }

    public void deleteCustomer(int id) {
        bookDAO.deleteBook(id);
    }
}
