import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../screens/player_detail_screen.dart';
import '../providers/player.dart';

class PlayerItem extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final player = Provider.of<Player>(context, listen: false);
    return ClipRRect(
      borderRadius: BorderRadius.circular(10),
      child: GridTile(
        child: GestureDetector(
          onTap: () {
            Navigator.of(context).pushNamed(
              PlayerDetailScreen.routeName,
              arguments: player.id,
            );
          },
        ),
        footer: GridTileBar(
          backgroundColor: Colors.black87,
          leading: Consumer<Player>(
            builder: (ctx, player, _) => IconButton(
                  color: Theme.of(context).accentColor,
                ),
          ),
          title: Text(
            player.id.toString(),
            textAlign: TextAlign.center,
          ),
        ),
      ),
    );
  }
}