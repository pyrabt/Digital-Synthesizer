package gui;

import audio.AudioClip;
import audio.Source;
import javafx.scene.shape.Circle;

public class Speaker implements Target{
	private Circle jack;
	private Source sAudio;
	
	public Speaker() {
		jack = new Circle(20,20,20);
		jack.setFill(javafx.scene.paint.Color.GREEN);
		jack.setStroke(javafx.scene.paint.Color.BLACK);
	}

	@Override
	public Circle getInputJack() {
		return jack;
	}

	@Override
	public void setSource(Source sound) {
		sAudio = sound;
	}
	
	public Source getSource() {
		return sAudio;
	}
}
