// IT325 Spring 2020
// Brent Reeves
// socket.io example for 4 clients
//
$(function () {
  // function runFloristRun(e) {
  //   console.log("keydown " + e.code);
  //   socket.emit("key", { sender: myId, key: e.code });
  // }
  // var colors = function drawMe(x, y) {};
  // document.onkeydown = runFloristRun;
  var columnCount = 4;
  var columns = [];
  for (i = 0; i < columnCount; i++) {
    columns[i] = $("#c" + i);
  }
  var socket = io();
  var myId = "";

  $("form").submit(function (e) {
    e.preventDefault(); // prevents page reloading
    // socket.emit("chat", $("#m").val());
    if (!myId) myId = "";

    socket.emit("chat", { sender: myId, text: $("#m").val() });
    $("#m").val("");
    return false;
  });

  socket.on("connect", function (msg) {
    console.log("i'm connected...[" + msg + "]");
  });

  socket.on("welcome", function (msg) {
    console.log("welcome");
    console.log(msg);
    myId = msg.id;
    var moi = $("#hh" + myId);

    //
    // make my column header different
    //
    moi.css({
      "font-style": "italic",
      "font-weight": "bold",
      "text-decoration": "underline",
    });
  });

  socket.on("chat", function (msg) {
    var sender = "anybody";
    if (msg.from) {
      sender = msg.from;
    }
    var sentMsg = "secret invisible message";
    if (msg.text) {
      sentMsg = msg.text;
    }

    $("#l" + sender).prepend($("<li>").text(sentMsg));
  });
});
