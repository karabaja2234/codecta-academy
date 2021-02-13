import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../screens/game_detail_screen.dart';
import '../providers/game.dart';

class GameItem extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final game = Provider.of<Game>(context, listen: false);
    return ClipRRect(
      borderRadius: BorderRadius.circular(10),
      child: GridTile(
        child: GestureDetector(
          onTap: () {
            Navigator.of(context).pushNamed(
              GameDetailScreen.routeName,
              arguments: game.id,
            );
          },
        ),
        footer: GridTileBar(
          backgroundColor: Colors.black87,
          leading: Consumer<Game>(
            builder: (ctx, game, _) => IconButton(
                  color: Theme.of(context).accentColor,
                ),
          ),
          title: Text(
            game.id.toString(),
            textAlign: TextAlign.center,
          ),
        ),
      ),
    );
  }
}