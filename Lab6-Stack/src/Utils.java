import java.util.ArrayList;
import java.util.List;

public class Utils {
	public static <E> E getLast(List<E> list) {
		return list.get(list.size() - 1);
	}

	public static <E> List<E> reverse(List<E> list) {
		var reverse = new ArrayList<E>();
		for (E e : list) {
			reverse.add(0, e);
		}
		return reverse;
	}
}
