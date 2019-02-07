package gui;

import audio.Source;
import filters.Filter;
import filters.VolumeFilter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.shape.Circle;

public class VolumeGUI extends GenWidget implements Target{
	
	private Circle inputJack;
	

	public VolumeGUI() {
		super("Volume Filter");
		inputJack = new Circle(10,10,10);
		inputJack.setFill(javafx.scene.paint.Color.ORANGE);
		widget.add(inputJack, 0, 1);
		var volSlider = new Slider();
		volSlider.setMin(0);
		volSlider.setMax(1);
		volSlider.setValue(1);
		volSlider.setShowTickLabels(true);
		volSlider.setShowTickMarks(true);
		volSlider.setMajorTickUnit(.1);
		Label volLabel = new Label("Filter/Boost");
		
		//widget.add(freqValBack, 1, 1);
		widget.add(volLabel, 1, 1);
		widget.add(volSlider,2,1);
		System.out.println("Filter connected to source");
			
			wave = new VolumeFilter(1);
			
			volSlider.valueProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> ov,
	                    Number old_val, Number new_val) {
	            			((VolumeFilter)wave).setScale((double) new_val);
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
