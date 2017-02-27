class Candy_135(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        length = len(ratings)
        candies = [1] * length

        for j in range(length - 1, 0, -1):
            if ratings[j] - ratings[j - 1] < 0 and candies[j - 1] <= candies[j]:
                candies[j - 1] = candies[j] + 1
        for k in range(1, length):
            if ratings[k] - ratings[k - 1] > 0 and candies[k - 1] >= candies[k]:
                candies[k] = candies[k - 1] + 1
        return sum(candies)
