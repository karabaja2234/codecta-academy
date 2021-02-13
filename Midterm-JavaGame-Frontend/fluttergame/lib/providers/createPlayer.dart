import 'dart:async';
import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

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
    throw Exception('Failed to create album.');
  }
}

class Player {
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

void main() {
  runApp(CreatePlayer());
}

class CreatePlayer extends StatefulWidget {
  CreatePlayer({Key key}) : super(key: key);

  @override
  _MyAppState createState() {
    return _MyAppState();
  }
}

class _MyAppState extends State<CreatePlayer> {
  final TextEditingController _controller = TextEditingController();
  Future<Player> _futureAlbum;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Create Data Example',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Scaffold(
        body: Container(
          decoration: BoxDecoration(
            image: DecorationImage(
              image: AssetImage("images/dungeonimage5.jpg"),
              fit: BoxFit.cover
            ),
          ),
          alignment: Alignment.center,
          padding: const EdgeInsets.all(8.0),
          child: (_futureAlbum == null) ? Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              TextField(
                textAlign: TextAlign.center,
                controller: _controller,
                decoration: InputDecoration(
                  hintText: 'Enter your name', 
                  hintStyle: TextStyle(color: Colors.white, fontFamily: 'Lobster', fontSize: 25.0),
                  labelStyle: TextStyle(color: Colors.white, fontFamily: 'Lobster', fontSize: 25.0)),
                style: TextStyle(color: Colors.white, fontFamily: 'Lobster', fontSize: 25.0),
              ),
              SizedBox(height: 20),
              ButtonTheme(
                minWidth: 150.0,
                height: 50.0,
                child:
                RaisedButton(
                  onPressed: () {
                    setState(() {
                      _futureAlbum = createPlayer(_controller.text);
                    });
                  },
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(18.0),
                    side: BorderSide(color: Colors.white)
                  ),
                  child: Text("Register and play!",
                  style: TextStyle(
                    fontFamily: 'Lobster',
                    fontSize: 20.0,
                    fontWeight: FontWeight.bold,
                    color: Colors.white
                  )),
                ),
              ),
            ],
          ) : FutureBuilder<Player>(
            future: _futureAlbum,
            builder: (context, snapshot) {
              if (snapshot.hasData) {
                return Text(snapshot.data.name);
              } else if (snapshot.hasError) {
                return Text("${snapshot.error}");
              }

              return CircularProgressIndicator();
            },
          ),
        ),
      ),
    );
  }
}