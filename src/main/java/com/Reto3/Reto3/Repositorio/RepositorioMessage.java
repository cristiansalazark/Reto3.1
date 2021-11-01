package com.Reto3.Reto3.Repositorio;

import com.Reto3.Reto3.Interfaces.InterfaceMessage;
import com.Reto3.Reto3.Modelo.Client;
import com.Reto3.Reto3.Modelo.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMessage {

    @Autowired
    private InterfaceMessage crudm;

    public List<Message> getAll() {
        return (List< Message>) crudm.findAll();
    }

    public Optional<Message> getMessage(int id) {
        return crudm.findById(id);
    }

    public Message save(Message messa) {
        return crudm.save(messa);
    }

    public void delete(Message messa) {
        crudm.delete(messa);
    }
}
