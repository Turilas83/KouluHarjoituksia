package Viikkotehtava4;

public class Tyontekija extends Henkilo {
	private double tuntipalkka;

	public Tyontekija() {
		super();	
	}

	public Tyontekija(String nimi, String osoite, Koko koko) {
		super(nimi, osoite, koko);	
	}

	public Tyontekija(String nimi, String osoite) {
		super(nimi, osoite);		
	}

	public Tyontekija(String nimi) {
		super(nimi);
	}

	public Tyontekija(double tuntipalkka) {
		super();
		this.tuntipalkka = tuntipalkka;
	}
	public Tyontekija(String nimi, String osoite, Koko koko, double tuntipalkka) {
		super(nimi, osoite, koko);	
		this.tuntipalkka = tuntipalkka;
	}

	public double getTuntipalkka() {
		return tuntipalkka;
	}

	public void setTuntipalkka(double tuntipalkka) {
		this.tuntipalkka = tuntipalkka;
	}

	@Override
	public String toString() {
		return "Tyontekija [tuntipalkka=" + tuntipalkka + ", toString()="
				+ super.toString() + "]";
	}
	
}
