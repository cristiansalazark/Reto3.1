package com.Reto3.Reto3.Repositorio;

/**
 * <h1>message </h1>
 * Clase Repositoriomessage crea las funciones de guardar crear eliminar
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Interfaces.InterfaceMessage;
import com.Reto3.Reto3.Modelo.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMessage {

    @Autowired
    private InterfaceMessage crudm;
/**
 * lista de message
 * @return regresa la lista de message
 */
    public List<Message> getAll() {
        return (List< Message>) crudm.findAll();
    }
  /**
     * obtiene message
     *
     * @param id
     * @return retorna el message por el id
     */
    public Optional<Message> getMessage(int id) {
        return crudm.findById(id);
    }
/**
 * guarda message
 * @param messa
 * @return regresa   el mensaje creado
 */
    public Message save(Message messa) {
        return crudm.save(messa);
    }
    /**
     * elmina el mensaje vinculado a la ip
     * @param messa 
     */

    public void delete(Message messa) {
        crudm.delete(messa);
    }
}
