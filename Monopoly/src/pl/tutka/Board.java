package pl.tutka;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Cell> boardCells = new ArrayList<>();

    public Board(){

        // Creating board - designed by Tutka & Bałuszynski

        // Creating START cell with final index 1

        boardCells.add(new StartCell());

        // Creating cities

        boardCells.add(new CityCell(2, "Zamość", 100));
        boardCells.add(new CityCell(3, "Lublin", 250));

        // Creating CHANCE cell

        boardCells.add(new ChanceCell());






    }
}
