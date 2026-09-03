class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        queue=deque()
        queue.append([sr,sc])
        start_color=image[sr][sc]
        x=[-1,1,0,0]
        y=[0,0,-1,1]
        m=len(image)
        n=len(image[0])
        image[sr][sc]=color
        visited=[[-1 for _ in range(n)]for _ in range(m)]
        visited[sr][sc]=1
        while queue:
            node=queue.popleft()
            for i in range(0,4):
                xr=x[i]+node[0]
                yr=y[i]+node[1]
                if xr>=0 and xr<m and yr>=0 and yr<n and visited[xr][yr]==-1 and image[xr][yr]==start_color:
                    image[xr][yr]=color
                    visited[xr][yr]=1
                    queue.append([xr,yr])
        return image