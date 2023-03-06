
//Stars. Программе передается 3 параметра: количество строк, количество столбцов, произвольный символ.
//        Необходимо вывести фигуру, состоящую из заданного списка строк и заданного количества столбцов,
//        и каждый элемент в которой равен указанному символу.
//        Ввод: n m c
//        Вывод: фигура
//        Пример:Ввод: 2 3 $
//        Вывод:$ $ $
//              $ $ $

import java.util.Scanner;

public class Start {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String template = scanner.next();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(template);
                    if (j + 1 < m) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
