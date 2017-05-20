package Viikkotehtava4;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class HenkiloListaSovellus {
	private Lukija lukija = new Lukija();
	DecimalFormat des = new DecimalFormat("0.00");
	private ArrayList<Henkilo> henkilot = new ArrayList<Henkilo>();
	
	public HenkiloListaSovellus(){
		naytaValikko();
	}
	
	private void naytaValikko() {
		System.out.println("1. Lisää henkilö");
		System.out.println("2. Näytä henkilön tiedot");
		System.out.println("3. Muuta henkilön nimi ja osoite");
		System.out.println("4. Muuta henkilön koko");
		System.out.println("5. Näytä kaikki henkilöt");
		System.out.println("0. Lopetus");
		switch (lukija.lueKokonaisluku("Anna valintasi (0-5): ")) {
		case 1:
			lisaaHenkilo();
			break;
		case 2:
			naytaTiedot();
			break;
		case 3:
			muutaTiedot();
			break;
		case 4:
			muutaKoko();
			break;
		case 5:
			naytaKaikki();
			break;
		case 0:
			System.exit(0);
			break;
		default:
			System.out.println("Luku ei kelpaa!\n");
			break;
		}
		naytaValikko();
	}

	private void lisaaHenkilo() {
		Henkilo henkilo = new Henkilo();
		Koko koko = new Koko();
		henkilo.setNimi(lukija.lueTeksti("Anna nimi: "));
		henkilo.setOsoite(lukija.lueTeksti("Anna osoite: "));
		koko.setPituus(lukija.lueDesimaaliluku("Anna pituus: "));
		koko.setPaino(lukija.lueKokonaisluku("Anna paino: "));
		henkilo.setKoko(koko);
		henkilot.add(henkilo);
	}

	private void naytaTiedot() {
		int lkm=0;
		String nimi = lukija.lueTeksti("Anna näytettävän henkilön nimi: ");
		for(int i=0;i<henkilot.size();i++){
			if(henkilot.get(i).getNimi().equalsIgnoreCase(nimi)){
				System.out.println("Nimi: "+henkilot.get(i).getNimi());
				System.out.println("Osoite: "+henkilot.get(i).getOsoite());
				System.out.println("Pituus: "+henkilot.get(i).getKoko().getPituus());
				System.out.println("Paino: "+henkilot.get(i).getKoko().getPaino());
				System.out.println("Painoindeksi: "+ des.format(henkilot.get(i).getKoko().getPainoindeksi()));
				System.out.println();
				lkm++;		
			}
		}
		if(lkm==0){
		System.out.println("Henkilöä ei ole");
		}
		
	}

	private void muutaTiedot() {
		int lkm=0;
		String nimi = lukija.lueTeksti("Anna perustietoja muutettavan henkilön nimi: ");
		for(int i=0;i<henkilot.size();i++){
			if(henkilot.get(i).getNimi().equalsIgnoreCase(nimi)){
				henkilot.get(i).setNimi(lukija.lueTeksti("Anna nimi: "));
				henkilot.get(i).setOsoite(lukija.lueTeksti("Anna osoite: "));
				lkm++;
			}
		}
		if(lkm==0){
			System.out.println("Henkilöä ei ole");
			}
		
	}

	private void muutaKoko() {
		int lkm=0;
		String nimi = lukija.lueTeksti("Anna kokoa muutettavan henkilön nimi: ");
		for(int i=0;i<henkilot.size();i++){
			if(henkilot.get(i).getNimi().equalsIgnoreCase(nimi)){
				henkilot.get(i).getKoko().setPituus(lukija.lueDesimaaliluku("Anna pituus: "));
				henkilot.get(i).getKoko().setPaino(lukija.lueKokonaisluku("Anna paino: "));
				lkm++;
			}
		}
		if(lkm==0){
			System.out.println("Henkilöä ei ole");
			}
		
	}

	private void naytaKaikki() {
		for(int i=0;i<henkilot.size();i++){
			System.out.println("Nimi: "+henkilot.get(i).getNimi());
			System.out.println("Osoite: "+henkilot.get(i).getOsoite());
			System.out.println("Pituus: "+henkilot.get(i).getKoko().getPituus());
			System.out.println("Paino: "+henkilot.get(i).getKoko().getPaino());
			System.out.println("Painoindeksi: "+ des.format(henkilot.get(i).getKoko().getPainoindeksi()));
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		new HenkiloListaSovellus();

	}

}
