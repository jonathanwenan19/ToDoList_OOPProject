package sample;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;


public class alertbox
{
    public static void display(String title, String message)
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Please add full description");
        window.setWidth(250);


        Label label = new Label();
        label.setText("Make sure you fill in all the information");
        Button closebutton = new Button();
        closebutton.setText("Ok!");
        closebutton.setOnAction(e-> window.close());
        VBox layout = new VBox(5);
        layout.getChildren().addAll(label,closebutton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }
}
