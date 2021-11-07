package com.Reto3.Reto3.Repositorio;

/**
 * <h1>Category </h1>
 * Clase RepositorioCstegory crea las funciones de guardar crear eliminar
 *
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Interfaces.InterfaceCategory;
import com.Reto3.Reto3.Modelo.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCategory {

    @Autowired

    private InterfaceCategory crud;

    /**
     * lista de clientes
     *
     * @return regresa la lista de clientes
     */
    public List<Category> getAll() {
        return (List< Category>) crud.findAll();
    }

    /**
     * obtiene la category
     *
     * @param id
     * @return retorna el category por el id
     */

    public Optional<Category> getCategory(int id) {
        return crud.findById(id);
    }

    /**
     * guarda category
     *
     * @param cate
     * @return retorna la categoria creada
     */
    public Category save(Category cate) {
        return crud.save(cate);
    }

    /**
     * elimina la category
     *
     * @param Cate
     */
    public void delete(Category Cate) {
        crud.delete(Cate);
    }

}
