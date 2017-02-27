class TopKFrequentElements(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]

        use counter to count the frequency
        then sort the counter with value(reverse means descending order)
        then return the top k
        """
        from collections import Counter
        counter = Counter(nums)
        counter = sorted(counter.items(), key=lambda x: x[1], reverse=True)
        return [x[0] for x in counter[:k]]
