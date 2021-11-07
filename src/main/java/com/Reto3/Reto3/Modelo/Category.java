package com.Reto3.Reto3.Modelo;

/**
 * <h1>Categoria </h1>
 * Clase Category crea la tabla 'Category'con id autoincremental su llave
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

    /**
     * @param ID definicion de id incremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * definicion de variables de la tabla category
     */
    private Integer id;
    private String name;
    private String description;
    /**
     * @param Relaciones entre tablas
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Quadbike> quadbikes;

    /**
     * obtiene el id de category
     *
     * @return obtiene el id
     */
    public Integer getId() {
        return id;
    }

    /**
     * inserta el id en la tabla category
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * obtiene el name de la tabla category
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * inserta el name en la tabla category
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * obtiene la Description de la tabla category
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * inserta la descripcion en la tabla category
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * obtiene la lista de Quadbikes registradas en la tabla Quadbike
     *
     * @return
     */
    public List<Quadbike> getQuadbikes() {
        return quadbikes;
    }

    /**
     * inserta la lista de quadbikes para la tabla category
     *
     * @param quadbikes
     */
    public void setQuadbikes(List<Quadbike> quadbikes) {
        this.quadbikes = quadbikes;
    }

}
