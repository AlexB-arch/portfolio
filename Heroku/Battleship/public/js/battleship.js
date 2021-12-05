
var FPS = 60;
var gameState = GameState();
var canvasElem = document.getElementsByTagName("canvas")[0];
var canvas = canvasElem.getContext("2d");

var you = Player();
var opponent = Player();

var selectors = [];
var images = [];

function Board()
{
    var board = {};
    board.img;
    board.boatsAlive;
    board.uBoat;
    board.destroyer1;
    board.destroyer2;
    board.battleship;
    board.aircraftCarrier;

    //Might move to server later.
    board.isHit = function ()
    {
        alert("implement later");
        return false;
    }

    // does the move without checking if it's valid
    board.moveBoat = function(boatName, direction)
    {
        if(boatName == "uBoat")
        {
            let rows = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
            for(var i = 0; i < board.uBoat.length; i++)
            {
                let row = board.uBoat[i][0];
                let column = board.uBoat[i][1];
                if(board.uBoat[i].length >= 3)
                {
                    column = board.uBoat[i].substring(1, 3);
                }

                if(direction.toLowerCase() == "up")
                {
                    row = rows[rows.indexOf(board.uBoat[i][0]) - 1];
                }
                else if(direction.toLowerCase() == "down")
                {
                    row = rows[rows.indexOf(board.uBoat[i][0]) + 1];
                }
                else if(direction.toLowerCase() == "right")
                {
                    column = Number(board.uBoat[i][1]) + 1;
                }
                else if(direction.toLowerCase() == "left")
                {
                    if(board.uBoat[i].length >= 3)
                    {
                        column = Number(board.uBoat[i].substring(1)) - 1;
                    }
                    else
                    {
                        column = Number(board.uBoat[i][1]) - 1;
                    }
                }
                board.uBoat[i] = row.toUpperCase() + column.toString();
            }
        }
        else if(boatName == "destroyer1")
        {
            let rows = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
            for(var i = 0; i < board.destroyer1.length; i++)
            {
                let row = board.destroyer1[i][0];
                let column = board.destroyer1[i][1];
                if(board.destroyer1[i].length >= 3)
                {
                    column = board.destroyer1[i].substring(1, 3);
                }

                if(direction.toLowerCase() == "up")
                {
                    row = rows[rows.indexOf(board.destroyer1[i][0]) - 1];
                }
                else if(direction.toLowerCase() == "down")
                {
                    row = rows[rows.indexOf(board.destroyer1[i][0]) + 1];
                }
                else if(direction.toLowerCase() == "right")
                {
                    column = Number(board.destroyer1[i][1]) + 1;
                }
                else if(direction.toLowerCase() == "left")
                {
                    if(board.destroyer1[i].length >= 3)
                    {
                        column = Number(board.destroyer1[i].substring(1)) - 1;
                    }
                    else
                    {
                        column = Number(board.destroyer1[i][1]) - 1;
                    }
                }
                board.destroyer1[i] = row.toUpperCase() + column.toString();
            }
        }
        else if(boatName == "destroyer2")
        {
            let rows = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
            for(var i = 0; i < board.destroyer2.length; i++)
            {
                let row = board.destroyer2[i][0];
                let column = board.destroyer2[i][1];
                if(board.destroyer2[i].length >= 3)
                {
                    column = board.destroyer2[i].substring(1, 3);
                }

                if(direction.toLowerCase() == "up")
                {
                    row = rows[rows.indexOf(board.destroyer2[i][0]) - 1];
                }
                else if(direction.toLowerCase() == "down")
                {
                    row = rows[rows.indexOf(board.destroyer2[i][0]) + 1];
                }
                else if(direction.toLowerCase() == "right")
                {
                    column = Number(board.destroyer2[i][1]) + 1;
                }
                else if(direction.toLowerCase() == "left")
                {
                    if(board.destroyer2[i].length >= 3)
                    {
                        column = Number(board.destroyer2[i].substring(1)) - 1;
                    }
                    else
                    {
                        column = Number(board.destroyer2[i][1]) - 1;
                    }
                }
                board.destroyer2[i] = row.toUpperCase() + column.toString();
            }
        }
        else if(boatName == "battleship")
        {
            let rows = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
            for(var i = 0; i < board.battleship.length; i++)
            {
                let row = board.battleship[i][0];
                let column = board.battleship[i][1];
                if(board.battleship[i].length >= 3)
                {
                    column = board.battleship[i].substring(1, 3);
                }

                if(direction.toLowerCase() == "up")
                {
                    row = rows[rows.indexOf(board.battleship[i][0]) - 1];
                }
                else if(direction.toLowerCase() == "down")
                {
                    row = rows[rows.indexOf(board.battleship[i][0]) + 1];
                }
                else if(direction.toLowerCase() == "right")
                {
                    column = Number(board.battleship[i][1]) + 1;
                }
                else if(direction.toLowerCase() == "left")
                {
                    if(board.battleship[i].length >= 3)
                    {
                        column = Number(board.battleship[i].substring(1)) - 1;
                    }
                    else
                    {
                        column = Number(board.battleship[i][1]) - 1;
                    }
                }
                board.battleship[i] = row.toUpperCase() + column.toString();
            }
        }
        else if(boatName == "aircraftCarrier")
        {
            let rows = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
            for(var i = 0; i < board.aircraftCarrier.length; i++)
            {
                let row = board.aircraftCarrier[i][0];
                let column = board.aircraftCarrier[i][1];
                if(board.aircraftCarrier[i].length >= 3)
                {
                    column = board.aircraftCarrier[i].substring(1, 3);
                }

                if(direction.toLowerCase() == "up")
                {
                    row = rows[rows.indexOf(board.aircraftCarrier[i][0]) - 1];
                }
                else if(direction.toLowerCase() == "down")
                {
                    row = rows[rows.indexOf(board.aircraftCarrier[i][0]) + 1];
                }
                else if(direction.toLowerCase() == "right")
                {
                    column = Number(board.aircraftCarrier[i][1]) + 1;
                }
                else if(direction.toLowerCase() == "left")
                {
                    if(board.aircraftCarrier[i].length >= 3)
                    {
                        column = Number(board.aircraftCarrier[i].substring(1)) - 1;
                    }
                    else
                    {
                        column = Number(board.aircraftCarrier[i][1]) - 1;
                    }
                }
                board.aircraftCarrier[i] = row.toUpperCase() + column.toString();
            }
        }
    }

    board.render = function()
    {
        function renderGridLabels()
        {
            canvas.save();

            canvas.fillStyle = "#3333BB";
            canvas.font = "32px Arial";
            canvas.fillText("1", 310, 85);
            canvas.fillText("2", 360, 85);
            canvas.fillText("3", 408, 85);
            canvas.fillText("4", 458, 85);
            canvas.fillText("5", 507, 85);
            canvas.fillText("6", 557, 85);
            canvas.fillText("7", 607, 85);
            canvas.fillText("8", 656, 85);
            canvas.fillText("9", 706, 85);
            canvas.fillText("10", 745, 85);

            canvas.fillText("A", 260, 130);
            canvas.fillText("B", 260, 180);
            canvas.fillText("C", 260, 230);
            canvas.fillText("D", 260, 278);
            canvas.fillText("E", 260, 328);
            canvas.fillText("F", 260, 378);
            canvas.fillText("G", 260, 426);
            canvas.fillText("H", 260, 476);
            canvas.fillText("I", 265, 526);
            canvas.fillText("J", 260, 576);

            canvas.restore();
        }

        function renderBoats()
        {
            function fillSquare(cord)
            {
                // A1 == 297, 97
                let rows = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
                let x = 297 + (Number(cord[1]) - 1)  * 49;
                if(cord.length >= 3)
                {
                    x = 297 + (Number(cord.substring(1)) - 1)  * 49;
                }
                let y = 97 + rows.indexOf(cord[0]) * 49;

                canvas.fillStyle = "#0000FF";
                canvas.save();
                canvas.fillRect(x, y, 49, 49);
                canvas.restore();
            }

            //U-Boat
            for(var i = 0; i < board.uBoat.length; i++)
            {
                fillSquare(board.uBoat[i]);
            }

            //Destoyer1
            for(var i = 0; i < board.destroyer1.length; i++)
            {
                fillSquare(board.destroyer1[i]);
            }

            //Destoyer2
            for(var i = 0; i < board.destroyer2.length; i++)
            {
                fillSquare(board.destroyer2[i]);
            }

            //Battleship
            for(var i = 0; i < board.battleship.length; i++)
            {
                fillSquare(board.battleship[i]);
            }

            //Aircraft-Carrier
            for(var i = 0; i < board.aircraftCarrier.length; i++)
            {
                fillSquare(board.aircraftCarrier[i]);
            }
        }

        renderBoats();
        board.img.render();
        renderGridLabels();
    }

    function init()
    {
        board.boatsAlive;
        board.img = Image("grid");
        board.uBoat = ["B2", "C2"];
        board.destroyer1 = ["E4", "F4", "G4"];
        board.destroyer2 = ["A8", "B8", "C8"];
        board.battleship = ["F6", "G6", "H6", "I6"];
        board.aircraftCarrier = ["D9", "E9", "F9", "G9", "H9"];
    }

    init();

    return board;
}

