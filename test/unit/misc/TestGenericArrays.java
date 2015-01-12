package unit.misc;

import org.junit.Test;
import ru.timmy.adt.stacks.vialist.Stack;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by tflomin on 14.10.2014.
 *
 */
public class TestGenericArrays {
    @Test
    public void testListOfStringArrays() {
        List<String[]> stringArrayList = new ArrayList<String[]>();
        String[] arr1 = new String[]{"q", "w", "e"};
        String[] arr2 = new String[]{"a", "s", "d"};
        stringArrayList.add(arr1);
        stringArrayList.add(arr2);

        assertEquals(2, stringArrayList.size());
    }

    @Test
    public void testGenericArray() {
        GenericArray<Integer[]> genericIntegerArray = new GenericArray<Integer[]>();
        Integer[] arr1 = new Integer[]{1, 2, 3};
        Integer[] arr2 = new Integer[]{4, 5, 6};
        Integer[] arr3 = new Integer[]{7, 8, 9};
        genericIntegerArray.add(arr1);
        genericIntegerArray.add(arr2);
        genericIntegerArray.add(arr3);

        assertEquals(3, genericIntegerArray.innerListSize());
    }

    @Test
    public void testArrayOfGenerics() {
        //GenericArray<String>[] arrayOfGenerics = new GenericArray<String>[10]; // FORBIDDEN!
        Stack<String>[] a = (Stack<String>[]) new Stack[3];
        Stack<String> s0 = new Stack<String>(); s0.push("string0");
        Stack<String> s1 = new Stack<String>(); s1.push("string1");
        Stack<String> s2 = new Stack<String>(); s2.push("string2");

        a[0] = s0;
        a[1] = s1;
        a[2] = s2;

        for (Stack<String> stack : a)
            System.out.println(stack.pop());
    }

    private class GenericArray<Item> {
        private Item obj;
        private List<Item> objs = new ArrayList<Item>();

        public int size() {
            return obj instanceof Object[] ? ((Object[]) obj).length : 0;
        }

        public int innerListSize() {
            return objs.size();
        }

        public void add(Item item) {
            objs.add(item);
        }
    }
}
