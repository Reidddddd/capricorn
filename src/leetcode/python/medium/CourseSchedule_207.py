class CourseSchedule_207(object):
    """
    if node v has not been visited, then mark it as 0.
    if node v is being visited, then mark it as -1. If we find a vertex marked as -1 in DFS, then their is a ring.
    if node v has been visited, then mark it as 1. If a vertex was marked as 1, then no ring contains v or its successors.
    """

    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        def dfs(courses):
            if visited[courses] == -1:
                return False
            if visited[courses] == 1:
                return True
            visited[courses] = -1
            for j in graph[courses]:
                if not dfs(j):
                    return False
            visited[courses] = 1
            return True

        if len(prerequisites) == 0:
            return True
        visited = [0 for _ in range(numCourses)]
        graph = [[] for _ in range(numCourses)]
        for x, y in prerequisites:
            graph[x].append(y)
        for i in range(numCourses):
            if not dfs(i):
                return False
        return True
