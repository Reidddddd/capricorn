class MinimumIndexSumOfTwoLists_599(object):
    def findRestaurant(self, list1, list2):
        """
        :type list1: List[str]
        :type list2: List[str]
        :rtype: List[str]
        """
        d1 = {v: i for i, v in enumerate(list1)}
        d2 = {v: i for i, v in enumerate(list2)}
        com = set(list1) & set(list2)
        res = []
        m = 1e9
        comset = {}
        for s in com:
            v = d1[s] + d2[s]
            m = min(m, v)
            comset[s] = v
        for k in comset.keys():
            if comset[k] == m:
                res.append(k)
        return res
