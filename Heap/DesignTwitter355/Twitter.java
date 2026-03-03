package Strivers_dsa.Heap.DesignTwitter355;
// design Twitter LeetCode problem 355
import java.util.*;

public class Twitter {

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {

    }
    public List<Integer> getNewsFeed(int userId) {

        return null;
    }

    public void follow(int followerId, int followeeId) {
    }

    public void unfollow(int followerId, int followeeId) {

    }
}



/*

public class Twitter {
    HashMap<Integer, HashSet<Integer>> followers; // store every user and their followings
    LinkedHashMap<Integer, Integer> tweets; // stores every tweet with user id with new one at first position
    public Twitter() {
        followers =new HashMap<>();
        tweets=new LinkedHashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if(!followers.containsKey(userId))
            followers.put(userId,new HashSet<>());
        tweets.putFirst(tweetId,userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        if(!followers.containsKey(userId))
            followers.put(userId,new HashSet<>());
        List<Integer> newsFeed=new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry:tweets.entrySet()){
            if(newsFeed.size()==10)
                break;
            if(followers.get(userId).contains(entry.getValue())||entry.getValue()==userId){
                newsFeed.add(entry.getKey());
            }
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId))
            followers.put(followerId,new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId))
            followers.put(followerId,new HashSet<>());
        followers.get(followerId).remove(followeeId);
    }
}
 */