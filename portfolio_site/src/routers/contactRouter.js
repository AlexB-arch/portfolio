const express = require('express');

const contactRouter = express.Router();

contactRouter.route('/').get((request, response) => {
    response.render('contact');
});

module.exports = contactRouter;