package demonstratie;

import java.util.Scanner;

public class Demo {
	boolean doorgaan = true;
	Scanner scanner = new Scanner(System.in);
	Kermis kermis;
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.starten();
		System.out.println("Bedankt voor het bezoeken van de Kermis");
	}
	void starten() {
		kermis = new Kermis();
		while(doorgaan) {
			menuTonen();
			String invoer = scanner.next();
			verwerkInvoer(invoer);
		}
	}
	void menuTonen() {
		System.out.println("1. Toets 1 voor botsautos");
		System.out.println("2. Toets 2 voor hawaii");
		System.out.println("3. Toets 3 voor spiegelpaleis");
		System.out.println("4. Toets 4 voor spin");
		System.out.println("5. Toets 5 voor spookhuis");
		System.out.println("6. Toets 6 voor ladderklimmen");
		System.out.println("7. Toets q om de kermis te verlaten");

	}
	void verwerkInvoer(String invoer) {
		switch(invoer) {
			case "1":
				kermis.attracties[0].ritjeMaken();
				break;
			case "2":
				kermis.attracties[1].ritjeMaken();
				break;
			case "3":
				kermis.attracties[2].ritjeMaken();
				break;
			case "4":
				kermis.attracties[3].ritjeMaken();
				break;
			case "5":
				kermis.attracties[4].ritjeMaken();
				break;
			case "6":
				kermis.attracties[5].ritjeMaken();
				break;
			case "q":
				 doorgaan = false;
				break;
			case "o":
				System.out.println(kermis.kassa.omzetTonen(kermis));
				break;
			default:
				System.out.println("Dit is onjuiste invoer. Probeer opnieuw");
		}
	}
}
class Kermis{
	Attractie[] attracties = new Attractie[6];
	Kassa kassa = new Kassa();
	Kermis(){
		attracties[0] = new Botsautos(250);
		attracties[1] = new Hawaii(225);
		attracties[2] = new SpiegelPaleis(275);
		attracties[3] = new Spin(320);
		attracties[4] = new Spookhuis(290);
		attracties[5] = new Ladderklimmen(500);
	}
}
class Kassa{
	String omzetTonen(Kermis kermis) {
		int TotaalOmzet = 0;
		for(Attractie a : kermis.attracties) {
			TotaalOmzet += a.prijs * a.aantalKerenBezocht;
			System.out.println("Het aantal kaartjes dat verkocht is: " + a.aantalKerenBezocht);
			System.out.println("De omzet van deze attractie is: " + a.prijs * a.aantalKerenBezocht);
		}
		return "Dit is de omzet: " + TotaalOmzet;
	}
}
abstract class Attractie{
	int prijs;
	int aantalKerenBezocht = 0;
	abstract void ritjeMaken();
}
class Botsautos extends Attractie{
	Botsautos(int prijs){ 
		this.prijs = prijs;
	}
	void ritjeMaken() {
		System.out.println("Er wordt een ritje gemaakt in object Botsautos");
		aantalKerenBezocht++;
	}
}
class Hawaii extends Attractie{
	Hawaii(int prijs){ 
		this.prijs = prijs;
	}
	void ritjeMaken() {
		System.out.println("Er wordt een ritje gemaakt in object Hawaii");
		aantalKerenBezocht++;
	}
}
class SpiegelPaleis extends Attractie{
	SpiegelPaleis(int prijs){ 
		this.prijs = prijs;
	}
	void ritjeMaken() {
		System.out.println("Er wordt een ritje gemaakt in object Spiegelpaleis");
		aantalKerenBezocht++;
	}
}
class Spin extends Attractie{
	Spin(int prijs){ 
		this.prijs = prijs;
	}
	void ritjeMaken() {
		System.out.println("Er wordt een ritje gemaakt in object Spin");
		aantalKerenBezocht++;
	}
}
class Spookhuis extends Attractie{
	Spookhuis(int prijs){ 
		this.prijs = prijs;
	}
	void ritjeMaken() {
		System.out.println("Er wordt een ritje gemaakt in object Spookhuis");
		aantalKerenBezocht++;
	}
}
class Ladderklimmen extends Attractie{
	Ladderklimmen(int prijs){ 
		this.prijs = prijs;
	}
	void ritjeMaken() {
		System.out.println("Er wordt een ritje gemaakt in object Ladderklimmen");
		aantalKerenBezocht++;
	}
}
