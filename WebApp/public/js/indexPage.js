//  returns bool if form is ready and valid for submission
function validateLoginForm()
{
    var username = document.getElementById("login-username").value;
    var password = document.getElementById("login-password").value;

    var validUser = validUsername(username);
    if(validUser != 0)
    {
        if(validUser == 1)
        {
            alert("Username too short (must be between 4 and 32 characters)");
        }
        else if(validUser == 2)
        {
            alert("Username too long (must be between 4 and 32 characters)");
        }
        else if(validUser == 3)
        {
            alert("Username contains invalid characters or whitespace at start/end");
        }
        return false;
    }
    else
    {
        var validPass = validPassword(password);
        if(validPass != 0)
        {
            if(validPass == 1)
            {
                alert("Password is too short (must be between 12 and 64 characters)");
            }
            else if(validPass == 2)
            {
                alert("Password is too long (must be between 12 and 64 characters)");
            }
            else if(validPass == 3)
            {
                alert("Password contains invalid characters");
            }
            return false;
        }
    }

    return true;
}

//  returns int code of whether or not a username is valid
//  0 = valid username
//  1 = invalid, too short
//  2 = invalid, too long
//  3 = invalid, invalid characters or space at start or end
function validUsername(username)
{
    if(username.length >= 4)
    {
        if(username.length <= 32)
        {
            var regex = /^[a-zA-Z1-9_-]{1}[a-zA-Z1-9 _-]*([^ ][a-zA-Z1-9_]){1}$/g;
            var result = regex.exec(username);
            if(result != null)
            {
                return 0;
            }
            else
            {
                // contains invalid characters or space at start or end
                return 3;
            }
        }
        else
        {
            // username too long
            return 2;
        }
    }
    else
    {
        // username too short
        return 1;
    }
}

//  returns int code of whether or not a password is valid
//  0 = valid username
//  1 = invalid, too short
//  2 = invalid, too long
//  3 = invalid, invalid characters
function validPassword(password)
{
    if(password.length >= 12)
    {
        if(password.length < 64)
        {
            var regex = /^[a-zA-Z\d !@#$%^&*()_+-=\[\]\;\'\,\.\/\{\}\:\"\<\>\?\|]*$/g;
            var result = regex.exec(password);
            if(result != null)
            {
                return 0;
            }
            else
            {
                // contains invalid characters or space at start or end
                return 3;
            }
        }
        else
        {
            // password too long
            return 2;
        }
    }
    else
    {
        // password too short
        return 1;
    }
}

function init()
{
    document.getElementsByClassName("login-form")[0].addEventListener("submit", function(event){
        var validForm = validateLoginForm();
        if(!validForm)
        {
            event.preventDefault();
        }
    });
}

window.onload = function()
{
    init();
}