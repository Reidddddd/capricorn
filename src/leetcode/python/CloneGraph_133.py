class UndirectedGraphNode:
    def __init__(self, x):
        self.label = x
        self.neighbors = []


class CloneGraph_133(object):
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):
        def clone(n):
            if not n:
                return None
            if n in cache:
                return cache.get(n)
            cp = UndirectedGraphNode(n.label)
            cache[n] = cp
            for neighbor in n.neighbors:
                cp.neighbors.append(clone(neighbor))
            return cp

        cache = {}
        return clone(node)