function Player()
{
    var player = {};
    player.board;
    player.yourTurn;

    player.render = function()
    {
        player.board.render();
    }

    function init()
    {
        player.board = Board();
        player.yourTurn = false;
    }

    init();

    return player;
}

function GameState()
{
    var gs = {};

    gs.scene;
    gs.state;

    gs.init = function()
    {
        gs.scene = "MainMenu";
        gs.state = "Menu";
    }

    gs.init();

    return gs;
}

function Image(name)
{
    var img = {};

    img.x;
    img.y;
    img.width;
    img.height;
    img.src;

    img.render = function()
    {
        canvas.save();
        canvas.translate(img.x - img.width / 2, img.y - img.height / 2);
        canvas.drawImage(img.src, 0, 0, img.width, img.height);
        canvas.restore();
    }

    img.init = function()
    {
        if(name == "grid")
        {
            img.src = document.getElementById("grid");
            img.x = 540;
            img.y = 340;
            img.width = 500;
            img.height = 500;
        }
        else if(name == "u-boat")
        {
            img.src = document.getElementById("u-boat");
            img.x = 70;
            img.y = 150;
            img.width = 91;
            img.height = 57;
        }
        else if(name == "destroyer1")
        {
            img.src = document.getElementById("destroyer1");
            img.x = 95;
            img.y = 230;
            img.width = 147;
            img.height = 57;
        }
        else if(name == "destroyer2")
        {
            img.src = document.getElementById("destroyer2");
            img.x = 95;
            img.y = 310;
            img.width = 147;
            img.height = 57;
        }
        else if(name == "battleship")
        {
            img.src = document.getElementById("battleship");
            img.x = 110;
            img.y = 390;
            img.width = 125;
            img.height = 57;
        }
        else if(name == "aircraft-carrier")
        {
            img.src = document.getElementById("aircraft-carrier");
            img.x = 125;
            img.y = 470;
            img.width = 216;
            img.height = 57;
        }
        else
        {
            console.error("Error: unknown image name: " + name);
        }
    };

    img.init();

    return img;
}

