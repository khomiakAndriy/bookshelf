package com.javarush.service;

import com.javarush.entity.Book;

import java.util.List;

public interface BookService {

    public List<Book> getCustomers();

    public void saveCustomer(Book book);

    public Book getCustomer(int id);

    public void deleteCustomer(int id);
}
