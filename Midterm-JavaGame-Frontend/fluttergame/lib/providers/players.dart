import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import './player.dart';

class Players with ChangeNotifier {
  List<Player> _items = [];
  List<Player> get items {
    return [..._items];
  }

  Player findById(int id) {
    return _items.firstWhere((game) => game.id == id);
  }

  Future<void> fetchAndSetPlayers() async {
    const url = 'http://10.0.2.2:8080/game/players';
    try {
      List<dynamic> responseJson;
      await http.get(url, headers: {"Content-Type": "application/json"})
                .then((http.Response response) => responseJson = json.decode(response.body));
      //print(responseJson);
      
      final List<Player> loadedPlayers = [];
      responseJson.forEach((gameId) { 
        loadedPlayers.add(Player(
          id: gameId['id'], 
          health: gameId['health'],
          damage: gameId['damage'],
          damageIncreasePotion: gameId['damageincreasepotion'],
          healingPotion: gameId['healingpotion'],
          hasOrbOfQuarkus: gameId['hasorbofquarkus'],
          name: gameId['name'],
          statusMessage: gameId['statusmessage'],
          dungeonId: gameId['dungeonid']
        ));
      });
      
      print(loadedPlayers[0].name);
      _items = loadedPlayers;
      notifyListeners();
    } catch (error) {
      throw (error);
    }
  }
}