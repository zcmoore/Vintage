package vintage.javax.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Consumer;

import vintage.javax.routers.Subroutine;

/**
 * Allows a function to be specified as a {@link KeyListener}. The function will be
 * invoked upon all key events, including {@link #keyPressed(KeyEvent)},
 * {@link #keyReleased(KeyEvent)}, and {@link #keyTyped(KeyEvent)}.
 * <p>
 * The same result may be achieved by implementing the {@link #accept(KeyEvent)} method of
 * this interface in a subclass.
 * <p>
 * For a listener that allows separate events for each trigger, see
 * {@link FunctionalKeyListener}
 * <p>
 * Usage Example:
 * <p>
 * <code>
 * MonoFunctionalKeyListener keyListener = this::method
 * 
 * JTextArea textArea = new JTextArea();
 * textArea.addKeyListener(keyListener);
 * </code>
 * <p>
 * In the above sample, this::method is a method with the signature
 * <code>void method(KeyEvent event)</code>
 * 
 * @see FunctionalKeyListener
 * @author Moore, Zachary
 *
 */
@FunctionalInterface
public interface MonoFunctionalKeyListener extends KeyListener, Consumer<KeyEvent>
{
	public static MonoFunctionalKeyListener routeTo(Consumer<KeyEvent> consumer)
	{
		return new MonoFunctionalKeyListener() {
			@Override
			public void accept(KeyEvent event)
			{
				consumer.accept(event);
			}
		};
	}
	
	public static MonoFunctionalKeyListener routeTo(Subroutine subroutine)
	{
		return new MonoFunctionalKeyListener() {
			@Override
			public void accept(KeyEvent event)
			{
				subroutine.call();
			}
		};
	}
	
	@Override
	default void keyPressed(KeyEvent event)
	{
		this.accept(event);
	}
	
	@Override
	default void keyReleased(KeyEvent event)
	{
		this.accept(event);
	}
	
	@Override
	default void keyTyped(KeyEvent event)
	{
		this.accept(event);
	}
}
