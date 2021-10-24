const Pool = require('pg').Pool;
const pool = new Pool({
    user: 'postgres',
    host: 'localhost',
    database: 'survey_api',
    password: '4c7a7cb40e37425e9b7039e9615dfeba',
    port: 5432,
});

const getUsers = (request, response) => {
    pool.query('SELECT * FROM users ORDER BY id ASC'), (error, results) => {
        if(error) {
            throw error;
        };

        response.status(200).json(results.rows);
    };
};

const getUserById = (request, response) => {
    const id = parseInt(request.params.id);

    pool.query('SELECT * FROM users WHERE id = $1', [id], (error, results) => {
        if(error) {
            throw error;
        };

        response.status(200).json(results.rows);
    });
};

const createUser = (request, response) => {
    const id = parseInt(request.params.id);
    const { email } = request.body;

    pool.query('INSERT INTO users (email) VALUES ($1)', [email], (error, results) => {
        if(error) {
            throw error;
        };

        response.status(201).send(`User added with email: ${email}`);
    });
};

const updateUser = (request, response) => {
    const id = parseInt(request.params.id);
    const { email } = request.body;
  
    pool.query('UPDATE users SET email = $1 WHERE id = $2', [email, id], (error, results) => {
        if (error) {
          throw error;
        };

        response.status(200).send(`User modified with ID: ${id}`);
      });
};

const deleteUser = (request, response) => {
    const email = request.body;
  
    pool.query('DELETE FROM users WHERE email = $1', [email], (error, results) => {
      if (error) {
        throw error;
      };

      response.status(200).send(`User deleted with email: ${email}`)
    });
};

module.exports = {
    getUsers,
    getUserById,
    createUser,
    updateUser,
    deleteUser,
};
