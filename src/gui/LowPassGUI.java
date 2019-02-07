package gui;

import audio.Source;
import filters.Filter;
import filters.LowPassFilter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.shape.Circle;

public class LowPassGUI extends GenWidget implements Target {
	
	private Circle inputJack;
	
	public LowPassGUI() {
		super("Low Pass Filter");
		inputJack = new Circle(10,10,10);
		inputJack.setFill(javafx.scene.paint.Color.ORANGE);
		widget.add(inputJack, 0, 1);
		var limSlider = new Slider();
		limSlider.setMin(0);
		limSlider.setMax(33000);
		limSlider.setValue(2000);
		limSlider.setShowTickLabels(true);
		limSlider.setShowTickMarks(true);
		limSlider.setMajorTickUnit(1000);
		Label limLabel = new Label("Limit");
		
		//widget.add(freqValBack, 1, 1);
		widget.add(limLabel, 1, 1);
		widget.add(limSlider,2,1);
			
			wave = new LowPassFilter(2000);
			
			limSlider.valueProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> ov,
	                    Number old_val, Number new_val) {
	            			((LowPassFilter)wave).setLimit((double) new_val);
	            			wave.getAudioClip();
	                	}
	            });
	}

	@Override
	public Circle getInputJack() {
		return inputJack;
	}

	@Override
	public void setSource(Source sound) {
		((Filter)wave).connectInput(sound);
	}
}

