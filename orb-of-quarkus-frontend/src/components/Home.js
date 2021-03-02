import React from 'react'
import Register from './Register'
import Info from './Info'
import { BrowserRouter as Router, Route, Link, Switch } from 'react-router-dom'
import dungeonImage from '../assets/images/dungeonbackground.jpg'

export default function Home() {
    return (
        <Router>
            <div className="home container" style={{ backgroundImage: `url(${dungeonImage})`}}>
                <Switch>
                    <Route exact path="/">
                        <Link to="/register">
                            <p className="text-warning">Start playing!</p>
                        </Link>
                        <Link to="/info">
                            <p>How to play?</p>
                        </Link>
                    </Route>
                    <Route exact path="/register">
                        <Register />
                    </Route>
                    <Route exact path="/info">
                        <Info />
                    </Route>
                </Switch>
            </div>
        </Router>
    )
}
