package tatai;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.concurrent.Task;

/*
 * This class will countdown for a given number of seconds which
 * you must pass into its constructor.
 */
public class Countdown {
	
	private ReadOnlyStringProperty _prop;
	private Task<Void> _task;
	
	public Countdown(int number) {
		_task = new Background(number);
		_prop = _task.messageProperty();
	}
	
	// Start counting down
	public void start() {
		Thread thread = new Thread(_task);
		thread.start();
	}
	
	// Get messages
	public ReadOnlyStringProperty getMessageProperty() {
		return _prop;
	}
	
	// Background task so that counter is on new thread
	private class Background extends Task<Void> {
		private int _number;
		
		public Background(int number) {
			_number = number;
		}
		
		@Override
		protected Void call() throws Exception {
			for (int i = _number; i >= 0; i--) {
				updateMessage("Time remaining: " + Integer.toString(i) + " seconds");
				Thread.sleep(1000);
			}
			return null;
		}
	}
}
