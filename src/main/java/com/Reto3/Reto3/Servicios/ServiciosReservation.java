package com.Reto3.Reto3.Servicios;

/**
 * <h1>reservation  </h1>
 * Clase serviciosreservation crea los servicios de guardar crear eliminar y
 * consultar.
 *
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Modelo.Reservation;
import com.Reto3.Reto3.Reportes.ContadorClientes;
import com.Reto3.Reto3.Reportes.StatusReservas;
import com.Reto3.Reto3.Repositorio.RepositorioReservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosReservation {

    @Autowired

    private RepositorioReservation metodoscrudr;

    /**
     * obtiene la lista de reservation
     *
     * @return retorna la lista reservation
     */
    public List<Reservation> getAll() {
        return metodoscrudr.getAll();
    }

    /**
     * obtiene reservatiion vuinculada a la id
     *
     * @param id
     * @return retorna id
     */
    public Optional<Reservation> getReservation(int id) {
        return metodoscrudr.getReservation(id);
    }

    public Reservation save(Reservation reserv) {
        if (reserv.getIdReservation() == null) {
            return metodoscrudr.save(reserv);
        } else {
            Optional<Reservation> evt = metodoscrudr.getReservation(reserv.getIdReservation());
            if (evt.isEmpty()) {
                return metodoscrudr.save(reserv);
            } else {
                return reserv;
            }
        }
    }

    /**
     * actualiza la recervacion
     *
     * @param reservation
     * @return retorna la recervation modificada
     */

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> e = metodoscrudr.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                metodoscrudr.save(e.get());
                return e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     * elimina la recervation vinculada al id
     *
     * @param reservationId
     * @return
     */

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodoscrudr.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
    /**
     * declara la lista de estados completed o cancelled
     * @return 
     */
    public StatusReservas reporteStatusServicio (){
        List<Reservation>completed= metodoscrudr.ReservacionStatusRepositorio("completed");
        List<Reservation>cancelled= metodoscrudr.ReservacionStatusRepositorio("cancelled");
        
        return new StatusReservas(completed.size(), cancelled.size() );
    }
    /**
     * genera el reporte del tiempo de servicio
     * @param datoA
     * @param datoB
     * @return retorna el reporte generado de tiempo de servicio
     */
    
    public List<Reservation> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodoscrudr.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    } 
    
    /**
     * reporte de servicio de clientes
     * @return 
     */
     public List<ContadorClientes> reporteClientesServicio(){
            return metodoscrudr.getClientesRepositorio();
        } 
    
    
}
