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
class TurnsXO {
    constructor() {
        this.currentPlayer = "X";
    }

    putXO() {
        for (let key1 = 0; key1 < 3; key1++) {
            for (let key2 = 0; key2 < 3; key2++) {
                let cellId = "cell-" + key1 + key2;
                let cell = document.getElementById(cellId);

                cell.addEventListener("click", () => {

                    if (cell.textContent === "1") {
                        cell.textContent = this.currentPlayer;

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
// Когда ходит игрок просчитыватсья победа
// Если победа, проверить кто победил