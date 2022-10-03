package semestr3.PredmetPointer;
import java.util.ArrayList;
import java.util.Arrays;

public class Termin {
    String name;
    int[] pages;
    ArrayList<Termin> podtermins;
    public Termin(String name, int[] pages){
        this.name = name;
        this.pages = Arrays.copyOf(pages,pages.length);
        podtermins = new ArrayList<Termin>();
    }

}