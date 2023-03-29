/*
Даны следующие классы:
Класс Generator, которые генерирует файл с заданными количеством чисел типа long
Класс Validator, который проверяет, что файл отсортирован по возрастанию
Класс Sorter, который получает на вход файл с числами, и возвращает
отсортированный по возрастанию файл
И класс Test, который запускает генерацию файла, затем сортировку и проверку, что
файл отсортирован
Задача - реализовать метод Sorter.sortFile используя алгоритм внешней
сортировки слиянием.
Для демонстрации решения проверяющим можно использовать файл небольшого
размера (до 100 элементов), однако, решение долго быть реализовано таким образом,
чтобы поддерживать сортировку файлов произвольно большого размера.
Для самопроверки можно сгенерировать файл из 375000000 записей, тогда объем
файла, который надо будет отсортировать, будет равен 7-8 Гб
 */

package filesort;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        File dataFile = new Generator().generate("data.txt", 1000000);
        System.out.println(new Validator(dataFile).isSorted()); // false
        File sortedFile = new Sorter().sortFile(dataFile);
        System.out.println(new Validator(sortedFile).isSorted()); // true
    }
}
