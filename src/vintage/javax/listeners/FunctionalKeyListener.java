package vintage.javax.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Consumer;

/**
 * Functional wrapper for {@link KeyListener} to simplify implementation of the strategy
 * pattern.
 * <p>
 * An event function is defined for each key trigger, each of which is unspecified by
 * default. If an event is specified, it will be called whenever the trigger is activated.
 * Otherwise, the trigger will be ignored.
 * <p>
 * Note: getter functions for all event listeners are provided for scalability. However,
 * in most cases the setters will be sufficient. Getters, in almost all circumstances,
 * should <b>not</b> be used to call the specified function. Rather, there may be cases
 * where the event needs to be compared against another strategy.
 * 
 * @author Moore, Zachary
 *
 */
public class FunctionalKeyListener implements KeyListener
{
	private Consumer<KeyEvent> onKeyPressed;
	private Consumer<KeyEvent> onKeyReleased;
	private Consumer<KeyEvent> onKeyTyped;
	
	@Override
	public void keyPressed(KeyEvent event)
	{
		if (onKeyPressed != null)
			onKeyPressed.accept(event);
	}
	
	@Override
	public void keyReleased(KeyEvent event)
	{
		if (onKeyReleased != null)
			onKeyReleased.accept(event);
	}
	
	@Override
	public void keyTyped(KeyEvent event)
	{
		if (onKeyTyped != null)
			onKeyTyped.accept(event);
	}
	
	public Consumer<KeyEvent> getOnKeyPressed()
	{
		return onKeyPressed;
	}
	
	public void setOnKeyPressed(Consumer<KeyEvent> onKeyPressed)
	{
		this.onKeyPressed = onKeyPressed;
	}
	
	public Consumer<KeyEvent> getOnKeyReleased()
	{
		return onKeyReleased;
	}
	
	public void setOnKeyReleased(Consumer<KeyEvent> onKeyReleased)
	{
		this.onKeyReleased = onKeyReleased;
	}
	
	public Consumer<KeyEvent> getOnKeyTyped()
	{
		return onKeyTyped;
	}
	
	public void setOnKeyTyped(Consumer<KeyEvent> onKeyTyped)
	{
		this.onKeyTyped = onKeyTyped;
	}
}
