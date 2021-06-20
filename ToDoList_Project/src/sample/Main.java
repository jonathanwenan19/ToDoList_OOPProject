package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;

import javafx.scene.layout.VBox;

public class Main extends Application
{
    Button button_add, button_delete, button_add2, button_close,add_info, button_info;
    static Stage window;
    Scene main, added, input,layout_aboutus;
    TextField HeaderInput, DateInput, InfoInput;

    TableView<Data> Table;

    public ObservableList<Data> getDatabase()
    {
        ObservableList<Data> data = FXCollections.observableArrayList();
        data.add(new Data("Action 1","January 1 2021", "Please help Mr.Jude"));
        return data;
    }

    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // starting the stage
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ToDo List");
        button_add = new Button();
        button_add.setText("Add");
        button_add.setOnAction(e->
        {
           window.setScene(input);
           System.out.println("Added");
        });
        button_delete = new Button();
        button_delete.setText("Delete");
        button_delete.setOnAction(e-> {
            delete_func();
            System.out.println("Action Deleted");
        });
        Label AskAction = new Label("What do you want to do?");

        window.setOnCloseRequest(e->
        {
            e.consume();
            closeProgram();
        });

        button_close = new Button();
        button_close.setOnAction(e->
        {
            ConfirmButton.display("Close","Hello");
        });
        button_close.setText("Close");

        //Table of actions
        // For the heading
        TableColumn<Data, String> HeadingColumn = new TableColumn<>("Heading");
        HeadingColumn.setMaxWidth(300);
        HeadingColumn.setCellValueFactory(new PropertyValueFactory<>("header"));

        //For the Date
        TableColumn<Data, String> DateColumn = new TableColumn<>("Date");
        DateColumn.setMaxWidth(200);
        DateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        //For the information of the to do list
        TableColumn<Data, String> BodyColumn = new TableColumn<>("Body");
        BodyColumn.setMaxWidth(500);
        BodyColumn.setCellValueFactory(new PropertyValueFactory<>("info"));

        Table = new TableView<>();
        Table.setItems(getDatabase());
        Table.getColumns().addAll(HeadingColumn,DateColumn,BodyColumn);

        button_info = new Button();
        button_info.setText("About me");
        button_info.setOnAction(e->{});

        // main page
        VBox layout1 = new VBox(20);
        layout1.setSpacing(10);
        layout1.setPadding(new Insets(20,20,20,20));
        layout1.setAlignment(Pos.TOP_CENTER);
        layout1.getChildren().addAll(AskAction,button_add,button_delete,button_close, button_info, Table);
        main = new Scene(layout1,1000,1000);
        primaryStage.setScene(main);
        primaryStage.show();

        // second page
        HeaderInput = new TextField();
        HeaderInput.setMaxWidth(300);
        HeaderInput.setPromptText("Header");

        //Date input
        DateInput = new TextField();
        DateInput.setMaxWidth(200);
        DateInput.setPromptText("Date");

        // Body input
        InfoInput = new TextField();
        InfoInput.setMaxWidth(500);
        InfoInput.setPromptText("Info");

        add_info = new Button();
        add_info.setText("Add info");
        add_info.setOnAction(e->
        {
            alertbox.display("Hello","Reminder");
            add_information();
            window.setScene(main);
        });




        // information
        VBox all = new VBox(20);
        all.getChildren().addAll(HeaderInput,DateInput,InfoInput,add_info);
        input = new Scene(all,500,500);

        // the window where we can add the description, date and subject of the activity
        //Label Name = new Label("Producer: Jonathan Wenan");
        //Label DOC = new Label("Date of creation: April - June 2021 ");


        //button_add2 = new Button();
        //button_add2.setText("Add");
        //button_add2.setOnAction(new EventHandler<ActionEvent>() {
         //   @Override
          //  public void handle(ActionEvent actionEvent) {
            //    window.setScene(main);
              //  alertbox.display("Title","Hello World!");
           // }
        //});
        //VBox layout2 = new VBox(20);
        //added = new Scene(layout2,1000,1000);
        //layout2.getChildren().addAll(Name, DOC, button_add2);
        //layout_aboutus = new Scene(layout2,500,500);


        window.setScene(main);
        window.setTitle("TodoList");
        window.show();
    }

    public void delete_func()
    {
        ObservableList<Data> productedSelected , AllProducts;
        AllProducts = Table.getItems();
        productedSelected = Table.getSelectionModel().getSelectedItems();
        productedSelected.forEach(AllProducts::remove);
    }

    public void add_information()
    {
        Data data = new Data("","","");
        data.setHeader(HeaderInput.getText());
        data.setDate(DateInput.getText());
        data.setInfo(InfoInput.getText());
        Table.getItems().add(data);
        HeaderInput.clear();
        DateInput.clear();
        InfoInput.clear();
    }
    private void closeProgram()
    {
        System.out.println("Application is closed!");
        window.close();
    }
}
