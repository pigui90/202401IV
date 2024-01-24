/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelFactoryMethod;

/**
 *
 * @author Sergio
 */
public class XmlResponseFactory implements  HttpResponseFactory{

    @Override
    public HttpResponse createResponse() {
        return new XmlResponse();
    }
    
}
