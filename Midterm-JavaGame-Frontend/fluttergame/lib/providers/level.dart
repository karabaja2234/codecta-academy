import 'package:flutter/foundation.dart';

class Level with ChangeNotifier {
  final int id;
  final int difficulty;

  Level({
    @required this.id,
    @required this.difficulty,
  });
}