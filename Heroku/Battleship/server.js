const express = require('express');
const path = require('path');

const app = express();
let port = process.env.PORT || 3000

//Template Engine
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

//Route
const indexRouter = require('./routes/index');

//Middleware
app.use(express.json());
app.use(express.urlencoded({extended: false}));
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);

app.listen(port, async () => { 
    console.log('App listening on port', port);
});