import java.util.Arrays;
/**
 * Creating an array list
 * @author Anna Bogdanova
 * @version 1.0.0
 */
public class ArrayList<T> implements List<T> {
    /**
     * First index of an element in the array list
     */
    private int index = 0;
    /**
     * Initial size of array list
     */
    private int size = 10;
    /**
     * Variable of an array of objects
     */
    private T[] array;
    /**
     * Creating an array constructor of initial size
     */
    public ArrayList() {
        array = (T[]) new Object[size];
    }
    /**
     * Adding an element to the array if an element parameter is entered,
     * changing the index to the next one, and checking the array for fullness
     * @param element The item that needs to be added to the list
     */
    @Override
    public void addElement(Object element) {
        array[index] = (T) element;
        index = index + 1;
        checkingForFullness();
    }
    /**
     * Adding an element to the array, if the element and index parameters are entered,
     * checking for the presence of this index in the array,
     * checking the array for fullness
     * @param element The item that needs to be added to the list
     * @param index The place in the array to add the element
     */
    public void addElement(Object element, int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("There is no such index");
        }
        array[index] = (T) element;
        checkingForFullness();
    }
    /**
     * Checking the array for fullness
     */
    public boolean arrayIsFull() {
        return array[size - 2] != null;
    }
    /**
     * Creating a new larger array and filling it with elements of the old array
     * @return new larger array with elements of the old array
     */
    public T[] newArray(){
        size = (int) Math.round((size * 1.5) + 1);
        T[] newArray = (T[]) new Object[size];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    /**
     * Checking the array for fullness and if true creating a new larger array
     * and filling it with elements of the old array,
     * fills the current array with the elements of the new array
     */
    public void checkingForFullness() {
        if (arrayIsFull()){
            array = newArray();
        }
    }
    /**
     * Getting the current size of the array
     * @return array list size
     */
    public int getSize() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null){
                size = i;
                break;
            }
        }
        return size;
    }
    /**
     * Getting an array element by index,
     * checking for the presence of this index in the array,
     * @return an array element
     */
    @Override
    public T getElement(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("There is no such index");
        }
        return array[index];
    }
    /**
     * Removal an array element by index,
     * checking for the presence of this index in the array
     */
    @Override
    public void deleteElement(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("There is no such index");
        }
        array[index] = null;
    }
    /**
     * Deleting all elements of the array
     */
    public void clean() {
        size = 10;
        array = (T[]) new Object[size];
    }
    /**
     * This method is an array sorting,
     * in the current array the number of filled array elements
     * is calculated up to null.
     * Then a new array is created with
     * a size equal to the number of filled elements of the current array.
     * The new array is filled with elements of the current array, except for null.
     * Then new array sorted.
     * Then the current array fills with the elements of the new array.
     */
    public void sort() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null){
                size = i;
                break;
            }
        }
        T[] newArray = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        Arrays.sort(newArray);
        array = newArray;
    }
    /**
     * Converting an array to a string representation for console output
     * @return String representation of an array
     */
    public String toString() {
        StringBuilder list = new StringBuilder();
        for (T listArray : array){
            if (listArray == null){
                break;
            }
            list.append(listArray).append(" ");
        }
        return list.toString();
    }
}