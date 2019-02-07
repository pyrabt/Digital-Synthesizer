package filters;

import audio.AudioClip;
import audio.Source;

public class VolumeFilter implements Filter {
	
	private double volumeScale;
	
	private Source input;
	
	public VolumeFilter(double new_val) {
		volumeScale = new_val;
		
	}
	
	@Override
	public AudioClip getAudioClip() {
		AudioClip adjustedSample = new AudioClip();
		AudioClip source = input.getAudioClip();
		for(int index = 0; index < adjustedSample.getSamples(); ++index) {
			int inputSample = source.getSample(index); 
			int sample = (int) (volumeScale * inputSample);
			adjustedSample.setSample(index, sample);
		}
		
		return adjustedSample;
	}

	@Override
	public void connectInput(Source soundIn) {
		input = soundIn;
		
	}
	
	public void setScale(double newScale) {
		volumeScale = newScale;
		
	}
}
