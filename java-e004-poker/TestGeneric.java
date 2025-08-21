import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGeneric<T> {
    private List<T> value;
    //constructor
    public TestGeneric(T[] array) {
        this.value = new ArrayList<>(Arrays.asList(array));
    }
    //return for 1 index
    public T get(int index) {
        return value.get(index);
    }

    //add to array
    public void add(T str) {
        this.value.add(str);
    }

    //show all
    public void printAll() {
        System.err.println(value);
    }

    //start
    public static void main(String[] args) {
        String[] arr = { "A", "B", "C" };
        TestGeneric<String> box = new TestGeneric<>(arr);
        box.add("1");
        box.printAll();

    }
}
