package gui;

import audio.Source;
import filters.Filter;
import filters.ReverbFilter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.shape.Circle;

public class ReverbGUI extends GenWidget implements Target{

private Circle inputJack;
	

	public ReverbGUI() {
		super("Reverb Filter");
		inputJack = new Circle(10,10,10);
		inputJack.setFill(javafx.scene.paint.Color.ORANGE);
		widget.add(inputJack, 0, 1);
		var scaleSlider = new Slider();
		scaleSlider.setMin(0);
		scaleSlider.setMax(20);
		scaleSlider.setValue(1);
		scaleSlider.setShowTickLabels(true);
		scaleSlider.setShowTickMarks(true);
		scaleSlider.setMajorTickUnit(1);
		Label scaleLabel = new Label("Scale");
		
		var delaySlider = new Slider();
		delaySlider.setMin(0);
		delaySlider.setMax(100);
		delaySlider.setValue(0);
		delaySlider.setShowTickLabels(true);
		delaySlider.setShowTickMarks(true);
		delaySlider.setMajorTickUnit(5);
		Label delayLabel = new Label("Delay");
		
		//widget.add(freqValBack, 1, 1);
		widget.add(scaleLabel, 1, 1);
		widget.add(scaleSlider,2,1);
		widget.add(delayLabel, 1, 2);
		widget.add(delaySlider,2,2);
		System.out.println("Filter connected to source");
			
			wave = new ReverbFilter(1, 0);
			
			scaleSlider.valueProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> ov,
	                    Number old_val, Number new_val) {
	            			((ReverbFilter)wave).setScale((double) new_val);
	            			wave.getAudioClip();
	                	}
	            });
			
			delaySlider.valueProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> ov,
	                    Number old_val, Number new_val) {
	            			((ReverbFilter)wave).setDelay((double) new_val);
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
