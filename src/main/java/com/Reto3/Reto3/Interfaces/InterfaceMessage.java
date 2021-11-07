
package com.Reto3.Reto3.Interfaces;
/**
 * <h1>message </h1>
 * Clase interface message permite conectar el crud con la interface
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Modelo.Message;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceMessage extends CrudRepository<Message,Integer>{
    
}