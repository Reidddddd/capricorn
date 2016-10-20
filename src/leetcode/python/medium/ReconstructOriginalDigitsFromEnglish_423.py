class ReconstructOriginalDigitsFromEnglish_423(object):
    def originalDigits(self, s):
        """
        :type s: str
        :rtype: str
        """
        cnt = [0] * 10
        for c in s:
            if c == 'z': cnt[0] += 1
            elif c == 'w': cnt[2] += 1
            elif c == 'u': cnt[4] += 1
            elif c == 'x': cnt[6] += 1
            elif c == 'g': cnt[8] += 1
            elif c == 's': cnt[7] += 1
            elif c == 'f': cnt[5] += 1
            elif c == 'h': cnt[3] += 1
            elif c == 'o': cnt[1] += 1
            elif c == 'i': cnt[9] += 1
        cnt[3] -= cnt[8]
        cnt[5] -= cnt[4]
        cnt[7] -= cnt[6]
        cnt[9] -= (cnt[8] + cnt[6] + cnt[5])
        cnt[1] -= (cnt[2] + cnt[4] + cnt[0])
        return "".join(str(i)*c for i, c in enumerate(cnt))
