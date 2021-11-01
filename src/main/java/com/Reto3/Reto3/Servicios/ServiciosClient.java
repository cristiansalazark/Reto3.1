
package com.Reto3.Reto3.Servicios;

import com.Reto3.Reto3.Modelo.Category;
import com.Reto3.Reto3.Modelo.Client;
import com.Reto3.Reto3.Repositorio.RepositorioClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosClient {
    
    
    
     @Autowired
     
       private RepositorioClient  crud;
     
      public List<Client > getAll(){
        return crud.getAll();
    }

    public Optional<Client > getClient(int id){
        return crud.getClient(id);
    }
    
    
        public Client save(Client Client){
        if(Client.getIdClient()==null){
            return crud.save(Client);
        }else{
            Optional<Client> evt=crud.getClient(Client.getIdClient());
            if(evt.isEmpty()){
                return crud.save(Client);
            }else{
                return Client;
            }
        }
    }
    
        
         public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= crud.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                crud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            crud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
