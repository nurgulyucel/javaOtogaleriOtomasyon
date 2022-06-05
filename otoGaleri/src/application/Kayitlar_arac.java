package application;

public class Kayitlar_arac {
	public int aId;
	public String marka;
	public  String model;
	public  int durum;
	public   int yil;
	public  String yakit;
	public  String vites;
	public  int km;
	public  String kasaTipi;
	public  int fiyat;
	public int getAId() {
		return aId;
	}

	public void setAId(int aId) {
		this.aId = aId;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getDurum() {
		return durum;
	}

	public void setDurum(int durum) {
		this.durum = durum;
	}

	public int getYil() {
		return yil;
	}

	public void setYil(int yil) {
		this.yil = yil;
	}

	public String getYakit() {
		return yakit;
	}

	public void setYakit(String yakit) {
		this.yakit = yakit;
	}

	public String getVites() {
		return vites;
	}

	public void setVites(String vites) {
		this.vites = vites;
	}
	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}
	
	public String getKasaTipi() {
		return kasaTipi;
	}

	public void setKasaTipi(String kasaTipi) {
		this.kasaTipi = kasaTipi;
	}

	public int getFiyat() {
		return fiyat;
	}

	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}

	

	

	
	Kayitlar_arac(int aId,String marka,String model,int durum,int yil,String yakit,String vites,int km,String kasaTipi,int fiyat){
		this.aId=aId;
		this.marka=marka;
		this.model=model;
		this.durum=durum;
		this.yil=yil;
		this.yakit=yakit;
		this.vites=vites;
		this.km=km;
		this.kasaTipi=kasaTipi;
		this.fiyat=fiyat;
		
		
	}

	public Kayitlar_arac() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
