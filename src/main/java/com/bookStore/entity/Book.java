package com.bookStore.entity;



import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private String price;
    public Book(int id, String name, String author, String price,Categorie categorie) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.categorie=categorie;
    }
    public Book() {
        super();
        // TODO Auto-generated constructor stub
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @ManyToOne
    @NotNull
    private Categorie categorie;

}
