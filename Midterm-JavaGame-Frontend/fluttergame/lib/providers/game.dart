import 'dart:async';
import 'package:flutter/material.dart';
import 'package:fluttergame/providers/player.dart';

void main() {
  runApp(Game());
}

class Game extends StatefulWidget {
  Game({Key key}) : super(key: key);

  @override
  _MyAppState createState() {
    return _MyAppState();
  }
}

class _MyAppState extends State<Game> {
  final TextEditingController _controller = TextEditingController();
  Future<Player> _futurePlayer;

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
              image: AssetImage("images/dungeonimage6.jpg"),
              fit: BoxFit.cover
            ),
          ),
          alignment: Alignment.center,
          //padding: const EdgeInsets.all(8.0),
          child: (_futurePlayer == null) ? Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              TextField(
                textAlign: TextAlign.center,
                controller: _controller,
                decoration: InputDecoration(
                  hintText: 'Enter your name', 
                  hintStyle: TextStyle(color: Colors.white, fontFamily: 'Montserrat', fontSize: 25.0),
                  labelStyle: TextStyle(color: Colors.white, fontFamily: 'Montserrat', fontSize: 25.0)),
                style: TextStyle(color: Colors.white, fontFamily: 'Montserrat', fontSize: 25.0),
              ),
              SizedBox(height: 20),
              ButtonTheme(
                minWidth: 150.0,
                height: 50.0,
                child:
                RaisedButton(
                  onPressed: () {
                    setState(() {
                      if(_controller.text != "") {
                        _futurePlayer = createPlayer(_controller.text);
                      }
                    });
                  },
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(18.0),
                    side: BorderSide(color: Colors.white)
                  ),
                  child: Text("Register and play!",
                  style: TextStyle(
                    fontFamily: 'Montserrat',
                    fontSize: 20.0,
                    fontWeight: FontWeight.bold,
                    color: Colors.white
                  )),
                ),
              ),
            ],
          ) : FutureBuilder<Player>(
            future: _futurePlayer,
            builder: (context, snapshot) {
              if (snapshot.hasData) {
                return Scaffold(
                  appBar: AppBar(
                    backgroundColor: Colors.black87,
                    title: Text(
                    snapshot.data.name + " | Health: " + snapshot.data.health.toString() + " | Damage: " + snapshot.data.damage.toString() + " |",
                    style: TextStyle(
                      fontFamily: 'Montserrat',
                      fontSize: 20.0,
                      fontWeight: FontWeight.bold,
                      color: Colors.white
                    )),
                  ),
                  body: Container(
                    height: 1000,
                    decoration: BoxDecoration(
                      //borderRadius: BorderRadius.circular(15.0),
                      image: DecorationImage(
                        image: AssetImage(
                          'images/dungeonimage7.jpg'),
                        fit: BoxFit.fitHeight,
                      ),
                    ),
                    child: ListView(
                      padding: const EdgeInsets.all(8),
                      children: <Widget>[
                        Visibility(
                          visible: snapshot.data.health > 0 ? true : false,
                          child: Container(
                            height: 450,
                            child: GridView.count(
                              primary: false,
                              padding: const EdgeInsets.all(20),
                              crossAxisSpacing: 10,
                              mainAxisSpacing: 10,
                              crossAxisCount: 2,
                              children: <Widget>[
                                GestureDetector(
                                  onTap: (){
                                    setState(() {
                                      _futurePlayer = fight(snapshot.data.id);
                                    });
                                  },
                                  child: Container(
                                    height: 100,
                                    width: 100,
                                    decoration: BoxDecoration(
                                      borderRadius: BorderRadius.circular(15.0),
                                      color: Colors.red,
                                      border: Border.all(color: Colors.white),
                                      image: DecorationImage(
                                        image: AssetImage(
                                          'images/sword.png'),
                                        //fit: BoxFit.fitWidth,
                                      ),
                                    ),
                                  ),
                                ),
                                GestureDetector(
                                  onTap: (){
                                    setState(() {
                                      _futurePlayer = heal(snapshot.data.id);
                                    });
                                  },
                                  child: Container(
                                    height: 100,
                                    width: 100,
                                    decoration: BoxDecoration(
                                      borderRadius: BorderRadius.circular(15.0),
                                      color: Colors.lightGreen,
                                      border: Border.all(color: Colors.white),
                                      image: DecorationImage(
                                        image: AssetImage(
                                          'images/healing.png'),
                                        //fit: BoxFit.fitWidth,
                                      ),
                                    ),
                                  ),
                                ),
                                GestureDetector(
                                  onTap: (){
                                    setState(() {
                                      _futurePlayer = getStronger(snapshot.data.id);
                                    });
                                  },
                                  child: Container(
                                    height: 100,
                                    width: 100,
                                    decoration: BoxDecoration(
                                      borderRadius: BorderRadius.circular(15.0),
                                      color: Colors.teal[900],
                                      border: Border.all(color: Colors.white),
                                      image: DecorationImage(
                                        image: AssetImage(
                                          'images/powerup.png'),
                                        //fit: BoxFit.fitWidth,
                                      ),
                                    ),
                                  ),
                                ),
                                GestureDetector(
                                  onTap: (){
                                    setState(() {
                                      _futurePlayer = collectItems(snapshot.data.id);
                                    });
                                  },
                                  child: Container(
                                    height: 100,
                                    width: 100,
                                    decoration: BoxDecoration(
                                      borderRadius: BorderRadius.circular(15.0),
                                      color: Colors.pink[900],
                                      border: Border.all(color: Colors.white),
                                      image: DecorationImage(
                                        image: AssetImage(
                                          'images/potion.png'),
                                        //fit: BoxFit.fitWidth,
                                      ),
                                    ),
                                  ),
                                ),
                              ],
                            )
                          ),
                        ),
                        Container(
                          height: 100,
                          margin: EdgeInsets.only(top: snapshot.data.health > 0 ? 80.0 : 600.0),
                          child: Text(snapshot.data.statusMessage,
                          textAlign: TextAlign.center,
                          style: TextStyle(
                            fontFamily: 'Montserrat',
                            fontSize: snapshot.data.health > 0 ? 25.0 : 50.0,
                            fontWeight: FontWeight.bold,
                            color: Colors.white
                          )),
                        ),
                        Visibility(
                          visible: snapshot.data.health > 0 ? true : false,
                          child: Container(
                            height: 70,
                            child: Row(
                              children: <Widget>[
                                Expanded(
                                  child: GestureDetector(
                                    onTap: (){
                                      setState(() {
                                        _futurePlayer = previousRoom(snapshot.data.id);
                                      });
                                    },
                                    child: Container(
                                      height: 100,
                                      width: 100,
                                      decoration: BoxDecoration(
                                        image: DecorationImage(
                                          image: AssetImage(
                                            'images/previous.png'),
                                          //fit: BoxFit.fitWidth,
                                        ),
                                      ),
                                    ),
                                  ),
                                ),
                                Expanded(
                                  child: Text(''),
                                ),
                                Expanded(
                                  child: GestureDetector(
                                    onTap: (){
                                      setState(() {
                                        _futurePlayer = nextRoom(snapshot.data.id);
                                      });
                                    },
                                    child: Container(
                                      height: 100,
                                      width: 100,
                                      decoration: BoxDecoration(
                                        image: DecorationImage(
                                          image: AssetImage(
                                            'images/next.png'),
                                          //fit: BoxFit.fitWidth,
                                        ),
                                      ),
                                    ),
                                  ),
                                )
                              ],
                            )
                          ),
                        ),
                      ],
                    )
                  ),
                );
              } else if (snapshot.hasError) {
                //return Text("${snapshot.error}");
              }
              return CircularProgressIndicator();
            },
          ),
        ),
      ),
    );
  }
}