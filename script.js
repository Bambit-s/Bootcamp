// document.getElementById()

class Field {

    printField() {
        document.write("<table>");
        for (var l = 0; l < 3; l++) {
            document.write("<tr class='line' id = 'line-", l, "'>");
            for (var c = 0; c < 3; c++) {
                document.write("<td class='cell' id = 'cell-", l, c, "'>1</td>");
            }
            document.write("</tr>");
        }
        document.write("</table > ");
    }

}
var a = new Field();
a.printField();

class CountWin {

    countWin() {

        var cost = 0;
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
            if (array[a] != "1" && array[a] === array[b] && array[b] === array[c]) {
                return "Won";
            }
        }
        return null;

    }
}

class TurnsXO {
    constructor() {
        this.currentPlayer = "X";
        this.asd = new CountWin();
    }

    putXO() {


        for (let key1 = 0; key1 < 3; key1++) {
            for (let key2 = 0; key2 < 3; key2++) {
                let cellId = "cell-" + key1 + key2;
                let cell = document.getElementById(cellId);

                cell.addEventListener("click", () => {

                    if (cell.textContent === "1") {
                        cell.textContent = this.currentPlayer;
                        let f = this.asd.countWin();
                        console.log(this.currentPlayer + " " + f);
                        if (f==="Won"){
                            pass;
                        }
                        this.currentPlayer = this.currentPlayer === "X" ? "O" : "X";
                    }


                });
            }
        }
    }
}
var b = new TurnsXO();

b.putXO();


// отрисовка поля +
// хода игрока Х или О +
// Когда ходит игрок просчитыватсья победа +
// Если победа, проверить кто победил +
// начать игру занаво.