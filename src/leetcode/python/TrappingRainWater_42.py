class TrappingRainWater_42(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if height > 1:
            head, tail = 0, len(height) - 1
            water = 0
            while head < tail:
                if height[head] < height[tail]:
                    pt = head + 1
                    while pt <= tail and height[pt] < height[head]:
                        water += height[head] - height[pt]
                        pt += 1
                    head = pt
                else:
                    pt = tail - 1
                    while pt >= head and height[pt] < height[tail]:
                        water += height[tail] - height[pt]
                        pt -= 1
                    tail = pt
            return water
        return 0
