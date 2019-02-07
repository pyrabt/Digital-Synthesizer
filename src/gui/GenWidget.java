package gui;

import audio.AudioClip;
import audio.Source;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public abstract class GenWidget {
	
	protected Source wave;
	protected GridPane widget;
	protected Circle OutputJack;
	private double xPos;
	private double yPos;
	
	public GenWidget(String title) {
		widget = new GridPane();
		Text newTitle = new Text(title);
		OutputJack = new Circle(10,10,10);
		OutputJack.setFill(javafx.scene.paint.Color.YELLOW);
		OutputJack.setStroke(javafx.scene.paint.Color.BLACK);
		widget.add(OutputJack, 3, 1);
		widget.add(newTitle, 0, 0);
		widget.setStyle("-fx-border-color: black");
		
		widget.setOnMousePressed(e -> {
		        xPos = widget.getLayoutX() - e.getSceneX();
		        yPos = widget.getLayoutY() - e.getSceneY();
		});
		
		widget.setOnMouseDragged(e -> {
	            if (!OutputJack.isPressed()) {
	            	widget.setLayoutX(e.getSceneX() + xPos);
		            widget.setLayoutY(e.getSceneY() + yPos);
	            }   
	    });
	}
	
		
		
	public GridPane getWidget() {
		return widget;
	}
	
	public Circle getOutputJack() {
		return OutputJack;
	}
	
	public Source getSound() {
		return wave;
	}
}
