import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();

        list.addFirst(5);
        System.out.println(list.getHead().value);
        System.out.println(list.getSize());
        System.out.println(list.isEmpty());

        System.out.println("-------");

        list.addFirst(8);
        System.out.println(list.getHead().value);
        System.out.println(list.getSize());
        System.out.println(list.isEmpty());

        System.out.println("-------");

        System.out.println(list.getTail().value);
        list.addLast(3);
        System.out.println(list.getTail().value);
        System.out.println(list.getSize());
        System.out.println("-------");

        list.forEach(System.out::println);

        System.out.println("-------");

        System.out.println(list.removeFirst());
        System.out.println(list.getSize());
        System.out.println(list.getHead().value);

        System.out.println("-------");

        System.out.println(list.removeLast());
        System.out.println(list.getSize());
        System.out.println(list.getTail().value);

        System.out.println("-------");

        list.forEach(System.out::println);

        System.out.println("-------");

        list.addFirst(4);
        list.addLast(6);
        int[] arr=list.toArray();
        System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);

        System.out.println("-------");

        list.addAfter(5,7);
        list.forEach(System.out::println);

        System.out.println("-------");

        list.addAfter(6,8);
        list.forEach(System.out::println);

        System.out.println("-------");

        list.addAfter(4,1);
        list.forEach(System.out::println);

        System.out.println("-------");
        //  list.addAfter(10,8);
        list.removeAfter(4);
        list.forEach(System.out::println);

        System.out.println("-------");

        list.removeAfter(5);
        list.forEach(System.out::println);
        System.out.println("-------");

        list.removeAfter(6);
        list.forEach(System.out::println);
    }
}
