class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m=len(grid)
        n=len(grid[0])
        visited=[[-1 for _ in range(n)]for _ in range(m)]


        def dfs(r,c):
            visited[r][c]=1
            direc=[(-1,0),(1,0),(0,1),(0,-1)]
            sum=0
            for i in direc:
                x,y=i
                xr=x+r
                xc=y+c
                if xr>=0 and xr<m and xc>=0 and xc<n and grid[xr][xc]==1 and visited[xr][xc]==-1:
                    sum+=dfs(xr,xc)
            return 1+sum
        maxi=0
        for i in range(m):
            for j in range(n):
                if visited[i][j]==-1 and grid[i][j]==1:
                    maxi=max(maxi,dfs(i,j))
        return maxi