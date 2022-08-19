//deze klasse is volledig, moet je dus niet wijzgen
public class SchietBeurt {
	//voor eenvoud houden we enkel aantal gemiste schoten bij
	private int aantalGemist;

	public SchietBeurt(int gemist){
		aantalGemist = gemist;
	}

	public String toString(){
		return String.valueOf(aantalGemist);
	}
}
