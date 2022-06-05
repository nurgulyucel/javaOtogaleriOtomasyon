package application;

public class Kayitlar_musteri {
	public int kId;
	public String kullanici_adi;
	public  String sifre;
	
	public int getKId() {
		return kId;
	}

	public void setKId(int kId) {
		this.kId = kId;
	}

	public String getKullanici_adi() {
		return kullanici_adi;
	}

	public void setKullanici_adi(String kullanici_adi) {
		this.kullanici_adi = kullanici_adi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	

	
	Kayitlar_musteri(int kId,String kullanici_adi,String sifre){
		this.kId=kId;
		this.kullanici_adi=kullanici_adi;
		this.sifre=sifre;
		
		
	}

	public Kayitlar_musteri() {
		// TODO Auto-generated constructor stub
	}


}
