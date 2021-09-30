-- Survey Generator SQL
-- Alex Burgos
-- IT325

drop database if exists axb19c_survey;
CREATE DATABASE axb19c_survey encoding 'UTF-8';

drop table if exists author;
CREATE TABLE author (
    author_id int primary key,
    fName varchar,
    lName varchar
);

drop table if exists admins;
CREATE TABLE admins (
    admins_id int primary key,
    fName varchar,
    lName varchar
);

drop table if exists users;
CREATE TABLE users (
    user_id int primary key,
    user_email varchar
);

drop table if exists survey;
CREATE TABLE survey (
    survey_id int primary key,
    title text,
    author_id int,
    admins_id int
);

drop table if exists questions;
CREATE TABLE questions (
    question_id int primary key,
    content text,
    question_type char,
    survey_id int
);

drop table if exists survey_answers;
CREATE TABLE survey_answers (
    answer_id int primary key,
    survey_id int,
    user_id int,
    question_type char,
    content text
);

insert into admins (admins_id, fName, lName) values
(42069, 'Alex', 'B'),
(1337, 'Lucas', 'Gigachad');

insert into author (author_id, fName, lName) values
(42069, 'Alex', 'B'),
(1337, 'Lucas', 'Gigachad');

insert into survey (survey_id, title, author_id) values
(0001, 'Genshin Impact Waifu', 42069);

insert into questions (question_id, content) values
(0001, 'Which waifu is best waifu?');

insert into survey_answers (answer_id, survey_id, user_id, content) values
(0001, 0001, 1337, 'Raiden Shogun is best waifu. UwU');

select s.survey_id, s.title, q.question_id, q.content, a.answer_id, a.user_id, a.content
from survey s, questions q, survey_answers a;

-- Sample queries
/*
SELECT *
FROM survey
WHERE survey.author = me;


list of survey
list of users by survey
list of answers to questions, by survey, by date
list of questions, by user, by survey
list of question types

are there survey types?
has a user started, but not finished the survey?

*/