/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;


/**
 * A wrapper for bundling up an item 
 * 
 * @param <T>
 */
public class PriorityItem<T> {

    private final T item;
    

    public PriorityItem(T item) {
        this.item = item;
        
    }

    public T getItem() {
        return item;
    }


    
    @Override
    public String toString() {
        return "(" + getItem() + ")";
    }
}
