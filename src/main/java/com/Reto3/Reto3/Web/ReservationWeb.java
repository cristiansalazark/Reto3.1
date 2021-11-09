
package com.Reto3.Reto3.Web;


/**
 * <h1>reservation  </h1>
 * Clase reservationweb declara las sentencias de mapeo consultar.
 *
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Modelo.Reservation;
import com.Reto3.Reto3.Reportes.ContadorClientes;
import com.Reto3.Reto3.Reportes.StatusReservas;
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
    /**
     * peticion saludo
     * @return  respuesta saludo
     */
     
    @GetMapping("/hola")
    
    public String saludar(){
          return "hola mundo";
    }
    
    /**
     * mapeo sewrviciosreservation
     */
    @Autowired
    private ServiciosReservation servicioreserv;
    @GetMapping("/all")
    
    /**
     * lista de reservation
     */
    public List <Reservation>getReservation(){
        return servicioreserv.getAll();
    }
    
    /**
     * obtiene reservation
     * @param idreserv
     * @return  regresa reservation por id 
     */
       @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int idreserv){
        return servicioreserv.getReservation(idreserv);
    }
    /**
     * crea reservation
     * @param reserv
     * @return regresa reservation creado
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reserv){
        return servicioreserv.save(reserv);
    }
    /**
     * actualiza reservation
     * @param reservation
     * @return retorna reservation actualizad0
     */
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return servicioreserv.update(reservation);
    }
    /**
     * elimina reservation por id 
     * @param reservationId
     * @return  retorna el reservation por id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicioreserv.deleteReservation(reservationId);
    }
    /**
     * genera el reporte  de status
     * @return retorna el reporte generado
     */
    @GetMapping("/report-status")
    public StatusReservas getReservas(){
        return servicioreserv.reporteStatusServicio();
    }
    /**
     * genera el reporte de  fechas
     * @param dateOne
     * @param dateTwo
     * @return retorna reporte grenerado
     */
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
     public List<Reservation> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo ){
         return servicioreserv.reporteTiempoServicio(dateOne, dateTwo);
     }
     /**
      * reporte cliente
      * @return retorna el reporte generado de clients
      */
     @GetMapping("/report-clients")
     public List<ContadorClientes> getClientes(){
         return servicioreserv.reporteClientesServicio();
     }
}
