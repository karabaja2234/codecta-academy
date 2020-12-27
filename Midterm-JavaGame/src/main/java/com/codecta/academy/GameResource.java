package com.codecta.academy;

import com.codecta.academy.services.GameService;
import com.codecta.academy.services.model.GameDto;
import com.codecta.academy.services.model.PlayerDto;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.Set;

@Path("/game")
public class GameResource {

    public class Error {
        public String code;
        public String description;

        public Error(String code, String description) {
            this.code = code;
            this.description = description;
        }
    }

    @Inject
    GameService gameService;

    @Inject
    Validator validator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        return  Response.ok(gameService.welcome()).build();
    }

    @GET
    @Path("/players")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPlayers()
    {
        List<PlayerDto> playerList = gameService.findAllPlayers();
        if(playerList == null || playerList.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(playerList).build();
    }

    @GET
    @Path("/players/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayerById(@PathParam("id") Integer id)
    {
        PlayerDto player = gameService.findPlayerById(id);
        if(player == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(player).build();
    }

    @PUT
    @Path("/players/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePlayerById(@PathParam("id") Integer id, PlayerDto player)
    {
        PlayerDto updatedPlayer = gameService.updatePlayer(id, player);
        if(updatedPlayer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedPlayer).build();
    }

    /*
    @POST
    @Path("/players")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createPlayer(PlayerDto player, @Context UriInfo uriInfo)
    {
        PlayerDto newPlayer = gameService.addPlayer(player);
        if(newPlayer != null) {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(newPlayer.getId()));
            return Response.created(uriBuilder.build()).entity(newPlayer).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(new Error("CDT-001", "Invalid request. Unknown theme park in request.")) .build();
    }*/

    @POST
    @Path("/games")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createGame(GameDto game, @Context UriInfo uriInfo)
    {
        Set<ConstraintViolation<GameDto>> constraintViolations = validator.validate(game);
        if(!constraintViolations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (ConstraintViolation<GameDto> violation : constraintViolations) {
                builder.append(violation.getMessage()).append(", ");
            }
            return Response.status(Response.Status.BAD_REQUEST).entity(new Error("VD-0001", "Invalid request in validation. >> " + builder.toString())).build();
        }
        GameDto newGame = gameService.addGame(game);
        if(newGame != null) {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(newGame.getId()));
            return Response.created(uriBuilder.build()).entity(newGame).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(new Error("TPD-001", "Invalid request.")).build();
    }

    @GET
    @Path("/games")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGames()
    {
        List<GameDto> gamesList = gameService.findAllGames();
        if(gamesList == null || gamesList.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(gamesList).build();
    }

    @GET
    @Path("/games/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGameById(@PathParam("id") Integer id)
    {
        GameDto game = gameService.findGameById(id);
        if(game == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(game).build();
    }

    /*
    @GET
    @Path("/games/{id}/players")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayersByGameId(@PathParam("id") Integer id) {
        List<PlayerDto> playerDtoList = gameService.findPlayerByGameId(id);
        if(playerDtoList == null) {
            return Response.noContent().build();
        }
        return Response.ok(playerDtoList).build();
    }

    @GET
    @Path("/games/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGameByPlayerName(@QueryParam("name") String name) {
        List<GameDto> gameDtoList = gameService.findGameByPlayerName(name);
        if(gameDtoList == null) {
            return Response.noContent().build();
        }
        return Response.ok(gameDtoList).build();
    }*/
}