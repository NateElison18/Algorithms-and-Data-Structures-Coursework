/**
 * Author: Nate Elison
 * Date: 7/12/23
 *
 * This program displays a gui that allows users to select a year, gender,
 * and enter a name to see if the name ranked in the top 1000 of baby names in the selected year.
 */

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.net.*;

public class Exercise21_11 extends Application {
    private static Map<String, Integer>[] mapForBoy = new HashMap[10];
    private static Map<String, Integer>[] mapForGirl = new HashMap[10];
    private static URL[] data = new URL[10];
    private static HashMap<Integer, Integer> yearMap = new HashMap<>();

    private Button btFindRanking = new Button("Find Ranking");
    private ComboBox<Integer> cboYear = new ComboBox<>();
    private ComboBox<String> cboGender = new ComboBox<>();
    private TextField tfName = new TextField();
    private Label lblResult = new Label();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)  throws IOException {
        buildURLArray();
        buildMapArrays();
        buildYearMap();

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Select a year:"), 0, 0);
        gridPane.add(new Label("Boy or girl?"), 0, 1);
        gridPane.add(new Label("Enter a name:"), 0, 2);
        gridPane.add(cboYear, 1, 0);
        gridPane.add(cboGender, 1, 1);
        gridPane.add(tfName, 1, 2);
        gridPane.add(btFindRanking, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(lblResult);
        BorderPane.setAlignment(lblResult, Pos.CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 370, 160);
        primaryStage.setTitle("Exercise21_11"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        for (int year = 2001; year <= 2010; year++) {
            cboYear.getItems().add(year);
        }
        cboYear.setValue(2001);

        cboGender.getItems().addAll("Male", "Female");
        cboGender.setValue("Male");

        // Actions
        btFindRanking.setOnAction(event -> {
            int yearIndex = yearMap.get(cboYear.getValue());
            String selectedGender = cboGender.getValue();
            String name = tfName.getText();
            String lowerCase = name.toLowerCase();
            if (mapForGirl[yearIndex].get(lowerCase) == null && mapForBoy[yearIndex].get(lowerCase) == null)
                lblResult.setText(name + " not found in the top 1000 baby names of " + cboYear.getValue());
            else {
                if (selectedGender.equals("Female"))
                    lblResult.setText("Girl name " + name + " is ranked #" + mapForGirl[yearIndex].get(lowerCase) + " in year " + cboYear.getValue());
                else
                    lblResult.setText("Boy name " + name + " is ranked #" + mapForBoy[yearIndex].get(lowerCase) + " in year " + cboYear.getValue());
            }

        });

    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static void buildMapArrays() throws IOException {
        for (int i = 0; i < 10; i++) {
            mapForBoy[i] = buildMaleMap(data[i]);
            mapForGirl[i] = buildFemaleMap(data[i]);
        }
    }

    public static void buildURLArray() throws MalformedURLException{
        for(int i = 0; i < 9; i++)
            data[i] = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking200" + (i + 1) + ".txt");
        data[9] = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking2010.txt");
    }

    public static HashMap<String, Integer> buildMaleMap(URL url) throws IOException {
        Scanner input = new Scanner(url.openStream());
        HashMap<String, Integer> map = new HashMap<>();

        while(input.hasNext()) {
            int value  = input.nextInt();
            String key = input.next();
            key = key.toLowerCase();
            map.put(key, value);
            input.nextLine();
        }

        return map;
    }

    public static HashMap<String, Integer> buildFemaleMap(URL url) throws IOException {
        Scanner input = new Scanner(url.openStream());
        HashMap<String, Integer> map = new HashMap<>();

        while(input.hasNext()) {
            int value  = input.nextInt();
            input.next();
            input.next();
            String key = input.next();
            key = key.toLowerCase();
            map.put(key, value);
            input.nextLine();
        }
        return map;
    }

    public static void buildYearMap() {
        for(int i = 0; i < 10; i++) {
            int year = 2001 + i;
            yearMap.put(year, i);
        }
    }
}