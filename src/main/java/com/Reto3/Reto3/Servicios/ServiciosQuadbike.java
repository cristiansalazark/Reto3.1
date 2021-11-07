package com.Reto3.Reto3.Servicios;

/**
 * <h1>quadbike  </h1>
 * Clase serviciosquadbike crea los servicios de guardar crear eliminar y
 * consultar.
 *
 * @since 06-11-2021
 * @version 1.0
 * @author Cristian David Salazar Aponte
 *
 */
import com.Reto3.Reto3.Modelo.Quadbike;
import com.Reto3.Reto3.Repositorio.RepositorioQuadbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosQuadbike {

    @Autowired

    private RepositorioQuadbike metodoscrud;

    /**
     * obtiene la lista de quadbike
     *
     * @return retorna la lista quadbike
     */
    public List<Quadbike> getAll() {
        return metodoscrud.getAll();
    }

    /**
     * obtiene quadbike por id
     *
     * @param id
     * @return retorna equadbike vinculado al id
     */
    public Optional<Quadbike> getQuadbike(int id) {
        return metodoscrud.getQuadbike(id);
    }

    /**
     * guarda quadbike por id
     *
     * @param Quad
     * @return retorna el quadbike creado
     */
    public Quadbike save(Quadbike Quad) {
        if (Quad.getId() == null) {
            return metodoscrud.save(Quad);
        } else {
            Optional<Quadbike> evt = metodoscrud.getQuadbike(Quad.getId());
            if (evt.isEmpty()) {
                return metodoscrud.save(Quad);
            } else {
                return Quad;
            }
        }
    }

    /**
     * actualiza el quadbike por id vinculado
     *
     * @param quadbike
     * @return retorna el quadbike actualizado
     */
    public Quadbike update(Quadbike quadbike) {
        if (quadbike.getId() != null) {
            Optional<Quadbike> e = metodoscrud.getQuadbike(quadbike.getId());
            if (!e.isEmpty()) {
                if (quadbike.getName() != null) {
                    e.get().setName(quadbike.getName());
                }
                if (quadbike.getBrand() != null) {
                    e.get().setBrand(quadbike.getBrand());
                }
                if (quadbike.getYear() != null) {
                    e.get().setYear(quadbike.getYear());
                }
                if (quadbike.getDescription() != null) {
                    e.get().setDescription(quadbike.getDescription());
                }
                if (quadbike.getCategory() != null) {
                    e.get().setCategory(quadbike.getCategory());
                }
                metodoscrud.save(e.get());
                return e.get();
            } else {
                return quadbike;
            }
        } else {
            return quadbike;
        }
    }

    /**
     * elimina el quadbike vinculado a la ip
     *
     * @param quadbikeid
     * @return retorna el ip eliminado
     */
    public boolean deleteQuadbike(int quadbikeid) {
        Boolean aBoolean = getQuadbike(quadbikeid).map(cabin -> {
            metodoscrud.delete(cabin);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
