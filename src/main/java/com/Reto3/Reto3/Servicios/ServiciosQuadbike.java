package com.Reto3.Reto3.Servicios;

import com.Reto3.Reto3.Modelo.Quadbike;
import com.Reto3.Reto3.Repositorio.RepositorioQuadbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ServiciosQuadbike {

    @Autowired
     
   private RepositorioQuadbike  metodoscrud;
     
      public List<Quadbike > getAll(){
        return metodoscrud.getAll();
    }

    public Optional<Quadbike > getQuadbike(int id){
        return metodoscrud.getQuadbike(id);
    }
    
    
        public Quadbike save(Quadbike Quad){
        if(Quad.getId()==null){
            return metodoscrud.save(Quad);
        }else{
            Optional<Quadbike> evt=metodoscrud.getQuadbike(Quad.getId());
            if(evt.isEmpty()){
                return metodoscrud.save(Quad);
            }else{
                return Quad;
            }
        }
    }
        
          public Quadbike update(Quadbike quadbike){
        if(quadbike.getId()!=null){
            Optional<Quadbike> e=metodoscrud.getQuadbike(quadbike.getId());
            if(!e.isEmpty()){
                if(quadbike.getName()!=null){
                    e.get().setName(quadbike.getName());
                }
                if(quadbike.getBrand()!=null){
                    e.get().setBrand(quadbike.getBrand());
                }
                if(quadbike.getYear()!=null){
                    e.get().setYear(quadbike.getYear());
                }
                if(quadbike.getDescription()!=null){
                    e.get().setDescription(quadbike.getDescription());
                }
                if(quadbike.getCategory()!=null){
                    e.get().setCategory(quadbike.getCategory());
                }
                metodoscrud.save(e.get());
                return e.get();
            }else{
                return quadbike;
            }
        }else{
            return quadbike;
        }
    }


    public boolean deleteQuadbike(int quadbikeid) {
        Boolean aBoolean = getQuadbike(quadbikeid).map(cabin -> {
            metodoscrud.delete(cabin);
            return true;
        }).orElse(false);
        return aBoolean;
    }

 

}
