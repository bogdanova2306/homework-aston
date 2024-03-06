import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.addElement(1);
        array.addElement(3);
        array.addElement(5);
        array.addElement(7);
        array.addElement(9);
        array.addElement(10);
        array.addElement(8);
        array.addElement(6);
        array.addElement(4);
        array.addElement(2);
        System.out.println(array);
        array.addElement(15,4);
        System.out.println(array.getSize());
        System.out.println(array.getElement(4));
        array.deleteElement(9);
        System.out.println(array);
        array.sortArray();
        System.out.println(array);
        array.cleanArray();
        System.out.println(array);

        LinkedList<Integer> array1 = new LinkedList<>();
        array1.addElement(1);
        array1.addElement(3);
        array1.addElement(5);
        array1.addElement(7);
        array1.addElement(9);
        array1.addElement(10);
        array1.addElement(8);
        array1.addElement(6);
        array1.addElement(4);
        array1.addElement(2);
        System.out.println(array1);
        array1.addElement(15,4);
        System.out.println(array1.getSize());
        System.out.println(array1.getElement(4));
        array1.deleteElement(9);
        System.out.println(array1);
        array1.sortList();
        System.out.println(array1);
        array1.clearList();
        System.out.println(array1);
    }
}