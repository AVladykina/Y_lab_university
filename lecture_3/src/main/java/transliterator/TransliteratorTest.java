/* Реализовать интерфейс Transliterator
    Метод transliterate должен выполнять транслитерацию входной строки в выходную, то
есть заменять каждый символ кириллицы на соответствующую группу символов
латиницы. Каждый символ кириллицы, имеющийся во входной строке входит в нее в
верхнем регистре.

 */

package transliterator;

public class TransliteratorTest {

    public static void main(String[] args) {

        Transliterator transliterator = new TransliteratorImpl();
        String res = transliterator
                .transliterate("HELLO! ПРИВЕТ! Go, boy!!");
        System.out.println(res);
    }
}


