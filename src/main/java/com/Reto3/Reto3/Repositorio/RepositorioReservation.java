
package com.Reto3.Reto3.Repositorio;
/**
 * <h1>reservatio </h1>
 * Clase Repositorioreservatio crea las funciones de guardar crear eliminar
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Interfaces.InterfaceReservation;
import com.Reto3.Reto3.Modelo.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioReservation {
     @Autowired
    private InterfaceReservation crud;
 /**
     * lista de reservation
     *
     * @return regresa la lista de reservation
     */
    public List<Reservation> getAll() {
        return (List < Reservation >) crud.findAll();
    }
/**
 * obtiene reservation consultado por ip
 * @param id
 * @return regresa  la reservacion vinculada al ip
 */
    public Optional<Reservation> getReservation(int id) {
        return crud.findById(id);
    }
    /**
     * crea la recervacion 
     * @param reserv
     * @return regresala reservacion creada 
     */
    
     public Reservation save(Reservation reserv){
        return crud.save(reserv);
    }
     /**
      * elmina la reservation vinculada a la ip
      * @param Quad 
      */
       public void delete(Reservation Quad){
       crud.delete(Quad);
    }
     
    
    
    
    
}
