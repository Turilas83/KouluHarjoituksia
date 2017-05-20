package Viikkotehtava4;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HenkiloMapSovellus {
	private Lukija lukija = new Lukija();
	private HashMap<String, Henkilo> henkilot = new HashMap<String, Henkilo>();
	DecimalFormat des = new DecimalFormat("0.00");
	

	public HenkiloMapSovellus(){
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
		henkilot.put(henkilo.getNimi(), henkilo);
	}

	private void naytaTiedot() {
		String nimi = lukija.lueTeksti("Anna näytettävän henkilön nimi: ");
		if(henkilot.containsKey(nimi)){
			System.out.println("Nimi: "+henkilot.get(nimi).getNimi());
			System.out.println("Osoite: "+henkilot.get(nimi).getOsoite());
			System.out.println("Pituus: "+henkilot.get(nimi).getKoko().getPituus());
			System.out.println("Paino: "+henkilot.get(nimi).getKoko().getPaino());
			System.out.println("Painoindeksi: "+ des.format(henkilot.get(nimi).getKoko().getPainoindeksi()));
			System.out.println();
			return;
		}
		System.out.println("Henkilöä ei ole");	
	}

	private void muutaTiedot() {		
		String nimi = lukija.lueTeksti("Anna perustietoja muutettavan henkilön nimi: ");
		if(henkilot.containsKey(nimi)){
				henkilot.get(nimi).setNimi(lukija.lueTeksti("Anna nimi: "));
				henkilot.get(nimi).setOsoite(lukija.lueTeksti("Anna osoite: "));
				return;
			}
			System.out.println("Henkilöä ei ole");
	}
		
	private void muutaKoko() {
	
		String nimi = lukija.lueTeksti("Anna kokoa muutettavan henkilön nimi: ");
		if(henkilot.containsKey(nimi)){
				henkilot.get(nimi).getKoko().setPituus(lukija.lueDesimaaliluku("Anna pituus: "));
				henkilot.get(nimi).getKoko().setPaino(lukija.lueKokonaisluku("Anna paino: "));
				return;
			}
			System.out.println("Henkilöä ei ole");
	}

	private void naytaKaikki() {
		Set<String> nimet= henkilot.keySet();
		Iterator<String> i = nimet.iterator();
		while (i.hasNext()) {
			System.out.println(henkilot.get(i.next()));
		}
	}

	public static void main(String[] args) {
		new HenkiloMapSovellus();
	}

}
