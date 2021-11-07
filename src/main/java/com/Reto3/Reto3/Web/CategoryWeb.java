package com.Reto3.Reto3.Web;

/**
 * <h1>category  </h1>
 * Clase categoryweb declara las sentencias de mapeo consultar.
 *
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Modelo.Category;
import com.Reto3.Reto3.Servicios.ServiciosCategory;
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
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class CategoryWeb {

    /**
     * prueba re respuista
     *
     * @return retorna el resultado de confirmacion
     */

    @GetMapping("/hola")

    public String saludar() {
        return "hola mundo";
    }

    @Autowired
    private ServiciosCategory servicios;

    @GetMapping("/all")

    /**
     * Lista categoria
     */
    public List<Category> getCategory() {
        return servicios.getAll();
    }

    /**
     * obtiene la categoria vinculada por id
     *
     * @param idcate
     * @return retorna el id
     */
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int idcate) {
        return servicios.getCategory(idcate);
    }

    /**
     * mapeo guardar category
     *
     * @param cate
     * @return retorna
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category cate) {
        return servicios.save(cate);
    }

    /**
     * mapeo actualizr
     *
     * @param categoria
     * @return retorna la categoria modificada
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category categoria) {
        return servicios.update(categoria);
    }

    /**
     * mapeo delete
     *
     * @param categoriaId
     * @return retorna el id de la categoria eliminada
     */

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoriaId) {
        return servicios.deletecategoria(categoriaId);
    }
}
