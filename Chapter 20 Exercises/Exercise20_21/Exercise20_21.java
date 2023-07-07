/*
Author: Nate Elison
Date: 7/7/23

Description: This program contains a generic selection sort method, that takes in a generic array and and comparator.
The program tests the method by creating two Geometric Object arrays with circles and rectangles and runs them through the method,
and  finally prints out the areas of the objects in ascending order.
*/
import java.util.Comparator;

public class Exercise20_21 {
  public static void main(String[] args) {
    GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
        new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
        new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
        new Circle(6.5), new Rectangle(4, 5)};

    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
      new Circle(5), new Circle(6), new Circle(1), new Circle(2),
      new Circle(3), new Circle(14), new Circle(12)};
    selectionSort(list1, new GeometricObjectComparator());
    System.out.println("list1: ");
    for (int i = 0; i < list1.length; i++)
      System.out.println(list1[i].getArea() + " ");

    selectionSort(list, new GeometricObjectComparator());
    System.out.println("\n\nlist: ");
    for (int i = 0; i < list.length; i++)
      System.out.println(list[i].getArea() + " ");

  }

  public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {

    for (int j = 0; j < list.length - 1; j ++) {
      E min = list[j];
      int minIndex = j;

      for (int i = j + 1; i < list.length; i++) {
          if (comparator.compare(min, list[i]) > 0) {
            min = list[i];
            minIndex = i;
          }
      }
      if (minIndex != j) {
        list[minIndex] = list[j];
        list[j] = min;
      }
    }
  }

}