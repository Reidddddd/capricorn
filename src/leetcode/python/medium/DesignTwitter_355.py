class DesignTwitter_355(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.users = {}
        self.tweets = []

    def postTweet(self, userId, tweetId):
        """
        Compose a new tweet.
        :type userId: int
        :type tweetId: int
        :rtype: void
        """
        self.tweets.append([userId, tweetId])
        if userId not in self.users:
            self.users[userId] = set()

    def getNewsFeed(self, userId):
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        :type userId: int
        :rtype: List[int]
        """
        following = self.users.get(userId, set())
        feeds = filter(lambda t: t[0] in following or t[0] == userId, self.tweets)
        feeds = map(lambda t: t[1], feeds)
        return list(feeds)[::-1][:10]

    def follow(self, followerId, followeeId):
        """
        Follower follows a followee. If the operation is invalid, it should be a no-op.
        :type followerId: int
        :type followeeId: int
        :rtype: void
        """
        if followerId not in self.users:
            self.users[followerId] = set()
        self.users[followerId].add(followeeId)

    def unfollow(self, followerId, followeeId):
        """
        Follower unfollows a followee. If the operation is invalid, it should be a no-op.
        :type followerId: int
        :type followeeId: int
        :rtype: void
        """
        if followerId not in self.users:
            return
        self.users[followerId].discard(followeeId)
