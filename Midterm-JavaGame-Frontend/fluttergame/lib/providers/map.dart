import 'package:flutter/foundation.dart';

class Map with ChangeNotifier {
  final int id;
  final int gameId;
  final int levelId;

  Map({
    @required this.id,
    @required this.gameId,
    @required this.levelId,
  });
}