class ContainerWithMostWater_11(object):
    def maxArea(self, height):
        head = 0
        tail = len(height) - 1
        area = 0
        high = 0
        while head < tail:
            high = min(height[head], height[tail])
            area = max(area, (tail - head) * high)
            while height[head] <= high and head < tail:
                head += 1
            while height[tail] <= high and head < tail:
                tail -= 1
        return area
