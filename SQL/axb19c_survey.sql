-- Survey Generator SQL Schema
-- Alex Burgos
-- IT325 Web App Development

--CREATES DATABASE
drop database if exists axb19c_survey;
CREATE DATABASE axb19c_survey encoding 'UTF-8';

--CREATES TABLES
drop table if exists author;
CREATE TABLE author (
    author_id int PRIMARY KEY NOT NULL,
    author_email varchar UNIQUE NOT NULL,
    fname varchar NOT NULL,
    lname varchar NOT NULL
);

drop table if exists admins;
CREATE TABLE admins (
    admins_id int PRIMARY KEY NOT NULL,
    admins_email varchar UNIQUE NOT NULL,
    fName varchar,
    lName varchar
);

drop table if exists users;
CREATE TABLE users (
    users_email text UNIQUE NOT NULL
);

drop table if exists surveys;
CREATE TABLE surveys (
    survey_id int PRIMARY KEY UNIQUE NOT NULL,
    title text NOT NULL,
    author_id int NOT NULL
);

drop table if exists questions;
CREATE TABLE questions (
    question_id int NOT NULL,
    survey_id int NOT NULL,
    question_type varchar,
    content text
);

drop table if exists answers;
CREATE TABLE answers (
    answer_id int PRIMARY KEY UNIQUE NOT NULL,
    question_id int NOT NULL,
    survey_id int NOT NULL,
    user_email varchar NOT NULL,
    question_type varchar NOT NULL,
    content text
);

--INSERT TEST ADMIN VALUES
insert into admins (admins_id, admins_email, fname, lname) VALUES
(42069, 'axb19c@acu.edu', 'Alex', 'B'),
(01337, 'genshinlover@gi.io', 'Lucas', 'Gigachad'),
(00001, 'erhevelyn@email.com', 'Evelyn', 'B'),
(00002, 'happy_kid@abc.org', 'Lucian', 'B');

--INSERT TEST AUTHOR VALUES
INSERT INTO author (author_id, author_email, fname, lname) VALUES
(42069, 'axb19c@acu.edu', 'Alex', 'B'),
(0001, 'erhevelyn@email.com', 'Evelyn', 'B'),
(01337, 'genshinlover@gi.io', 'Lucas', 'Gigachad');

--INSERTS 30 TEST USER VALUES
INSERT INTO users (users_email) VALUES
('johndoe1@acu.edu'),
('johndoe2@acu.edu'),
('johndoe3@acu.edu'),
('johndoe4@acu.edu'),
('johndoe5@acu.edu'),
('johndoe6@acu.edu'),
('johndoe7@acu.edu'),
('johndoe8@acu.edu'),
('johndoe9@acu.edu'),
('johndoe10@acu.edu'),
('johndoe11@acu.edu'),
('johndoe12@acu.edu'),
('johndoe13@acu.edu'),
('johndoe14@acu.edu'),
('johndoe15@acu.edu'),
('janedoe1@acu.edu'),
('janedoe2@acu.edu'),
('janedoe3@acu.edu'),
('janedoe4@acu.edu'),
('janedoe5@acu.edu'),
('janedoe6@acu.edu'),
('janedoe7@acu.edu'),
('janedoe8@acu.edu'),
('janedoe9@acu.edu'),
('janedoe10@acu.edu'),
('janedoe11@acu.edu'),
('janedoe12@acu.edu'),
('janedoe13@acu.edu'),
('janedoe14@acu.edu'),
('janedoe15@acu.edu');

--INSERTS SURVEY TEST VALUES
INSERT INTO surveys (survey_id, title, author_id) VALUES
(0001, 'Basic Introduction', 42069),
(0002, 'School Satistaction', 42069),
(0003, 'MCU Fan Sentiment', 42069),
(0004, 'Why is Tesla so meh', 42069),
(0005, 'Animal Shelter Survey', 0001),
(0006, 'Employee Safety Assesment', 0001),
(0007, 'Recruiting Priority Questionair', 0001),
(0008, 'Exit Interview', 0001),
(0009, 'USG Client Satistaction', 0001),
(0010, 'Travel Accomodation Feedback', 0001),
(0011, 'Streaming Service Wars', 01337),
(0012, 'Pre-Built Computers Community Sentiment', 01337),
(0013, 'Battle Royale Fatigue Study', 01337),
(0014, 'New World Initial Impressions', 01337),
(0015, 'MMO Design Research', 01337);

