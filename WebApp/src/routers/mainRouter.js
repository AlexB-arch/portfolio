const express = require('express');
const users = require('../data/users.json'); //path that contains user data.

const mainRouter = express.Router();

mainRouter.route('/').get((request, response) => {
    response.render('main', {users: [
        {name: 'AlexB'}
    ]});
});

module.exports = mainRouter;