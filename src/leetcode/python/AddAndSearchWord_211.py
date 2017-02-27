class Dict(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.is_word = False
        self.dicts = {}


class AddAndSearchWord_211(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.root = Dict()

    def addWord(self, word):
        """
        Adds a word into the data structure.
        :type word: str
        :rtype: void
        """
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = Dict()
            node = node.children[c]
        node.is_word = True

    def search(self, word):
        """
        Returns if the word is in the data structure. A word could
        contain the dot character '.' to represent any one letter.
        :type word: str
        :rtype: bool
        """
        def nextSearch(n, j):
            for nd in n.dicts:
                k = j
                while k < len(word):
                    wd = word[k]
                    if wd == '.':
                        if nextSearch(nd, k+1):
                            return True
                        else:
                            break
                    else:
                        if wd not in nd.dicts:
                            break
                        nd = nd.dicts[wd]
                    k += 1
                if k == len(word) and nd.is_word:
                    return True
            return False

        node = self.root
        for i in range(len(word)):
            w = word[i]
            if w == '.':
                return nextSearch(node, i + 1)
            else:
                if w not in node.dicts:
                    return False
                node = node.dicts[w]
        return node.is_word
