const express = require('express');
const path = require('path');
const PORT = process.env.PORT || 5000;

const app = express();
const io = socketIO(app);

//Middleware
app.use(express.static(path.join(__dirname, 'public')));
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

//Routes
app.get('/', (request, response) => response.render('index'));

//Socket
io.on('connection', (socket) => {
    console.log('Client connected');
    socket.on('disconnect', () => console.log('Client disconnected'));
  });

app.listen(PORT, () => console.log(`Listening on ${PORT}`));