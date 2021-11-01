
package com.Reto3.Reto3.Servicios;

import com.Reto3.Reto3.Modelo.Category;
import com.Reto3.Reto3.Repositorio.RepositorioCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ServiciosCategory {
     @Autowired
     
       private RepositorioCategory  crud;
     
      public List<Category > getAll(){
        return crud.getAll();
    }

    public Optional<Category > getCategory(int id){
        return crud.getCategory(id);
    }
    
    
        public Category save(Category cate){
        if(cate.getId()==null){
            return crud.save(cate);
        }else{
            Optional<Category> evt=crud.getCategory(cate.getId());
            if(evt.isEmpty()){
                return crud.save(cate);
            }else{
                return cate;
            }
        }
    }
        public Category update(Category categoria){
        if(categoria.getId()!=null){
            Optional<Category>g=crud.getCategory(categoria.getId());
            if(!g.isEmpty()){
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                return crud.save(g.get());
            }
        }
        return categoria;
    }
    public boolean deletecategoria(int categoriaId){
        Boolean d=getCategory(categoriaId).map(categoria -> {
            crud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
     
     
}
