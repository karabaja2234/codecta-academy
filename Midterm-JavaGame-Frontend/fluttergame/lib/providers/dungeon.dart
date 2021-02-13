import 'package:flutter/foundation.dart';

class Dungeon with ChangeNotifier {
  final int id;
  final int mapId;

  Dungeon({
    @required this.id,
    @required this.mapId,
  });
}