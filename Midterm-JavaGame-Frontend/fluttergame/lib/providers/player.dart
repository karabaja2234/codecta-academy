import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:flutter/foundation.dart';

class Player with ChangeNotifier {
  final int id;
  final int health;
  final int damage;
  final int damageIncreasePotion;
  final int healingPotion;
  final bool hasOrbOfQuarkus;
  final String name;
  final String statusMessage;
  final int dungeonId;

  Player({
    @required this.id,
    @required this.health,
    @required this.damage,
    @required this.damageIncreasePotion,
    @required this.healingPotion,
    @required this.hasOrbOfQuarkus,
    @required this.name,
    @required this.statusMessage,
    @required this.dungeonId,
  });

  factory Player.fromJson(Map<String, dynamic> json) {
    return Player(
      id: json['id'],
      health: json['health'],
      damage: json['damage'],
      damageIncreasePotion: json['damageIncreasePotion'],
      healingPotion: json['healingPotion'],
      hasOrbOfQuarkus: json['hasOrbOfQuarkus'],
      name: json['name'],
      statusMessage: json['statusMessage'],
      dungeonId: json['dungeonId']
    );
  }
}

Future<Player> createPlayer(String name) async {
  final response = await http.post(
    'http://10.0.2.2:8080/game/newplayer',
    headers: <String, String>{
      'Content-Type': 'application/json; charset=UTF-8',
    },
    body: jsonEncode(<String, dynamic>{
      "health": 100,
      "damage": 10,
      "name": name,
      "healingPotion": 0,
      "damageIncreasePotion": 0,
      "hasOrbOfQuarkus": false,
      "statusMessage": "",
      "dungeonId": 1
    }),
  );

  if (response.statusCode == 201) {
    return Player.fromJson(jsonDecode(response.body));
  } else {
    throw Exception('Failed to create a player.');
  }
}

Future<Player> fight(int playerId) async {
  final response = await http.put(
    'http://10.0.2.2:8080/game/players/$playerId/fight',
  );

  if (response.statusCode == 200) {
    return Player.fromJson(jsonDecode(response.body));
  } else {
    throw Exception('Failed to start a fight.');
  }
}

Future<Player> heal(int playerId) async {
  final response = await http.put(
    'http://10.0.2.2:8080/game/players/$playerId/heal',
  );

  if (response.statusCode == 200) {
    return Player.fromJson(jsonDecode(response.body));
  } else {
    throw Exception('Failed to heal the player.');
  }
}

Future<Player> getStronger(int playerId) async {
  final response = await http.put(
    'http://10.0.2.2:8080/game/players/$playerId/stronger',
  );

  if (response.statusCode == 200) {
    return Player.fromJson(jsonDecode(response.body));
  } else {
    throw Exception('Failed to make the player stronger.');
  }
}

Future<Player> nextRoom(int playerId) async {
  final response = await http.put(
    'http://10.0.2.2:8080/game/players/$playerId/move',
  );

  if (response.statusCode == 200) {
    return Player.fromJson(jsonDecode(response.body));
  } else {
    final secondResponse = await http.get(
      'http://10.0.2.2:8080/game/players/$playerId',
    );
    if(secondResponse.statusCode == 200) {
      return Player.fromJson(jsonDecode(secondResponse.body));
    }
  }
}

Future<Player> previousRoom(int playerId) async {
  final response = await http.put(
    'http://10.0.2.2:8080/game/players/$playerId/goback',
  );

  if (response.statusCode == 200) {
    return Player.fromJson(jsonDecode(response.body));
  } else {
      final secondResponse = await http.get(
      'http://10.0.2.2:8080/game/players/$playerId',
    );
    if(secondResponse.statusCode == 200) {
      return Player.fromJson(jsonDecode(secondResponse.body));
    }
  }
}

Future<Player> collectItems(int playerId) async {
  final response = await http.put(
    'http://10.0.2.2:8080/game/players/$playerId/collect',
  );

  if (response.statusCode == 200) {
    return Player.fromJson(jsonDecode(response.body));
  } else {
    throw Exception('Failed to collect the items.');
  }
}