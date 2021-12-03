const { Client } = require('pg');

const client = new Client({
	connectionString: process.env.DATABASE_URL,
	ssl: {
		rejectUnauthorized: false
	}
});

client.connect();

async function query(sql, variable = null) {
	try {
		const client = await client.connect();
		let result = '';

		if (variable == null) {
			result = await client.query(sql);
		} else {
			result = await client.query(sql, variable);
		}

	    const data = result ? result.rows : null;

		client.release();

		return data;

	} catch (error) {
		console.error('ERROR: database', error);

		return {
			status: 500,
			body: {
				error: `ERROR: database: ${error}`
			}
		};
	}
}

//Queries
async function insertUser(){
	let data = await this.query('');
}