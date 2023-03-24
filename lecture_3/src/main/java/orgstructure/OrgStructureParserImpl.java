package orgstructure;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OrgStructureParserImpl implements OrgStructureParser {

    @Override
    public Employee parseStructure(File csvFile) throws IOException {
        try (Scanner scanner = new Scanner(csvFile)) {
            var employees = new LinkedHashMap<Long, Employee>();

            // Пропускаем первую строку с названиями полей
            scanner.nextLine();

            // Читаем данные о сотрудниках
            while (scanner.hasNextLine()) {
                var emp = parseEmployee(scanner.nextLine());
                employees.put(emp.getId(), emp);
            }
            return buildHierarchy(employees);
        }
    }

    //Метод создает объект Employee на основе полей из строки и возвращает его.
    private Employee parseEmployee(String line) {
        String[] fields = line.split(";");
        Long id = Long.parseLong(fields[0]);
        Long bossId = fields[1].isEmpty() ? null : Long.parseLong(fields[1]);
        String name = fields[2];
        String position = fields[3];
        return new Employee(id, bossId, name, position);
    }

    //Метод строит иерархию сотрудников на основе списка employees.
    // Для каждого сотрудника находится начальник (по его boss_id) и добавляется в список его подчиненных.
    private Employee buildHierarchy(Map<Long, Employee> employees) {
        Employee topBoss = null;
        for (Employee employee : employees.values()) {
            Long bossId = employee.getBossId();
            if (bossId == null) {
                topBoss = employee;
                continue;
            }
            Employee boss = employees.get(bossId);
            ;
            if (boss != null) {
                boss.getSubordinate().add(employee);
                employee.setBoss(boss);
            }
        }
        return topBoss;
    }
}