
package com.Reto3.Reto3.Servicios;
/**
 * <h1>category </h1>
 * Clase servicioscategory crea los servicios de guardar crear eliminar y consultar.
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
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
     
     /**
      * obtiene la lista de category
      * @return retorna la lista category
      */
      public List<Category > getAll(){
        return crud.getAll();
    }
      /**
       * obtiene category por id
       * @param id
       * @return regresa la category vinculada a el ip 
       */

    public Optional<Category > getCategory(int id){
        return crud.getCategory(id);
    }
    /**
     * crea la categoria 
     * @param cate
     * @return regresa la categoria creada 
     */
    
    
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
        /**
         * modifica la categoria 
         * @param categoria
         * @return retorna los cambios echos en categoria 
         */
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
        /**
         * elimina la categoria por id 
         * @param categoriaId
         * @return regresa la categoria vinculada por el id
         */
    public boolean deletecategoria(int categoriaId){
        Boolean d=getCategory(categoriaId).map(categoria -> {
            crud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
     
     
}
