
package com.Reto3.Reto3.Reportes;


import com.Reto3.Reto3.Modelo.Client;

public class ContadorClientes {
    
    private Long total;
    private Client client;
/**
 * constructor
 * @param total
 * @param client 
 */
    public ContadorClientes(Long total, Client client) {
        this.total = total;
        this.client = client;
    }
/**
 * obtiene el total
 * @return 
 */
    public Long getTotal() {
        return total;
    }
/**
 * inserta el total 
 * @param total 
 */
    public void setTotal(Long total) {
        this.total = total;
    }
/**
 * obtiene  client
 * @return 
 */
    public Client getClient() {
        return client;
    }
/**
 * inserta client
 * @param client 
 */
    public void setClient(Client client) {
        this.client = client;
    }

  
    
    
    
}
