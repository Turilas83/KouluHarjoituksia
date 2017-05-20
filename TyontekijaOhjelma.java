package Viikkotehtava4;

import java.text.DecimalFormat;

public class TyontekijaOhjelma {
	private Lukija lukija = new Lukija();
	DecimalFormat des = new DecimalFormat("0.00");
	Tyontekija tyontekija = new Tyontekija();
	public TyontekijaOhjelma(){
		lisaaTyontekija();
	}
	private void lisaaTyontekija(){		
		tyontekija.setNimi(lukija.lueTeksti("Anna nimi: "));
		tyontekija.setOsoite(lukija.lueTeksti("Anna osoite: "));
		tyontekija.setTuntipalkka(lukija.lueDesimaaliluku("Anna tuntipalkka: "));
		naytaTyontekija();
	}
	private void naytaTyontekija(){
		System.out.println();
		System.out.println("Nimi: "+ tyontekija.getNimi());
		System.out.println("Osoite: "+ tyontekija.getOsoite());
		System.out.println("Tuntipalkka: "+ des.format(tyontekija.getTuntipalkka()));	
	}
		
	public static void main(String[] args) {
		new TyontekijaOhjelma();
		
	}

}
