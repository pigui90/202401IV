/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ulatina;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/**
 *
 * @author Sergio
 */
@Path("/xml")
public class XmlWebService {

    @GET
    public String obtenerDatosXml() {
        return "<datos><nombre>John</nombre><edad>30</edad></datos>";
    }
}
