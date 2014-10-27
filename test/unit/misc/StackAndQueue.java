package unit.misc;

import org.junit.Test;
import ru.timmy.adt.queues.Queue;
import ru.timmy.adt.stacks.vialist.Stack;

/**
 * Created by tflomin on 21.10.2014.
 *
 */
public class StackAndQueue {
    @Test
    public void testStackAndQueue() {
        Queue<String> q = new Queue<String>();
        q.enqueue("1");
        q.enqueue("2");
        q.enqueue("3");
        q.enqueue("4");
        q.enqueue("5");
        q.enqueue("6");
        q.enqueue("7");

        Stack<String> s = new Stack<String>();
        while (!q.isEmpty())
            s.push(q.dequeue());
        while (!s.isEmpty())
            q.enqueue(s.pop());

        for (String str : q)
            System.out.println(str);
    }
}
