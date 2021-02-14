import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class Info extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
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
              SizedBox(height: 20),
              Container(
                height: 800,
                child: GridView.count(
                  primary: false,
                  padding: const EdgeInsets.all(20),
                  crossAxisSpacing: 10,
                  mainAxisSpacing: 10,
                  crossAxisCount: 2,
                  children: <Widget>[
                    Container(
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
                    Text("Fight the monsters in each dungeon!",
                    style: TextStyle(
                      fontFamily: 'Montserrat',
                      fontSize: 25.0,
                      fontWeight: FontWeight.bold,
                      color: Colors.white,
                      backgroundColor: Colors.black87
                    )),
                    Container(
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
                    Text("Heal yourself with healing potions!",
                    style: TextStyle(
                      fontFamily: 'Montserrat',
                      fontSize: 25.0,
                      fontWeight: FontWeight.bold,
                      color: Colors.white,
                      backgroundColor: Colors.black87
                    )),
                    Container(
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
                    Text("Increase your damage with damage increasing potions!",
                    style: TextStyle(
                      fontFamily: 'Montserrat',
                      fontSize: 25.0,
                      fontWeight: FontWeight.bold,
                      color: Colors.white,
                      backgroundColor: Colors.black87
                    )),
                    Container(
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
                    Text("Collect items in each dungeon after you kill the monster!",
                    style: TextStyle(
                      fontFamily: 'Montserrat',
                      fontSize: 25.0,
                      fontWeight: FontWeight.bold,
                      color: Colors.white,
                      backgroundColor: Colors.black87
                    )),
                  ],
                )
              ),
            ],
          )
        ),
      ),
    );
  }
}