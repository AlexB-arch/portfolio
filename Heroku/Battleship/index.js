// IT325 Spring 2020
// Brent Reeves
// socket.io example for 4 clients
//
const express = require("express");
const path = require("path");
const app = express();
var http = require("http").createServer(app);
var io = require("socket.io")(http);
var port = process.env.PORT || 3000;
const production = false;

app.use(express.static(path.join(__dirname, "./static")));

app.get("/", function(req, res)
{
    res.sendFile(__dirname + "./index.html");
});

var clients = new Map();
var clientId = 0;

function aKey(aSocket)
{
    if(production)
    {
        return aSocket.handshake.address;
    }
    else
    {
        return aSocket.id;
    }
}

io.on("connection", function(socket)
{
    // remember this socket id
    clientId += 1;
    // var aKey = socket.handshake.address; // production ok, but testing difficult
    var aKey = socket.id;
    clients.set(aKey, {id: clientId});
    console.log("connection: " + socket.id + " clientId: " + clientId + " key: " + aKey);
    socket.emit("welcome", {id: clientId});

    socket.on("chat", function(msg) 
    {
        // var info = clients.get(socket.handshake.address);
        var info = clients.get(socket.id);

        io.emit("chat", {
            from: info.id,
            text: msg.text
        }); // io.emit sends to all
        console.log("chat received from " + info.id + " - " + msg.text);
    });
});

io.on("disconect", function(socket)
{
    console.log("disconnect from: " + socket.io + "  ip: " + socket.handshake.address);
});

http.listen(port, function()
{
    console.log("listening on port " + port);
});
