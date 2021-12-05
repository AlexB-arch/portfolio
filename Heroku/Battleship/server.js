const express = require('express');
const path = require('path');
const PORT = process.env.PORT || 3000;
const http = require('http');
const { Server } = require("socket.io");

const app = express();
//Initiate server first
const server = http.createServer(app);
//Then, declare. Otherwise it doesn't work. (At least locally.)
const io = new Server(server);

//Middleware
app.use(express.static(path.join(__dirname, 'public')));

//Routes
app.get('/', (request, response) => {
    response.sendFile('/index.html')
});

server.listen(PORT, () => console.log(`Listening on ${PORT}`));

/*----------------------------------------------------
SERVER SOCKET.IO IMPLEMENTATION
-----------------------------------------------------*/

//IO is the server. Socket is the client.
io.on('connection', (socket) => {
    
    //Creates a new player object on connection.
    player = new Player();

    player.id = socket.id;

    //Test value of player id.
    console.log(player);
})

//Chat Example. Keep for reference.
io.on('connection', (socket) => {
    socket.on('chat message', msg => {
        io.emit('chat message', msg);
    });
});

/*----------------------------------------------------
SERVER-SIDE OBJECTS
-----------------------------------------------------*/

//Player object that holds id and ship location.
function Player(){

    var player = {
        name: null,
        id: null,
        ships:{
            uBoat:[],
            destroyer1:[],
            destroyer2:[],
            battleship:[],
            aircraftCarrier:[]
        }
    }

    return player;
}