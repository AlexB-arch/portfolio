const express = require('express');

const resumeRouter = express.Router();

resumeRouter.route('/').get((request, response) => {
    response.render('resume');
});

module.exports = resumeRouter;