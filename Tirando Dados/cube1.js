function generate() {
    sq1 = Math.floor(Math.random() * 6 + 1);
    sq2 = Math.floor(Math.random() * 6 + 1);
    sq3 = Math.floor(Math.random() * 6 + 1);
    sq4 = Math.floor(Math.random() * 6 + 1);
    sq5 = Math.floor(Math.random() * 6 + 1);
    document.getElementById("square1").innerHTML = sq1;
    document.getElementById("square2").innerHTML = sq2;
    document.getElementById("square3").innerHTML = sq3;
    document.getElementById("square4").innerHTML = sq4;
    document.getElementById("square5").innerHTML = sq5;
    foto1 = document.getElementById('square1foto')
    foto2 = document.getElementById('square2foto')
    foto3 = document.getElementById('square3foto')
    foto4 = document.getElementById('square4foto')
    foto5 = document.getElementById('square5foto')
    foto1.src = sq1+".png";
    foto2.src = sq2+".png";
    foto3.src = sq3+".png";
    foto4.src = sq4+".png";
    foto5.src = sq5+".png";
}

function start() {
    let c = 0;
    let intervalId = setInterval(() => {
        generate();
        c++;
        if (c >= 5) {
            clearInterval(intervalId);
        }
    }, 300);
}
const button = document.getElementById("Start");
button.onclick = () => start();