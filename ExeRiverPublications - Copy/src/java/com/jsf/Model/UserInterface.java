/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Model;

import java.util.List;

/**
 *
 * @author clair
 */
public interface UserInterface {
        //method to update the observer, used by subject

    /**
     *
     */
    public void update(State state);
 
    //attach with subject to observe

    /**
     *
     * @param book
     */
    public void setSubject(Book book);
    
}
