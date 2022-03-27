const express = require('express');//the base for your web app. (npm install express)
const chalk = require('chalk');//adds color to console messages. (npm install chalk)
const debug = require('debug')('app');//middleware that helps with debugging. (npm install debug)
const morgan = require('morgan');//middleware that helps to output what's happening with your app. (npm install morgan)
const db = require('./queries');

const PORT = process.env.PORT || 3000;

const app = express();

/* ROUTERS */
const mainRouter = require('./src/routers/mainRouter');
const adminRouter = require('./src/routers/adminRouter');
const aboutRouter = require('./src/routers/aboutRouter');
const authRouter = require('./src/routers/authRouter');

/* MIDDLEWARE */
app.use(morgan('tiny'));//Gives you less information from the connection.
app.use(express.json());//Parses json file contents
app.use(express.urlencoded({extended:true}));//Parses encoded URLs.

app.use('/main', mainRouter);
app.use('/admin', adminRouter);
app.use('/about', aboutRouter);
app.use('/auth', authRouter);

/* APP.SET ALLOWS YOU TO SET VARIABLES FOR THE APP */
app.set('views', './src/views');//sets the path for your views.
app.set('view engine', 'ejs');//sets your template engine that renders html.

/* APP.GET SENDS RESPONSES FOR "GET REQUESTS" */
app.get('/', (request, response) => {
    response.render('index', {title: 'Welcome to Basic Survey Generator'});//displays dynamic html pages.
});

/* DATABASE QUERIES */
app.get('/users', db.getUsers);
app.get('/users/:id', db.getUserById);
app.post('/users', db.createUser);
app.put('/users/:id', db.updateUser);
app.delete('/users/:id', db.deleteUser);

app.listen(PORT, () =>{
    debug(`Listening on port ${chalk.green(PORT)}`);//Sends a message when app starts
});