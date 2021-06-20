package sample;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;

public class Todo
{

    public static void Display()
    {


        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Todolist (Adding the action)");
        window.setWidth(1000);
        window.setHeight(1000);

        // header input
        Label HeaderLabel = new Label("Header");
        TextField HeaderInput = new TextField();
        HeaderInput.setMaxWidth(300);
        HeaderInput.setPromptText("Header");

        //Date input
        TextField DateInput = new TextField();
        DateInput.setMaxWidth(200);
        DateInput.setPromptText("Date");

        // Body input
        TextField BodyInput = new TextField();
        BodyInput.setMaxWidth(500);
        BodyInput.setPromptText("Info");

        Button button_header = new Button();
        button_header.setText("Add");
        button_header.setOnAction(e->
        {

        }
        );

        // information

        VBox all = new VBox(20);
        all.getChildren().addAll(HeaderInput,BodyInput,BodyInput);



        Scene scene = new Scene(all);
        window.setScene(scene);
        window.showAndWait();
    }


}