function Selector(type)
{
    var selector = {};
    selector.type = type;
    selector.width;
    selector.height;
    selector.x;
    selector.y;
    selector.img;
    selector.movingRight;
    selector.movingLeft;
    selector.speed;
    selector.movedDistance;
    selector.allowedDistance;
    selector.position;
    selector.optionCount;
    selector.selected;
    selector.rotated;

    selector.moveSelectorUp = function()
    {
        if(selector.position > 0 && selector.type != "ShipPlacer")
        {
            if(selector.type == "MainMenu")
            {
                selector.y -= 100;
            }
            else if(selector.type == "ShipSelect")
            {
                selector.y -= 80;
            }
            selector.position--;
        }
        else if(selector.type == "ShipPlacer")
        {
            if(selector.position == 0)
            {
                let canMove = true;
                for(var i = 0; i < you.board.uBoat.length; i++)
                {
                    if(you.board.uBoat[i][0] <= "A")
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("uBoat", "up");
                }
            }
            else if(selector.position == 1)
            {
                let canMove = true;
                for(var i = 0; i < you.board.destroyer1.length; i++)
                {
                    if(you.board.destroyer1[i][0] <= "A")
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("destroyer1", "up");
                }
            }
            else if(selector.position == 2)
            {
                let canMove = true;
                for(var i = 0; i < you.board.destroyer2.length; i++)
                {
                    if(you.board.destroyer2[i][0] <= "A")
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("destroyer2", "up");
                }
            }
            else if(selector.position == 3)
            {
                let canMove = true;
                for(var i = 0; i < you.board.battleship.length; i++)
                {
                    if(you.board.battleship[i][0] <= "A")
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("battleship", "up");
                }
            }
            else if(selector.position == 4)
            {
                let canMove = true;
                for(var i = 0; i < you.board.aircraftCarrier.length; i++)
                {
                    if(you.board.aircraftCarrier[i][0] <= "A")
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("aircraftCarrier", "up");
                }
            }
        }
    }

    selector.moveSelectorDown = function()
    {
        if(selector.position < selector.optionCount && selector.type != "ShipPlacer")
        {
            if(selector.type == "MainMenu")
            {
                selector.y += 100;
            }
            else if(selector.type == "ShipSelect")
            {
                selector.y += 80;
            }
            selector.position++;
        }
        else if(selector.type == "ShipPlacer")
        {
            if(selector.position == 0)
            {
                let canMove = true;
                for(var i = 0; i < you.board.uBoat.length; i++)
                {
                    if(you.board.uBoat[i][0] == "J")
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("uBoat", "down");
                }
            }
            else if(selector.position == 1)
            {
                let canMove = true;
                for(var i = 0; i < you.board.destroyer1.length; i++)
                {
                    if(you.board.destroyer1[i][0] == "J")
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("destroyer1", "down");
                }
            }
            else if(selector.position == 2)
            {
                let canMove = true;
                for(var i = 0; i < you.board.destroyer2.length; i++)
                {
                    if(you.board.destroyer2[i][0] == "J")
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("destroyer2", "down");
                }
            }
            else if(selector.position == 3)
            {
                let canMove = true;
                for(var i = 0; i < you.board.battleship.length; i++)
                {
                    if(you.board.battleship[i][0] == "J")
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("battleship", "down");
                }
            }
            else if(selector.position == 4)
            {
                let canMove = true;
                for(var i = 0; i < you.board.aircraftCarrier.length; i++)
                {
                    if(you.board.aircraftCarrier[i][0] == "J")
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("aircraftCarrier", "down");
                }
            }
        }
    }

    selector.moveSelectorLeft = function()
    {
        if(selector.type == "ShipPlacer")
        {
            if(selector.position == 0)
            {
                let canMove = true;
                for(var i = 0; i < you.board.uBoat.length; i++)
                {
                    if(you.board.uBoat[i][1] == "1" && (you.board.uBoat[i].length == 2 || you.board.uBoat[i][2] != "0"))
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("uBoat", "left");
                }
            }
            else if(selector.position == 1)
            {
                let canMove = true;
                for(var i = 0; i < you.board.destroyer1.length; i++)
                {
                    if(you.board.destroyer1[i][1] == "1" && (you.board.destroyer1[i].length == 2 || you.board.destroyer1[i][2] != "0"))
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("destroyer1", "left");
                }
            }
            else if(selector.position == 2)
            {
                let canMove = true;
                for(var i = 0; i < you.board.destroyer2.length; i++)
                {
                    if(you.board.destroyer2[i][1] == "1" && (you.board.destroyer2[i].length == 2 || you.board.destroyer2[i][2] != "0"))
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("destroyer2", "left");
                }
            }
            else if(selector.position == 3)
            {
                let canMove = true;
                for(var i = 0; i < you.board.battleship.length; i++)
                {
                    if(you.board.battleship[i][1] == "1" && (you.board.battleship[i].length == 2 || you.board.battleship[i][2] != "0"))
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("battleship", "left");
                }
            }
            else if(selector.position == 4)
            {
                let canMove = true;
                for(var i = 0; i < you.board.aircraftCarrier.length; i++)
                {
                    if(you.board.aircraftCarrier[i][1] == "1" && (you.board.aircraftCarrier[i].length == 2 || you.board.aircraftCarrier[i][2] != "0"))
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("aircraftCarrier", "left");
                }
            }
        }
    }

    selector.moveSelectorRight = function()
    {
        if(selector.type == "ShipPlacer")
        {
            if(selector.position == 0)
            {
                let canMove = true;
                for(var i = 0; i < you.board.uBoat.length; i++)
                {
                    if(you.board.uBoat[i][1] == "1" && you.board.uBoat[i].length >= 3 && you.board.uBoat[i][2] == "0")
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("uBoat", "right");
                }
            }
            else if(selector.position == 1)
            {
                let canMove = true;
                for(var i = 0; i < you.board.destroyer1.length; i++)
                {
                    if(you.board.destroyer1[i][1] == "1" && you.board.destroyer1[i].length >= 3 && you.board.destroyer1[i][2] == "0")
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("destroyer1", "right");
                }
            }
            else if(selector.position == 2)
            {
                let canMove = true;
                for(var i = 0; i < you.board.destroyer2.length; i++)
                {
                    if(you.board.destroyer2[i][1] == "1" && you.board.destroyer2[i].length >= 3 && you.board.destroyer2[i][2] == "0")
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("destroyer2", "right");
                }
            }
            else if(selector.position == 3)
            {
                let canMove = true;
                for(var i = 0; i < you.board.battleship.length; i++)
                {
                    if(you.board.battleship[i][1] == "1" && you.board.battleship[i].length >= 3 && you.board.battleship[i][2] == "0")
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("battleship", "right");
                }
            }
            else if(selector.position == 4)
            {
                let canMove = true;
                for(var i = 0; i < you.board.aircraftCarrier.length; i++)
                {
                    if(you.board.aircraftCarrier[i][1] == "1" && you.board.aircraftCarrier[i].length >= 3 && you.board.aircraftCarrier[i][2] == "0")
                    {
                        canMove = false;
                        break;
                    }
                }
                if(canMove)
                {
                    you.board.moveBoat("aircraftCarrier", "right");
                }
            }
        }
    }

    selector.attemptRotate = function()
    {
        if(selector.type == "ShipPlacer")
        {
            let rows = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
            if(selector.position == 0)
            {
                // horizontal to vertical
                if(you.board.uBoat[0][0] == you.board.uBoat[1][0])
                {
                    if(you.board.uBoat[1][0] <= "I")
                    {
                        let newValue = rows[rows.indexOf(you.board.uBoat[1][0]) + 1].toString();
                        if(you.board.uBoat[1].length >= 3 && you.board.uBoat[1].substring(1, 3) == "10")
                        {
                            newValue += "9" + you.board.uBoat[1].substring(3);
                        }
                        else
                        {
                            newValue += (Number(you.board.uBoat[1][1]) - 1).toString() + you.board.uBoat[1].substring(2);
                        }
                        you.board.uBoat[1] = newValue;
                    }
                }
                // vertical to horizontal
                else
                {
                    if(you.board.uBoat[1].length == 2 || (you.board.uBoat[1].length >= 3 && you.board.uBoat[1].substring(1, 3) != "10"))
                    {
                        let newValue = rows[rows.indexOf(you.board.uBoat[1][0]) - 1].toString() + (Number(you.board.uBoat[1][1]) + 1).toString();
                        you.board.uBoat[1] = newValue + you.board.uBoat[1].substring(2);
                    }
                }
            }
            else if(selector.position == 1)
            {
                // horizontal to vertical
                if(you.board.destroyer1[0][0] == you.board.destroyer1[1][0])
                {
                    if(you.board.destroyer1[2][0] <= "I")
                    {
                        let newValue = rows[rows.indexOf(you.board.destroyer1[1][0]) + 1].toString();
                        if(you.board.destroyer1[1].length >= 3 && you.board.destroyer1[1].substring(1, 3) == "10")
                        {
                            newValue += "9" + you.board.destroyer1[1].substring(3);
                        }
                        else
                        {
                            newValue += (Number(you.board.destroyer1[1][1]) - 1).toString() + you.board.destroyer1[1].substring(2);
                        }
                        you.board.destroyer1[1] = newValue;
                    }
                }
                // vertical to horizontal
                else
                {
                    if(you.board.destroyer1[1].length == 2 || (you.board.destroyer1[1].length >= 3 && you.board.destroyer1[1].substring(1, 3) != "10"))
                    {
                        let newValue = rows[rows.indexOf(you.board.destroyer1[1][0]) - 1].toString() + (Number(you.board.destroyer1[1][1]) + 1).toString();
                        you.board.destroyer1[1] = newValue + you.board.destroyer1[1].substring(2);
                    }
                }
            }
        }
    }

    selector.selectAction = function()
    {

        if(gameState.scene == "MainMenu")
        {
            if(selector.position == 0)
            {
                loadScene("Battleship");
            }
            else if(selector.position == 1)
            {
                loadScene("Credits");
            }
        }
        else if(gameState.scene == "Battleship")
        {
            if(gameState.state == "ShipPlacement")
            {
                if(selector.type == "ShipSelect")
                {
                    selector.selected = !selector.selected;
                }
                else if(selector.type == "ShipPlacer")
                {
                    selectors[0].selected = !selectors[0].selected;
                }
            }
        }
    }

    selector.update = function()
    {
        if(selector.movingLeft)
        {
            if(selector.movedDistance + selector.speed > selector.allowedDistance)
            {
                selector.x -= selector.allowedDistance - selector.movedDistance;
                selector.movingLeft = false;
                selector.movingRight = true;
                selector.movedDistance = 0;
            }
            else
            {
                selector.x -= selector.speed;
                selector.movedDistance += selector.speed;
                if(selector.movedDistance == selector.allowedDistance)
                {
                    selector.movingLeft = false;
                    selector.movingRight = true;
                    selector.movedDistance = 0;
                }
            }
        }

        if(selector.movingRight)
        {
            if(selector.movedDistance + selector.speed > selector.allowedDistance)
            {
                selector.x += selector.allowedDistance - selector.movedDistance;
                selector.movingLeft = true;
                selector.movingRight = false;
                selector.movedDistance = 0;
            }
            else
            {
                selector.x += selector.speed;
                selector.movedDistance += selector.speed;
                if(selector.movedDistance == selector.allowedDistance)
                {
                    selector.movingLeft = true;
                    selector.movingRight = false;
                    selector.movedDistance = 0;
                }
            }
        }

        if(gameState.scene == "Battleship" && gameState.state == "ShipPlacement")
        {
            if(selector.type == "ShipSelect")
            {
                if(selector.position == 0)
                {
                    selector.x = 70;
                    selector.width = 100;
                    selector.height = 75;
                }
                else if(selector.position == 1)
                {
                    selector.x = 95;
                    selector.width = 160;
                    selector.height = 75;
                }
                else if(selector.position == 2)
                {
                    selector.x = 95;
                    selector.width = 160;
                    selector.height = 75;
                }
                else if(selector.position == 3)
                {
                    selector.x = 110;
                    selector.width = 190;
                    selector.height = 75;
                }
                else if(selector.position == 4)
                {
                    selector.x = 125;
                    selector.width = 225;
                    selector.height = 75;
                }
            }

            if(selector.type == "ShipPlacer")
            {
                if(selector.position == 0)
                {
                    //console.log(selector.width);
                    // A1 == 297, 97
                    let rows = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
                    if(you.board.uBoat[0].substring(1, 3) == "10")
                    {
                        selector.x = 297 + 9 * 49;
                    }
                    else
                    {
                        selector.x = 297 + (Number(you.board.uBoat[0][1]) - 1)  * 49;
                    }
                    selector.y = 97 + rows.indexOf(you.board.uBoat[0][0]) * 49;

                    // boat horizontal
                    if(you.board.uBoat[0][0] == you.board.uBoat[1][0])
                    {
                        selector.width  = 49 * 2;
                        selector.height = 49;
                    }
                    // boat vertical
                    else
                    {
                        selector.width  = 49;
                        selector.height = 49 * 2;
                    }
                }
                else if(selector.position == 1)
                {
                    // A1 == 297, 97
                    let rows = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
                    if(you.board.destroyer1[0].length >= 3)
                    {
                        selector.x = 297 + (Number(you.board.destroyer1[0].substring(1, 3)) - 1)  * 49;
                    }
                    else
                    {
                        selector.x = 297 + (Number(you.board.destroyer1[0][1]) - 1)  * 49;
                    }
                    selector.y = 97 + rows.indexOf(you.board.destroyer1[0][0]) * 49;

                    // boat horizontal
                    if(you.board.destroyer1[0][0] == you.board.destroyer1[1][0])
                    {
                        selector.width  = 49 * 3;
                        selector.height = 49;
                    }
                    // boat vertical
                    else
                    {
                        selector.width  = 49;
                        selector.height = 49 * 3;
                    }
                }
                else if(selector.position == 2)
                {
                    // A1 == 297, 97
                    let rows = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
                    if(you.board.destroyer2[0].length >= 3)
                    {
                        selector.x = 297 + (Number(you.board.destroyer2[0].substring(1, 3)) - 1)  * 49;
                    }
                    else
                    {
                        selector.x = 297 + (Number(you.board.destroyer2[0][1]) - 1)  * 49;
                    }
                    selector.y = 97 + rows.indexOf(you.board.destroyer2[0][0]) * 49;

                    // boat horizontal
                    if(you.board.destroyer2[0][0] == you.board.destroyer2[1][0])
                    {
                        selector.width  = 49 * 3;
                        selector.height = 49;
                    }
                    // boat vertical
                    else
                    {
                        selector.width  = 49;
                        selector.height = 49 * 3;
                    }
                }
                else if(selector.position == 3)
                {
                    // A1 == 297, 97
                    let rows = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
                    if(you.board.battleship[0].length >= 3)
                    {
                        selector.x = 297 + (Number(you.board.battleship[0].substring(1, 3)) - 1)  * 49;
                    }
                    else
                    {
                        selector.x = 297 + (Number(you.board.battleship[0][1]) - 1)  * 49;
                    }
                    selector.y = 97 + rows.indexOf(you.board.battleship[0][0]) * 49;

                    // boat horizontal
                    if(you.board.battleship[0][0] == you.board.battleship[1][0])
                    {
                        selector.width  = 49 * 4;
                        selector.height = 49;
                    }
                    // boat vertical
                    else
                    {
                        selector.width  = 49;
                        selector.height = 49 * 4;
                    }
                }
                else if(selector.position == 4)
                {
                    // A1 == 297, 97
                    let rows = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];
                    if(you.board.aircraftCarrier[0].length >= 3)
                    {
                        selector.x = 297 + (Number(you.board.aircraftCarrier[0].substring(1, 3)) - 1)  * 49;
                    }
                    else
                    {
                        selector.x = 297 + (Number(you.board.aircraftCarrier[0][1]) - 1)  * 49;
                    }
                    selector.y = 97 + rows.indexOf(you.board.aircraftCarrier[0][0]) * 49;

                    // boat horizontal
                    if(you.board.aircraftCarrier[0][0] == you.board.aircraftCarrier[1][0])
                    {
                        selector.width  = 49 * 5;
                        selector.height = 49;
                    }
                    // boat vertical
                    else
                    {
                        selector.width  = 49;
                        selector.height = 49 * 5;
                    }
                }

                // fix border offset
                selector.x -= 3;
                selector.y -= 3;
            }

            selectors[1].position = selectors[0].position;
        }

        if(selector.img != "rect" && selector.img != "centeredRect")
        {
            selector.img.x = selector.x;
            selector.img.y = selector.y;
        }
    }

    selector.render = function()
    {
        if(selector.img != "rect" && selector.img != "centeredRect")
        {
            selector.img.render();
        }
        else if(selector.img == "centeredRect")
        {
            canvas.save();

            canvas.translate(selector.x - selector.width / 2, selector.y - selector.height / 2);

            canvas.beginPath();

            canvas.lineWidth = "3";
            if(selector.selected)
            {
                canvas.strokeStyle = "#AA0000";
            }
            else
            {
                canvas.strokeStyle = "#00AA00";
            }
            canvas.rect(0, 0, selector.width, selector.height);

            canvas.stroke();

            canvas.restore();
        }
        else if(selector.img == "rect")
        {
            canvas.save();

            canvas.beginPath();

            canvas.lineWidth = "20";
            if(selector.selected)
            {
                canvas.strokeStyle = "#AA0000";
            }
            else
            {
                canvas.strokeStyle = "#00AA00";
            }
            canvas.rect(selector.x, selector.y, selector.width, selector.height);

            canvas.stroke();

            canvas.restore();
        }
    }

    selector.init = function()
    {
        if(type == "MainMenu")
        {
            selector.img = Image("battleship");
            selector.x = 125;
            selector.y = 320;
            selector.width = 125;
            selector.height = 57;
            selector.movingLeft = true;
            selector.movingRight = false;
            selector.speed = 3/10;
            selector.movedDistance = 0;
            selector.allowedDistance = 30;
            selector.position = 0;
            selector.optionCount = 1;
        }
        else if(type == "ShipSelect")
        {
            selector.img = "centeredRect";
            selector.x = 70;
            selector.y = 150;
            selector.width = 100;
            selector.height = 75;
            selector.position = 0;
            selector.optionCount = 4;
            selector.selected = false;
        }
        else if (type == "ShipPlacer")
        {
            selector.img = "rect";
            selector.position = 0;
            selector.selected = true;
        }
        else
        {
            console.error("Error: invalid selector type: " + type);
        }
    }

    selector.init();

    return selector;
}

