class ImplementQueueUsingStacks_232(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.in_stack, self.out_stack = [], []

    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        self.in_stack.append(x)

    def pop(self):
        """
        :rtype: nothing
        """
        if len(self.out_stack) == 0:
            while len(self.in_stack) > 0:
                self.out_stack.append(self.in_stack.pop())
        self.out_stack.pop()

    def peek(self):
        """
        :rtype: int
        """
        if len(self.out_stack) == 0:
            while len(self.in_stack) > 0:
                self.out_stack.append(self.in_stack.pop())
        return self.out_stack[-1]

    def empty(self):
        """
        :rtype: bool
        """
        return len(self.in_stack) == 0 and len(self.out_stack) == 0
