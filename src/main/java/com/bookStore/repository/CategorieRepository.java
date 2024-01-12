package com.bookStore.repository;



import com.bookStore.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository <Categorie,Long> {
}
