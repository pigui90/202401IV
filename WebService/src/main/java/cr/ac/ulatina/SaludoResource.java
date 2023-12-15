/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ulatina;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author Sergio
 */
@Path("/saludo")
public class SaludoResource {
    @GET
    public String obtenerSaludo() {
        return "¡Hola, mundo!";
    }
    
    @GET
    @Path("/{nombre}")
    public Response saludar(@PathParam("nombre") String nombre) {
        String mensaje = "¡Hola, " + nombre + "!";
        return Response.status(200).entity(mensaje).build();
    }
}
