const express = require('express');
const debug = require('debug')('app:adminRouter');
const users = require('../data/users.json'); //path that contains user data.

const adminRouter = express.Router();

module.exports = adminRouter;