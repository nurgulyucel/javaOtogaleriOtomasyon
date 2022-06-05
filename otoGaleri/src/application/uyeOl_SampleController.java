package application;

import java.net.URL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.IsteMySQL.Util.VeirtabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.*;

public class uyeOl_SampleController {
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	String sql;
	public uyeOl_SampleController(){
		baglanti=VeirtabaniUtil.Baglan();
	}
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_tum;

    @FXML
    private AnchorPane anchor_yan;

    @FXML
    private Button btn_uyeOl;

    @FXML
    private Button btn_yanEkranGetir;

    @FXML
    private ImageView image;

    @FXML
    private ImageView image2;

    @FXML
    private TextField txt_ad;

    @FXML
    private TextField txt_kullaniciAdi;


    @FXML
    private PasswordField txt_password;

    @FXML
    private TextField txt_soyad;

    @FXML
    void btn_uyeOl_click(ActionEvent event) {
    	sql="insert into kullanici(kullanici_adi,sifre) values (?,?)";
    	
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		
    		sorguIfadesi.setString(1,txt_kullaniciAdi.getText().trim());
    		sorguIfadesi.setString(2,VeirtabaniUtil.MD5Sifrele(txt_password.getText().trim()));
    		sorguIfadesi.executeUpdate();
    		
    		
    		Alert alert=new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Otogaleri Otomasyonu");
	    	alert.setHeaderText("Kayýt Baþarýlý!");
	    	alert.setContentText("Sisteme hoþ geldiniz.");
	    	alert.showAndWait();
    		
    		
    		
    		
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage().toString());
    		
    	}
    	

    }

    @FXML
    void btn_yanEkranGetir_click(ActionEvent event) {
    	try {
    		 Parent root = FXMLLoader.load(getClass().getResource("musteriGirisEkran.fxml"));
             Stage stage = new Stage();
             Scene scene = new Scene(root);
       
             scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
             stage.setScene(scene);
             stage.show();
    		
    	}catch(Exception e) {
    	
    	}
    	
     
    }

    @FXML
    void initialize() {
      

    }

}

