import org.junit.jupiter.api.Test;

public class JavaBasics {

    @Test
    public void javaBasics() {
        sumTwoDigits("1", "2");

        sumTwoDigits(30, 45);

        sumTwoDigits(10, 15);

    }

    private void sumTwoDigits(int a, int b) {
        int c = a + b;
        System.out.println("Sum is: " + c);
    }
    private void sumTwoDigits(String a, String b) {
        int c = Integer.parseInt(a);
        int d = Integer.parseInt(b);
        //String k = Integer.toString(d);

        sumTwoDigits(c, d);
    }

}
