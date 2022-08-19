import java.util.ArrayList;
import java.util.Collections;

public class Wedstrijd {
	private ArrayList<Atleet> atleten; //groepering Atleet
	
	public Wedstrijd() {
		this.atleten = new ArrayList<Atleet>();
	}
	
	public void setAantalSchietBeurten(int aantalSchietBeurten) {
		SchietBeurten.setAantalSchietBeurten(aantalSchietBeurten);
	}

	public void voegAtleetToe(Atleet atleet) {
		atleten.add(atleet);
	}
	
	public String getStartLijst() {
		String returnString = "";
		Collections.sort(atleten, new CompareNumber());
		
		for (int i = 0; i < atleten.size(); i++) {
			Atleet atleet = atleten.get(i);
			returnString += atleet.toString() + "\n";
		}
		
		return returnString;
	}
	
	public void verwerkSchietBeurt(int nummer, int gemist) {
		for(int i = 0; i < atleten.size(); i++) {
			Atleet atleet = atleten.get(i);
			if (atleet.getStartNummer() == nummer) {
				atleet.voegSchietBeurtToe(gemist);
			}
		}
	}

	public void verwerkFinish(int nummer, double eindTijd) {
		for(int i = 0; i < atleten.size(); i++) {
			Atleet atleet = atleten.get(i);
			if (atleet.getStartNummer() == nummer) {
				atleet.setEindTijd(eindTijd);
			}
		}
	}
	
	public void verwerkNietVetrokken(int nummer) {
		for(int i = 0; i < atleten.size(); i++) {
			Atleet atleet = atleten.get(i);
			if (atleet.getStartNummer() == nummer) {
				atleet.setEindTijd(-2.0);
			}
		}
	}
	
	public ArrayList<Atleet> getAtleten() {
		return atleten;
	}
}
