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
public class Book implements BookInterface{
    private Long bookId;
    private String title;
    private String fileName;
    private String location;
    private String state;
    private Payment payment;
    private Feedback feedback;
    private Meeting meeting;
}
