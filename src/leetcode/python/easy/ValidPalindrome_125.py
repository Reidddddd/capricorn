class ValidPalindrome_125(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool

        Below solution is neater and faster:
        newS= [i.lower() for i in s if i.isalnum()]
        return newS == newS[::-1]
        """
        if not s or len(s) == 1:
            return True
        head, tail = 0, len(s) - 1
        while head < tail:
            while head < tail and not s[head].isalnum():
                head += 1
            while head < tail and not s[tail].isalnum():
                tail -= 1
            if s[head].lower() != s[tail].lower():
                return False
            head += 1
            tail -= 1
        return True
