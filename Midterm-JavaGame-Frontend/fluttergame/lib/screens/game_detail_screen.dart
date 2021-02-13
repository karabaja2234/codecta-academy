import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../providers/games.dart';

class GameDetailScreen extends StatelessWidget {
  static const routeName = '/game-detail';

  @override
  Widget build(BuildContext context) {
    final int gameId = ModalRoute.of(context).settings.arguments; // is the id!
    final loadedProduct = Provider.of<Games>(
      context,
      listen: false,
    ).findById(gameId);
    return Scaffold(
      appBar: AppBar(
        title: Text(loadedProduct.id.toString()),
      ),
    );
  }
}
