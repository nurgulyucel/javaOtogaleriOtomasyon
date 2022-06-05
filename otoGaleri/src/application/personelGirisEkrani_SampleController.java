package application;

import java.net.URL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import com.IsteMySQL.Util.VeirtabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class personelGirisEkrani_SampleController {
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	String sql;
	public personelGirisEkrani_SampleController(){
		baglanti=VeirtabaniUtil.Baglan();
	}
	

	  @FXML
	    private AnchorPane anchor_tum;

	    @FXML
	    private AnchorPane anchor_yan;

	    @FXML
	    private Button btn_girisYap;

	    @FXML
	    private Button btn_yanGetir;

	    @FXML
	    private ImageView image;

	    @FXML
	    private TextField txt_kullaniciAdi;

	    @FXML
	    private PasswordField txt_password;
	    

    @FXML
    void btn_girisYap_click(ActionEvent event) {
    	
    	sql="select*from personel where kullanici_adi=? and sifre=?";
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, txt_kullaniciAdi.getText().trim());
    		sorguIfadesi.setString(2,txt_password.getText().trim()) ;
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		if(!getirilen.next())
    		{
    			//alert
    			Alert alert=new Alert(AlertType.WARNING);
    	    	alert.setTitle("Otogaleri Otomasyonu");
    	    	alert.setHeaderText("Yeniden Deneyiniz!");
    	    	alert.setContentText("Hatalý kullanýcý adý veya þifre!");
    	    	alert.showAndWait();
    			
    		}
    		else {
    			getirilen.getString(3);
    			System.out.println("pId:"+getirilen.getString("pId"));
    			//alert yap .
    			Alert alert=new Alert(AlertType.INFORMATION);
    	    	alert.setTitle("Otogaleri Otomasyonu");
    	    	alert.setHeaderText("Giriþ Baþarýlý!");
    	    	alert.setContentText("Sisteme hoþ geldiniz.");
    	    	
    	    	Optional<ButtonType> result=alert.showAndWait();;
    	    	if (result.isPresent() && result.get()==ButtonType.OK)
       	    	{
       	    		  Parent root = FXMLLoader.load(getClass().getResource("personelAnaEkran.fxml"));
       	                Stage stage = new Stage();
       	                Scene scene = new Scene(root);
      	            
       	             scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
       	                stage.setScene(scene);
       	                stage.show();   
       	        }
    		}
    	}
    		
    		catch(Exception e) {
        		System.out.println(e.getMessage().toString());
        	}
        
    	}

    @FXML
    void btn_yanGetir_Click(ActionEvent event) {
    	try {
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("solEkran.fxml"));
    		anchor_yan.getChildren().setAll(pane1);
    		
    	}catch(Exception e) {
    		
    	}

    }

    @FXML
    void initialize() {
    	Tooltip tip=new Tooltip();
    	tip.setStyle("-fx-background-color;gray");
    	tip.setText("Hýzlý Ýþlemler");
    	btn_yanGetir.setTooltip(tip);

    }

}
