
package com.Reto3.Reto3.Interfaces;
/**
 * <h1>Reservacion </h1>
 * Clase interface reservation permite conectar el crud con la interface
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Modelo.Reservation;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceReservation extends CrudRepository<Reservation,Integer>{
    
}