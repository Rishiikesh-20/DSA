class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m,n=len(grid),len(grid[0])

        one=[]
        visited=[[-1 for _ in range(n)]for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if grid[i][j]=="1":
                    one.append((i,j))
        

        def dfs(r,c):
            visited[r][c]=1
            dir=[(-1,0),(1,0),(0,1),(0,-1)]

            for dr,dc in dir:
                xr=r+dr
                xc=c+dc

                if xr>=0 and xr<m and xc>=0 and xc<n and visited[xr][xc]==-1 and grid[xr][xc]=="1":
                    dfs(xr,xc)
        islands=0

        for x,y in one:
            if visited[x][y]==-1:
                islands+=1
                dfs(x,y)

        return islands
        
