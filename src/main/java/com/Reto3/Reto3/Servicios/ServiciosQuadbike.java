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

 

}
