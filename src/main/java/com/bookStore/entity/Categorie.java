package com.bookStore.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data // getter & setter & tostring
@AllArgsConstructor
@NoArgsConstructor
@Builder // patern dessign
@Entity
public class Categorie {
    @Id //cle primaire id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
    private Long id;
    private String nom;
    @JsonIgnore
    //assocation biderctionnelle
    //mappedby tethat fel onetomany
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL) // indiquer ei lokhra maitre mtee table lokhra , cascade bech ki tfassakh categore tout les produits yetfasskhou
    private List<Book> produits; // une categorie contien oo produit
}
