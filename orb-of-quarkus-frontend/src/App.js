import Home from './components/Home'
import Register from './components/Register'
import Info from './components/Info'
import Game from './components/Game'
import { BrowserRouter as Router, Route } from "react-router-dom";
import dungeonImage from './assets/images/dungeonbackground.jpg'

function App() {
  return (
    <Router>
      <div className="App" style={{ backgroundImage: `url(${dungeonImage})`, backgroundPosition: 'center', padding: '15px'}}>
        <Route exact path="/">
          <Home />
        </Route>
        <Route exact path='/register'>
          <Register />
        </Route>
        <Route exact path="/info">
          <Info />
        </Route>
        <Route exact path="/game">
          <Game />
        </Route>
      </div>
    </Router >
  );
}

export default App;
