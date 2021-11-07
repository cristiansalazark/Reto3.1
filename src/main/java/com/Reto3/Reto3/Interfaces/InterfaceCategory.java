
package com.Reto3.Reto3.Interfaces;
/**
 * <h1>Category  </h1>
 * Clase interface Category  permite conectar el crud con la interface
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Modelo.Category;
import org.springframework.data.repository.CrudRepository;




public interface InterfaceCategory extends CrudRepository<Category,Integer>{
    
}