package waveGenerators;

import java.util.Random;

import audio.AudioClip;
import audio.Source;

public class WhiteNoise implements Source {

	@Override
	public AudioClip getAudioClip() {
		var rand = new Random();
		AudioClip noise = new AudioClip();
		for(int index = 0; index < noise.getSamples(); ++index) {
			int sample = rand.nextInt(32767) + -32768;
			noise.setSample(index, sample);
		}
		return noise;
	}

}
