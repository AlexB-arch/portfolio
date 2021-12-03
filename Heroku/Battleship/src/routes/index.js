const express = require('express');
const router = express.Router();


module.exports = params => {
    router.get('/db', async (req, res) => {
        console.log('This is /db route');

        try {
          const client = await pool.connect();
          const result = await client.query('SELECT * FROM test_table');
          const results = { 'results': (result) ? result.rows : null};
          res.render('index', results);
          client.release();
        } catch (err) {
          console.error(err);
          res.send("Error " + err);
        }
      })

      return router;
}