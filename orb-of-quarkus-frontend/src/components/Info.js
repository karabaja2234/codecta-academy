import React from 'react'
import Player from '../assets/images/player.gif'
import Fight from '../assets/images/fight.gif'
import Heal from '../assets/images/heal.gif'
import Potion from '../assets/images/potion.gif'
import Gift from '../assets/images/gift.gif'

export default function Info() {
    return (
        <div className="Info container d-flex align-items-start justify-content-between flex-column" style={{backgroundImage: `url(${Player})`, backgroundPosition: 'bottom', backgroundRepeat: 'no-repeat', backgroundSize: '500px 500px'}}>
            <div className="d-flex justify-content-center align-items-center flex-wrap w-100">
                <div style={{maxWidth: '220px', minWidth: '120px'}} id="card-div">
                    <div id="card-div-img-box" style={{ backgroundImage: `url(${Fight})`, backgroundPosition: 'center'}}></div>
                    <div id="card-div-description">
                        <div id="card-text">
                            <p className="mt-2 text-center">FIGHT</p>
                        </div>
                    </div>
                </div>
                <h5 className="text-light text-center p-4 w-50" style={{background: 'rgba(0, 0, 0, 0.6)'}}>Fight the monsters in dungeons!</h5>
            </div>
            
            <div className="d-flex justify-content-center align-items-center flex-wrap w-100">
                <div style={{maxWidth: '220px', minWidth: '120px'}} id="card-div">
                    <div id="card-div-img-box" style={{ backgroundImage: `url(${Heal})`, backgroundPosition: 'center'}}></div>
                    <div id="card-div-description">
                        <div id="card-text">
                            <p className="mt-2 text-center">HEAL</p>
                        </div>
                    </div>
                </div>
                <h5 className="text-light text-center p-4 w-50" style={{background: 'rgba(0, 0, 0, 0.6)'}}>Heal yourself using a healing potion!</h5>
            </div>

            <div className="d-flex justify-content-center align-items-center flex-wrap w-100">
                <div style={{maxWidth: '220px', minWidth: '120px'}} id="card-div">
                    <div id="card-div-img-box" style={{ backgroundImage: `url(${Potion})`, backgroundPosition: 'center'}}></div>
                    <div id="card-div-description">
                        <div id="card-text">
                            <p className="mt-2 text-center">STRONGER</p>
                        </div>
                    </div>
                </div>
                <h5 className="text-light text-center p-4 w-50" style={{background: 'rgba(0, 0, 0, 0.6)'}}>Get stronger with a damage increasing potion!</h5>
            </div>

            <div className="d-flex justify-content-center align-items-center flex-wrap w-100">
                <div style={{maxWidth: '220px', minWidth: '120px'}} id="card-div">
                    <div id="card-div-img-box" style={{ backgroundImage: `url(${Gift})`, backgroundPosition: 'center'}}></div>
                    <div id="card-div-description">
                        <div id="card-text">
                            <p className="mt-2 text-center">COLLECT</p>
                        </div>
                    </div>
                </div>
                <h5 className="text-light text-center p-4 w-50" style={{background: 'rgba(0, 0, 0, 0.6)'}}>Collect the items from the dungeons!</h5>
            </div>
        </div>
    )
}
