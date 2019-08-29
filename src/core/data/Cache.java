/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.data;

import java.util.ArrayDeque;
import java.util.TreeMap;

/**
 *
 * @author ADMIN
 */
public class Cache {
    
    ArrayDeque<Integer> userQueue;
    ArrayDeque<Integer> topicQueue;
    ArrayDeque<Integer> subjectQueue;
    
    TreeMap<Integer, User> userCache;
    TreeMap<Integer, Topic> topicCache;
    TreeMap<Integer, Subject> subjectCache;

    public Cache() {
        userQueue = new ArrayDeque<>();
        topicQueue = new ArrayDeque<>();
        subjectQueue = new ArrayDeque<>();
        
        userCache = new TreeMap<>();
        topicCache = new TreeMap<>();
        subjectCache = new TreeMap<>();
    }

    public User getUser(Integer key) {
        return userCache.get(key);
    }

    public void putUser(Integer key, User value) {
        if(userCache.size() > 11) {
            userCache.remove(userQueue.getFirst());
            userQueue.remove();
        }
        userCache.put(key, value);
        userQueue.add(key);
    }

    public Topic getTopic(Integer key) {
        return topicCache.get(key);
    }

    public void putTopic(Integer key, Topic value) {
        if(topicCache.size() > 17) {
            topicCache.remove(topicQueue.getFirst());
            topicQueue.remove();
        }
        topicCache.put(key, value);
        topicQueue.add(key);
    }

    public Subject getSubject(Integer key) {
        return subjectCache.get(key);
    }

    public void putSubject(Integer key, Subject value) {
        if(subjectCache.size() > 11) {
            subjectCache.remove(subjectQueue.getFirst());
            subjectQueue.remove();
        }
        subjectCache.put(key, value);
        subjectQueue.add(key);
    }
    
    
    
}
