#!/usr/bin/env node
// LeetCode 690. Employee Importance

/**
 * Definition for Employee.
 * function Employee(id, importance, subordinates) {
 *     this.id = id;
 *     this.importance = importance;
 *     this.subordinates = subordinates;
 * }
 */

/**
 * @param {Employee[]} employees
 * @param {number} id
 * @return {number}
 */
var GetImportance = function(employees, id) {
    let emps = {}
    for (e_ob of employees)
        emps[e_ob.id] = e_ob;
    let queue = [];
    queue.push(id);
    let total = 0;
    for (e_id of queue) {
        total += emps[e_id].importance;
        queue.push(...emps[e_id].subordinates);
    }
    return total;
};
