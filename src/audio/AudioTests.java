package audio;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import filters.Filter;
import filters.VolumeFilter;
import gui.SineGUI;
import waveGenerators.SineWave;
import waveGenerators.SquareWave;

class AudioTests {

	@Test
	void test() throws Exception {
		AudioClip tester = new AudioClip();
		tester.setSample(0, 255);
		assertEquals(tester.getSample(0), 255);
		
		tester.setSample(1, 127);
		assertEquals(tester.getSample(1), 127);
		
		tester.setSample(2, -100);
		assertEquals(tester.getSample(2), -100);
		
		tester.setSample(3, 100);
		assertEquals(tester.getSample(3), 100);
		
		tester.setSample(4, -32768);
		assertEquals(tester.getSample(4), -32768);
		
		
		Source source = new SineWave(440);
		Filter fil = new VolumeFilter(1);
		fil.connectInput(source);
		PlayAudio.playSound(fil, 2);
		
		//Source mixed = new Mixer(source, two);
		//PlayAudio.playSound(mixed, 2);
		
		
	}

}
