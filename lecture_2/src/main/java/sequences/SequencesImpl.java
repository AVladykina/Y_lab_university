package sequences;

public class SequencesImpl
        implements Sequences {

    @Override
    public void a(int n) {
        int number = 2;
        for (int i = 0; i < n; i++) {
            System.out.print(number + " ");
            number += 2;
        }
        System.out.println();
    }

    @Override
    public void b(int n) {
        int number = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(number + " ");
            number += 2;
        }
        System.out.println();
    }

    @Override
    public void c(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print((int)Math.pow(i, 2) + " ");
        }
        System.out.println();
    }

    @Override
    public void d(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print((int)Math.pow(i, 3) + " ");
        }
        System.out.println();
    }

    @Override
    public void e(int n) {
        int number = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(number + " ");
            number *= -1;
        }
        System.out.println();
    }

    @Override
    public void f(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.print(-i + " ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    @Override
    public void g(int n) {
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (i % 2 == 0) {
                System.out.print(-square + " ");
            } else {
                System.out.print(square + " ");
            }
        }
        System.out.println();
    }

    @Override
    public void h(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.print("0 ");
            } else {
                System.out.print((i + 1) / 2 + " ");
            }
        }
        System.out.println();
    }

    @Override
    public void i(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            System.out.print(factorial + " ");
        }
        System.out.println();
    }

    @Override
    public void j(int n) {
        int n1 = 1, n2 = 1, n3;
        System.out.print(n1 + " " + n2 + " ");
        for (int i = 2; i < n; i++) {
            n3 = n1 + n2;
            System.out.print(n3 + " ");
            n1 = n2;
            n2 = n3;
        }
        System.out.println();
    }
}
