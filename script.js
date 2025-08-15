class Field {

    printField() {
        //found id-game and painted field 3x3
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
        //create html field
        container.innerHTML = html;
    }

}


class CountWin {

    countWin() {
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
        let array = this.createArray();
        //check for win
        for (let combo of wins) {
            let [a, b, c] = combo;
            //if found the similar
            if (array[a] != "" && array[a] === array[b] && array[b] === array[c]) {
                return "Won";
            }
            // if equal
            if (!array.includes("")) {
                return "Draw";
            }
        }
        return null;
    }

    //results in field
    createArray() {
        let array = [];
        for (let key1 = 0; key1 < 3; key1++) {
            for (let key2 = 0; key2 < 3; key2++) {
                let cellId = "cell-" + key1 + key2;
                let cell = document.getElementById(cellId);
                let text = cell.textContent;
                array.push(text);
            }
        }
        return array;
    }
}

class TurnsXO {
    constructor() {
        this.gameisover = false;
        this.currentPlayer = "X";
        this.createrules = new CountWin();
        this.game = new Field();
        this.game.printField();
        this.putXO();
    }
    //player puts
    putXO() {

        let cell = document.getElementById("game");
        cell.addEventListener("click", (e) => {
            const cell = e.target;
            //check for finish
            if (this.gameisover) { return };
            // if space is free player can put his symbol
            if (cell.textContent === "") {
                cell.textContent = this.currentPlayer;
                //check if win
                let winrule = this.createrules.countWin();
                if (winrule === "Won") {
                    this.gameisover = true;
                    this.addWin(this.currentPlayer);
                    setTimeout(() => this.restart(), 1500);

                    return;
                }
                if (winrule === "Draw") {
                    this.addDraw();
                    setTimeout(() => this.restart(), 1500);
                    return;
                }
                this.currentPlayer = this.currentPlayer === "X" ? "O" : "X";
            }

        });
    }
    //push in html win player
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
    //push in html Draw
    addDraw() {
        const message = document.getElementById("message");
        message.textContent = `Draw.`;
    }
    restart() {
        this.gameisover = false;
        this.addWin();
        this.currentPlayer = "X";
        this.game = new Field();
        this.game.printField();
        this.putXO();
    }
}

//Start point
new TurnsXO();