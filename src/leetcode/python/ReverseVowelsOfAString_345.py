class ReverseVowelsOfAString_345(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
        ls = list(s)
        i, j = 0, len(ls) - 1
        while i < j and i < len(ls) and j >= 0:
            while i < len(ls) and ls[i] not in vowels:
                i += 1
            if i >= j:
                break
            while j >= 0 and ls[j] not in vowels:
                j -= 1
            ls[i], ls[j] = ls[j], ls[i]
            i += 1
            j -= 1
        return ''.join(ls)
