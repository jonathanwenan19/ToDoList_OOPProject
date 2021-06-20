package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmButton
{
    static boolean confirm ;
    public static void display(String title, String smallinfo)
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Close?");
        window.setWidth(250);


        HBox optionarea = new HBox(2);
        Label label = new Label();
        label.setText("Are you sure you want to close the program?");
        Button yesbutton = new Button();
        yesbutton.setText("Yes");
        yesbutton.setOnAction(e->
        {

            System.out.println("All windows closed!");
            window.close();
            Main.window.close();
        });
        Button NoButton = new Button();
        NoButton.setText("No");
        NoButton.setOnAction(e-> window.close());
        VBox layout = new VBox(5);
        optionarea.getChildren().addAll( yesbutton,NoButton);
        optionarea.setAlignment(Pos.CENTER);

        VBox wholething = new VBox(2);
        wholething.getChildren().addAll(label,optionarea);

        Scene scene = new Scene(wholething,250,250);
        window.setScene(scene);
        window.showAndWait();
    }

}
