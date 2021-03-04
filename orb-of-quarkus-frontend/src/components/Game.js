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
import { BrowserRouter as Redirect } from 'react-router-dom'
import dungeonImage2 from '../assets/images/dungeonbackground2.jpg'
import dungeonImage3 from '../assets/images/dungeonbackground3.jpg'

const axios = require('axios')
const monsters = [Monster1, Monster2, Monster3]; //hardcoded

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
            redirect: false,
            showMonster: false
        };
        this.fight = this.fight.bind(this)
        this.heal = this.heal.bind(this)
        this.increaseDamage = this.increaseDamage.bind(this)
        this.collect = this.collect.bind(this)
        this.previousDungeon = this.previousDungeon.bind(this)
        this.nextDungeon = this.nextDungeon.bind(this)
        this.monsterIsAlive = this.monsterIsAlive.bind(this)
    }

    componentDidMount() {
        this.monsterIsAlive();
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

    fight() {
        Swal.fire({
            title: "Are you sure you want to fight the monster from this dungeon?",
            text: "There is no going back!",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Yes, I am sure.",
            cancelButtonText: "No, I am not.",
            background: "#ebe1f7",
            iconColor: "#d9534f"
          }).then((result) => {
            if (result.value) {
                axios.put(`http://localhost:8080/game/players/${this.state.player != null ? this.state.player.id : null}/fight`, this.state.player)
                .then(response => {
                    this.setState({player: response.data})
                    if(response.data.health > 0) {
                        this.setState({showMonster: false})
                        Toast.fire({
                            icon: "success",
                            title: response.data.statusMessage,
                        });
                    } else {
                        this.setState({redirect: true})
                        Swal.fire({
                            icon: 'error',
                            title: 'Game over!',
                            text: 'Better luck next time!',
                        })
                    }
                })
                .catch(error => {
                    console.log(error);
                });
            }
        });
    }

    heal() {
        if(this.state.player.healingPotion == 0) {
            Toast.fire({
                icon: "error",
                title: "You don't have a healing potion yet!",
            });
            return;
        }
        Swal.fire({
            title: "Are you sure you want to use your healing potion?",
            icon: "question",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Yes, I am sure.",
            cancelButtonText: "No, I am not.",
            background: "#ebe1f7",
            iconColor: "#d9534f"
          }).then((result) => {
            if (result.value) {
                axios.put(`http://localhost:8080/game/players/${this.state.player != null ? this.state.player.id : null}/heal`, this.state.player)
                .then(response => {
                    this.setState({player: response.data})
                    Toast.fire({
                        icon: "success",
                        title: response.data.statusMessage,
                    });
                })
                .catch(error => {
                    console.log(error);
                });
            }
        });
    }

    increaseDamage() {
        if(this.state.player.damageIncreasePotion == 0) {
            Toast.fire({
                icon: "error",
                title: "You don't have a damage increasing potion yet!",
            });
            return;
        }
        Swal.fire({
            title: "Are you sure you want to use your damage increasing potion?",
            icon: "question",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Yes, I am sure.",
            cancelButtonText: "No, I am not.",
            background: "#ebe1f7",
            iconColor: "#d9534f"
          }).then((result) => {
            if (result.value) {
                axios.put(`http://localhost:8080/game/players/${this.state.player != null ? this.state.player.id : null}/stronger`, this.state.player)
                .then(response => {
                    this.setState({player: response.data})
                    Toast.fire({
                        icon: "success",
                        title: response.data.statusMessage,
                    });
                })
                .catch(error => {
                    console.log(error);
                });
            }
        });
    }

    collect() {
        Swal.fire({
            title: "Are you sure you want to collect the item from this dungeon?",
            icon: "question",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Yes, I am sure.",
            cancelButtonText: "No, I am not.",
            background: "#ebe1f7",
            iconColor: "#d9534f"
          }).then((result) => {
            if (result.value) {
                axios.put(`http://localhost:8080/game/players/${this.state.player != null ? this.state.player.id : null}/collect`, this.state.player)
                .then(response => {
                    this.setState({player: response.data})
                    if(response.data.hasOrbOfQuarkus) {
                        Swal.fire({
                            icon: 'success',
                            title: 'Congratulations, you won!',
                            text: 'The Orb of Quarkus is finally yours!',
                        })
                    } else {
                        Toast.fire({
                            icon: "success",
                            title: response.data.statusMessage,
                        });
                    }
                })
                .catch(error => {
                    console.log(error);
                });
            }
        });
    }

    previousDungeon() {
        Swal.fire({
            title: "Are you sure you want to go back to the previous dungeon?",
            icon: "question",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Yes, I am sure.",
            cancelButtonText: "No, I am not.",
            background: "#ebe1f7",
            iconColor: "#d9534f"
          }).then((result) => {
            if (result.value) {
                axios.put(`http://localhost:8080/game/players/${this.state.player != null ? this.state.player.id : null}/goback`, this.state.player)
                .then(response => {
                    this.setState({player: response.data})
                    Toast.fire({
                        icon: "success",
                        title: response.data.statusMessage,
                    });
                })
                .catch(error => {
                    console.log(error);
                });
            }
        });
    }

    nextDungeon() {
        Swal.fire({
            title: "Are you sure you want to go back to the next dungeon?",
            icon: "question",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Yes, I am sure.",
            cancelButtonText: "No, I am not.",
            background: "#ebe1f7",
            iconColor: "#d9534f"
          }).then((result) => {
            if (result.value) {
                axios.put(`http://localhost:8080/game/players/${this.state.player != null ? this.state.player.id : null}/move`, this.state.player)
                .then(response => {
                    this.setState({player: response.data})
                    this.monsterIsAlive();
                    Toast.fire({
                        icon: "success",
                        title: response.data.statusMessage,
                    });
                })
                .catch(error => {
                    console.log(error);
                });
            }
        });
    }

    monsterIsAlive() {
        axios.get(`http://localhost:8080/game/monsters`)
        .then(response => {
            for(let i=0; i<response.data.length; i++) {
                if(response.data[i].dungeonId == this.state.player.dungeonId) {
                    if(response.data[i].health > 0) this.setState({showMonster: true})
                    else this.setState({showMonster: false})
                }
            }
        })
        .catch(error => {
            console.log(error);
        });
    }

    render() {
        return (
            <div className="Game container d-flex align-items-start justify-content-center" style={{ backgroundImage: `url(${this.state.player != null && this.state.showMonster ? monsters[this.state.player.dungeonId -1 ] : null})`, backgroundPosition: 'bottom', backgroundRepeat: 'no-repeat'}}>
                { this.state.redirect ? (<Redirect push to="/"/>) : null }
                <div className="d-flex container justify-content-center align-items-center flex-wrap">
                    <div className="container p-5 bg-secondary rounded border border-light" style={{backgroundImage: `url(${Player}), url(${dungeonImage2})`, backgroundPosition: 'top, center', backgroundRepeat: 'no-repeat'}}>
                        <h1 className="text-light">{this.state.player != null ? this.state.player.name : "Undefined player's name"}</h1>
                        <p className="text-light">Players health: {this.state.player != null ? this.state.player.health : "Undefined player's health"}</p>
                        <p className="text-light">Players damage: {this.state.player != null ? this.state.player.damage : "Undefined player's damage"}</p>
                    </div>
                    <div style={{maxWidth: '220px'}} id="card-div" onClick={this.fight}>
                        <div id="card-div-img-box" style={{ backgroundImage: `url(${Fight})`}}></div>
                        <div id="card-div-naziv-cijena">
                            <div id="card-naziv">
                                <p className="mt-2 text-center">FIGHT</p>
                            </div>
                        </div>
                    </div>
                    <div style={{maxWidth: '220px'}} id="card-div" onClick={this.heal}>
                        <div id="card-div-img-box" style={{ backgroundImage: `url(${Heal})`}}></div>
                        <div id="card-div-naziv-cijena">
                            <div id="card-naziv">
                                <p className="mt-2 text-center">HEAL</p>
                            </div>
                        </div>
                    </div>
                    <div style={{maxWidth: '220px'}} id="card-div" onClick={this.increaseDamage}>
                        <div id="card-div-img-box" style={{ backgroundImage: `url(${Potion})`}}></div>
                        <div id="card-div-naziv-cijena">
                            <div id="card-naziv">
                                <p className="mt-2 text-center">STRONGER</p>
                            </div>
                        </div>
                    </div>
                    <div style={{maxWidth: '220px'}} id="card-div" onClick={this.collect}>
                        <div id="card-div-img-box" style={{ backgroundImage: `url(${Gift})`}}></div>
                        <div id="card-div-naziv-cijena">
                            <div id="card-naziv">
                                <p className="mt-2 text-center">COLLECT</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="container d-flex justify-content-between flex-wrap pl-4 pr-4" style={{position: 'absolute', bottom: 50}}>
                    <button className="btn btn-lg btn-dark btn-outline-light" onClick={this.previousDungeon}>
                        Previous dungeon
                    </button>
                    <button className="btn btn-lg btn-dark btn-outline-light" onClick={this.nextDungeon}>
                        Next dungeon
                    </button>
                </div>
            </div>
        )
    }
}
