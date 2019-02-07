package audio;

public class AudioClip {
	private byte[] audio;
	private double duration;
	private double samples;
	
	public AudioClip() {
		duration = 1.0;
		samples = 44100;
		audio = new byte[88200];
	}
	
	public byte[] getAudio() {
		return audio;
	}
	
	public double getDuration() {
		return duration;
	}
	
	public double getSamples() {
		return samples;
	}
	
	public int getSample(int index) {

		int byteL = (int) audio[2*index];
		int byteM = (int) audio[2*index+1] << 8;
		int lMask = 0x000000ff;
		int mMask = 0x0000ff00;
		
		byteL = byteL & lMask;
		byteM = byteM & mMask;
		
		int sample = byteL | byteM;

		if(byteM >>> 15 != 0) {sample = sample | 0xFFFF0000;}
		return sample;
	}
	
	public void setSample(int index, int x) {
		byte sampleByte1 = (byte) x;
		byte sampleByte2 = (byte) (x >> 8);
		audio[2*index] = sampleByte1;
		audio[2*index+1] = sampleByte2;
	}
}
