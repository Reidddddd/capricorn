class DecodeString_394(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        stack = [["", 1]]
        num = ""
        for c in s:
            if c.isdigit():
                num += c
            elif c == '[':
                stack.append(["", int(num)])
                num = ""
            elif c == ']':
                seq, fre = stack.pop()
                stack[-1][0] += seq * fre
            else:
                stack[-1][0] += c
        return stack[0][0]
