package vintage.javax.routers;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConsumerRouter
{
	public static <T> Consumer<T> routeTo(Subroutine target)
	{
		Consumer<T> router = new Consumer<T>() {
			@Override
			public void accept(T unusedArgument)
			{
				target.call();
			}
		};
		
		return router;
	}
	
	public static <T> Consumer<T> routeTo(Function<T, ?> target)
	{
		Consumer<T> router = new Consumer<T>() {
			@Override
			public void accept(T argument)
			{
				target.apply(argument);
			}
		};
		
		return router;
	}
	
	public static <T> Consumer<T> routeTo(Predicate<T> target)
	{
		Consumer<T> router = new Consumer<T>() {
			@Override
			public void accept(T argument)
			{
				target.test(argument);
			}
		};
		
		return router;
	}
}
