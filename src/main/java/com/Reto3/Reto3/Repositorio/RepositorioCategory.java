
package com.Reto3.Reto3.Repositorio;

import com.Reto3.Reto3.Interfaces.InterfaceCategory;
import com.Reto3.Reto3.Modelo.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class RepositorioCategory {
     @Autowired
    
     
      private InterfaceCategory crud;

    public List<Category> getAll() {
        return (List < Category >) crud.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return crud.findById(id);
    }
    
     public Category save(Category cate){
        return crud.save(cate);
    }
      
    public void delete(Category Cate){
       crud.delete(Cate);
    }
     
    
    
}
