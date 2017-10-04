package com.javarush.controller;

import com.javarush.entity.Book;
import com.javarush.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/book")
public class MainController {

    @Autowired
    private BookService bookService;


    @RequestMapping("/list")
    public String listBook(Model model){
        // get customer from the dao
        List<Book> books = bookService.getBooks();

        // add the customers to the model
        model.addAttribute("books", books);

        return "books-list";
    }


    @GetMapping("/showFormForAdd")
    public String showForForAdd(Model model){
        Book book = new Book();
        model.addAttribute("book", book);

        return "book-form";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book ") Book book){

        bookService.saveBook(book);
        return "redirect:/book/list";
    }

    @PostMapping("/updateBook")
    public String updateBook(@ModelAttribute("book") Book book){
        book.setReadAlready(false);

        bookService.saveBook(book);
        return "redirect:/book/list";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId") int id){
        bookService.deleteBook(id);

        return "redirect:/book/list";
    }

    @GetMapping("/changeStatus")
    public String changeBookStatus(@RequestParam("bookId") int id){
        Book book = bookService.getBook(id);
        book.setReadAlready(true);
        bookService.saveBook(book);

        return "redirect:/book/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showForForUpdate(@RequestParam("bookId") int id, Model model){
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);

        return "book-update";
    }

}
