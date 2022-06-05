package application;
import java.net.URL;
import java.util.ResourceBundle;

import com.IsteMySQL.Util.VeirtabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.sql.*;

public class musterileriListele_SampleController {
	private static final String String=null;
	public musterileriListele_SampleController(){
		baglanti=VeirtabaniUtil.Baglan();
	}
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	String sql;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_guncelle;

    @FXML
    private Button btn_listele;

    @FXML
    private Button btn_sil;

    @FXML
    private TableView<Kayitlar_musteri> table;

    @FXML
    private TableColumn<Kayitlar_musteri, Integer> tbl_id;

    @FXML
    private TableColumn<Kayitlar_musteri, String> tbl_kullaniciAdi;

    @FXML
    private TableColumn<Kayitlar_musteri, String> tbl_sifre;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_kullaniciAdi;

    @FXML
    private TextField txt_sifre;
    
    
    public void DegerleriGetir(TableView tablo) {
    	sql="select*from kullanici";
    	ObservableList<Kayitlar_musteri>kayitlarliste=FXCollections.observableArrayList();
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		while(getirilen.next())
    		{
    			kayitlarliste.add(new Kayitlar_musteri(getirilen.getInt("kId"),getirilen.getString("kullanici_adi"),getirilen.getString("sifre")));
    			
    		}
    		tbl_id.setCellValueFactory(new PropertyValueFactory<>("kId"));
    		tbl_kullaniciAdi.setCellValueFactory(new PropertyValueFactory<>("kullanici_adi"));
    		tbl_sifre.setCellValueFactory(new PropertyValueFactory<>("sifre"));
    		table.setItems(kayitlarliste);
    		
    		
    		
    		
    		
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage().toString());
    		
    	}
    }
    

    @FXML
    void btn_ekle_click(ActionEvent event) {
    	sql="insert into kullanici(kId,kullanici_adi,sifre) values(?,?,?)";
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, txt_id.getText().trim());
    		sorguIfadesi.setString(2, txt_kullaniciAdi.getText().trim());
    		sorguIfadesi.setString(3,VeirtabaniUtil.MD5Sifrele(txt_sifre.getText().trim())) ;
    		sorguIfadesi.executeUpdate();
    		Alert alert=new Alert(AlertType.INFORMATION);
    		alert.setTitle("Otogaleri Otomasyonu");
    		alert.setHeaderText("Bilgi Mesajý");
    		alert.setContentText("Müþteri Ekleme Ýþlemi Baþarýlý");
    		alert.showAndWait();
    		
    		
    		
    	}catch(Exception e) {
    		System.out.println(e.getMessage().toString());
    	}

    }

    @FXML
    void btn_guncelle_click(ActionEvent event) {
    	
    	//guncelleme islemi yapmýyor
    	sql="UPDATE kullanici SET kullanici_adi=?,sifre=? WHERE kId=?";
    	baglanti=VeirtabaniUtil.Baglan();
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    	
    		sorguIfadesi.setString(3,txt_id.getText().trim()) ;
    		sorguIfadesi.setString(1, txt_kullaniciAdi.getText().trim());
    		sorguIfadesi.setString(2,VeirtabaniUtil.MD5Sifrele( txt_sifre.getText().trim()));
    		sorguIfadesi.executeUpdate();
    		Alert alert=new Alert(AlertType.INFORMATION);
    		alert.setTitle("Otogaleri Otomasyonu");
    		alert.setHeaderText("Bilgi Mesajý");
    		alert.setContentText("Güncelleme Ýþlemi Baþarýlý");
    		alert.showAndWait();
    		
    		
    		
    		
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage().toString());
    		
    	}
    	
    	

    }

    @FXML
    void btn_listele_click(ActionEvent event) {
    	DegerleriGetir(table);

    }

    @FXML
    void btn_mause_click(MouseEvent event) {
    	Kayitlar_musteri kayit=new Kayitlar_musteri();
    	kayit=(Kayitlar_musteri)table.getItems().get(table.getSelectionModel().getSelectedIndex());
    	txt_id.setText(String.valueOf(kayit.getKId()));
    	txt_kullaniciAdi.setText(kayit.getKullanici_adi());
    	txt_sifre.setText(kayit.getSifre());
    	

    }

    @FXML
    void btn_sil_click(ActionEvent event) {
    	sql="delete from kullanici where kId=? and kullanici_adi=? and sifre=? ";
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, txt_id.getText().trim());
    		sorguIfadesi.setString(2, txt_kullaniciAdi.getText().trim());
    		sorguIfadesi.setString(3, txt_sifre.getText().trim());
    		sorguIfadesi.executeUpdate();
    		Alert alert=new Alert(AlertType.INFORMATION);
    		alert.setTitle("Otogaleri Otomasyonu");
    		alert.setHeaderText("Bilgi Mesajý");
    		alert.setContentText("Müþteri Silme Ýþlemi Baþarýlý");
    		alert.showAndWait();
    		
    		
    		
    	}catch(Exception e) {
    		System.out.println(e.getMessage().toString());
    	}

    	
    	

    }

    @FXML
    void initialize() {
    	DegerleriGetir(table);
    	
    	Tooltip tip=new Tooltip();
    	tip.setStyle("-fx-background-color;gray");
    	tip.setText("Müþteri Ekleme");
    	btn_ekle.setTooltip(tip);
    	
    	Tooltip tip1=new Tooltip();
    	tip1.setStyle("-fx-background-color;gray");
    	tip1.setText("Müþteri Silme");
    	btn_sil.setTooltip(tip1);
    	
    	Tooltip tip2=new Tooltip();
    	tip2.setStyle("-fx-background-color;gray");
    	tip2.setText("Müþteri Bilgileri Güncelleme");
    	btn_guncelle.setTooltip(tip2);
     
    	Tooltip tip3=new Tooltip();
    	tip3.setStyle("-fx-background-color;gray");
    	tip3.setText("Müþteri Tablosunu Listeleme");
    	btn_listele.setTooltip(tip3);
    }

}
