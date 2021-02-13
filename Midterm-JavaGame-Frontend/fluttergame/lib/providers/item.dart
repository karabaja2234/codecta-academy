import 'package:flutter/foundation.dart';

class Item with ChangeNotifier {
  final int id;
  final String name;
  final int value;

  Item({
    @required this.id,
    @required this.name,
    @required this.value,
  });
}