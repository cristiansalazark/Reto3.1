
package com.Reto3.Reto3.Interfaces;
/**
 * <h1>Client  </h1>
 * Clase interface Client  permite conectar el crud con la interface
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Modelo.Client;
import org.springframework.data.repository.CrudRepository;



public interface InterfaceClient extends CrudRepository<Client,Integer>{
    
}
