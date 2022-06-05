package application;

import java.net.URL;

import java.util.ResourceBundle;

import com.IsteMySQL.Util.VeirtabaniUtil;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.*;


public class personelAnaEkran_SampleController {
	private static final String String = null;
	public personelAnaEkran_SampleController(){
		baglanti=VeirtabaniUtil.Baglan();
	}


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Kayitlar_arac, Integer> btl_km;

    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_guncelle;

    @FXML
    private Button btn_listele;

    @FXML
    private Button btn_musteriListele;

    @FXML
    private Button btn_sil;

    @FXML
    private ImageView image_personel;

    @FXML
    private TableView<Kayitlar_arac> table;

    @FXML
    private TableColumn<Kayitlar_arac, Integer> tbl_durum;

    @FXML
    private TableColumn<Kayitlar_arac, Integer> tbl_fiyat;

    @FXML
    private TableColumn<Kayitlar_arac, Integer> tbl_id;

    @FXML
    private TableColumn<Kayitlar_arac, String> tbl_kasaTipi;

    @FXML
    private TableColumn<Kayitlar_arac, String> tbl_marka;

    @FXML
    private TableColumn<Kayitlar_arac, String> tbl_model;

    @FXML
    private TableColumn<Kayitlar_arac, String> tbl_vites;

    @FXML
    private TableColumn<Kayitlar_arac, String> tbl_yakit;

    @FXML
    private TableColumn<Kayitlar_arac, Integer> tbl_yil;

    @FXML
    private TextField txt_durum;

    @FXML
    private TextField txt_fiyat;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_kasaTipi;

    @FXML
    private TextField txt_km;

    @FXML
    private TextField txt_marka;

    @FXML
    private TextField txt_model;

    @FXML
    private TextField txt_vites;

    @FXML
    private TextField txt_yakit;

    @FXML
    private TextField txt_yil;
    
    Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	String sql;
	
	 public void DegerleriGetir(TableView tablo) {
	    	sql="select*from arac";
	    	ObservableList<Kayitlar_arac>kayitlarliste=FXCollections.observableArrayList();
	    	try {
	    		sorguIfadesi=baglanti.prepareStatement(sql);
	    	    ResultSet getirilen=sorguIfadesi.executeQuery();
	    	    
	    	    while(getirilen.next())
	    	    {
	    	    	kayitlarliste.add(new Kayitlar_arac(getirilen.getInt("aId"),getirilen.getString("marka"),getirilen.getString("model"), getirilen.getInt("durum"), getirilen.getInt("yil"), getirilen.getString("yakit"), getirilen.getString("vites"), getirilen.getInt("km"), getirilen.getString("kasaTipi"), getirilen.getInt("fiyat")));
	    	    	
	    	    }
	    	    tbl_id.setCellValueFactory(new PropertyValueFactory<>("aId"));
	    		tbl_marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
	    		tbl_model.setCellValueFactory(new PropertyValueFactory<>("model"));
	    		tbl_durum.setCellValueFactory(new PropertyValueFactory<>("durum"));
	    		tbl_yil.setCellValueFactory(new PropertyValueFactory<>("yil"));
	    		tbl_yakit.setCellValueFactory(new PropertyValueFactory<>("yakit"));
	    		tbl_vites.setCellValueFactory(new PropertyValueFactory<>("vites"));
	    		btl_km.setCellValueFactory(new PropertyValueFactory<>("km"));
	    		tbl_kasaTipi.setCellValueFactory(new PropertyValueFactory<>("kasaTipi"));
	    		tbl_fiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
	    		table.setItems(kayitlarliste);
	    	    
	    	
	    	}catch(Exception e) {
	    		System.out.println(e.getMessage().toString());
	    		
	    	}
	    		
	    	
	    }
	 
	 

    @FXML
    void btn_ekle_click(ActionEvent event) {
    	sql="insert into arac(aId,marka,model,durum,yil,yakit,vites,km,kasaTipi,fiyat) values (?,?,?,?,?,?,?,?,?,?) ";
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1,txt_id.getText().trim());
    		sorguIfadesi.setString(2,txt_marka.getText().trim());
    		sorguIfadesi.setString(3,txt_model.getText().trim());
    		sorguIfadesi.setString(4,txt_durum.getText().trim());
    		sorguIfadesi.setString(5,txt_yil.getText().trim()) ;
    		sorguIfadesi.setString(6,txt_yakit.getText().trim());
    		sorguIfadesi.setString(7,txt_vites.getText().trim());
    		sorguIfadesi.setString(8,txt_km.getText().trim());
    		sorguIfadesi.setString(9,txt_kasaTipi.getText().trim());
    		sorguIfadesi.setString(10,txt_fiyat.getText().trim());
    		sorguIfadesi.executeUpdate();
    		
