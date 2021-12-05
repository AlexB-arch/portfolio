const express = require('express');
const path = require('path');
const PORT = process.env.PORT || 5000;
const server = http.createServer(app)
const { Server } = require('socket.io')

const app = express();
const io = Server(server);

//Middleware
app.use(express.static(path.join(__dirname, 'public')));

//Routes
app.get('/', (request, response) => response.sendFile('/index.html'));

//Socket
io.on('connection', (socket) => {
    console.log('Client connected');
    socket.on('disconnect', () => console.log('Client disconnected'));
  });

server.listen(PORT, () => console.log(`Listening on ${PORT}`));