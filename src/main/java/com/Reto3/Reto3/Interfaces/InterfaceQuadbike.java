
package com.Reto3.Reto3.Interfaces;
/**
 * <h1>Quadbike </h1>
 * Clase interface Quadbike permite conectar el crud con la interface
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Modelo.Quadbike;
import org.springframework.data.repository.CrudRepository;



public interface InterfaceQuadbike extends CrudRepository<Quadbike,Integer>{
    
}
