module com.example.mychat {
    requires javafx.controls;
    requires javafx.fxml;


    opens myChatApp to javafx.fxml;
    exports myChatApp;
}