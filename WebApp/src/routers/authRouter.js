const { response, request } = require('express');
const express = require('express');
const debug = require('debug')('app:authRouter');

const authRouter = express.Router();

authRouter.route('/signup').post((require, response) => {
    response.json(request.body);
});

module.exports = authRouter;