package com.bookStore.controller;

import com.bookStore.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;

import java.util.*;

@Controller
public class BookController {
    @Autowired

    private CategorieRepository categorieRepository;

    @Autowired//tadhrab el principe d'encapsulation//Utilisé pour effectuer l'injection de dépendances .
    private BookService service;

    @Autowired
    private MyBookListService myBookService;


    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister(Model m) {
        m.addAttribute("categories",categorieRepository.findAll());
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook() {
        List<Book>list=service.getAllBook();
        return new ModelAndView("bookList","book",list);// Utilisés pour transporter les données entre le contrôleur et la vue.
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        service.save(b);
        return "redirect:/available_books";
    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model)
    {
        List<MyBookList>list=myBookService.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book b=service.getBookById(id);
        MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model) {
        Book b=service.getBookById(id);
        model.addAttribute("book",b);
        model.addAttribute("categories",categorieRepository.findAll());
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id) {
        service.deleteById(id);
        return "redirect:/available_books";
    }

}
