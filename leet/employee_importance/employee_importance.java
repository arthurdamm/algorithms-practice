// LeetCode 690. Employee Importance

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> emps = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        Integer _id;
        int total = 0;
        for (Employee employee : employees)
            emps.put(employee.id, employee);
        queue.add(id);
        while ((_id = queue.poll()) != null)
        {
            total += emps.get(_id).importance;
            for (int subordinate : emps.get(_id).subordinates)
                queue.add(subordinate);
        }
        return total;
    }
}
