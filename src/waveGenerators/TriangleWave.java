package waveGenerators;

import audio.AudioClip;
import audio.Source;

public class TriangleWave implements Source {
	private static int frequency;
	
	public TriangleWave(int freqToSet) {
		frequency = freqToSet;
	}
	

	@Override
	public AudioClip getAudioClip() {
		AudioClip saw = new AudioClip();
		for(int index = 0; index < saw.getSamples(); ++index) {
			int sample = (int) (Math.sin((2*index)+saw.getSamples()))/(2*index);
			saw.setSample(index, sample);
		}
		return saw;
	}

}
