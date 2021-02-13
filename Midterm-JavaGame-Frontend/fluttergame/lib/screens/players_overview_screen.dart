import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../widgets/players_grid.dart';
import '../providers/players.dart';

class PlayersOverviewScreen extends StatefulWidget {
  @override
  _PlayersOverviewScreenState createState() => _PlayersOverviewScreenState();
}

class _PlayersOverviewScreenState extends State<PlayersOverviewScreen> {
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
      Provider.of<Players>(context).fetchAndSetPlayers().then((_) {
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
          : PlayersGrid(),
    );
  }
}