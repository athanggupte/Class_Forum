/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.data;

import java.util.TreeMap;

/**
 *
 * @author ADMIN
 */
public class Cache {
    
    TreeMap<Integer, User> userCache;
    TreeMap<Integer, Topic> topicCache;
    TreeMap<Integer, Subject> subjectCache;

    public Cache() {
        userCache = new TreeMap<>();
        topicCache = new TreeMap<>();
        subjectCache = new TreeMap<>();
    }

    public User getUser(Integer key) {
        return userCache.get(key);
    }

    public void putUser(Integer key, User value) {
        userCache.put(key, value);
    }

    public Topic getTopic(Integer key) {
        return topicCache.get(key);
    }

    public void putTopic(Integer key, Topic value) {
        topicCache.put(key, value);
    }

    public Subject getSubject(Integer key) {
        return subjectCache.get(key);
    }

    public void putSubject(Integer key, Subject value) {
        subjectCache.put(key, value);
    }
    
    
    
}