function updateGame()
{
    function updateSelectors()
    {
        for(var i = 0; i < selectors.length; i++)
        {
            selectors[i].update();
        }
    }

    if(gameState.scene == "MainMenu")
    {
        updateSelectors();
    }
    else if(gameState.scene == "Battleship")
    {
        if(gameState.state == "ShipPlacement")
        {
            updateSelectors();
        }
    }
}

function renderGame()
{
    // erase everything for next frame
    canvas.clearRect(0, 0, 800, 600);

    function renderMainMenuBackground()
    {
        canvas.save();

        canvas.fillStyle = "purple";
        canvas.fillRect(0, 0, 800, 600);

        canvas.fillStyle = "gold";
        canvas.font = "98px Arial";
        canvas.fillText("Battleship 325", 90, 125);

        canvas.fillStyle = "white";
        canvas.font = "64px Arial";
        canvas.fillText("Play", 200, 350);
        canvas.fillText("Credits", 200, 450);

        canvas.restore();
    }

    function renderSelectors()
    {
        for(var i = 0; i < selectors.length; i++)
        {
            selectors[i].render();
        }
    }

    function renderImages()
    {
        for(var i = 0; i < images.length; i++)
        {
            images[i].render();
        }
    }

    if(gameState.scene == "MainMenu")
    {
        renderMainMenuBackground();
        renderSelectors();
    }
    else if(gameState.scene == "Battleship")
    {
        if(gameState.state == "ShipPlacement")
        {
            canvas.save();

            canvas.fillStyle = "#DDDDDD";
            canvas.fillRect(0, 0, 800, 600);
            canvas.fillStyle = "#EE4444";
            canvas.font = "42px Arial";
            canvas.fillText("Place your ships", 200, 45);

            canvas.restore();

            renderSelectors();
            renderImages();
            you.render();
        }
    }
}

