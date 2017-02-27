class CourseScheduleII_210(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        def dfs(course):
            if visited[course] == 0:
                visited[course] = 1
                onstack[course] = 1
                if course in neigh:
                    for j in neigh[course]:
                        if not dfs(j):
                            return False
                topo.append(course)
                onstack[course] = 0
            elif onstack[course] == 1:
                return False
            return True

        if len(prerequisites) == 0:
            return [i for i in range(numCourses)]
        neigh = {}
        for i, j in prerequisites:
            if j not in neigh:
                neigh[j] = set()
            neigh[j].add(i)
        visited, onstack = [0] * numCourses, [0] * numCourses
        topo = []
        for i in range(numCourses):
            if not dfs(i):
                return []
        return topo[::-1]
