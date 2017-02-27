class SubstringWithConcatenationOfAllWords_30(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        import copy
        import collections
        res = []
        wordlen, wordnum, slen = len(words[0]), len(words), len(s)
        counter = collections.Counter(words)
        for i in range(wordlen):
            start = i
            temp_counter = copy.copy(counter)
            for j in range(start, slen - wordlen + 1, wordlen):
                word = s[j:j + wordlen]
                temp_counter[word] -= 1
                while temp_counter[word] < 0:
                    temp_counter[s[start:start + wordlen]] += 1
                    start += wordlen
                if j + wordlen - start == wordlen * wordnum:
                    res.append(start)
        return res
