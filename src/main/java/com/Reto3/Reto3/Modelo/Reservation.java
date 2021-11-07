package com.Reto3.Reto3.Modelo;

/**
 * <h1>Reservacion </h1>
 * Clase Reservation crea la tabla 'Reservation'con idReservation
 * autoincremental su llave primaria es idReservation
 *
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")

public class Reservation {

    /**
     * @param ID definicion de id incremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Definicion de las variables de la tabla reservation
     */
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";
    /**
     * Relacion entre tablas message y reservation ManyToOne tabla message con
     * tabla quadbike
     *
     * @para Relaciones entre tablsa con reservation
     */

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservations")
    private Quadbike quadbike;
    /**
     * Relacion entre tablas message y reservation ManyToOne tabla reservation
     * con tabla client
     *
     * @para Relaciones entre tablsa con reservation
     */
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;
    /**
     * variable estatica score
     */
    private String score; //depende el grupo

    /**
     * obtiene score de la tabla reservation
     *
     * @return regresa score
     */
    public String getScore() {
        return score;
    }

    /**
     * inserta score en la tabla reservation
     *
     * @param score
     */

    public void setScore(String score) {
        this.score = score;
    }

    /**
     * obtiene idreservation de la tabla reservation
     *
     * @return regresa idreservation
     */
    public Integer getIdReservation() {
        return idReservation;
    }

    /**
     * inserta idreservation en la tabla reservation
     *
     * @param idReservation
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    /**
     * obtiene startdate de la tabla reservation
     *
     * @return regresa startdate
     */

    public Date getStartDate() {
        return startDate;
    }

    /**
     * inserta stardate en la tabla reservation
     *
     * @param startDate
     */

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * obtiene devolutiondate de la tabla reservation
     *
     * @return regresa devolutiondate
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }

    /**
     * inserta datedevolution en la tabla reservation
     *
     * @param devolutionDate
     */
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    /**
     * obtiene status de la tabla reservation
     *
     * @return regresa status
     */
    public String getStatus() {
        return status;
    }

    /**
     * inserta status en la tabla reservation
     *
     * @param status
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * obtiene quadbike de la tabla quadbike
     *
     * @return regresa queadbike
     */

    public Quadbike getQuadbike() {
        return quadbike;
    }

    /**
     * inserta quadbike en la tabla reservation
     *
     * @param quadbike
     */
    public void setQuadbike(Quadbike quadbike) {
        this.quadbike = quadbike;
    }

    /**
     * obtiene client de la tabla client
     *
     * @return envia client
     */
    public Client getClient() {
        return client;
    }

    /**
     * inserta client en la tabla reservation
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

}
