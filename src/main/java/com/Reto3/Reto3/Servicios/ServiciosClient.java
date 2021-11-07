package com.Reto3.Reto3.Servicios;

/**
 * <h1>client  </h1>
 * Clase serviciosclient crea los servicios de guardar crear eliminar y
 * consultar.
 *
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Modelo.Client;
import com.Reto3.Reto3.Repositorio.RepositorioClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosClient {

    @Autowired

    private RepositorioClient crud;

    /**
     * obtiene la lista de client
     *
     * @return retorna la lista client
     */
    public List<Client> getAll() {
        return crud.getAll();
    }

    /**
     * obtiene client por id
     *
     * @param id
     * @return regresa el cliente por id
     */
    public Optional<Client> getClient(int id) {
        return crud.getClient(id);
    }

    /**
     * crea client
     *
     * @param Client
     * @return retorna el cliente creado
     */

    public Client save(Client Client) {
        if (Client.getIdClient() == null) {
            return crud.save(Client);
        } else {
            Optional<Client> evt = crud.getClient(Client.getIdClient());
            if (evt.isEmpty()) {
                return crud.save(Client);
            } else {
                return Client;
            }
        }
    }

    /**
     * actualiza client mediante el id vinculado
     *
     * @param client
     * @return regresa el cliente modificado
     */
    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> e = crud.getClient(client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    e.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }
                crud.save(e.get());
                return e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    /**
     * elimina el cliente
     *
     * @param clientId
     * @return regresa el cliente eliminado por id
     */
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            crud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
