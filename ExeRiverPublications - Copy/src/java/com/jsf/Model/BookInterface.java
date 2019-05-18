/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Model;
/**
 *
 * @author clair
 */
public interface BookInterface {
     
    //methods to register and unregister observers

    /**
     *
     * @param observer
     */
    public void register(UserInterface observer);

    /**
     *
     * @param observer
     */
    public void unregister(UserInterface observer);
 
    //method to notify observers of change

    /**
     *
     */
    public void notifyObservers();
 
    //method to get updates from subject

    /**
     *
     * @param observer
     * @return
     */
    public Object getUpdate(UserInterface observer);
}
