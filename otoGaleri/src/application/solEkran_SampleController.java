package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;

public class solEkran_SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_hakkimizda;

    @FXML
    private Button btn_iletisim;

    @FXML
    private ImageView image;

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
    void btn_hakkimizda_click(ActionEvent event) {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Otogaleri Otomasyonu");
    	alert.setHeaderText("Hakkýmýzda");
    	alert.setContentText("Bu proje 2022 JavaFx dersi için yapýlmýþtýr. ");
    	alert.showAndWait();
    	

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
    void initialize() {
        assert btn_cikis != null : "fx:id=\"btn_cikis\" was not injected: check your FXML file 'solEkran.fxml'.";
        assert btn_hakkimizda != null : "fx:id=\"btn_hakkimizda\" was not injected: check your FXML file 'solEkran.fxml'.";
        assert btn_iletisim != null : "fx:id=\"btn_iletisim\" was not injected: check your FXML file 'solEkran.fxml'.";
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'solEkran.fxml'.";

    }

}

