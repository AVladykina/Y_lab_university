import java.util.Scanner;

//Числа Пелля задаются следующим соотношением:
//Pell numbers: a(0) = 0, a(1) = 1; for n > 1, a(n) = 2*a(n-1) + a(n-2).
// На вход подается число n (0 <= n <= 30), необходимо распечатать n-e число Пелля
// Пример:
// Ввод: 5
// Вывод:29

public class Pell {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            if (n < 0 || n > 30) {
                System.out.println("Введеное число должно быть от 0 до 30 включительно");
            } else if (n == 0) {
                System.out.println(0);
            } else if (n == 1) {
                System.out.println(1);
            } else {
                long n1 = 1;
                long n2 = 0;
                long result = 0;
                for (int i = 1; i < n; i++) {
                    result = 2 * n1 + n2;
                    n2 = n1;
                    n1 = result;
                }
                System.out.println(result);
            }
        }
    }
}
