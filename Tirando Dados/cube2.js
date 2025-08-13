let canvas = document.getElementById("myCanvas");
let ctx = canvas.getContext("2d");
ctx.fillStyle = "green";

x = 50;
while (x <= 450) {

    ctx.fillRect(x, 200, 50, 50); // x, y, width, height
    x += 100;
}

var dice = {
    1: {
        1: [3, 2],
        2: [2, 4],
        3: [4, 5],
        4: [5, 3]
    },
    2: {
        1: [1, 3],
        2: [3, 6],
        3: [6, 3],
        4: [4, 1]
    },
    3: {
        1: [1, 5],
        2: [5, 6],
        3: [6, 2],
        4: [2, 1]
    },
    4: {
        1: [1, 2],
        2: [2, 6],
        3: [6, 5],
        4: [5, 1]
    },
    5: {
        1: [1, 4],
        2: [4, 6],
        3: [6, 3],
        4: [3, 1]
    },
    6: {
        1: [2, 3],
        2: [3, 5],
        3: [5, 4],
        4: [4, 2]
    },

};

// console.log(dice[1]); //random nomber front dice (1-6)
// console.log(dice[1][1]); // random combination (1-4)
// console.log(dice[1][1][0]); // random put on top
// console.log(dice[1][1][1]); // random put on right

var x1 = 50;
var x2 = 75;
var x3 = 100;
var x4 = 125;
countCubs = 0;
while (countCubs < 5) {
    ctx.moveTo(x1, 200);
    ctx.lineTo(x2, 175);
    ctx.stroke();

    ctx.moveTo(x2, 175);
    ctx.lineTo(x4, 175);
    ctx.stroke();

    ctx.moveTo(x4, 175);
    ctx.lineTo(x3, 200);
    ctx.stroke();

    ctx.moveTo(x4, 175);
    ctx.lineTo(x4, 225);
    ctx.lineTo(x3, 250);
    ctx.stroke();
    countCubs += 1;
    x1 += 100;
    x2 += 100;
    x3 += 100;
    x4 += 100;
}

ctx.fillStyle = "black";
ctx.font = "20px Arial";
var xy1 = 70;
var xy2 = 80;
var xy3 = 105;
countNombers = 0;
while (countNombers < 5) {
    var front = Math.floor(Math.random() * 6 + 1);

    var toprightnum = Math.floor(Math.random() * 4 + 1);

    var topright = dice[front][toprightnum];

    ctx.fillText(front, xy1, 225);
    ctx.fillText(topright[0], xy2, 195);
    ctx.fillText(topright[1], xy3, 215);
    xy1 += 100;
    xy2 += 100;
    xy3 += 100;
    countNombers += 1;
}