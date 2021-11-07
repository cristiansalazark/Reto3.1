
package com.Reto3.Reto3.Web;

/**
 * <h1>message  </h1>
 * Clase messageweb declara las sentencias de mapeo consultar.
 *
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Modelo.Message;
import com.Reto3.Reto3.Servicios.ServiciosMessage;
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
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class MessageWeb {
  
    /**
     * obtiene  la peticion hola
     * @return retorna el saludo
     */
    @GetMapping("/hola")
    
    public String saludar(){
          return "hola mundo";
    }
    
    /**
     * mapeo serviciosmmessage
     */
     
    @Autowired
    private ServiciosMessage serviciosmessage;
    @GetMapping("/all")
    
    /**
     * obtiene la lista message
     */
    public List <Message>getMessage(){
        return serviciosmessage.getAll();
    }
    /**
     * obtiene  message por id
     * @param idmessa
     * @return regresa id por message
     */
       @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int idmessa){
        return serviciosmessage.getMessage(idmessa);
    }
    /**
     * guarda message
     * @param messa
     * @return retorna messa guardado
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message messa){
        return serviciosmessage.save(messa);
    }
    
    /**
     * actualiza message
     * @param message
     * @return regresa messa actualizado
     */
        @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message) {
        return serviciosmessage.update(message);
    }
/**
 * elimina message 
 * @param messageId
 * @return regresa el id de messade eliminado
 */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return serviciosmessage.deleteMessage(messageId);
    }
    
}
