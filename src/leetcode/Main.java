package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
// Employee info */
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
    
    public Employee(int id, int importance, List<Integer> subordinates) {
    	this.id = id;
    	this.importance = importance;
    	this.subordinates = subordinates;
    }
};

class Solution1 {
   /* public int getImportance(List<Employee> employees, int id) {
        Employee current = getEmployeeById(employees, id);
        if (current != null) {
            int point = getImportant(employees, current, current.importance);
            return point;
        }else{
            return 0;
        }
    }
    
    public Employee getEmployeeById(List<Employee> employees, int id){
        if (employees != null && !employees.isEmpty()){
            for (Employee e : employees){
                if (e.id == id){
                    return e;
                }
            }
        }
        return null;
    }
    
    public int getImportant (List<Employee> employees, Employee employee, int point){ // Each child of a tree is a root of its subtree.
        if (employee.subordinates == null){
        	return 0;
        }
        
        for (Integer subId: employee.subordinates){
            Employee subEmployee = getEmployeeById(employees, subId);
            point = subEmployee.importance + getImportant(employees, subEmployee, point);     
        }
        
        return point;
    }*/
	
	
	
	/***
	 * Better solution using Queue and BFS, DFS search
	 */
	public int getImportance(List<Employee> employees, int id) {
		// At first need to create a Hashmap of Id pair employee for easy lookup
		HashMap<Integer, Employee> employMap = new HashMap<Integer, Employee>();
		for (Employee e: employees) {
			employMap.put(e.id, e);
		}
		
		Queue<Employee> q = new LinkedList<Employee>();
		q.add(employMap.get(id));
		int point = 0;
		
		while (!q.isEmpty()) {
			Employee current = q.poll();
			for (int subId : current.subordinates) {
				q.add(employMap.get(subId));
			}
			point += current.importance;			
		}
		
		return point;
    }
	
	
}

public class Main {
    public static void main(String[] args) throws IOException {
    		List<Employee >list = new ArrayList<Employee>();
    		//[[1,5,[2,3]],[2,3,[]],[3,3,[]]]
    		list.add(new Employee(1, 5 , Arrays.asList ( 2, 3 )));
    		list.add(new Employee(2, 3 ,  new ArrayList<Integer>()));
    		list.add(new Employee(3, 3 ,  new ArrayList<Integer>()));
            int ret = new Solution1().getImportance(list, 1);
            
            // expected 11
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
     }
    
}
