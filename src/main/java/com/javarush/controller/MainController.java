package com.javarush.controller;

import com.javarush.entity.Book;
import com.javarush.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/book")
public class MainController {

    @Autowired
    private BookService bookService;


//    @RequestMapping("/list/{pageid}")
//    public String listBook(Model model){
//        // get customer from the dao
//        List<Book> books = bookService.getBooks();
//
//        // add the customers to the model
//        model.addAttribute("books", books);
//
//        return "books-list";
//    }

    @RequestMapping(value="/list/{pageid}")
    public ModelAndView list(@PathVariable int pageid){
        int total=10;
        if(pageid==1){}
        else{
            pageid=(pageid-1)*total+1;
        }
        List<Book> books = bookService.getBooksByPage(pageid,total);

        return new ModelAndView("books-list","books", books);
    }


    @GetMapping("/showFormForAdd")
    public String showForForAdd(Model model){
        Book book = new Book();
        model.addAttribute("book", book);

        return "book-form";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchText") String searchText, Model model){
        List<Book> books = bookService.searchBooks(searchText);

        System.out.println(books.size());
        model.addAttribute("books", books);

        return "books-list";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book ") Book book){

        bookService.saveBook(book);
        return "redirect:/book/list/1";
    }

    @PostMapping("/updateBook")
    public String updateBook(@ModelAttribute("book") Book book){
        book.setReadAlready(false);

        bookService.saveBook(book);
        return "redirect:/book/list/1";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId") int id){
        bookService.deleteBook(id);

        return "redirect:/book/list/1";
    }

    @GetMapping("/changeStatus")
    public String changeBookStatus(@RequestParam("bookId") int id){
        Book book = bookService.getBook(id);
        book.setReadAlready(true);
        bookService.saveBook(book);

        return "redirect:/book/list/1";
    }

    @GetMapping("/showFormForUpdate")
    public String showForForUpdate(@RequestParam("bookId") int id, Model model){
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);

        return "book-update";
    }

}
