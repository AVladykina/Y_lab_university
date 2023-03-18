package sequences;/*Последовательности A - J заданы в виде нескольких значений следующим образом
        A. 2, 4, 6, 8, 10...
        B. 1, 3, 5, 7, 9...
        C. 1, 4, 9, 16, 25...
        D. 1, 8, 27, 64, 125...
        E. 1, -1, 1, -1, 1, -1...
        F. 1, -2, 3, -4, 5, -6...
        G. 1, -4, 9, -16, 25....
        H. 1, 0, 2, 0, 3, 0, 4....
        I. 1, 2, 6, 24, 120, 720...
        J. 1, 1, 2, 3, 5, 8, 13, 21…
        Необходимо найти закономерности, по которым эти последовательности
        сформированы и реализовать следующий интерфейс, каждый метод которого
        принимает число N и выводит в консоль N элементов соответствующей
        последовательности. Каждый элемент можно выводить с новой строки

Интерфейс называется sequences.Sequences
Реализация - sequences.SequencesImpl
Демонстрация - sequences.SequencesTest. В данном классе есть метод main, в котором создается
экземпляр объекта и вызываются методы
 */

public class SequencesTest {

    public static void main(String[] args) {

        int n = 5;
        Sequences sequences = new SequencesImpl();

        sequences.a(n);
        sequences.b(n);
        sequences.c(n);
        sequences.d(n);
        sequences.e(n);
        sequences.f(n);
        sequences.g(n);
        sequences.h(n);
        sequences.i(n);
        sequences.j(n);


    }

}