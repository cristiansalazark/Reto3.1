
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
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceReservation extends CrudRepository<Reservation,Integer>{
    /**
     * llama  el status
     * @param status
     * @return 
     */
   public List<Reservation> findAllByStatus (String status); 
    /**
     * declara los dos datos
     * @param dateOne
     * @param dateTwo
     * @return 
     */
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    // SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    @Query ("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient(); 
}