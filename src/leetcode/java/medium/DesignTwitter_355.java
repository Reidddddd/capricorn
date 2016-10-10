package leetcode.java.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DesignTwitter_355 {
  private HashMap<Integer, HashSet<Integer>> users;
  private LinkedList<Tweets> tweets;

  /** Initialize your data structure here. */
  public DesignTwitter_355() {
    this.users = new HashMap<>();
    this.tweets = new LinkedList<>();
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    tweets.addFirst(new Tweets(userId, tweetId));
    users.putIfAbsent(userId, new HashSet<>());
  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
   * be posted by users who the user followed or by the user herself. Tweets must be ordered from
   * most recent to least recent.
   */
  public List<Integer> getNewsFeed(int userId) {
    HashSet<Integer> following = users.getOrDefault(userId, new HashSet<>());
    return tweets.stream().filter(t -> userId == t.userId || following.contains(t.userId))
        .map(t -> t.tweetId).limit(10).collect(Collectors.toList());
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    HashSet<Integer> following = users.getOrDefault(followerId, new HashSet<>());
    following.add(followeeId);
    users.putIfAbsent(followerId, following);
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    HashSet<Integer> following = users.get(followerId);
    if (following == null) return;
    following.remove(followeeId);
  }

  class Tweets {
    int userId;
    int tweetId;
    public Tweets(int userId, int tweetId) {
      this.userId = userId;
      this.tweetId = tweetId;
    }
  }
}
