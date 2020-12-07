package ba.codecta.academy;

import ba.codecta.academy.services.DisneyService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/disney")
public class DisneyResource {

    @Inject
    DisneyService disneyService;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        return Response.ok(disneyService.getWelcomeMessage()).build();
    }

    @GET
    @Path("/characters")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharacters() {
        return Response.ok(disneyService.getWelcomeMessage()).build();
    }
}