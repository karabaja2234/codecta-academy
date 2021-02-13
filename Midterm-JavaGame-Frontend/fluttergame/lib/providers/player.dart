import 'package:flutter/foundation.dart';

class Player with ChangeNotifier {
  final int id;
  final int health;
  final int damage;
  final int damageIncreasePotion;
  final int healingPotion;
  final bool hasOrbOfQuarkus;
  final String name;
  final String statusMessage;
  final int dungeonId;

  Player({
    @required this.id,
    @required this.health,
    @required this.damage,
    @required this.damageIncreasePotion,
    @required this.healingPotion,
    @required this.hasOrbOfQuarkus,
    @required this.name,
    @required this.statusMessage,
    @required this.dungeonId,
  });
}