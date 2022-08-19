import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

        Wedstrijd wedstrijd = new Wedstrijd();

//deel 1
       
        
		//inlezen gegevens uit csv-bestand startlijst.txt
		//startnummer,naam,land,starttijd (int,String,String,double)
		//starttijd = aantal seconden na start wedstrijd
		//eerste heeft starttijd 0;
		//gebruik wedstrijd.voegAtleetToe(...) om een atleet aan de wedstrijd toe te voegen
		//iedere atleet krijgt eindTijd -1;
		
        
        FileReader f = new FileReader("startlijst.txt");
        Scanner scFile = new Scanner(f);

        while (scFile.hasNext()) {
        	String line = scFile.nextLine();
        	String[] sLine = line.split(",");
        	
        	Atleet atleet = new Atleet(Integer.valueOf(sLine[0]), sLine[1], sLine[2], Double.parseDouble(sLine[3]), -1.0, new SchietBeurten());
        	wedstrijd.voegAtleetToe(atleet);

        }
        
        scFile.close();
        f.close();
		
//deel 2		

		//startlijst uitschrijven volgens oplopend startnummer
		//opgelet startlijst.txt is niet noodzakelijk correct gesorteerd
		System.out.println(wedstrijd.getStartLijst());

//deel 3

		//inlezen en verwerken simulatie.txt
		//eerste lijn: aantal schietbeurten (2,4 of 8)
		//gebruik wedstrijd.setAantalSchietBeurten(aantalSchietBeurten);
		//met aantalSchietBeurten het eerste ingelezen getal
		//daarna, aantal lijnen met 3 mogelijkheden:
		//nietVertrokken startnummerAtleet
		//schiet startnummerAtleet aantalGemist
		//finish startnummerAtleet aantalSecondenSindsStartWedstrijd
		
		FileReader f2 = new FileReader("simulatie.txt");
        Scanner scFile2 = new Scanner(f2);
        
        wedstrijd.setAantalSchietBeurten(scFile2.nextInt());
        
        
		int nummerAtleet;
		int gemist;
		double eindTijd;

		while (scFile2.hasNext()) {
			String line = scFile2.nextLine();
        	String[] sLine = line.split(" ");
        	
			switch (sLine[0]) {
				case "schiet": nummerAtleet = Integer.parseInt(sLine[1]);
							   gemist = Integer.parseInt(sLine[2]);
							   //schietbeurt toevoegen bij juiste atleet via
							   wedstrijd.verwerkSchietBeurt(nummerAtleet,gemist);
							   break;
				case "finish": nummerAtleet = Integer.parseInt(sLine[1]);
							   eindTijd = Double.parseDouble(sLine[2]);
							   //eindTijd invullen bij juiste atleet via
							   wedstrijd.verwerkFinish(nummerAtleet,eindTijd);
							   break;
				case "nietVertrokken": nummerAtleet = Integer.parseInt(sLine[1]);
				                       //eindTijd moet op -2 worden gezet bij juiste atleet via
									   wedstrijd.verwerkNietVetrokken(nummerAtleet);
									   break;
				default: System.out.println("foute mogelijkheid"); break;
				
			}
        }
		
		scFile2.close();
        f2.close();
        
		/*
//deel 3 bis
		
		//exceptions toevoegen aan verwerken simulaties (=in deel 3)
		//nummer 1
		//Als je een schietBeurt toevoegt, dan moet je een OnmogelijkeWaardeException opgooien
		//als de atleet daarvoor al aantalSchietBeurten keren geschoten heeft.
		//Deze Exception moet in de main worden opgevangen en dan moet je enkel de fout uitschrijven.
		//nummer 2
		//als je een finish verwerkt, dan moet je ook een OnmogelijkeWaardeException opgooien
		//als de eindTijd voor de startTijd ligt
		//Ook deze Exception moet in de main worden opgevangen (en enkel de fout uitschrijven).
		
		*/
//deel 4

		//finale stand schrijven naar tekstbestand "resultaat.txt"
		//plaatsnummer startnummer naam land aantalGemistSchiett1 + aantalGemistSchiet2 (+...) tijdsVerschilMetEerste
		//volgens oplopend plaatsnummer, d.w.z snelste eerst
		//wie niet gefinisht is moet DNF hebben ipv tijdsVerschilMetEerste
		//wie niet gestart is moet DNS hebben ipv tijdsVerschilMetEerste
		//DNF en DNS moeten achteraan in de lijst staan.
		
		FileWriter fw = new FileWriter("resultaat.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		ArrayList <Atleet> atleten = wedstrijd.getAtleten();
		Collections.sort(atleten, new TimeComparator());
		for (int i = 0; i < wedstrijd.getAtleten().size();i++) {
			Atleet atleet = wedstrijd.getAtleten().get(i);
			
		}

	}
}
