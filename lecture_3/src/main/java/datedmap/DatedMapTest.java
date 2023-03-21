/* DatedMap - это структура данных, очень похожая на Map, но содержащая
        дополнительную информацию: время добавления каждого ключа. При этом время
        хранится только для тех ключей, которые присутствуют в Map.
        Реализовать DatedMap путем реализации следующего интерфейса
        Методы:
        put. Помещает в map пару ключ и значение. Как видно из описания метода, ключ и
        значение - это строки (семантика Map#put)
        get. Возвращает значение, связанное с переданным в метод ключом. Если для
        переданного ключа значение отсутствует - возвращается null (семантика Map#get)
        containsKey. Метод, проверяющий, есть ли в map значение для данного ключа
        (семантика Map#containsKey).
        remove. Получая на вход ключ, удаляет из map ключ и значение, с ним связанное
        (семантика Map#remove)
        ketSet. Возвращает множество ключей, присутствующее в map (семантика
        Map#keySet)
        getKeyLastInsertionDate. Получая на вход ключ, проверяет, что для данного ключа
        существует значение в map. Если существует - возвращает дату, когда оно было
        добавлено. Если нет - возвращает null
        В реализации данного класса можно использовать уже готовые структуры данных в
        Java, такие как HashMap

 */

package datedmap;

public class DatedMapTest {

    public static void main(String[] args) {

        DatedMapImpl map = new DatedMapImpl();

        map.put("11111", "Anna");
        map.put("22222", "Sergi");
        map.put("33333", "Fedor");

        System.out.println("Дата создания записи для Anna " + map.getKeyLastInsertionDate("11111"));
        System.out.println("Дата создания записи для Sergi " + map.getKeyLastInsertionDate("22222"));
        System.out.println("Дата создания записи для Fedor " + map.getKeyLastInsertionDate("33333"));
        System.out.println("Дата для ? " + map.getKeyLastInsertionDate("4"));

        System.out.println("Значение для ключа 33333 - " + map.get("33333"));

        System.out.println("Множество ключей " + map.keySet());

        map.put("33333", "Irina");
        System.out.println("Дата создания записи для Irina " + map.getKeyLastInsertionDate("33333"));
        System.out.println("Значение для ключа 33333 - " + map.get("33333"));
        map.remove("33333");

        System.out.println("Удалилась ли запись для Irina - " + map.get("33333"));

    }
}
