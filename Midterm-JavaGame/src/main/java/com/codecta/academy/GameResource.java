package com.codecta.academy;

import com.codecta.academy.services.GameService;
import com.codecta.academy.services.model.*;

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

    //POST requests for: Game, Level, Map, Player, Dungeon, Item, Monster
    @POST
    @Path("/newgame")
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

    @POST
    @Path("/newlevel")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createLevel(LevelDto level, @Context UriInfo uriInfo)
    {
        Set<ConstraintViolation<LevelDto>> constraintViolations = validator.validate(level);
        if(!constraintViolations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (ConstraintViolation<LevelDto> violation : constraintViolations) {
                builder.append(violation.getMessage()).append(", ");
            }
            return Response.status(Response.Status.BAD_REQUEST).entity(new Error("VD-0001", "Invalid request in validation. >> " + builder.toString())).build();
        }
        LevelDto newLevel = gameService.addLevel(level);
        if(newLevel != null) {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(newLevel.getId()));
            return Response.created(uriBuilder.build()).entity(newLevel).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(new Error("TPD-001", "Invalid request.")).build();
    }

    @POST
    @Path("/newmap")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createMap(MapDto map, @Context UriInfo uriInfo)
    {
        Set<ConstraintViolation<MapDto>> constraintViolations = validator.validate(map);
        if(!constraintViolations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (ConstraintViolation<MapDto> violation : constraintViolations) {
                builder.append(violation.getMessage()).append(", ");
            }
            return Response.status(Response.Status.BAD_REQUEST).entity(new Error("VD-0001", "Invalid request in validation. >> " + builder.toString())).build();
        }
        MapDto newMap = gameService.addMap(map);
        if(newMap != null) {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(newMap.getId()));
            return Response.created(uriBuilder.build()).entity(newMap).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(new Error("TPD-001", "Invalid request.")).build();
    }

    @POST
    @Path("/newdungeon")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createDungeon(DungeonDto dungeon, @Context UriInfo uriInfo)
    {
        Set<ConstraintViolation<DungeonDto>> constraintViolations = validator.validate(dungeon);
        if(!constraintViolations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (ConstraintViolation<DungeonDto> violation : constraintViolations) {
                builder.append(violation.getMessage()).append(", ");
            }
            return Response.status(Response.Status.BAD_REQUEST).entity(new Error("VD-0001", "Invalid request in validation. >> " + builder.toString())).build();
        }
        DungeonDto newDungeon = gameService.addDungeon(dungeon);
        if(newDungeon != null) {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(newDungeon.getId()));
            return Response.created(uriBuilder.build()).entity(newDungeon).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(new Error("TPD-001", "Invalid request.")).build();
    }

    @POST
    @Path("/newplayer")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createPlayer(PlayerDto player, @Context UriInfo uriInfo)
    {
        Set<ConstraintViolation<PlayerDto>> constraintViolations = validator.validate(player);
        if(!constraintViolations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (ConstraintViolation<PlayerDto> violation : constraintViolations) {
                builder.append(violation.getMessage()).append(", ");
            }
            return Response.status(Response.Status.BAD_REQUEST).entity(new Error("VD-0001", "Invalid request in validation. >> " + builder.toString())).build();
        }
        PlayerDto newPlayer = gameService.addPlayer(player);
        if(newPlayer != null) {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(newPlayer.getId()));
            return Response.created(uriBuilder.build()).entity(newPlayer).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(new Error("TPD-001", "Invalid request.")).build();
    }

    @POST
    @Path("/newitem")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createItem(ItemDto item, @Context UriInfo uriInfo)
    {
        Set<ConstraintViolation<ItemDto>> constraintViolations = validator.validate(item);
        if(!constraintViolations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (ConstraintViolation<ItemDto> violation : constraintViolations) {
                builder.append(violation.getMessage()).append(", ");
            }
            return Response.status(Response.Status.BAD_REQUEST).entity(new Error("VD-0001", "Invalid request in validation. >> " + builder.toString())).build();
        }
        ItemDto newItem = gameService.addItem(item);
        if(newItem != null) {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(newItem.getId()));
            return Response.created(uriBuilder.build()).entity(newItem).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(new Error("TPD-001", "Invalid request.")).build();
    }

    @POST
    @Path("/newmonster")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createMonster(MonsterDto monster, @Context UriInfo uriInfo)
    {
        Set<ConstraintViolation<MonsterDto>> constraintViolations = validator.validate(monster);
        if(!constraintViolations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (ConstraintViolation<MonsterDto> violation : constraintViolations) {
                builder.append(violation.getMessage()).append(", ");
            }
            return Response.status(Response.Status.BAD_REQUEST).entity(new Error("VD-0001", "Invalid request in validation. >> " + builder.toString())).build();
        }
        MonsterDto newMonster = gameService.addMonster(monster);
        if(newMonster != null) {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(newMonster.getId()));
            return Response.created(uriBuilder.build()).entity(newMonster).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(new Error("TPD-001", "Invalid request.")).build();
    }

    //GET requests for: Game, Level, Map, Player, Dungeon, Item, Monster
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
    @Path("/levels")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLevels()
    {
        List<LevelDto> levelsList = gameService.findAllLevels();
        if(levelsList == null || levelsList.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(levelsList).build();
    }

    @GET
    @Path("/maps")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMaps()
    {
        List<MapDto> mapsList = gameService.findAllMaps();
        if(mapsList == null || mapsList.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(mapsList).build();
    }

    @GET
    @Path("/dungeons")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDungeons()
    {
        List<DungeonDto> dungeonsList = gameService.findAllDungeons();
        if(dungeonsList == null || dungeonsList.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(dungeonsList).build();
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
    @Path("/items")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllItems()
    {
        List<ItemDto> itemsList = gameService.findAllItems();
        if(itemsList == null || itemsList.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(itemsList).build();
    }

    @GET
    @Path("/monsters")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMonsters()
    {
        List<MonsterDto> monstersList = gameService.findAllMonsters();
        if(monstersList == null || monstersList.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(monstersList).build();
    }

    @PUT
    @Path("/players/{id}/heal")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePlayersHealth(@PathParam("id") Integer id)
    {
        PlayerDto updatedPlayer = gameService.updatePlayersHealth(id);
        if(updatedPlayer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedPlayer).build();
    }

    @PUT
    @Path("/players/{id}/move")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePlayersDungeon(@PathParam("id") Integer id)
    {
        PlayerDto updatedPlayer = gameService.updatePlayersDungeon(id);
        if(updatedPlayer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedPlayer).build();
    }

    @PUT
    @Path("/players/{id}/stronger")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePlayersDamage(@PathParam("id") Integer id)
    {
        PlayerDto updatedPlayer = gameService.updatePlayersDamage(id);
        if(updatedPlayer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedPlayer).build();
    }

    @PUT
    @Path("/players/{id}/collect")
    @Produces(MediaType.APPLICATION_JSON)
    public Response collectPlayersItems(@PathParam("id") Integer id)
    {
        PlayerDto updatedPlayer = gameService.collectItems(id);
        if(updatedPlayer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedPlayer).build();
    }

    /*
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