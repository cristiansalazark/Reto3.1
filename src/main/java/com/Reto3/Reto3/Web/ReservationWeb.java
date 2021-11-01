
package com.Reto3.Reto3.Web;

import com.Reto3.Reto3.Modelo.Reservation;
import com.Reto3.Reto3.Servicios.ServiciosReservation;
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
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ReservationWeb {
    
    @GetMapping("/hola")
    
    public String saludar(){
          return "hola mundo";
    }
    
    
    @Autowired
    private ServiciosReservation servicioreserv;
    @GetMapping("/all")
    
    
    public List <Reservation>getReservation(){
        return servicioreserv.getAll();
    }
    
       @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int idreserv){
        return servicioreserv.getReservation(idreserv);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reserv){
        return servicioreserv.save(reserv);
    }
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return servicioreserv.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicioreserv.deleteReservation(reservationId);
    }
    
}
