package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class MainViewController implements Initializable {

	@FXML
	private TextField txtPathIn;

	@FXML
	private TextField txtPathOut;

	@FXML
	private Button btOpenFile;

	@FXML
	private Button btSaveAs;
	
	@FXML
	private Button btShuffle;

	@FXML
	private Button btSave;

	@FXML
	private Label labelErrorOpenFile;

	@FXML
	private Label labelErrorSaveAs;

	@FXML
	public void onBtOpenFileAction() {
		System.out.println("onBtOpenFileAction");
	}
	
	@FXML
	public void onBtSaveAsAction() {
		System.out.println("onBtSaveAsAction");
	}
	
	@FXML
	public void onBtShuffleAction() {
		System.out.println("onBtShuffleAction");
		String pathIn = txtPathIn.getText().toString();

		try (BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
			String line = br.readLine();
			Integer lineCount = 1;
			
			Map<String, Integer> itemsList = new HashMap<>();
			while (line != null) {
				itemsList.keySet().add(line);
				System.out.println(line);
				line = br.readLine();
				lineCount += 1;
				
			}

		} catch (FileNotFoundException e) {
			Alerts.showAlerts("File Not Found", null, e.getMessage(), AlertType.ERROR);
		} catch (IOException e) {
			Alerts.showAlerts("IO Error", null, e.getMessage(), AlertType.ERROR);
		}
		
		
	}
	
	@FXML
	public void onBtSaveAction() {
		System.out.println("onBtSaveAction");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}

}
