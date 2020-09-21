// LeetCode #980 Unique Paths 3

class Solution {
	int dirs[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}, grid[][];
	int count, path, paths, start_x, start_y;

    public int uniquePathsIII(int[][] grid) {
    	this.grid = grid;
    	findStartAndCountZeros();
    	dfs(this.start_x, this.start_y);
    	return this.paths;
    }

	void findStartAndCountZeros() {
		int r = 0, c = 0, count = 0;
        for (r = 0; r < this.grid.length; r++) {
        	for (c = 0; c < this.grid[r].length; c++) {
        		if (this.grid[r][c] == 1) {
        			this.start_x = r;
        			this.start_y = c;
        			this.grid[r][c] = -1;
        		} else if (this.grid[r][c] == 0)
        			count += 1;

        	}
        }
        this.count = count;
	}

    void dfs(int _x, int _y) {
    	for (int[] dir : dirs) {
    		int x = _x + dir[0];
    		int y = _y + dir[1];
    		if (x < 0 || x >= this.grid.length || y < 0 ||
    			y >= this.grid[x].length || this.grid[x][y] == -1)
    			continue;
    		if (this.grid[x][y] == 2) {
    			if (this.path == this.count)
    				this.paths++;
    			continue;
    		}
    		this.path += 1;
    		this.grid[x][y] = -1;
    		dfs(x, y);
    		this.grid[x][y] = 0;
    		this.path -= 1;
    	}
    }
}
