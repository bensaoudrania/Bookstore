package com.bookStore.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Book;
import com.bookStore.repository.BookRepository;
import org.springframework.web.multipart.MultipartFile;

@Service// utilisée pour indiquer à Spring que la classe annotée est un service

public class BookService {


    @Autowired
    private BookRepository bRepo;

    public void save(Book b) {
        bRepo.save(b);
    }

    public List<Book> getAllBook(){
        return bRepo.findAll();
    }

    public Book getBookById(int id) {
        return bRepo.findById(id).get();
    }
    public void deleteById(int id) {
        bRepo.deleteById(id);
    }

}
