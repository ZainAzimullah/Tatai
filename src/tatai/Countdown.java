package tatai;

import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;

public class Countdown {
	
	private ReadOnlyStringProperty _prop;
	private Task<Void> _task;
	
	public Countdown(int number) {
		_task = new Background(number);
		_prop = _task.messageProperty();
	}
	
	
	public void start() {
		Thread thread = new Thread(_task);
		thread.start();
	}
	
	public ReadOnlyStringProperty getMessageProperty() {
		return _prop;
	}
	
	private class Background extends Task<Void> {
		
		private int _number;
		
		public Background(int number) {
			_number = number;
		}
		
		@Override
		protected Void call() throws Exception {
			for (int i = _number; i >= 0; i--) {
				updateMessage("Time remaining: " + Integer.toString(i) + " seconds");
				System.out.println(i);
				Thread.sleep(1000);
			}
			return null;
		}
		
	}
}
