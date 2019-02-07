package gui;

import javafx.scene.shape.Circle;
import audio.AudioClip;
import audio.Source;

public interface Target {
	Circle getInputJack();
	
	void setSource(Source source);
}
