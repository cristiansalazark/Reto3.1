package com.Reto3.Reto3.Servicios;

/**
 * <h1>client  </h1>
 * Clase serviciosmessage crea los servicios de guardar crear eliminar y
 * consultar.
 *
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Modelo.Message;
import com.Reto3.Reto3.Repositorio.RepositorioMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMessage {

    @Autowired

    private RepositorioMessage metodoscrudm;

    /**
     * obtiene la lista de message
     *
     * @return retorna la lista message
     */
    public List<Message> getAll() {
        return metodoscrudm.getAll();
    }

    /**
     * ontiene el menssage oir id
     *
     * @param idmessa
     * @return retorna el mesage por id
     */

    public Optional<Message> getMessage(int idmessa) {
        return metodoscrudm.getMessage(idmessa);
    }

    /**
     * guarda message
     *
     * @param mesa
     * @return reptor namesa
     */
    public Message save(Message mesa) {
        if (mesa.getIdMessage() == null) {
            return metodoscrudm.save(mesa);
        } else {
            Optional<Message> evt = metodoscrudm.getMessage(mesa.getIdMessage());
            if (evt.isEmpty()) {
                return metodoscrudm.save(mesa);
            } else {
                return mesa;
            }
        }
    }

    /**
     * actualliza message
     *
     * @param message
     * @return retorna el message modificado
     */
    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> e = metodoscrudm.getMessage(message.getIdMessage());
            if (!e.isEmpty()) {
                if (message.getMessageText() != null) {
                    e.get().setMessageText(message.getMessageText());
                }
                metodoscrudm.save(e.get());
                return e.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    /**
     * elimina el mensaje vinculado por id
     *
     * @param messageId
     * @return retorna el mensaje que se elimino
     */
    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodoscrudm.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
