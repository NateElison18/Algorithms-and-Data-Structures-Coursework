/**
 * Author: Nate Elison
 * Date: 7/11/23
 *
 * This program creates a genericQueue class using inheritance to extend LinkedList.
 * The Main tests the class by creating a queue of 11 integers from 0-11, using the enqueue method,
 * before removing the first item using the dequeue method. Print statements show the change.
 */
public class Exercise24_05 {
    public static void main(String args[]) throws InterruptedException {
        GenericQueue<Integer> integerGenericQueue = new GenericQueue<>();
        System.out.println("Creating a new queue of integers, adding numbers 0-10 to the queue . . . ");

        for (int i = 0; i < 11; i++) {
            integerGenericQueue.enqueue(new Integer(i));
        }
        System.out.println();
        System.out.println("Queue currently holds " + integerGenericQueue.size() + " items: ");
        for (int i = 0; i < integerGenericQueue.size(); i++) {
            System.out.print(integerGenericQueue.get(i) + " ");
        }
        Thread.sleep(1000);
        System.out.println("\n\nNow to test the dequeue method. Running the method once . . . \n");
        integerGenericQueue.dequeue();
        Thread.sleep(1000);

        System.out.println("Queue now holds " + integerGenericQueue.size() + " items: ");
        for (int i = 0; i < integerGenericQueue.size(); i++) {
            System.out.print(integerGenericQueue.get(i) + " ");
        }

    }
}
