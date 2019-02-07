package filters;

import audio.AudioClip;
import audio.Source;

public class HighPassFilter implements Filter{
	private double limit;
	
	private Source input;
	
	public HighPassFilter(double new_val) {
		limit = new_val;
		
	}
	
	@Override
	public AudioClip getAudioClip() {
		AudioClip adjustedSample = new AudioClip();
		AudioClip source = input.getAudioClip();
		
		for(int index = 0; index < adjustedSample.getSamples(); ++index) {
			int sample = source.getSample(index); 
			if(sample < limit) {
				sample = (int) limit;
			}
			adjustedSample.setSample(index, sample);
		}
		
		return adjustedSample;
	}

	@Override
	public void connectInput(Source soundIn) {
		input = soundIn;
	}
	
	public void setLimit(double newLimit) {
		limit = newLimit;
	}
}
