import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../providers/players.dart';

class PlayerDetailScreen extends StatelessWidget {
  static const routeName = '/player-detail';

  @override
  Widget build(BuildContext context) {
    final int playerId = ModalRoute.of(context).settings.arguments; // is the id!
    final loadedPlayer = Provider.of<Players>(
      context,
      listen: false,
    ).findById(playerId);
    return Scaffold(
      appBar: AppBar(
        title: Text(loadedPlayer.id.toString()),
      ),
    );
  }
}
