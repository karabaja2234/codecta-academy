import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import './game.dart';

class Games with ChangeNotifier {
  List<Game> _items = [];
  List<Game> get items {
    return [..._items];
  }

  Game findById(int id) {
    return _items.firstWhere((game) => game.id == id);
  }

  Future<void> fetchAndSetGames() async {
    const url = 'http://10.0.2.2:8080/game/games';
    try {
      List<dynamic> responseJson;
      await http.get(url, headers: {"Content-Type": "application/json"})
                .then((http.Response response) => responseJson = json.decode(response.body));
      //print(responseJson[0]['id']);
      
      final List<Game> loadedGames = [];
      responseJson.forEach((gameId) { 
        loadedGames.add(Game(id: gameId['id']));
      });
      
      //print(loadedGames[0].id);
      _items = loadedGames;
      notifyListeners();
    } catch (error) {
      throw (error);
    }
  }

  Future<void> addGame(Game game) async {
    const url = 'http://10.0.2.2:8080/api/game/newgame';
    try {
      final response = await http.post(
        url,
        body: json.encode({
          'id': game.id
        }),
      );
      final newGame = Game(
        id: game.id
      );
      _items.add(newGame);
      // _items.insert(0, newProduct); // at the start of the list
      notifyListeners();
    } catch (error) {
      print(error);
      throw error;
    }
  }
}