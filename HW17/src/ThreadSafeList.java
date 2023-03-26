import java.util.LinkedList;
import java.util.List;

public class ThreadSafeList<T> {

    private final List<T> threadSafeList = new LinkedList<>();

    public T get(T element) {
        synchronized (threadSafeList) {
            return threadSafeList.contains(element) ? threadSafeList.get(threadSafeList.indexOf(element)) : null;
        }
    }

    public void add(T element) {
        synchronized (threadSafeList) {
            threadSafeList.add(element);
        }
    }

    public boolean remove(T element) {
        synchronized (threadSafeList) {
            return threadSafeList.remove(element);
        }
    }
}
