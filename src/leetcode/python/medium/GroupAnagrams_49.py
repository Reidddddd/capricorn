import collections


class GroupAnagrams_49(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        groups = collections.defaultdict(list)
        for str in strs:
            groups[tuple(sorted(str))].append(str)
        return groups.values()
