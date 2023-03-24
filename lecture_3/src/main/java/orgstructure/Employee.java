package orgstructure;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    public Employee(Long id, Long bossId, String name, String position) {
        this.id = id;
        this.bossId = bossId;
        this.name = name;
        this.position = position;
    }

    private Long id;
    private Long bossId;
    private String name;
    private String position;
    private Employee boss;
    private List<Employee> subordinate = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBossId() {
        return bossId;
    }

    public void setBossId(Long bossId) {
        this.bossId = bossId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public List<Employee> getSubordinate() {
        return subordinate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Boss ID: ").append(bossId).append("\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Position: ").append(position).append("\n");
        sb.append("Subordinates: ");
        if (subordinate.isEmpty()) {
            sb.append("none");
        } else {
            sb.append("\n");
            for (Employee subordinate : subordinate) {
                sb.append(subordinate.toString().replaceAll("(?m)^", "\t")).append("\n");
            }
        }
        return sb.toString();
    }
}


