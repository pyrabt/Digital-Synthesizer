package waveGenerators;

import audio.AudioClip;
import audio.Source;

public class SquareWave implements Source {
	private static double frequency;
	
	public SquareWave(double freq) {
		frequency = freq;
	}
	
	public double getFrequency() {
		return frequency;
	}
	
	public static void setFrequency(double newValue) {
		frequency = newValue;
	}
	

	@Override
	public AudioClip getAudioClip() {
		AudioClip squaredsine = new AudioClip();
		for(int index = 0; index < squaredsine.getSamples(); ++index) {
			int sample = (int) (32767 * Math.signum(Math.sin(2 * Math.PI * frequency * index / squaredsine.getSamples())));
			squaredsine.setSample(index, sample);
		}
		return squaredsine;
	}
}
