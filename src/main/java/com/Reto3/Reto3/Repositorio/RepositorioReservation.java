
package com.Reto3.Reto3.Repositorio;

import com.Reto3.Reto3.Interfaces.InterfaceQuadbike;
import com.Reto3.Reto3.Interfaces.InterfaceReservation;
import com.Reto3.Reto3.Modelo.Quadbike;
import com.Reto3.Reto3.Modelo.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioReservation {
     @Autowired
    private InterfaceReservation crud;

    public List<Reservation> getAll() {
        return (List < Reservation >) crud.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return crud.findById(id);
    }
    
     public Reservation save(Reservation reserv){
        return crud.save(reserv);
    }
    
    
    
    
}
