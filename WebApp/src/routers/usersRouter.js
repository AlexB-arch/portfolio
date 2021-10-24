/*const { response } = require('express');
const express = require('express');
const debug = require('debug')('app:adminRouter');
const { MongoClient, ObjectId } = require("mongodb");
const users = require('../data/users.json'); //path that contains user data.

const usersRouter = express.Router();

// Connection URL
const url =
  "mongodb+srv://alexb:abo081890@cluster0.lsxl0.mongodb.net?retryWrites=true&w=majority";

// Create a new MongoClient
const client = new MongoClient(url);

async function run(req, res){
    
  try {
    // Connect the client to the server
    await client.connect();

    const db = client.db("survey_generator");//Name of the database.
    const id = req.params.id;

    // Establish and verify connection
    const user = await db.collection('users').findOne({_id: new ObjectId(id)});
    console.log("Connected successfully to server");
    } 

    finally {
    // Ensures that the client will close when you finish/error
    await client.close();
    }

    res.render('users', {user});
}
run().catch(console.dir);

usersRouter.route('/').get((req, res) => {
    res.render('main', {user});
});

module.exports = usersRouter;*/