import java.util.Comparator;

public class CompareNumber implements Comparator<Atleet> {
    @Override
    public int compare(Atleet o1, Atleet o2) {
        return o1.getStartNummer() - o2.getStartNummer();
    }
}