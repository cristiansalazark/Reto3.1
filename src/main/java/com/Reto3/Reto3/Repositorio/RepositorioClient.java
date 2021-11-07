
package com.Reto3.Reto3.Repositorio;

/**
 * <h1>Cliente </h1>
 * Clase RepositorioClient crea las funciones de guardar crear eliminar
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Interfaces.InterfaceClient;
import com.Reto3.Reto3.Modelo.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioClient {
    
     @Autowired
    
     
      private InterfaceClient crud;
/**
 * lista de clientes
 * @return regresa la lista de clientes
 */
    public List<Client> getAll() {
        return (List < Client >) crud.findAll();
    }
    /**
     * obtiene el cliente
     * @param id
     * @return retorna el cliente por el id
     */

    public Optional<Client> getClient(int id) {
        return crud.findById(id);
    }
    /**
     * guarda el cliente
     * @param Client
     * @return retorna el cliente creado
     */
     public Client save(Client Client){
        return crud.save(Client);
    }
     /**
      * elimina el client
      * @param Client 
      */
      public void delete(Client Client){
       crud.delete(Client);
    }
    
}