    		Alert alert=new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Otogaleri Otomasyonu");
	    	alert.setHeaderText("Bilgi Mesajý");
	    	alert.setContentText("Ürün Ekleme Ýþlemi Baþarýlý!");
	    	alert.showAndWait();
    		
    		
    		
    	}catch(Exception e) {
    		System.out.println(e.getMessage().toString());
    		
    	}
    	
    	
    	

    }

    @FXML
    void btn_guncelle_click(ActionEvent event) {
    	
    	// guncellenme islemi olmuyor.
    	
    	sql="UPDATE arac SET marka=?,model=?,durum=?,yil=?,yakit=?,vites=?,km=?,kasaTipi=?,fiyat=? WHERE aId=? ";
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    	
    		
    		//sorguIfadesi.setString(1,txt_id.getText().trim());
    		sorguIfadesi.setString(1,txt_marka.getText().trim());
    		sorguIfadesi.setString(2,txt_model.getText().trim());
    		sorguIfadesi.setString(3,txt_durum.getText().trim());
    		sorguIfadesi.setString(4,txt_yil.getText().trim()) ;
    		sorguIfadesi.setString(5,txt_yakit.getText().trim());
    		sorguIfadesi.setString(6,txt_vites.getText().trim());
    		sorguIfadesi.setString(7,txt_km.getText().trim());
    		sorguIfadesi.setString(8,txt_kasaTipi.getText().trim());
    		sorguIfadesi.setString(9,txt_fiyat.getText().trim());
    		sorguIfadesi.setString(10, txt_id.getText().trim());
    		
    		
    		sorguIfadesi.executeUpdate();//silme,guncelleme,ekleme

    		Alert alert=new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Otogaleri Otomasyonu");
	    	alert.setHeaderText("Bilgi Mesajý");
	    	alert.setContentText("Güncelleme Baþarýlý!");
	    	alert.showAndWait();
    		
    	}catch(Exception e) {
    		System.out.println(e.getMessage().toString());
    		
    		
    	}

    }









	@FXML
    void btn_listele_click(ActionEvent event) {
		DegerleriGetir(table);

    }

    @FXML
    void btn_sil_click(ActionEvent event) {
    	sql="delete from arac where aId=? and marka=? and model=? and durum=? and yil=? and yakit=? and vites=? and km=? and kasaTipi=? and fiyat=?";
    	try {
    		
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1,txt_id.getText().trim());
    		sorguIfadesi.setString(2,txt_marka.getText().trim());
    		sorguIfadesi.setString(3,txt_model.getText().trim());
    		sorguIfadesi.setString(4,txt_durum.getText().trim());
    		sorguIfadesi.setString(5,txt_yil.getText().trim()) ;
    		sorguIfadesi.setString(6,txt_yakit.getText().trim());
    		sorguIfadesi.setString(7,txt_vites.getText().trim());
    		sorguIfadesi.setString(8,txt_km.getText().trim());
    		sorguIfadesi.setString(9,txt_kasaTipi.getText().trim());
    		sorguIfadesi.setString(10,txt_fiyat.getText().trim());
    		
    		sorguIfadesi.executeUpdate();
    		
    		Alert alert=new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Otogaleri Otomasyonu");
	    	alert.setHeaderText("Bilgi Mesajý");
	    	alert.setContentText("Silme Ýþlemi Baþarýlý!");
	    	alert.showAndWait();
    		
    	
    	}catch(Exception e) {
    		System.out.println(e.getMessage().toString());
    		
    		
    	}
    	
    	

    }

    @FXML
    void table_mause_click(MouseEvent event) {
     	Kayitlar_arac kayit=new Kayitlar_arac();
    	kayit=(Kayitlar_arac) table.getItems().get(table.getSelectionModel().getSelectedIndex());
    	txt_id.setText(String.valueOf(kayit.getAId()));
    	txt_marka.setText(kayit.getMarka());
    	txt_model.setText(kayit.getModel());
    	txt_durum.setText(String.valueOf(kayit.getDurum()));
    	txt_yil.setText(String.valueOf(kayit.getYil()));
    	txt_yakit.setText(kayit.getYakit());
    	txt_vites.setText(kayit.getVites());
    	txt_km.setText(String.valueOf(kayit.getKm()));
    	txt_kasaTipi.setText(kayit.getKasaTipi());
    	txt_fiyat.setText(String.valueOf(kayit.getFiyat()));
    	

    }
    @FXML
    void btn_cikis_click(ActionEvent event) {
    	Platform.exit();

    }
    @FXML
    void btn_musteriListele_click(ActionEvent event) {
    	 try {
    	    	Parent root = FXMLLoader.load(getClass().getResource("musterileriListele.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
           
                scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                stage.setScene(scene);
                stage.show();
    	    	
    	    }catch(Exception e) {
    	    	System.out.println(e.getMessage().toString());
    	    	
    	    }

    }

    @FXML
    void initialize() {
    	DegerleriGetir(table);
       
    	Tooltip tip=new Tooltip();
    	tip.setStyle("-fx-background-color;gray");
    	tip.setText("Müþterileri Listeler");
    	btn_musteriListele.setTooltip(tip);
    	
    	Tooltip tip1=new Tooltip();
    	tip1.setStyle("-fx-background-color;gray");
    	tip1.setText("Programdan Çýkýþ");
    	btn_cikis.setTooltip(tip1);
    }

}