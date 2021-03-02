import React, { Component } from 'react'
const axios = require('axios')


export default class Test extends Component {
    
    componentDidMount() {
        var config = {
            method: 'GET',
            url: 'http://localhost:8080/game/games',
        };

        axios(config)
        .then(response => {
            console.log(response);
            console.log(JSON.parse(JSON.stringify(response.data[0])));
        })
        .catch(error => {
            console.log(error);
        });
    }
    render() {
        return (
            <div>
                <p>Selman</p>
            </div>
        )
    }
}

