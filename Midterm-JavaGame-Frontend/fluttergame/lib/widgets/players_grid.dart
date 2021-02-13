import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../providers/players.dart';
import './player_item.dart';

class PlayersGrid extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final playersData = Provider.of<Players>(context);
    final players = playersData.items;
    return GridView.builder(
      padding: const EdgeInsets.all(10.0),
      itemCount: players.length,
      itemBuilder: (ctx, i) => ChangeNotifierProvider.value(
            // builder: (c) => products[i],
            value: players[i],
            child: PlayerItem(
                // players[i].id,
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