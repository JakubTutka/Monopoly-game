package pl.tutka;

import java.util.ArrayList;
import java.util.List;

public class Board {

    List<Cell> boardCells = new ArrayList<>();

    public Board(){

        // Creating board - designed by Tutka & Bałuszynski

        // Creating START cell with final index 1

        boardCells.add(new StartCell());

        // Creating cities - POLSKA and chances

        boardCells.add(new CityCell(2, "Kraków", 100, Nationality.POLSKA));
        boardCells.add(new ChanceCell(3));
        boardCells.add(new CityCell(4, "Lublin", 250, Nationality.POLSKA));
        boardCells.add(new CityCell(5, "Rzeszów", 400, Nationality.POLSKA));

        // Creating TRAIN cell

        boardCells.add(new TrainCell(6));

        // Creating cities - GRECJA and chances

        boardCells.add(new CityCell(7, "Ateny", 200, Nationality.GRECJA));
        boardCells.add(new ChanceCell(8));
        boardCells.add(new CityCell(9, "Saloniki", 300, Nationality.GRECJA));
        boardCells.add(new CityCell(10, "Kreta", 500, Nationality.GRECJA));

    }
}