/*
    w - 119
    a - 97
    s - 115
    d - 100
*/
function handleInputs(event)
{
    //console.log(event.keyCode);
    if(gameState.scene == "MainMenu")
    {
        if(event.keyCode == 119 || event.which == 119)
        {
            selectors[0].moveSelectorUp();
        }
        else if(event.keyCode == 115 || event.which == 115)
        {
            selectors[0].moveSelectorDown();
        }
        else if (event.keyCode == 13 || event.which == 13 || event.keyCode == 32 || event.which == 32)
        {
            selectors[0].selectAction();
        }
    }
    else if(gameState.scene == "Battleship" && gameState.state == "ShipPlacement")
    {
        let whichSelector = 0;
        if(selectors[0].selected)
        {
            whichSelector = 1;
        }

        if(event.keyCode == 119 || event.which == 119)
        {
            selectors[whichSelector].moveSelectorUp();
        }
        else if(event.keyCode == 97 || event.which == 97)
        {
            selectors[whichSelector].moveSelectorLeft();
        }
        else if(event.keyCode == 115 || event.which == 115)
        {
            selectors[whichSelector].moveSelectorDown();
        }
        else if(event.keyCode == 100 || event.which == 100)
        {
            selectors[whichSelector].moveSelectorRight();
        }
        else if(event.keyCode == 114 || event.which == 114)
        {
            selectors[whichSelector].attemptRotate();
        }
        else if (event.keyCode == 13 || event.which == 13 || event.keyCode == 32 || event.which == 32)
        {
            selectors[whichSelector].selectAction();
        }
    }
}

function run()
{
    updateGame();
    renderGame();
    setTimeout(run, FPS / 1000);
}

function loadScene(sceneName)
{
    selectors = [];
    images = [];
    if(sceneName == "MainMenu")
    {
        selectors.push(Selector("MainMenu"));
    }
    else if(sceneName == "Battleship")
    {
        gameState.scene = "Battleship"
        gameState.state = "ShipPlacement";

        images.push(Image("u-boat"));
        images.push(Image("destroyer1"));
        images.push(Image("destroyer2"));
        var battleshipImg = Image("battleship");
        battleshipImg.width = 175;
        images.push(battleshipImg);
        images.push(Image("aircraft-carrier"));

        selectors.push(Selector("ShipSelect"));
        selectors.push(Selector("ShipPlacer"));
    }
    else if(sceneName == "Credits")
    {
        alert("These are the credits");
    }
}

window.onload = function()
{
    loadScene("MainMenu");
    run();
}

/*----------------------------------------------------
CLIENT SOCKET.IO IMPLEMENTATION
-----------------------------------------------------*/
const socket = io();

