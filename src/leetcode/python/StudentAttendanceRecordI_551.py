# def checkRecord(self, s):
#     return not (s.count('A') > 1 or 'LLL' in s)


class StudentAttendanceRecordI_551(object):
    def checkRecord(self, s):
        """
        :type s: str
        :rtype: bool
        """
        numA, numL = 0, 0
        conL = False
        for c in s:
            if c == 'A':
                numA += 1
            elif c == 'L':
                numL += 1
                if numL == 3:
                    conL = True
                continue
            numL = 0
        return not (numA > 1 or conL)
