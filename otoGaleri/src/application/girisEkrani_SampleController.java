package application;

import java.net.URL;


import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;



public class girisEkrani_SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_iletisim;

    @FXML
    private Button btn_musteriGirisi;

    @FXML
    private Button btn_personelGirisi;
  
   
    @FXML
    void btn_cikis_click(ActionEvent event) {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Otogaleri Otomasyonu");
    	alert.setHeaderText("Çýkýþ");
    	alert.setContentText("Çýkmak istediðinizden emin misiniz?");
    	
    	ButtonType buton1=new ButtonType("Evet");
    	ButtonType buton2=new ButtonType("Hayýr");
    	alert.getButtonTypes().setAll(buton1,buton2);
    	Optional<ButtonType> sonuc=alert.showAndWait();
    	
    	if(sonuc.get()==buton1) {
    		Platform.exit();
    		
    	}
    	else if(sonuc.get()==buton2) {
    		System.out.println("Ýþlem iptal edildi.");	
    	}

    }

    @FXML
    void btn_iletisim_click(ActionEvent event) {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Otogaleri Otomasyonu");
    	alert.setHeaderText("Ýletiþim Bilgileri");
    	alert.setContentText("Telefon: 0540 500 00 80 "+"     "+
    	"Mail: nyucel.mdbf19@iste.edu.tr");
    	
    	
    	alert.showAndWait();
    	
    	

    }

    @FXML
    void btn_musteriGirisi_click(ActionEvent event) {
    	   try {
   	    	Parent root = FXMLLoader.load(getClass().getResource("musteriGirisEkran.fxml"));
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
    void btn_personelGirisi_click(ActionEvent event) {
    	    try {
    	    	Parent root = FXMLLoader.load(getClass().getResource("personelGirisEkrani.fxml"));
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
    	Tooltip tip=new Tooltip();
    	tip.setStyle("-fx-background-color;gray");
    	tip.setText("Personel Giriþ Sayfasý");
    	btn_personelGirisi.setTooltip(tip);
    	
    	Tooltip tip1=new Tooltip();
    	tip1.setStyle("-fx-background-color;gray");
    	tip1.setText("Müþteri Giriþ Sayfasý");
    	btn_musteriGirisi.setTooltip(tip1);
    	
    	Tooltip tip2=new Tooltip();
    	tip2.setStyle("-fx-background-color;gray");
    	tip2.setText("Ýletiþim Bilgileri");
    	btn_iletisim.setTooltip(tip2);
    	
    	Tooltip tip3=new Tooltip();
    	tip3.setStyle("-fx-background-color;gray");
    	tip3.setText("Programdan Çýkýþ");
    	btn_cikis.setTooltip(tip3);
    	
    	
    	
    	
      

    }

}
