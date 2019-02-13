public class Main {
    public static void main(String[] args) {

        SmartArray arr = new SmartArray();
        for (int i = 0; i < 16; i++) {
            arr.add(i);
        }

        int n =12;
        while (n-- > 0) {
            arr.removeAt(0);
        }

        arr.contains(3);


        System.out.println();
    }
}
