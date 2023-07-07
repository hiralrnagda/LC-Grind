class Twitter {
    private static int timeStamp = 0;
    // easy to find if user exist
    private Map<Integer, User> userMap;

    private class Tweet {
        public int id;
        public int time;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }

    public class User {
        private int id;
        private Set<Integer> followed;
        Tweet tweet_head;

        public User(int id) {
            this.id = id;
            followed = new HashSet();
            follow(id);
            tweet_head = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = tweet_head;
            tweet_head = tweet;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<Integer, User>();
    }

    // compose a new tweet
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User u = new User(userId);
            userMap.put(userId, u);
        }
        userMap.get(userId).post(tweetId);
    }

    // Best part of this.
    // first get all tweets lists from one user including itself and all people it
    // followed.
    // Second add all heads into a max heap. Every time we poll a tweet with
    // largest time stamp from the heap, then we add its next tweet into the heap.
    // So after adding all heads we only need to add 9 tweets at most into this
    // heap before we get the 10 most recent tweet.
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        if (!userMap.containsKey(userId))
            return res;

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> heap = new PriorityQueue<Tweet>(users.size(), (a, b) -> b.time - a.time);

        for (int user : users) {
            Tweet t = userMap.get(user).tweet_head;
            // very imporant! If we add null to the head we are screwed.
            if (t != null) {
                heap.add(t);
            }
        }

        int n = 0;
        while (!heap.isEmpty() && n < 10) {
            Tweet t = heap.poll();
            res.add(t.id);
            n++;
            if (t.next != null) {
                heap.add(t.next);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if (!userMap.containsKey(followeeId)) {
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId)
            return;
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */