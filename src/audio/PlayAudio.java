package audio;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;

import javafx.scene.paint.Stop;
import waveGenerators.SineWave;
import waveGenerators.SquareWave;
import waveGenerators.TriangleWave;

public class PlayAudio {
	
	public static void playSound(Source audio, int duration) throws LineUnavailableException {
		Clip c = AudioSystem.getClip(); 
		AudioFormat format16 = new AudioFormat(c.getFormat().getSampleRate(), 16, 1, true, false);
		Source gen = audio;
		byte[] get = gen.getAudioClip().getAudio();
		c.open(format16, get, 0, get.length);
		c.start(); //plays it
		c.loop(duration); //plays it 2 more times if desired
		//Thread.sleep(1000);
		c.addLineListener(e -> {
			if(e.getType() == LineEvent.Type.STOP) {
				c.close();
			}
		});
	
	}
	
	public static Source getSource(int frequency) {
		Source gen = new SineWave(frequency);
		return gen;
	}
	
}
