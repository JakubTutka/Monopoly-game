package General;

import Cells.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {

    List<Cell> boardCells = new ArrayList<>();
    HashMap<Nationality, Integer> fullNationality = new HashMap<Nationality, Integer>();

    public HashMap<Nationality, Integer> getFullNationality() {
        return fullNationality;
    }

    Player gracz;

    public Board() {

        // czy powinniśmy zrobić najpierw obiekty np Property saloniki i potem Property saloniki = new Property(XYZ) żeby móc się do tych obiektów jakoś odwoływać?

        // Creating board - designed by Tutka & Bałuszynski

        // Creating START cell with final index 1

        boardCells.add(new Start());

        // Creating cities - GRECJA and chance

        boardCells.add(new Property(2, CellType.CITY, "Saloniki", 120, 10, Nationality.GRECJA));
        boardCells.add(new Chance(3));
        boardCells.add(new Property(4, CellType.CITY, "Ateny", 120, 10, Nationality.GRECJA));

        // Creating Tax cell

        boardCells.add(new Tax(5, 400));

        // Creating TRAIN cell

        boardCells.add(new Property(6, CellType.TRAIN, "Południowe", 400, 15, null));

        // Creating cities - WLOCHY and chance

        boardCells.add(new Property(7, CellType.CITY, "Neapol", 200, 15, Nationality.WLOCHY));
        boardCells.add(new Chance(8));
        boardCells.add(new Property(9, CellType.CITY, "Mediolan", 200, 10, Nationality.WLOCHY));
        boardCells.add(new Property(10, CellType.CITY, "Rzym", 240, 20, Nationality.WLOCHY));

        // Creating Jail cell

        boardCells.add(new Jail(11));

        // Creating cities - HISZPANIA and chances

        boardCells.add(new Property(12, CellType.CITY, "Barcelona", 280, 20, Nationality.HISZPANIA));
        boardCells.add(new Chance(13));
        boardCells.add(new Property(14, CellType.CITY, "Sewilla", 280, 20, Nationality.HISZPANIA));
        boardCells.add(new Property(15, CellType.CITY, "Madryt", 320, 25, Nationality.HISZPANIA));

        // Creating TRAIN cell

        boardCells.add(new Property(16, CellType.TRAIN, "Zachodnie", 400, 50, null));

        // Creating cities - ANGLIA and chances

        boardCells.add(new Property(17,CellType.CITY,"Liverpool", 360, 30, Nationality.ANGLIA));
        boardCells.add(new Chance(18));
        boardCells.add(new Property(19,CellType.CITY,"Glasgow", 360, 30, Nationality.ANGLIA));
        boardCells.add(new Property(20,CellType.CITY,"Londyn", 400, 35, Nationality.ANGLIA));

        // Creating PARKING cell

        boardCells.add(new Parking(21));

        // Creating cities - BENELUX and chances

        boardCells.add(new Property(22, CellType.CITY,"Rotterdam", 440, 35, Nationality.BENELUX));
        boardCells.add(new Chance(23));
        boardCells.add(new Property(24, CellType.CITY,"Bruksela", 440, 35, Nationality.BENELUX));
        boardCells.add(new Property(25, CellType.CITY,"Amsterdam", 480, 40, Nationality.BENELUX));

        // Creating TRAIN cell

        boardCells.add(new Property(26, CellType.TRAIN, "Północne", 400, 50, null));

        // Creating cities - SZWECJA and chances

        boardCells.add(new Property(27, CellType.CITY, "Malmo", 520, 45, Nationality.SZWECJA));
        boardCells.add(new Chance(28));
        boardCells.add(new Property(29, CellType.CITY, "Goteborg", 520, 45, Nationality.SZWECJA));
        boardCells.add(new Property(30, CellType.CITY, "Sztokholm", 560, 50, Nationality.SZWECJA));

        // Creating PARKING cell

        boardCells.add(new GoToJail(31));

        // Creating cities - NIEMCY and chance

        boardCells.add(new Property(32, CellType.CITY, "Frankfurt", 600, 55, Nationality.NIEMCY));
        boardCells.add(new Property(33, CellType.CITY, "Monachium", 600, 55, Nationality.NIEMCY));
        boardCells.add(new Chance(34));
        boardCells.add(new Property(35, CellType.CITY, "Berlin", 640, 60, Nationality.NIEMCY));

        // Creating TRAIN cell

        boardCells.add(new Property(36, CellType.TRAIN, "Wschodnie", 400, 50, null));

        // Creating cities - AUSTRIA and chance + tax

        boardCells.add(new Chance(37));
        boardCells.add(new Property(38, CellType.CITY, "Innsbruck", 700, 70, Nationality.AUSTRIA));
        boardCells.add(new Tax(39, 200));
        boardCells.add(new Property(40, CellType.CITY, "Wiedeń", 800, 100, Nationality.AUSTRIA));

        // Filling hashmap with appropriate values

        for (Nationality l:Nationality.values()) {
            if (l != Nationality.GRECJA && l != Nationality.AUSTRIA && l != Nationality.KOLEJE) {
                fullNationality.put(l, 3);
            }
            else if (l == Nationality.AUSTRIA || l == Nationality.GRECJA) {
                fullNationality.put(l, 2);
            }
            else {
                fullNationality.put(l, 4);
            }
        }
    }
}
