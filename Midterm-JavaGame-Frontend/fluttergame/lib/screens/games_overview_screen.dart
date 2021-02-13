import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../widgets/games_grid.dart';
import '../providers/games.dart';

class GamesOverviewScreen extends StatefulWidget {
  @override
  _GamesOverviewScreenState createState() => _GamesOverviewScreenState();
}

class _GamesOverviewScreenState extends State<GamesOverviewScreen> {
  var _isInit = true;
  var _isLoading = false;

  @override
  void initState() {
    // Provider.of<Products>(context).fetchAndSetProducts(); // WON'T WORK!
    //Future.delayed(Duration.zero).then((_) {
    //  Provider.of<Games>(context).fetchAndSetGames();
    //});
    super.initState();
  }

  @override
  void didChangeDependencies() {
    if (_isInit) {
      setState(() {
        _isLoading = true;
      });
      Provider.of<Games>(context).fetchAndSetGames().then((_) {
        setState(() {
          _isLoading = false;
        });
      });
    }
    _isInit = false;
    super.didChangeDependencies();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('The Orb of Quarkus')
      ),
      body: _isLoading
          ? Center(
              child: CircularProgressIndicator(),
            )
          : GamesGrid(),
    );
  }
}