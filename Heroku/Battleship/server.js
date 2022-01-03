const express = require('express');
const path = require('path');
const PORT = process.env.PORT || 3000;
const http = require('http');
const { Server } = require('socket.io');
const { disconnect } = require('process');

const app = express();
//Initiate server first
const server = http.createServer(app);
//Then, declare. Otherwise it doesn't work. (At least locally.)
const io = new Server(server);

//Middleware
app.use(express.static(path.join(__dirname, 'public')));

//Routes
app.get('/', (request, response) => {
    response.sendFile('/index.html');
});

server.listen(PORT, () => console.log(`Listening on ${PORT}`));

/*----------------------------------------------------
SERVER SOCKET.IO IMPLEMENTATION
-----------------------------------------------------*/
const connections = [null, null];

io.on('connection', (socket) => {
    // console.log('New WS Connection')

    // Find an available player number
    let playerIndex = -1;
    for (const i in connections) {
        if (connections[i] === null) {
            playerIndex = i;
            break;
        }
    }

    // Tell the connecting client what player number they are
    socket.emit('player-number', playerIndex);

    console.log(`Player ${playerIndex} has connected`);

    // Ignore player 3
    if (playerIndex === -1) return;

    connections[playerIndex] = false;

    // Tell eveyone what player number just connected
    socket.broadcast.emit('player-connection', playerIndex);

    // Handle Diconnect
    socket.on('disconnect', () => {
        console.log(`Player ${playerIndex} disconnected`);
        connections[playerIndex] = null;
        //Tell everyone what player numbe just disconnected
        socket.broadcast.emit('player-connection', playerIndex);
    });

    // On Ready
    socket.on('player-ready', () => {
        socket.broadcast.emit('enemy-ready', playerIndex);
        connections[playerIndex] = true;
    });

    // Check player connections
    socket.on('check-players', () => {
        const players = [];
        for (const i in connections) {
            connections[i] === null
                ? players.push({ connected: false, ready: false })
                : players.push({ connected: true, ready: connections[i] });
        }
        socket.emit('check-players', players);
    });

    // On Fire Received
    socket.on('attack', (id) => {
        console.log(`Shot fired from ${playerIndex}`, id);

        // Emit the move to the other player
        socket.broadcast.emit('attack', id);
    });

    // on Fire Reply
    socket.on('attack-reply', (square) => {
        console.log(square);

        // Forward the reply to the other player
        socket.broadcast.emit('attack-reply', square);
    });

    socket.on('chat message', (msg) => {
        console.log('message: ' + msg);
    });
});
