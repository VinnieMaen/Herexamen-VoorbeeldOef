import java.util.Comparator;

public class TimeComparator implements Comparator<Atleet> {
    @Override
    public int compare(Atleet o1, Atleet o2) {
        return (o1.getEindTijd() - o1.getStartTijd()) - o2.getStartNummer();
    }
}