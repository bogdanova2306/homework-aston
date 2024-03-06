public interface List<T> {
   void addElement(Object element, int index);
   void addElement(Object element);
   int getSize();
   T getElement(int index);
   void deleteElement(int index);
   void clean();
   void sort();
   String toString();
}