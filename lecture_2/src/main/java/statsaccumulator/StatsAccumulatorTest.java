/*Необходимо реализовать интерфейс StatsAccumulator
        Объект данного класса, будучи созданным, может принимать значения через метод
        add. Приняв значение, объект меняет свое внутреннее состояние, чтобы в любой
        момент времени предоставить данные о количестве переданных ему элементах,
        минимальному их них, максимальному из них, а также о среднем арифметическом
        всех переданных ему элементов

 */

package statsaccumulator;

public class StatsAccumulatorTest {

    public static void main(String[] args) {

        StatsAccumulator s = new StatsAccumulatorImpl();
        s.add(1);
        s.add(2);
        System.out.println(s.getAvg()); // 1.5 - среднее арифметическое элементов
        s.add(0);
        System.out.println(s.getMin()); // 0 - минимальное из переданных значений
        s.add(3);
        s.add(8);
        System.out.println(s.getMax()); // 8 - максимальный из переданных
        System.out.println(s.getCount()); // 5 - количество переданных элементов
    }
}
