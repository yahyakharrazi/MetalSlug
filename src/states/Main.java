package states;


import java.io.File;

//import LigneCommande.FormVent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jeu.programme;

public class Main extends Application  {

	Stage s1;
	private double width=800;
	private double hight=600;
	//Media media =new Media(new File("file:Kalimba.mp3"));


	//Methods

	@Override
	public void start(Stage primaryStage){
	try {
	Pane p= new Pane();

	final File file = new File("C:\\Users\\Public\\Music\\Sample Music\\Kalimba.mp3");
	final Media media = new Media(file.toURI().toString());
	final MediaPlayer mediaPlayer = new MediaPlayer(media);
//	mediaPlayer.play();

	Image image = new Image("file:pics/metal.png");
	Image image1 = new Image("file:pics/start.png");
//	Image image1 = new Image("file:slug.png");

	ImageView mv = new ImageView(image);
	ImageView mv1 = new ImageView(image1);

	mv.setFitHeight(hight-300);
	mv.setFitWidth(width);
	mv.setImage(image);
	mv1.setImage(image1);


	mv1.setFitHeight(50);
	mv1.setFitWidth(240);
	mv1.setLayoutX(300);
	mv1.setLayoutY(400);
	mv1.setStyle("-fx-background-color: black");


//p.getChildren().add(mv);

	mv1.setOnMouseClicked((MouseEvent event) -> {
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			programme c4= new programme();
			s1.close();
			try {
				c4.start(new Stage());
			//c2.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	   }



	});

	p.getChildren().addAll(mv, mv1);
	p.setStyle("-fx-background-color: black");
	Scene scene = new Scene(p,width,hight);
	primaryStage.setScene(scene);

	primaryStage.show();
	s1=primaryStage;



}
	catch (Exception e) {
		e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}