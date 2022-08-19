public class Atleet { 
	private int startNummer;
	private String naam;
	private String land;
	private double startTijd;
	private double eindTijd;
	private SchietBeurten schietBeurten;

	public Atleet(int sn, String n, String l, double st, double et, SchietBeurten sb) {
		this.startNummer = sn;
		this.naam = n;
		this.land = l;
		this.startTijd = st;
		this.eindTijd = et;
		this.schietBeurten = sb;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.startNummer) + " " + naam + " " + land + " ...";
	}

	public int getStartNummer() {
		return startNummer;
	}
	
	public void voegSchietBeurtToe(int gemist) {
		schietBeurten.addSchietBeurt(gemist);
	}

	public void setEindTijd(double eindTijd) {
		this.eindTijd = eindTijd;
	}

	public double getStartTijd() {
		return startTijd;
	}

	public void setStartTijd(double startTijd) {
		this.startTijd = startTijd;
	}

	public double getEindTijd() {
		return eindTijd;
	}
	
}
