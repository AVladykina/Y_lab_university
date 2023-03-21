// Класс для хранения значения и даты добавления значения в HashMap

package datedmap;

import java.util.Date;

public class DatedValue {

    String value;
    Date dateAdded;


    public DatedValue(String value) {
        this.value = value;
        this.dateAdded = new Date();
    }
}
