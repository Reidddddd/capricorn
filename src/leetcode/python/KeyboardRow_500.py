class KeyboardRow_500(object):
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        res = []
        l1, l2, l3 = set('qwertyuiop'), set('asdfghjkl'), set('zxcvbnm')
        for wd in words:
            w = set(wd.lower())
            if w.issubset(l1) or w.issubset(l2) or w.issubset(l3):
                res.append(wd)
        return res
