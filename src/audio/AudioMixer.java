package audio;

public class AudioMixer implements Mixer {

	private Source input;
	
	private AudioClip stored;
	
	public AudioMixer() {
		stored = new AudioClip();
	}
	
	@Override
	public AudioClip getAudioClip() {
		AudioClip inputAudio = input.getAudioClip();
		for(int index = 0; index < inputAudio.getSamples(); ++index) {
			int sample = inputAudio.getSample(index);
			if(stored.getAudio().length > 0) {
				sample += stored.getSample(index);
			}
			stored.setSample(index, sample);
		}
		return stored;
	}

	@Override
	public void addInput(Source soundIn) {
		input = soundIn;
	}

}
