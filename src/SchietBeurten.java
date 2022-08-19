import java.util.ArrayList;

public class SchietBeurten {
	private static int totaalAantalSchietBeurten;
	private ArrayList<SchietBeurt> schietBeurten; //groepering SchietBeurt
	
	public SchietBeurten() {
		this.schietBeurten = new ArrayList<SchietBeurt>();
	}
	
	public static void setAantalSchietBeurten(int aantal) {
		totaalAantalSchietBeurten = aantal;
	}
	
	public void addSchietBeurt(int gemist) {
		SchietBeurt sb = new SchietBeurt(gemist);
		schietBeurten.add(sb);

		if (gemist < 1) {
			totaalAantalSchietBeurten--;
		}
	}
}
