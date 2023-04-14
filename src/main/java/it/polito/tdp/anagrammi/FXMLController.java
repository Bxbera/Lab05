package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import it.polito.tdp.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private Button btnClearText;

    @FXML
    private TextArea txtResultCorrect;

    @FXML
    private TextArea txtResultErrors;

    @FXML
    private Label txtTempoEsecuzione;

    @FXML
    private TextField txtWord;

    @FXML
    void doClearText(ActionEvent event) {
    	this.txtResultCorrect.clear();
    	this.txtResultErrors.clear();
    	this.txtWord.clear();
    	this.txtWord.setDisable(false);
    	this.btnCalcolaAnagrammi.setDisable(false);
    }

    @FXML
    void doAnagrammi(ActionEvent event) {
    	String word = this.txtWord.getText();
    	
    	long a = System.currentTimeMillis();
    	List<String> words = model.getAnagrammi(word);
    	List<RichWord> richWords = model.getRichWord(words);
    	for(RichWord rw : richWords) {
    		if(rw.isCorretta()) {
    			this.txtResultCorrect.appendText(rw.getParola()+"\n");
    		}
    		else {
    			this.txtResultErrors.appendText(rw.getParola()+"\n");
    		}
    	}
    	long b = System.currentTimeMillis();
    	
    	this.txtTempoEsecuzione.setText("tempo esecuzione: " + (b-a));
    	
    	this.txtWord.setDisable(true);
    	this.btnCalcolaAnagrammi.setDisable(true);
    }

    public void setModel(Model model) {
    	this.model = model;
    }
    @FXML
    void initialize() {
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResultCorrect != null : "fx:id=\"txtResultCorrect\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResultErrors != null : "fx:id=\"txtResultErrors\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempoEsecuzione != null : "fx:id=\"txtTempoEsecuzione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}


