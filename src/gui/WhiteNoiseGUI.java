package gui;

import javafx.scene.layout.GridPane;
import waveGenerators.WhiteNoise;

public class WhiteNoiseGUI extends GenWidget{
	public WhiteNoiseGUI() {
		super("White Noise Generator");
		wave = new WhiteNoise();
	}
}
