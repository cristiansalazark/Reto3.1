package com.Reto3.Reto3.Repositorio;

import com.Reto3.Reto3.Interfaces.InterfaceQuadbike;
import com.Reto3.Reto3.Modelo.Client;
import com.Reto3.Reto3.Modelo.Quadbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class RepositorioQuadbike {

    @Autowired
    private InterfaceQuadbike crud;

    public List<Quadbike> getAll() {
        return (List < Quadbike >) crud.findAll();
    }

    public Optional<Quadbike> getQuadbike(int id) {
        return crud.findById(id);
    }
    
     public Quadbike save(Quadbike Quad){
        return crud.save(Quad);
    }
      public void delete(Quadbike Quad){
       crud.delete(Quad);
    }
     
     
}
