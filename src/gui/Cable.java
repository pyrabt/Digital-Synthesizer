package gui;

import javafx.scene.shape.Line;

public class Cable {
	
	private GenWidget SoundSource;
	private Target target;
	private Line connection;
	
	public Cable(GenWidget source, Target output) {
		SoundSource = source;
		target = output;
		target.setSource(SoundSource.getSound());
		connection = new Line();
		updateConnection();
	}
	
	public void updateConnection() {
		var sourceJack = SoundSource.getOutputJack().localToScene(SoundSource.getOutputJack().getCenterX(), SoundSource.getOutputJack().getCenterY());
		var targetJack = target.getInputJack().localToScene(SoundSource.getOutputJack().getCenterX(), SoundSource.getOutputJack().getCenterY());
		connection.setStartX(sourceJack.getX());
		connection.setStartY(sourceJack.getY());
		connection.setEndX(targetJack.getX());
		connection.setEndY(targetJack.getY());
	}

	public GenWidget getSource() {
		return SoundSource;
	}
	
	public Line getConnection() {
		return connection;
	}
	
	public Target geTarget() {
		return target;
	}
}

