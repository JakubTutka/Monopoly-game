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

    public static void main(String[] args) {
        Board plansza = new Board();
        System.out.println(plansza.boardCells.get(4).getIndex());

    }

    public List<Cell> getBoardCells() {
        return boardCells;
    }

    public Board() {

        // czy powinniśmy zrobić najpierw obiekty np Property saloniki i potem Property saloniki = new Property(XYZ) żeby móc się do tych obiektów jakoś odwoływać?

        // Creating board - designed by Tutka & Bałuszynski

        // Creating START cell with final index 1

        boardCells.add(new Start());

        // Creating cities - GRECJA and chance

        boardCells.add(new Property(1, CellType.CITY, "Saloniki", 120, 10, Nationality.GRECJA));
        boardCells.add(new Chance(2));
        boardCells.add(new Property(3, CellType.CITY, "Ateny", 120, 10, Nationality.GRECJA));

        // Creating Tax cell

        boardCells.add(new Tax(4, 400));

        // Creating TRAIN cell

        boardCells.add(new Property(5, CellType.TRAIN, "Południowe", 400, 15, null));

        // Creating cities - WLOCHY and chance

        boardCells.add(new Property(6, CellType.CITY, "Neapol", 200, 15, Nationality.WLOCHY));
        boardCells.add(new Chance(7));
        boardCells.add(new Property(8, CellType.CITY, "Mediolan", 200, 10, Nationality.WLOCHY));
        boardCells.add(new Property(9, CellType.CITY, "Rzym", 240, 20, Nationality.WLOCHY));

        // Creating Jail cell

        boardCells.add(new Jail(10));

        // Creating cities - HISZPANIA and chances

        boardCells.add(new Property(11, CellType.CITY, "Barcelona", 280, 20, Nationality.HISZPANIA));
        boardCells.add(new Chance(12));
        boardCells.add(new Property(13, CellType.CITY, "Sewilla", 280, 20, Nationality.HISZPANIA));
        boardCells.add(new Property(14, CellType.CITY, "Madryt", 320, 25, Nationality.HISZPANIA));

        // Creating TRAIN cell

        boardCells.add(new Property(15, CellType.TRAIN, "Zachodnie", 400, 50, null));

        // Creating cities - ANGLIA and chances

        boardCells.add(new Property(16,CellType.CITY,"Liverpool", 360, 30, Nationality.ANGLIA));
        boardCells.add(new Chance(17));
        boardCells.add(new Property(18,CellType.CITY,"Glasgow", 360, 30, Nationality.ANGLIA));
        boardCells.add(new Property(19,CellType.CITY,"Londyn", 400, 35, Nationality.ANGLIA));

        // Creating PARKING cell

        boardCells.add(new Parking(20));

        // Creating cities - BENELUX and chances

        boardCells.add(new Property(21, CellType.CITY,"Rotterdam", 440, 35, Nationality.BENELUX));
        boardCells.add(new Chance(22));
        boardCells.add(new Property(23, CellType.CITY,"Bruksela", 440, 35, Nationality.BENELUX));
        boardCells.add(new Property(24, CellType.CITY,"Amsterdam", 480, 40, Nationality.BENELUX));

        // Creating TRAIN cell

        boardCells.add(new Property(25, CellType.TRAIN, "Północne", 400, 50, null));

        // Creating cities - SZWECJA and chances

        boardCells.add(new Property(26, CellType.CITY, "Malmo", 520, 45, Nationality.SZWECJA));
        boardCells.add(new Chance(27));
        boardCells.add(new Property(28, CellType.CITY, "Goteborg", 520, 45, Nationality.SZWECJA));
        boardCells.add(new Property(29, CellType.CITY, "Sztokholm", 560, 50, Nationality.SZWECJA));

        // Creating PARKING cell

        boardCells.add(new GoToJail(30));

        // Creating cities - NIEMCY and chance

        boardCells.add(new Property(31, CellType.CITY, "Frankfurt", 600, 55, Nationality.NIEMCY));
        boardCells.add(new Property(32, CellType.CITY, "Monachium", 600, 55, Nationality.NIEMCY));
        boardCells.add(new Chance(33));
        boardCells.add(new Property(34, CellType.CITY, "Berlin", 640, 60, Nationality.NIEMCY));

        // Creating TRAIN cell

        boardCells.add(new Property(35, CellType.TRAIN, "Wschodnie", 400, 50, null));

        // Creating cities - AUSTRIA and chance + tax

        boardCells.add(new Chance(36));
        boardCells.add(new Property(37, CellType.CITY, "Innsbruck", 700, 70, Nationality.AUSTRIA));
        boardCells.add(new Tax(38, 200));
        boardCells.add(new Property(39, CellType.CITY, "Wiedeń", 800, 100, Nationality.AUSTRIA));

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
