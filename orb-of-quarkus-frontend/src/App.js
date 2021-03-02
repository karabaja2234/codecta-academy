import Home from './components/Home'
import Register from './components/Register'
import Info from './components/Info'
import { BrowserRouter as Router, Route } from "react-router-dom";

function App() {
  return (
    <Router>
      <div className="App">
        <Route exact path="/">
          <Home />
        </Route>
        <Route exact path='/register'>
          <Register />
        </Route>
        <Route exact path="/info">
          <Info />
        </Route>
      </div>
    </Router >
  );
}

export default App;
