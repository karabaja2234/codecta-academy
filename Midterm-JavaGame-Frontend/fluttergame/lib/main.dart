import 'package:flutter/material.dart';
import 'package:fluttergame/providers/createPlayer.dart';
import 'package:fluttergame/providers/form.dart';
import 'package:provider/provider.dart';
import './screens/games_overview_screen.dart';
import './screens/game_detail_screen.dart';
import './screens/players_overview_screen.dart';
import './screens/player_detail_screen.dart';
import './providers/games.dart';
import './providers/players.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
        home: new HomeScreen());
  }
}

class HomeScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider.value(
          value: Players()
        ),
        ChangeNotifierProvider.value(
          value: Games()
        ),
      ],
      child: MaterialApp(
          //home: GamesOverviewScreen(),
          //home: PlayersOverviewScreen(),
          home: Scaffold(
            body: Container(
              alignment: Alignment.center,
              decoration: BoxDecoration(
                image: DecorationImage(
                  image: AssetImage("images/dungeonimage8.jpg"),
                  fit: BoxFit.cover
                ),
              ),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  SizedBox(height: 60),
                  Text("Welcome To",
                  style: TextStyle(
                    fontFamily: 'Montserrat',
                    fontSize: 25.0,
                    fontWeight: FontWeight.bold,
                    color: Colors.white
                  )),
                  SizedBox(height: 20),
                  Text("The Orb of Quarkus",
                  style: TextStyle(
                    fontFamily: 'Montserrat',
                    fontSize: 40.0,
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                    backgroundColor: Colors.black54,
                  )),
                  SizedBox(height: 20),
                  ButtonTheme(
                    minWidth: 150.0,
                    height: 50.0,
                    child: RaisedButton(
                      onPressed: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(builder: (context) => CreatePlayer()),
                        );
                      },
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(18.0),
                        side: BorderSide(color: Colors.white)
                      ),
                      child: Text("Play",
                      style: TextStyle(
                        fontFamily: 'Montserrat',
                        fontSize: 20.0,
                        fontWeight: FontWeight.bold,
                        color: Colors.white
                      )),
                    ),
                  ),
                ]
              ),
            ),
          ),
          routes: {
            GameDetailScreen.routeName: (ctx) => GameDetailScreen(),
            PlayerDetailScreen.routeName: (ctx) => PlayerDetailScreen(),
          }),
    );
  }
}

/*
class GamesPage extends StatelessWidget {
  final HttpService httpService = HttpService();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Games"),
      ),
      body: FutureBuilder(
        future: httpService.getGames(),
        builder: (BuildContext context, AsyncSnapshot<List<Game>> snapshot) {
          if (snapshot.hasData) {
            List<Game> games = snapshot.data;
            return ListView(
              children: games
                  .map(
                    (Game game) => ListTile(
                      title: Text("${game.id}"),
                    ),
                  )
                  .toList(),
            );
          } else {
            return Center(child: CircularProgressIndicator());
          }
        },
      ),
    );
  }
}

class Game {
  final int id;

  Game({
    @required this.id,
  });

  factory Game.fromJson(Map<String, dynamic> json) {
    return Game(
      id: json['id'] as int
    );
  }
}


class HttpService {
  final String gamesURL = "http://localhost:8080/game/games";

  Future<List<Game>> getGames() async {
    Response res = await get(gamesURL);

    if (res.statusCode == 200) {
      List<dynamic> body = jsonDecode(res.body);

      List<Game> games = body
          .map(
            (dynamic item) => Game.fromJson(item),
          )
          .toList();

      return games;
    } else {
      throw "Can't get games.";
    }
  }
}
*/