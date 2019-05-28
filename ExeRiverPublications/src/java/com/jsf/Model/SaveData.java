/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author clair
 */
public class SaveData implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String data;
    
    /**
     *
     * @param thisdata
     */
    public void setdata( String thisdata)
    {
        data = thisdata;
    }
    
    /**
     *
     * @return data
     */
    public String getdata()
    {
        return data;
    }
    
    /**
     * clears the data
     */
    public void cleardata()
    {
        data = "";
    }    
}
