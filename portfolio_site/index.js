const express = require('express');//the base for your web app. (npm install express)
const chalk = require('chalk');//adds color to console messages. (npm install chalk)
const debug = require('debug')('app');//middleware that helps with debbuging. (npm install debug)
const morgan = require('morgan');//middleware that helps to output whats happening with your app. (npm install morgan)
const path = require('path');

const app = express();
const port = 3000;

/* ROUTERS */
const resumeRouter = require('./src/routers/resumeRouter');

/* MIDDLEWARE */
app.use(morgan('tiny'));//Gives you less information from the connection.
app.use(express.json());//Parses json file contents
app.use(express.urlencoded({extended:true}));//Parses encoded URLs.

app.use('/resume', resumeRouter);

/* SETTINGS */
app.set('views', './src/views');//sets the path for your views.
app.set('view engine', 'ejs');//sets your template engine that renders html.
app.use(express.static(path.join(__dirname, '/public')));

/* DEFAULT LANDING PAGE */
app.get('/', (request, response) => {
    response.render('index');
});

app.listen(port, () =>{
    debug(`Listening on port ${chalk.green(port)}`);//Sends a message when when app starts
});