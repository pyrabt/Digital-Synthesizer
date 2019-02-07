package filters;

import audio.Source;

public interface Filter extends Source{
	
	void connectInput(Source soundIn);
	
}
