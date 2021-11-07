package com.Reto3.Reto3.Repositorio;


/**
 * <h1>Quadbike </h1>
 * Clase Repositoriomessage crea las funciones de guardar crear eliminar
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */

import com.Reto3.Reto3.Interfaces.InterfaceQuadbike;
import com.Reto3.Reto3.Modelo.Quadbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class RepositorioQuadbike {

    @Autowired
    private InterfaceQuadbike crud;
    /**
     * lista de quadbike
     *
     * @return regresa la lista de quadbike
     */
    public List<Quadbike> getAll() {
        return (List < Quadbike >) crud.findAll();
    }
/**
 * obtiene quadbike  mediante id
 * @param id
 * @return regresa el quadbike ppor id
 */
    public Optional<Quadbike> getQuadbike(int id) {
        return crud.findById(id);
    }
    /**
     * guarda  quadbike 
     * @param Quad
     * @return regresa la quadbike creada
     */
     public Quadbike save(Quadbike Quad){
        return crud.save(Quad);
    }
     /**
      * elimina quadbike vinculada con el ip
      * @param Quad 
      */
      public void delete(Quadbike Quad){
       crud.delete(Quad);
    }
     
     
}
