package myChatApp;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class MyChatController {
    private List<String> history = new ArrayList<>();
    @FXML
    private VBox messageContainer;
    @FXML
    private TextField chatInput = new TextField();

    @FXML
    private ScrollPane scrollPane = new ScrollPane();

    @FXML
    public void initialize() {
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        messageContainer.getChildren().add(CreateMessChildren("Chán đời quá a ạ", "/img/avt.jpg"));
        messageContainer.getChildren().add(CreateMessChildren_Noimg("Sao thế"));
        messageContainer.getChildren().add(CreateMessChildren("Làm nội dung thuyết trình", "/img/avt.jpg"));
        messageContainer.getChildren().add(CreateMessChildren("E góp ý thì chả nghe", "/img/avt.jpg"));
        messageContainer.getChildren().add(CreateMessChildren("=)) cái tôi cao quá", "/img/avt.jpg"));
        messageContainer.getChildren().add(CreateMessChildren("Còn nữa. Ko thích làm chung với mấy bạn chỉ đi làm thêm tối ngày", "/img/avt.jpg"));
        messageContainer.getChildren().add(CreateMessChildren("=)))", "/img/avt.jpg"));


        slowScrollToBottom(scrollPane);
        printHis();
    }

    public static void slowScrollToBottom(ScrollPane scrollPane) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1.5), new KeyValue(scrollPane.vvalueProperty(), 1))
        );
        timeline.play();
    }

    @FXML
    public HBox CreateMessChildren(String text, String path_img) {
        Label messageLabel = new Label(text);
        messageLabel.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-padding: 10;");
        messageLabel.setWrapText(true);
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(path_img)));
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        Circle circle = new Circle(10); // 50 là bán kính của hình tròn
        circle.setCenterX(10);
        circle.setCenterY(10);
        imageView.setClip(circle);
        HBox hbox = new HBox(imageView, messageLabel);
        hbox.setMaxWidth(260);
        hbox.setSpacing(5.0);
        return hbox;
    }

    @FXML
    public HBox CreateMessChildren_Noimg(String text) {
        Label messageLabel = new Label(text);
        messageLabel.setStyle("-fx-border-color: black; -fx-border-radius: 10; -fx-padding: 10");
        messageLabel.setWrapText(true);
        Region spacer = new Region(); // Tạo một thành phần trống
        messageLabel.setMaxWidth(260);
        HBox hbox = new HBox(spacer, messageLabel);
        hbox.setPrefWidth(390);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return hbox;
    }



    @FXML
    public void sendMessage() {
        String text = chatInput.getText();
        history.add(text);
        HBox hbox = CreateMessChildren_Noimg(text);
        messageContainer.getChildren().add(hbox);
        chatInput.clear();
        slowScrollToBottom(scrollPane);
    }

    void printHis() {
        for(String x : history) System.out.println(x + "\n");
    }
}
