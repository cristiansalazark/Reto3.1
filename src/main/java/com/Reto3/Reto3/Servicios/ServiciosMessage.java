
package com.Reto3.Reto3.Servicios;

import com.Reto3.Reto3.Modelo.Message;
import com.Reto3.Reto3.Repositorio.RepositorioMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMessage {
   
    
    @Autowired
     
   private RepositorioMessage  metodoscrudm;
     
      public List<Message > getAll(){
        return metodoscrudm.getAll();
    }

    public Optional<Message > getMessage(int idmessa){
        return metodoscrudm.getMessage(idmessa);
    }
    
    
        public Message save(Message mesa){
        if(mesa.getIdMessage()==null){
            return metodoscrudm.save(mesa);
        }else{
            Optional<Message> evt=metodoscrudm.getMessage(mesa.getIdMessage());
            if(evt.isEmpty()){
                return metodoscrudm.save(mesa);
            }else{
                return mesa;
            }
        }
    }
    
      public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> e= metodoscrudm.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodoscrudm.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodoscrudm.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
