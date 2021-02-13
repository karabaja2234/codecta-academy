import 'package:flutter/foundation.dart';

class Monster with ChangeNotifier {
  final int id;
  final int health;
  final int damage;
  final String name;
  final int itemId;
  final int dungeonId;

  Monster({
    @required this.id,
    @required this.health,
    @required this.damage,
    @required this.name,
    @required this.itemId,
    @required this.dungeonId,
  });
}