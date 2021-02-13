import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../providers/games.dart';
import './game_item.dart';

class GamesGrid extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final gamesData = Provider.of<Games>(context);
    final games = gamesData.items;
    return GridView.builder(
      padding: const EdgeInsets.all(10.0),
      itemCount: games.length,
      itemBuilder: (ctx, i) => ChangeNotifierProvider.value(
            // builder: (c) => products[i],
            value: games[i],
            child: GameItem(
                // games[i].id,
                ),
          ),
      gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
        crossAxisCount: 2,
        childAspectRatio: 3 / 2,
        crossAxisSpacing: 10,
        mainAxisSpacing: 10,
      ),
    );
  }
}