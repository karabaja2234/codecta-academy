import React, { Component } from 'react'
import { Form } from 'react-bootstrap';
import { BrowserRouter as Router, Route, Switch, Redirect } from 'react-router-dom'
import Home from './Home'
import Info from './Info'
import Game from './Game'
import Cobweb from '../assets/images/cobweb.gif'
import Player from '../assets/images/player.gif'

export default class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {
            player: {
                name: '',
                health: 100,
                damage: 10,
                healingPotion: 0,
                damageIncreasePotion: 0,
                hasOrbOfQuarkus: false,
                statusMessage: "",
                dungeonId: 1
            },
            enteredName: '',
            redirect: false
        };

        this.onChangeName = this.onChangeName.bind(this)
        this.play = this.play.bind(this)
    }

    onChangeName(e) {
        this.setState({ enteredName: e.target.value})
    }

    play() {
        if(this.state.enteredName !== "") {
            this.setState((state, props) => ({
                player: {
                    name: state.enteredName,
                    health: 100,
                    damage: 10,
                    healingPotion: 0,
                    damageIncreasePotion: 0,
                    hasOrbOfQuarkus: false,
                    statusMessage: "",
                    dungeonId: 1
                },
                redirect: true
            }))
        }
    }

    render() {
        return (
            <Router>
                <div className="Register d-flex align-items-center flex-column justify-content-center">
                    { this.state.redirect ? (<Redirect push to="/game"/>) : null }
                    <Switch>
                        <Route exact path="/register">
                            <img src={Cobweb} alt="Logo" width="450px" height="450px" style={{ position: 'absolute', left: '20%', top: 0}}/>
                            <img src={Player} alt="Logo" width="350px" height="350px" style={{ position: 'absolute', right: '25%', bottom: 0}}/>
                            <Form>
                                <Form.Group controlId="formGroupEmail">
                                    <Form.Label className="text-light text-center" style={{fontSize: '24px', fontFamily: 'RocknRoll One'}}>Enter your name</Form.Label>
                                    <Form.Control className="bg-dark mt-2 text-light" style={{fontFamily: 'RocknRoll One', height: '50px'}} type="text" placeholder="Enter your name here" value={this.state.enteredName} onChange={this.onChangeName}/>
                                </Form.Group>
                            </Form>
                            <button className="btn btn-lg btn-dark btn-outline-light" onClick={this.play}>
                                Start playing!
                            </button>
                        </Route>
                        <Route exact path="/">
                            <Home />
                        </Route>
                        <Route exact path="/game">
                            <Game player={this.state.player}/>
                        </Route>
                        <Route exact path="/info">
                            <Info />
                        </Route>
                    </Switch>
                </div>
            </Router>
        )
    }
}

