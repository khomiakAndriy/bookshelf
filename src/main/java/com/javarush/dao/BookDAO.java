package com.javarush.dao;

import com.javarush.entity.Book;

import java.util.List;

public interface BookDAO {

    public List<Book> getBooks();

    public void saveBook(Book book);

    public Book getBook(int id);

    public void deleteBook(int id);

    public List<Book> getBooksByPage(int pageid, int total);

    public List<Book> searchBooks(String searchText);
}
