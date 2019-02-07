package waveGenerators;

import audio.AudioClip;
import audio.Source;

public class SineWave implements Source {
	private double frequency;
	
	public SineWave(double frequency2) {
		frequency = frequency2;
	}

	public void setFrequency(double freqNew) {
		frequency = freqNew;
	}
	
	@Override
	public AudioClip getAudioClip() {
		AudioClip sine = new AudioClip();
		for(int index = 0; index < sine.getSamples(); ++index) {
			int sample = (int) (32767 * Math.sin(2 * Math.PI * frequency * index / sine.getSamples()));
			sine.setSample(index, sample);
		}
		return sine;
	}
	
}

