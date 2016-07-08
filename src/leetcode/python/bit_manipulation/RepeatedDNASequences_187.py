class RepeatedDNASequences_187(object):
    # "[record, r][substring in record].add(substring)"?
    # if substring in record:
    #   r.add(substring)
    # else:
    #   record.add(substring)
    def findRepeatedDnaSequences(self, s):
        r, record = set(), set()
        for i in range(len(s) - 9):
            substring = s[i:i + 10]
            [record, r][substring in record].add(substring)
        return list(r)