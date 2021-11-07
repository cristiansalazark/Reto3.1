package com.Reto3.Reto3.Modelo;

/**
 * <h1>Cuatrimoto </h1>
 * Clase Quadbike crea la tabla 'Quadbike'con id autoincremental su llave
 * primaria es id
 *
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
@Table(name = "quadbike")

public class Quadbike {

    /**
     * @param ID definicion de id incremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Definicion de variables de labla quadbike
     */
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    /**
     * Relaciones entre tablas quadbike y category
     *
     * @param Relaciones entre tablas
     */
    @ManyToOne
    @JoinColumn(name = "id_Category")
    @JsonIgnoreProperties("quadbikes")
    private Category category;
    /**
     * Relaciones entre tablas quadbike y message
     *
     * @param Relacione entre tablas
     */

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike", "client"})
    private List<Message> messages;

    /**
     * Relacion entre las tablas quadbike y client OneToMany quadbike, client
     *
     * @param
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "quadbike")
    @JsonIgnoreProperties({"quadbike", "client"})
    public List<Reservation> reservations;

    /**
     * obtiene el id de quadbike
     *
     * @return obtiene el id
     */
    public Integer getId() {
        return id;
    }

    /**
     * inserta el id en la tabla quadbike
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * obtiene Name de la tabla quadbike
     *
     * @return obtiene name
     */
    public String getName() {
        return name;
    }

    /**
     * inserta name en la tabla quadbike
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * obtiene brand de la tabla quadbike
     *
     * @return regresa brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * inseta brand en la tabla quadbike
     *
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * obtiene year de la tabla quadbike
     *
     * @return regresa year de la tabla quadbike
     */
    public Integer getYear() {
        return year;
    }

    /**
     * inserta year en la tabla quadbike
     *
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * obtiene description de la tabla quadbike
     *
     * @return trae description
     */
    public String getDescription() {
        return description;
    }

    /**
     * inserta description de la tabla quadbike
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * obtiene category de la tabla quadbike
     *
     * @return trae category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * inserta en category
     *
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * obtiene lista message de la tabla message
     *
     * @return regresa message
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * inserta en la lista de message
     *
     * @param messages
     */

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * obtiene lista de reservation
     *
     * @return trae reservation
     */

    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     *inserta en la lista reservation 
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
