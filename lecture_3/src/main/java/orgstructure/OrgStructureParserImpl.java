package orgstructure;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrgStructureParserImpl implements OrgStructureParser {

    public Employee parseStructure(File csvFile) throws IOException {
        Scanner scanner = new Scanner(csvFile);
        String headerLine = scanner.nextLine(); // пропускаем первую строку
        Employee boss = null;
        List<Employee> employees = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split(";");
            Long id = Long.parseLong(fields[0]);
            Long bossId = fields[1].isEmpty() ? null : Long.parseLong(fields[1]);
            String name = fields[2];
            String position = fields[3];

            Employee employee = new Employee();
            employee.setId(id);
            employee.setBossId(bossId);
            employee.setName(name);
            employee.setPosition(position);
            employees.add(employee);

            if (bossId == null) {
                boss = employee;
            }
        }
        for (Employee employee : employees) {
            Long bossId = employee.getBossId();
            if (bossId != null) {
                for (Employee e : employees) {
                    if (e.getId().equals(bossId)) {
                        employee.setBoss(e);
                        e.getSubordinate().add(employee);
                        break;
                    }
                }
            }
        }
        scanner.close();
        return boss;
    }
}