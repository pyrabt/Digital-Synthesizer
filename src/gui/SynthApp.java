package gui;

import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;

import audio.AudioMixerGUI;
import audio.PlayAudio;
import gui.SineGUI;
import gui.SquareGUI;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SynthApp extends Application{
	private Line newCable;
	private GenWidget sourceWidget;
	private ArrayList<GenWidget> widgets = new ArrayList<GenWidget>();
	private ArrayList<Cable> cables = new ArrayList<Cable>();
	private ArrayList<Target> targets = new ArrayList<Target>();
	
	public void updateCables() {
		for(Cable c:cables) {
			c.updateConnection();
		}
	}
	
	
	public static void main(String[] args) throws LineUnavailableException {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("sYnThEsIzEr");
		primaryStage.setHeight(720);
		primaryStage.setWidth(1080);
		var border = new BorderPane();
		var p = new Pane();
		
		var library = new VBox();
	    library.setSpacing(8);
	    Text title = new Text("Sound Gadget Library");
	    VBox.setMargin(title, new Insets(0, 0, 0, 8));
	    title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	    library.getChildren().add(title);

	    var sine = new Button("Sine Wave");
	    VBox.setMargin(sine, new Insets(0, 8, 0, 0));
	    sine.setStyle("-fx-font: 18 arial; -fx-background-color: green; -fx-border-color: black;");
	    library.getChildren().add(sine);
	    
	    var square = new Button("Square Wave");
	    VBox.setMargin(square, new Insets(0, 8, 0, 0));
	    square.setStyle("-fx-font: 18 arial; -fx-background-color: green; -fx-border-color: black;");
	    library.getChildren().add(square);
	    
	    var pulse = new Button("Pulse Wave");
	    VBox.setMargin(pulse, new Insets(0, 8, 0, 0));
	    pulse.setStyle("-fx-font: 18 arial; -fx-background-color: green; -fx-border-color: black;");
	    library.getChildren().add(pulse);
	    
	    var noise = new Button("White Noise");
	    VBox.setMargin(noise, new Insets(0, 8, 0, 0));
	    noise.setStyle("-fx-font: 18 arial; -fx-background-color: green; -fx-border-color: black;");
	    library.getChildren().add(noise);
	    
	    var volume = new Button("Volume Filter");
	    VBox.setMargin(volume, new Insets(0, 8, 0, 0));
	    volume.setStyle("-fx-font: 18 arial; -fx-background-color: green; -fx-border-color: black;");
	    library.getChildren().add(volume);
	    
	    var reverb = new Button("Reverb Filter");
	    VBox.setMargin(volume, new Insets(0, 8, 0, 0));
	    reverb.setStyle("-fx-font: 18 arial; -fx-background-color: green; -fx-border-color: black;");
	    library.getChildren().add(reverb);
	    
	    var highPass = new Button("High Pass Filter");
	    VBox.setMargin(volume, new Insets(0, 8, 0, 0));
	    highPass.setStyle("-fx-font: 18 arial; -fx-background-color: green; -fx-border-color: black;");
	    library.getChildren().add(highPass);
	    
	    var lowPass = new Button("Low Pass Filter");
	    VBox.setMargin(volume, new Insets(0, 8, 0, 0));
	    lowPass.setStyle("-fx-font: 18 arial; -fx-background-color: green; -fx-border-color: black;");
	    library.getChildren().add(lowPass);
	    
	    var mixer = new Button("Audio Mixer");
	    VBox.setMargin(volume, new Insets(0, 8, 0, 0));
	    mixer.setStyle("-fx-font: 18 arial; -fx-background-color: green; -fx-border-color: black;");
	    library.getChildren().add(mixer);
	    
	    var speaker = new Speaker();
	    var speakerJack = speaker.getInputJack();
	    targets.add(speaker);
		speakerJack.setLayoutX(900);
		speakerJack.setLayoutY(600);
		p.getChildren().add(speakerJack);
		
		
		var hbox = new HBox();
	    hbox.setSpacing(8);
	    Button play = new Button("Play");
	    HBox.setMargin(play, new Insets(0, 0, 8, 8));
	    hbox.getChildren().add(play);
	    
		border.setRight(library);
		//border.setRight(speaker);
		border.setBottom(hbox);
		border.setCenter(p);
		
		
		library.setAlignment(Pos.TOP_CENTER);
		
		var scene = new Scene(border);
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
		
		//EMPTY ATM
		play.setOnAction(e -> {
			try {
				PlayAudio.playSound(speaker.getSource(), 2);
			} catch (LineUnavailableException e1) {
				e1.printStackTrace();
			}
		});
		
		sine.setOnAction(e -> {
		    	GenWidget ns = new SineGUI();
		    	widgets.add(ns);
		    	p.getChildren().add(ns.getWidget());
		});
		
		square.setOnAction(e -> {
		    	var nw = new SquareGUI();
		    	widgets.add(nw);
		    	p.getChildren().add(nw.getWidget());
		});
		
		pulse.setOnAction(e -> {
	    	var pw = new PulseGUI();
	    	widgets.add(pw);
	    	p.getChildren().add(pw.getWidget());
		});
		
		noise.setOnAction(e -> {
	    	var noi = new WhiteNoiseGUI();
	    	widgets.add(noi);
	    	p.getChildren().add(noi.getWidget());
		});
		
		volume.setOnAction(e -> {
	    	var vol = new VolumeGUI();
	    	targets.add(vol);
	    	widgets.add(vol);
	    	p.getChildren().add(vol.getWidget());
		});
		
		reverb.setOnAction(e -> {
	    	var rev = new ReverbGUI();
	    	targets.add(rev);
	    	widgets.add(rev);
	    	p.getChildren().add(rev.getWidget());
		});
		
		highPass.setOnAction(e -> {
	    	var hp = new HighPassGUI();
	    	targets.add(hp);
	    	widgets.add(hp);
	    	p.getChildren().add(hp.getWidget());
		});
		
		lowPass.setOnAction(e -> {
	    	var lp = new LowPassGUI();
	    	targets.add(lp);
	    	widgets.add(lp);
	    	p.getChildren().add(lp.getWidget());
		});
		
		mixer.setOnAction(e -> {
	    	var mix = new AudioMixerGUI();
	    	targets.add(mix);
	    	widgets.add(mix);
	    	p.getChildren().add(mix.getWidget());
		});
		
			// creating a line when pressing inside window
			p.setOnMousePressed(e -> {
				var mouseScene = new Point2D(e.getX(), e.getY());
		        	if(widgets.size() > 0) {
			        	for(GenWidget w:widgets) {
			        		var c = w.getOutputJack();
			        		var cPoint = c.localToScene(c.getCenterX(),c.getCenterY());
			        		if(c.contains(c.sceneToLocal(mouseScene))) {
			        			System.out.println("jack pressed");
			        			newCable = new Line(cPoint.getX(), cPoint.getY(), e.getSceneX(), e.getSceneY());
			        			newCable.setStrokeWidth(5);
			        			p.getChildren().add(newCable);
			        			sourceWidget = w;
			        		}
			        	}
		        	} 
		        	
		        	for(Cable c:cables) {
		    			if(c.getConnection().contains(mouseScene)) {
		    				p.getChildren().remove(c);
		    				cables.remove(c);
		    			}
		    		}
			});
			
			// updating endpoint of line with mouse drag coordinates
			p.setOnMouseDragged(e -> {
				if(widgets.size() > 0) {
					newCable.setEndX(e.getSceneX());
	                newCable.setEndY(e.getSceneY());
				}
				if(cables.size() > 0) {
					updateCables();
				}
	        });
			
			//detect line draw release and delete line (will use this for determining of line should be kept)
			p.setOnMouseReleased(e -> {
				var mouseScene = new Point2D(e.getX(), e.getY());
				if(widgets.size() > 0) {
					for(Target t:targets) {
		            	if(t.getInputJack().contains(t.getInputJack().sceneToLocal(mouseScene))) {
		            		newCable.setEndX(t.getInputJack().getLayoutX()+t.getInputJack().getCenterX());
		 	                newCable.setEndY(t.getInputJack().getLayoutY()+t.getInputJack().getCenterY());
		 	                cables.add(new Cable(sourceWidget, t));
		 	                p.getChildren().remove(newCable);
		 	                p.getChildren().add(cables.get(cables.size()-1).getConnection());
		            	}
					}
					p.getChildren().remove(newCable);
				}
	        });
		
	}
}
