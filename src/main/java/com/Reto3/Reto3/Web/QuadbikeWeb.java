
package com.Reto3.Reto3.Web;

/**
 * <h1>quadbike  </h1>
 * Clase quadbikeweb declara las sentencias de mapeo consultar.
 *
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Modelo.Quadbike;
import com.Reto3.Reto3.Servicios.ServiciosQuadbike;
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
@RequestMapping("/api/Quadbike")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class QuadbikeWeb {
    
    
    /**
     * obtiene un saludo
     * @return  retorna una respuesta 
     */
    @GetMapping("/hola")
    
    public String saludar(){
          return "hola mundo";
    }
    
    
    @Autowired
    private ServiciosQuadbike servicios;
    @GetMapping("/all")
    
    /**
     * obtiene lista  quadbike
     */
    public List <Quadbike>getQuadbike(){
        return servicios.getAll();
    }
    /**
     * obtiene quadbike 
     * @param idQuad
     * @return retorna quadbike por id
     */
       @GetMapping("/{id}")
    public Optional<Quadbike> getQuadbike(@PathVariable("id") int idQuad){
        return servicios.getQuadbike(idQuad);
    }
    /**
     * guarda quadbike
     * @param Quad
     * @return regresa quadbike creado
     */
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike save(@RequestBody Quadbike Quad){
        return servicios.save(Quad);
    }
    /**
     * actualiza quadbike 
     * @param Quad
     * @return retorna quadbike actualizado
     */
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike update(@RequestBody Quadbike Quad) {
        return servicios.update(Quad);
    }
    /**
     * elimina quadbike por id
     * @param Quad
     * @return regresa quadbike eliminado
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int Quad) {
        return servicios.deleteQuadbike(Quad);
    }
  
}
