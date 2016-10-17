class ValidWordSquare_422(object):
    def validWordSquare(self, words):
        """
        :type words: List[str]
        :rtype: bool
        """
        row = len(words)
        for i in range(row):
            for j in range(len(words[i])):
                try:
                    if words[i][j] != words[j][i]:
                        return False
                except:
                    return False
        return True
