
package com.Reto3.Reto3.Web;

/**
 * <h1>client  </h1>
 * Clase clientweb declara las sentencias de mapeo consultar.
 *
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Modelo.Client;
import com.Reto3.Reto3.Servicios.ServiciosClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController 
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ClientWeb {
    /**
     * prueba  de respuesta
     * @return retorna saludar 
     */
      @GetMapping("/hola")
    
    public String saludar(){
          return "hola mundo";
    }
    /**
     * maping all
     */
      
    @Autowired
    private ServiciosClient servicios;
    @GetMapping("/all")
    
    /**
     * lista obtenia de client
     */
    public List <Client >getClient (){
        return servicios.getAll();
    }
    /**
     * mapeo obtenido por id
     * @param idclient
     * @return  regresa el id del resultado
     */
       @GetMapping("/{id}")
    public Optional<Client > getClient (@PathVariable("id") int idclient){
        return servicios.getClient (idclient);
    }
    /**
     * mapeo save, guarda el cliente 
    */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client  save(@RequestBody Client  client){
        return servicios.save(client);
    }
    /**
     * actualizacion de cliente
     * @param client
     * @return regresa el id  de el cliente modificado
     */
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client) {
        return servicios.update(client);
    }
    /**
     * elimina el cliente vinculado por id
     * @param clientId
     * @return retorna el id 
     */

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId) {
        return servicios.deleteClient(clientId);
    }
}
