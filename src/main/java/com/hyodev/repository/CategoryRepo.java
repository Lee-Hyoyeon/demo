package com.hyodev.repository;

import java.util.Locale.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepo extends JpaRepository<Category, Long>{

  void save(com.hyodev.entity.Category category);
  


  
}
