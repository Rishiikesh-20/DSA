"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        emp_map={employee.id:employee for employee in employees}

        def dfs(id):
            emp=emp_map[id]
            sum=emp.importance
            for x in emp.subordinates:
                sum+=dfs(x)
            return sum
        return dfs(id)