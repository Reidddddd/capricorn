class ValidParentheses_20(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        res = []
        for c in s:
            if c == '[':
                res.append(']')
            elif c == '{':
                res.append('}')
            elif c == '(':
                res.append(')')
            elif len(res) == 0 or res.pop() != c:
                return False
        return len(res) == 0
