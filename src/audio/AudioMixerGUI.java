package audio;

import gui.GenWidget;
import gui.Target;
import javafx.scene.shape.Circle;

public class AudioMixerGUI extends GenWidget implements Target{
	
private Circle inputJack;
	
	public AudioMixerGUI() {
		super("Audio Mixer");
		inputJack = new Circle(10,10,10);
		inputJack.setFill(javafx.scene.paint.Color.ORANGE);
		widget.add(inputJack, 0, 1);
		wave = new AudioMixer();
	}

	@Override
	public Circle getInputJack() {
		return inputJack;
	}

	@Override
	public void setSource(Source sound) {
		((Mixer)wave).addInput(sound);
	}
}
