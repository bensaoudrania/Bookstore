package com.bookStore;

import com.bookStore.repository.BookRepository;
import com.bookStore.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner{
	@Autowired //injection de dependence ken nahihom iwaliw null
	CategorieRepository categorieRepository;
	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {

		SpringApplication.run(BookStoreApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}


