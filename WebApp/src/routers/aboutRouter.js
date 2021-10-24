const express = require('express');
//const users = require('../data/users.json'); //path that contains user data.

const aboutRouter = express.Router();

aboutRouter.route('/').get((request, response) => {
    response.render('about', {users: [
        {name: 'AlexB'}
    ]});
});

module.exports = aboutRouter;