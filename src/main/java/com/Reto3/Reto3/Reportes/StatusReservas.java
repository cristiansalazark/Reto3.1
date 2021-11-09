
package com.Reto3.Reto3.Reportes;


public class StatusReservas {
    
    private int completed;
    private int cancelled;
/**
 * Constructor 
 * @param completed
 * @param cancelled 
 */
    public StatusReservas(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }
/**
 * obtiene  el estado completed
 * @return 
 */
    public int getCompleted() {
        return completed;
    }
/**
 * inserta el estado completed
 * @param completed 
 */
    public void setCompleted(int completed) {
        this.completed = completed;
    }
/**
 * obtiene el estado cancelled
 * @return 
 */
    public int getCancelled() {
        return cancelled;
    }
/**
 * inserta el estado cancelled
 * @param cancelled 
 */
    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

  
    
    
}
