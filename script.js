// document.getElementById()

class Field {

    printField() {
        const container = document.getElementById("game");
        let html = "<table class='table'>";
        for (let l = 0; l < 3; l++) {
            html += `<tr class='line' id = 'line-${l}'>`;
            for (let c = 0; c < 3; c++) {
                html += `<td class='cell' id = 'cell-${l}${c}'></td>`;
            }
            html += "</tr>";
        }
        html += "</table >";
        container.innerHTML = html;
    }

}


class CountWin {

    countWin() {

        let array = [];
        const wins = [
            [0, 1, 2],
            [3, 4, 5],
            [6, 7, 8],
            [0, 3, 6],
            [1, 4, 7],
            [2, 5, 8],
            [0, 4, 8],
            [2, 4, 6]
        ];
        for (let key1 = 0; key1 < 3; key1++) {
            for (let key2 = 0; key2 < 3; key2++) {
                let cellId = "cell-" + key1 + key2;
                let cell = document.getElementById(cellId);
                let text = cell.textContent;
                array.push(text);
            }
        }
        for (let combo of wins) {
            let [a, b, c] = combo;
            if (array[a] != "" && array[a] === array[b] && array[b] === array[c]) {
                return "Won";
            }
        }
        return null;

    }
}

class TurnsXO {
    constructor() {
        this.gameisover = false;
        this.currentPlayer = "X";
        this.asd = new CountWin();
        this.a = new Field();
        this.a.printField();
        this.putXO();
    }

    putXO() {

        let cell = document.getElementById("game");

        cell.addEventListener("click", (e) => {
            const cell = e.target;

            if (this.gameisover) { return };

            if (cell.textContent === "") {
                cell.textContent = this.currentPlayer;
                let f = this.asd.countWin();
                if (f === "Won") {
                    this.gameisover = true;
                    this.addWin(this.currentPlayer);
                    setTimeout(() => this.restart(), 2000);

                    return;
                }
                this.currentPlayer = this.currentPlayer === "X" ? "O" : "X";
            }

        });
    }

    addWin(currentPlayer) {
        const message = document.getElementById("message");

        if (currentPlayer) {
            if (currentPlayer === "X") {
                const won = document.getElementById("PlayerX");
                won.textContent = parseInt(won.textContent) + 1;
            }
            if (currentPlayer === "O") {
                const won = document.getElementById("PlayerO");
                won.textContent = parseInt(won.textContent) + 1;
            }
            message.textContent = `${currentPlayer} Won!`;
        } else {
            message.textContent = "";
        }
    }

    restart() {
        this.gameisover = false;
        this.addWin();
        this.currentPlayer = "X";
        this.a = new Field();
        this.a.printField();
        this.putXO();
    }
}
var b = new TurnsXO();



// отрисовка поля +
// хода игрока Х или О +
// Когда ходит игрок просчитыватсья победа +
// Если победа, проверить кто победил +
// начать игру занаво. + 