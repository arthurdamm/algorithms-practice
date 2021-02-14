// LeetCode 407. Trapping Rain Water II
// https://leetcode.com/problems/trapping-rain-water-ii/
// O(nlogn) time, O(n) space
function trapRainWater(heightMap: number[][]): number {
    const m = heightMap.length, n = heightMap[0].length;
    const visited: boolean[][] = new Array(m).fill(false).map(a => new Array(n).fill(false));
    const dirs = [[-1, 0], [0, 1], [1, 0], [0, -1]];
    const heap: Heap = new Heap();
    let maxHeight = 0;
    for (let i = 0; i < m; i++) {
        if (i != 0 && i != m - 1) {
            heap.push([heightMap[i][0], i, 0]);
            visited[i][0] = true;
            heap.push([heightMap[i][n - 1], i, n - 1]);
            visited[i][n - 1] = true;
            continue;
        }
        for (let j = 0; j < n; j++) {
            heap.push([heightMap[i][j], i, j]);
            visited[i][j] = true;
        }
    }
    let water = 0;
    while (heap.size()) {
        for (let sz = heap.size(); sz > 0; sz--) {
            let [h, i, j] = heap.pop();
            maxHeight = Math.max(maxHeight, h);
            for (let [ddi, ddj] of dirs) {
                let di = i + ddi, dj = j + ddj;
                if (di >= 0 && di < m && dj >= 0 && dj < n && !visited[di][dj]) {
                    heap.push([heightMap[di][dj], di, dj])
                    visited[di][dj] = true;
                    water += Math.max(maxHeight - heightMap[di][dj], 0);
                }
            }
        }
    }
    return water;
};

class Heap {
    arr: any[][]
    constructor() {
        this.arr = []
    }
    
    push(n: any[]) {
        this.arr.push(n);
        this.heapifyUp(this.arr.length - 1);
    }
    
    pop(): any[] {
        let n = this.arr[0];
        this.arr[0] = this.arr[this.arr.length - 1];
        this.arr.pop();
        if (this.arr.length)
            this.heapifyDown(0);
        return n;
    }
    
    heapifyUp(i: number) {
        let parent = this.getParent(i);
        if (this.arr[i][0] < this.arr[parent][0]) {
            let temp = this.arr[parent];
            this.arr[parent] = this.arr[i];
            this.arr[i] = temp;
            this.heapifyUp(parent);
        }
    }
    
    heapifyDown(i: number) {
        let left = this.getLeft(i), right = this.getRight(i), swap = left;
        if (left >= this.arr.length)
            return;
        if (right < this.arr.length && this.arr[right][0] < this.arr[left][0])
            swap = right;
        if (this.arr[i][0] <= this.arr[swap][0])
            swap = -1;
        if (swap == -1)
            return;
        let temp = this.arr[i];
        this.arr[i] = this.arr[swap]
        this.arr[swap] = temp;
        this.heapifyDown(swap);
    }
    
    size(): number {
        return this.arr.length;
    }
    
    getParent(i: number): number {
        return i == 0 ? 0 : Math.floor(((i - 1) / 2));
    }
    
    getLeft(i: number): number {
        return i * 2 + 1;
    }
    
    getRight(i: number): number {
        return i * 2 + 2;
    }
}
