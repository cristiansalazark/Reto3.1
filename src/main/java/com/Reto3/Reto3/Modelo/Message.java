package com.Reto3.Reto3.Modelo;

/**
 * <h1>Mensajes </h1>
 * Clase message crea la tabla 'message'con id autoincremental su llave primaria
 * es idMessage
 *
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Message")
public class Message {

    /**
     * @param ID definicion de id incremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * Definicion de las variables de la tabla message
     */
    private Integer idMessage;
    private String messageText;
    /**
     * Relacion entre tablas message y reservation ManyToOne tabla message con
     * tabla quadbike
     *
     * @para Relaciones entre tablsa con message
     */
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Quadbike quadbike;
    /**
     * Relacion entre tablas message y reservation ManyToOne tabla message con
     * tabla client
     *
     * @para Relaciones entre tablsa con message
     */
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages", "reservations", "client"})
    private Client client;

    /**
     * obtiene el idmessage de la tabla message
     *
     * @return retorna el IdMessage
     */
    public Integer getIdMessage() {
        return idMessage;
    }

    /**
     * inserta idmessage en la tabla message
     *
     * @param idMessage
     */
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * obtiene messagetext de la tabla message
     *
     * @return regresa messagetext
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * inserta mesagetext en la tabla message
     *
     * @param messageText
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    /**
     * obtiene quadbike de la tabla quadbike
     *
     * @return
     */
    public Quadbike getQuadbike() {
        return quadbike;
    }

    /**
     * inserta quadbike en la tabla message
     *
     * @param quadbike
     */
    public void setQuadbike(Quadbike quadbike) {
        this.quadbike = quadbike;
    }

    /**
     * obtiene client de la tabla client
     *
     * @return regresa client
     */
    public Client getClient() {
        return client;
    }

    /**
     * inserta cliente en la tabla message
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

}
