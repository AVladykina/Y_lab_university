// Класс для хранения значения и даты добавления значения в HashMap

package datedmap;

import java.util.Date;

public class DatedValue {

    private String value;
    private Date dateAdded;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public DatedValue(String value) {
        this.value = value;
        this.dateAdded = new Date();
    }
}
