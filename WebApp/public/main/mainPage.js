//Template for the Author object.
const Author ={
    fname: "",
    lname: "",
    email: "",
    id: 0,
    surveysCreated: 0
};

//Template for the Admin object.
const Admin ={
    fname: "",
    lname: "",
    email: "",
    id: 0,
    surveysCreated: 0,
    surveysApproved: 0
};

//Template for the User object.
const User ={
    email: "",
    surveyComplete: false
};

function SurveyInfo()
{
    var surveyInfo = {};
    surveyInfo.title = null;
    surveyInfo.author = null;
    surveyInfo.approvedBy = null;
    surveyInfo.dateCreated = null;
    surveyInfo.dateClosed = null;
    surveyInfo.sendTo = null;

    surveyInfo.fill = function()
    {
        surveyInfo.title = document.getElementById("survey-title-input").value;
        surveyInfo.author = document.getElementById("survey-author").value; // Should automatically be the logged in author.
        surveyInfo.approvedBy = "You"; //document.getElementById("survey-author").value; //Should automatically be the logged in admin
        surveyInfo.dateCreated = new Date().toDateString();
        try {
            var dateClosed = document.getElementById("survey-duedate").valueAsDate.toDateString();
            surveyInfo.dateClosed = dateClosed;
        } catch (error) {
            console.log("opted to not provide due date");
            surveyInfo.dateClosed = "";
        }
        surveyInfo.sendTo = document.getElementById("survey-sendTo").value;
    }

    return surveyInfo;
}

function Survey(tableId, surveyInfo)
{
    var survey  = {};

    survey.__surveyTableElement = document.getElementById(tableId);
    survey.__surveyCount = null;
    try {
        survey.__surveyCount = survey.__surveyTableElement.rows.length - 1;
    } catch (error) {
        alert("Failed to find table with id: " + id);
        console.error("Failed to find table with id: " + id);
        console.error(error);
        survey.__surveyCount = null;
    }

    survey.id = null;   // auto generates id just before returning Object
    survey.title = surveyInfo.title;
    survey.author = surveyInfo.author;
    survey.approvedBy = surveyInfo.approvedBy;
    survey.dateCreated = surveyInfo.dateCreated;
    survey.dateClosed = surveyInfo.dateClosed;
    survey.sendTo = surveyInfo.sendTo;

    survey.send = function()
    {
        alert("Survey sent");
    }

    survey.appendToTable = function()
    {
        var row = survey.__surveyTableElement.insertRow(-1);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        var cell7 = row.insertCell(6);

        cell1.innerHTML = "<a href=\"#\">" + survey.id + "</a>";
        cell2.innerHTML = survey.title;
        cell3.innerHTML = survey.author; // Should automatically be the logged in author.
        cell4.innerHTML = survey.approvedBy; //Should automatically be the logged in admin
        cell5.innerHTML = survey.dateCreated;
        cell6.innerHTML = survey.dateClosed;
        cell7.innerHTML = survey.sendTo;

        if(survey.sendTo != null && survey.sendTo != "")
        {
            var sendButton = document.createElement("button");
            sendButton.class = "sendButton";
            sendButton.id = survey.id + "-sendButton";
            sendButton.innerHTML = "Send";
            sendButton.onclick = function() {
                survey.send();
            }
            cell7.appendChild(sendButton);
        }
    }

    survey.generateSurveyId = function()
    {
        return 325 + survey.__surveyCount;
    }


    survey.id = survey.generateSurveyId();
    return survey;
}

function hideSurveyOverlay()
{
    var newSurveyOverlay = document.getElementsByClassName("new-survey-container")[0];
    newSurveyOverlay.style.display = "none";
    clearCreateSurveyOverlay();
}

function showCreateSurveyOverlay()
{
    var newSurveyOverlay = document.getElementsByClassName("new-survey-container")[0];
    newSurveyOverlay.style.display = "block";
    newSurveyOverlay.addEventListener("submit", function(event){
        hideSurveyOverlay();
        event.preventDefault();
    });
}

function clearCreateSurveyOverlay()
{
    document.getElementById("survey-title-input").value = null;
    document.getElementById("survey-author").value = null;
    document.getElementById("survey-duedate").valueAsDate = null;
    document.getElementById("survey-description").value = null;
    document.getElementById("survey-sendTo").value = null;
}

function submitNewSurvey()
{
    var newSurveyInfo = SurveyInfo();
    newSurveyInfo.fill();
    var newSurvey = Survey("survey-table", newSurveyInfo);
    newSurvey.appendToTable();
}