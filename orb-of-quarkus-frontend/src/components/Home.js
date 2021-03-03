import React from 'react'
import Register from './Register'
import Info from './Info'
import fire from '../assets/images/fire.gif'
import { BrowserRouter as Router, Route, Link, Switch } from 'react-router-dom'

export default function Home() {
    return (
        <Router>
            <div className="Home container d-flex align-items-center flex-column justify-content-center" style={{ backgroundColor: 'rgba(0, 0, 0, 0.6)'}}>
                <Switch>
                    <Route exact path="/">
                        <img src={fire} alt="Logo" width="80px" height="140px"/>;
                        <h1 className="text-light text-center" style={{ fontSize: '70px', fontFamily: 'RocknRoll One'}}>The Orb of Quarkus</h1>
                        <Link to="/register">
                            <button className="btn btn-lg btn-dark mt-5 btn-outline-light" style={{ fontFamily: 'RocknRoll One'}}>
                                Start playing!
                            </button>
                        </Link>
                        <Link to="/info">
                            <p className="mt-3 text-light" style={{ fontSize: '20px', fontFamily: 'RocknRoll One'}}>How to play?</p>
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
