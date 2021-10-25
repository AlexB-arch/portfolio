const menu = document.getElementById("dropdown");

function show_hide(){
    if(menu.style.display == "none"){
        menu.style.display = "block";
    }
    else{
        menu.style.display = "none";
    }
}

menu.addEventListener("onclick", function show_hide(){

        if(menu.style.display == "none"){
            menu.style.display = "block";
        }
        else{
            menu.style.display = "none";
        }
    });