--INSERTS TEST QUESTION VALUES
-- Question types: T = Text, MC = Multiple Choice (1-4), TF = True/False, LK = Likert(1-5)
INSERT INTO questions (survey_id, question_id, question_type, content) VALUES
(0001, 01, 'T', 'What is your name?'),
(0001, 02, 'T', 'How old are you?'),
(0001, 03, 'TF', 'Are you attending ACU in the Spring semester?'),
(0001, 04, 'T', 'What is your major?'),
(0002, 01, 'LK', 'Classes you wanted this semester where available. (1 = Strongly Disagree 2 = Disagree 3 = Neutral 4 = Agree 5 = Strongly Agree)'),
(0002, 02, 'LK', 'Academic Advisors were diligent and helpful in accomodating your needs. (1 = Strongly Disagree 2 = Disagree 3 = Neutral 4 = Agree 5 = Strongly Agree)'),
(0002, 03, 'LK', 'Living Quarters are well maintained and serviced promptly. (1 = Strongly Disagree 2 = Disagree 3 = Neutral 4 = Agree 5 = Strongly Agree)'),
(0002, 04, 'LK', 'Dining Facility is clean, well stocked, and food is fresh. (1 = Strongly Disagree 2 = Disagree 3 = Neutral 4 = Agree 5 = Strongly Agree)'),
(0003, 01, 'T', 'Which MCU movie is your favorite?'),
(0003, 02, 'T', 'Favorite MCU Villian.'),
(0003, 03, 'TF', 'Thanos did nothing wrong.'),
(0003, 04, 'T', 'Most anticipated hero stand-alone movie?'),
(0004, 01, 'TF', 'Elon Musk makes the brand cool.'),
(0004, 02, 'TF', 'Other manufacturers should adopt the Tesla charging network'),
(0004, 03, 'TF', 'Electric vehicles will be the norm by 2030'),
(0004, 04, 'TF', 'Using AI to improve road safety is more important that self driving.'),
(0005, 01, 'TF', 'Are you a crazy cat lady?'),
(0005, 02, 'MC', 'Favory type of pet. 1 = Dogs 2 = Cats 3 = Fish 4 = Birds'),
(0005, 03, 'TF', 'Do you have a yard?'),
(0005, 04, 'TF', 'Will this be an emotional therapy animal?'),
(0005, 05, 'TF', 'Would you like you to contact you for more information?'),
(0006, 01, 'LK', 'You were issued serviceable safety equipment upon starting at the company. (1 = Strongly Disagree 2 = Disagree 3 = Neutral 4 = Agree 5 = Strongly Agree)'),
(0006, 02, 'LK', 'Your coworkers value and promote a culture of safety. (1 = Strongly Disagree 2 = Disagree 3 = Neutral 4 = Agree 5 = Strongly Agree)'),
(0006, 03, 'LK', 'Management values and promotes a culture of safety. (1 = Strongly Disagree 2 = Disagree 3 = Neutral 4 = Agree 5 = Strongly Agree)'),
(0006, 04, 'LK', 'Your safety concerns are taken seriously. (1 = Strongly Disagree 2 = Disagree 3 = Neutral 4 = Agree 5 = Strongly Agree)'),
(0006, 05, 'LK', 'You are scared of retaliation if you speak up about an unsafe work environment. (1 = Strongly Disagree 2 = Disagree 3 = Neutral 4 = Agree 5 = Strongly Agree)'),
(0006, 06, 'LK', 'I feel like it is easy to contribute to the improvement process of safe practices. (1 = Strongly Disagree 2 = Disagree 3 = Neutral 4 = Agree 5 = Strongly Agree)'),
(0007, 01, 'MC', 'Which department needs the most manning? 1 = Supply 2 = Admin 3 = Maintenance 4 = Support'),
(0007, 02, 'MC', 'What is the most important characteristic in a new hire? (1 = Trainable 2 = Creativity 3 = Self Starter 4 = Competitive'),
(0007, 03, 'MC', 'What is most important to you in a co-worker? 1 = Punctuality 2 = Integrity 3 = Ambition 4 = Dependability'),
(0007, 04, 'MC', 'What is the worst managing style? 1 = Laise-fair 2 = Hands-Off 3 = Hand-On 4 = Micromanager'),
(0008, 01, 'T', 'How was your overall experience in the company?'),
(0008, 02, 'T', 'What are your thoughts about company leadership?'),
(0008, 03, 'T', 'Was your immediate supervisor helpful and effective? Elaborate.'),
(0008, 04,'T', 'What could leadership do to improve the workplace experience?'),
(0009, 01, 'T', 'What is your go-to USG product?'),
(0009, 02, 'LK', 'How likely are you to recommend that product to someone? 1 = Not at all. 2 = As a last resort. 3 = Maybe. 4 = Yes, among other options. 5 = Absolutely, the best choice.'),
(0009, 03, 'T', 'What other products do you buy besides your favorite?'),
(0009, 04, 'T', 'What other products you wish USG would make?');

--INSERTS TEST ANSWER VALUES

--STATISTICS

--NOTES
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

Only authors and admins need to log in, not the users

*/