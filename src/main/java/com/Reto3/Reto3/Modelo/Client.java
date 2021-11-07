package com.Reto3.Reto3.Modelo;

/**
 * <h1>Cliente </h1>
 * Clase Client crea la tabla 'Category'con id autoincremental su llave primaria
 * es idClient
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

    /**
     * @param ID definicion de id incremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Definicion de las variables de la tabla client
     */
    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;

    /**
     * Relacion entre tablas message y reservation OneToManytabla client con
     * tabla message
     *
     * @para Relaciones entre tablsa con message
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    public List<Message> messages;
    /**
     * Relacion entre tablas message y reservation OneToManytabla message con
     * tabla client
     *
     * @para Relaciones entre tablsa con client
     */

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    public List<Reservation> reservations;

    /**
     * obtiene el id de la tabla client
     *
     * @return retorna el idclient
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     * inserta el id en la tabla client
     *
     * @param idClient
     */

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }
    /**
     * obtiene  el email de la tabla client
     * @return retorna el emaril 
     */

    public String getEmail() {
        return email;
    }
    /**
     * inserta el email en la tabla client
     * @param email 
     */

    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * obtiene password de la tabla client
     * @return retorna password
     */

    public String getPassword() {
        return password;
    }
    /**
     * inserta password de la tabla client
     * @param password 
     */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * obtiene name de la tabla client
     * @return reetorna name
     */

    public String getName() {
        return name;
    }
    /**
     * inserta name de la tabla client
     * @param name 
     */

    public void setName(String name) {
        this.name = name;
    }
    /**
     * obtiene age de la tabla client
     * @return retorna age
     */
    

    public Integer getAge() {
        return age;
    }/**
     *  inserta age en la tabla client
     * @param age 
     */

    public void setAge(Integer age) {
        this.age = age;
    }
    /**
     * trae la lista  de messgges a la tabla client
     * @return retorna la lista de messages
     */

    public List<Message> getMessages() {
        return messages;
    }
    /**
     * inserta en la lista ed message
     * @param messages 
     */

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
/**
 * obtiene la lista de la tabla  reservations 
 * @return  retorna la lista de reservations
 */
    public List<Reservation> getReservations() {
        return reservations;
    }
/**
 * inserta en lista de reservations
 * @param reservations 
 */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
