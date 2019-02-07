package filters;

import audio.AudioClip;
import audio.Source;

public class ReverbFilter implements Filter {
	
	private double volumeScale;
	
	private double delay;
	
	private Source input;
	
	public ReverbFilter(double newScale, int newDelay) {
		volumeScale = newScale;
		
	}
	
	@Override
	public AudioClip getAudioClip() {
		AudioClip adjustedSample = new AudioClip();
		AudioClip source = input.getAudioClip();
		int sample;
		
		for(int index = 0; index < adjustedSample.getSamples(); ++index) {
			if(index + delay <= adjustedSample.getSamples()) {
				sample = source.getSample((int) (index + delay)); 
			} else {
				sample = source.getSample((int) ((index + delay) - adjustedSample.getSamples())); 
			}
			
			sample += (volumeScale * source.getSample(index));
			
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
	
	public void setDelay(double newDelay) {
		delay = newDelay;
	}

}
