/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana1_2;

/**
 *
 * @author Sergio
 */
public class HtmlResponseFactory implements HttpResponseFactory{

    @Override
    public HttpResponse createResponse() {
        return new HtmlResponse();
    }
    
}
