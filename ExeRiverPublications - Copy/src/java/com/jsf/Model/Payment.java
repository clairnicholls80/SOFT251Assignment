/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.Model;

import java.io.Serializable;

/**
 *
 * @author clair
 */
public class Payment implements Serializable{
    private Long paymentId;
    private String paymentType;
    private Integer amount;
    private Boolean paymentComplete;
}
