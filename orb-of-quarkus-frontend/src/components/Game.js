import React, { Component } from 'react'
import Swal from "sweetalert2";
import Player from '../assets/images/player.gif'
import Fight from '../assets/images/fight.gif'
import Heal from '../assets/images/heal.gif'
import Potion from '../assets/images/potion.gif'
import Gift from '../assets/images/gift.gif'
import Monster1 from '../assets/images/monster1.gif'
import Monster2 from '../assets/images/monster2.gif'
import Monster3 from '../assets/images/monster3.gif'
import {Button} from 'react-bootstrap';

const axios = require('axios')

//<p className="text-light">{this.state.player != null ? this.state.player.name : ""}</p>
const Toast = Swal.mixin({
    toast: true,
    position: "top-end",
    showConfirmButton: false,
    timer: 3000,
    timerProgressBar: true,
    onOpen: (toast) => {
      toast.addEventListener("mouseenter", Swal.stopTimer);
      toast.addEventListener("mouseleave", Swal.resumeTimer);
    },
});

export default class Game extends Component {
    constructor(props) {
        super(props);
        this.state = {
            
        };
    }

    componentDidMount() {
        if(this.props.player != null) {
            const player = { 
                name: this.props.player.name,
                health: this.props.player.health,
                damage: this.props.player.damage,
                healingPotion: this.props.player.healingPotion,
                damageIncreasePotion: this.props.player.damageIncreasePotion,
                hasOrbOfQuarkus: this.props.player.hasOrbOfQuarkus,
                statusMessage: this.props.player.statusMessage,
                dungeonId: this.props.player.dungeonId 
            };
    
            axios.post('http://localhost:8080/game/newplayer', player)
            .then(response => this.setState({player: response.data}))
            .catch(error => {
                console.log(error);
            });
        }
    }

    render() {
        return (
            <div className="Game container d-flex align-items-start justify-content-center" style={{ backgroundColor: 'rgba(0, 0, 0, 0.6)', backgroundImage: `url(${Player})`, backgroundPosition: 'bottom', backgroundRepeat: 'no-repeat'}}>
                <div className="d-flex container justify-content-center align-items-center flex-wrap">
                    <div className="jumbotron bg-secondary">
                        <h1 className="display-4 text-light">{this.state.player != null ? this.state.player.name : "Undefined player's name"}</h1>
                        <p className="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
                        <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
                        <a className="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
                    </div>
                    <div style={{maxWidth: '220px'}} id="card-div">
                        <div id="card-div-img-box" style={{ backgroundImage: `url(${Fight})`}}></div>
                        <div id="card-div-naziv-cijena">
                            <div id="card-naziv">
                                <p className="mt-2 text-center">FIGHT</p>
                            </div>
                        </div>
                    </div>
                    <div style={{maxWidth: '220px'}} id="card-div">
                        <div id="card-div-img-box" style={{ backgroundImage: `url(${Heal})`}}></div>
                        <div id="card-div-naziv-cijena">
                            <div id="card-naziv">
                                <p className="mt-2 text-center">HEAL</p>
                            </div>
                        </div>
                    </div>
                    <div style={{maxWidth: '220px'}} id="card-div">
                        <div id="card-div-img-box" style={{ backgroundImage: `url(${Potion})`}}></div>
                        <div id="card-div-naziv-cijena">
                            <div id="card-naziv">
                                <p className="mt-2 text-center">STRONGER</p>
                            </div>
                        </div>
                    </div>
                    <div style={{maxWidth: '220px'}} id="card-div">
                        <div id="card-div-img-box" style={{ backgroundImage: `url(${Gift})`}}></div>
                        <div id="card-div-naziv-cijena">
                            <div id="card-naziv">
                                <p className="mt-2 text-center">COLLECT</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="container d-flex justify-content-between flex-wrap pl-4 pr-4" style={{position: 'absolute', bottom: 50}}>
                    <button className="btn btn-lg btn-dark btn-outline-light" onClick={this.play}>
                        Previous dungeon
                    </button>
                    <button className="btn btn-lg btn-dark btn-outline-light" onClick={this.play}>
                        Next dungeon
                    </button>
                </div>
            </div>
        )
    }
}
