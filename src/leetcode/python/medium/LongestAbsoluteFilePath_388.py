class LongestAbsoluteFilePath_388(object):
    def lengthLongestPath(self, input):
        """
        :type input: str
        :rtype: int
        """
        splits = input.split("\n")
        visited = [False] * len(input)
        tab = "\t"
        max_l = 0
        for i in range(len(splits)):
            if tab not in splits[i]:
                if "." in splits[i]:
                    max_l = max(max_l, len(splits[i]))
                    continue
                max_l = max(max_l, self.maxLength(splits, i+1, tab, len(splits[i]), visited))
        return max_l

    def maxLength(self, splits, start, tab, length, visited):
        max_l = 0
        i = start
        while i < len(splits):
            if tab in splits[i] and not visited[i]:
                tmp = len(splits[i]) - len(tab) + 1
                visited[i] = True
                if "." not in splits[i]:
                    max_l = max(self.maxLength(splits, i+1, (tab+"\t"), (length+tmp), visited), max_l)
                else:
                    max_l = max(length+tmp, max_l)
            elif not visited[i]:
                break
            i += 1
        return max_l
