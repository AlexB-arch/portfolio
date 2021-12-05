const { response } = require('express');
const express = require('express');
const router = express.Router();


module.exports = params => {

    router.get('/', async (request, response) =>{
        response.send('index');
    })

    router.get('/db', async (request, response) => {
        try {
            const client = await pool.connect();

            client.release();

        } catch (err) {
            console.error(err);
            response.send("Error " + err);
        }
    })

    return router;
}