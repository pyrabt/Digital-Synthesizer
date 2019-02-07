package gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import waveGenerators.SineWave;


public class SineGUI extends GenWidget {
	
	private double frequency = 440;
	
	Text fVal = new Text(Double.toString((int) frequency));
	
	public SineGUI() {
		super("Sine Wave Generator");
		wave = new SineWave(frequency);
		
		var freqSlider = new Slider();
		freqSlider.setMin(20);
		freqSlider.setMax(2000);
		freqSlider.setValue(440);
		freqSlider.setShowTickLabels(true);
		freqSlider.setShowTickMarks(true);
		freqSlider.setMajorTickUnit(100);
	
		Label freqSL = new Label("Frequency");
		var freqValBack = new Rectangle(40,30,javafx.scene.paint.Color.WHITE);
		freqValBack.setStroke(javafx.scene.paint.Color.BLACK);
	
		widget.add(freqValBack, 0, 1);
		widget.add(freqSL, 0, 1);
		widget.add(freqSlider,2,1);
		widget.add(fVal, 0, 1);
		
		GridPane.setHalignment(freqSL, HPos.CENTER);
		GridPane.setHalignment(fVal, HPos.RIGHT);
		GridPane.setHalignment(freqValBack, HPos.RIGHT);
		
		freqSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                    Number old_val, Number new_val) {
            			frequency = (double) new_val;
        
            			widget.getChildren().remove(fVal);
            			fVal = new Text(Integer.toString((int) frequency));
            			widget.add(fVal, 0, 1);
            			GridPane.setHalignment(fVal, HPos.RIGHT);
            			SineWave xsin = (SineWave) wave;
            			xsin.setFrequency(frequency);
            			wave = xsin;
            			
                        
                }
            });
	}
	
}
