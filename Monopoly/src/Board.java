import Cells.*;

import java.util.ArrayList;
import java.util.List;

public class Board {

    List<Cell> boardCells = new ArrayList<>();

    public Board(){

        // Creating board - designed by Tutka & Bałuszynski

        // Creating START cell with final index 1

        boardCells.add(new StartCell());

        // Creating cities - GRECJA and chance

        boardCells.add(new CityCell(2, "Saloniki", 120, Nationality.GRECJA));
        boardCells.add(new ChanceCell(3));
        boardCells.add(new CityCell(4, "Ateny", 120, Nationality.GRECJA));

        // Creating Tax cell

        boardCells.add(new TaxCell(5, 400));

        // Creating TRAIN cell

        boardCells.add(new TrainCell(6, "Poludniowe", 400));

        // Creating cities - WLOCHY and chance

        boardCells.add(new CityCell(7, "Neapol", 200, Nationality.WLOCHY));
        boardCells.add(new ChanceCell(8));
        boardCells.add(new CityCell(9, "Mediolan", 200, Nationality.WLOCHY));
        boardCells.add(new CityCell(10, "Rzym", 240, Nationality.WLOCHY));

        // Creating Jail cell

        boardCells.add(new JailCell(11));

        // Creating cities - HISZPANIA and chances

        boardCells.add(new CityCell(12, "Barcelona", 280, Nationality.HISZPANIA));
        boardCells.add(new ChanceCell(13));
        boardCells.add(new CityCell(14, "Sewilla", 280, Nationality.HISZPANIA));
        boardCells.add(new CityCell(15, "Madryt", 320, Nationality.HISZPANIA));

        // Creating TRAIN cell

        boardCells.add(new TrainCell(16, "Zachodnie", 400));

        // Creating cities - ANGLIA and chances

        boardCells.add(new CityCell(17, "Liverpool", 360, Nationality.ANGLIA));
        boardCells.add(new ChanceCell(18));
        boardCells.add(new CityCell(19, "Glasgow", 360, Nationality.ANGLIA));
        boardCells.add(new CityCell(20, "Londyn", 400, Nationality.ANGLIA));

        // Creating PARKING cell

        boardCells.add(new ParkingCell(21));

        // Creating cities - BENELUX and chances

        boardCells.add(new CityCell(22, "Rotterdam", 440, Nationality.BENELUX));
        boardCells.add(new ChanceCell(23));
        boardCells.add(new CityCell(24, "Bruksela", 440, Nationality.BENELUX));
        boardCells.add(new CityCell(25, "Amsterdam", 480, Nationality.BENELUX));

        // Creating TRAIN cell

        boardCells.add(new TrainCell(26, "Polnocne", 400));

        // Creating cities - SZWECJA and chances

        boardCells.add(new CityCell(27, "Malmo", 520, Nationality.SZWECJA));
        boardCells.add(new ChanceCell(28));
        boardCells.add(new CityCell(29, "Goteborg", 520, Nationality.SZWECJA));
        boardCells.add(new CityCell(30, "Sztokholm", 560, Nationality.SZWECJA));

        // Creating PARKING cell

        boardCells.add(new GoToJailCell(31));

        // Creating cities - NIEMCY and chance

        boardCells.add(new CityCell(32, "Frankfurt", 600, Nationality.NIEMCY));
        boardCells.add(new CityCell(33, "Monachium", 600, Nationality.NIEMCY));
        boardCells.add(new ChanceCell(34));
        boardCells.add(new CityCell(35, "Berlin", 640, Nationality.NIEMCY));

        // Creating TRAIN cell

        boardCells.add(new TrainCell(36, "Wschodnie", 400));

        // Creating cities - AUSTRIA and chance + tax

        boardCells.add(new ChanceCell(37));
        boardCells.add(new CityCell(38, "Innsbruck", 700, Nationality.AUSTRIA));
        boardCells.add(new TaxCell(39, 400));
        boardCells.add(new CityCell(40, "Wiedeń", 800, Nationality.AUSTRIA));
    }
}
