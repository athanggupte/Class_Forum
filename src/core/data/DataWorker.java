/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.data;

import core.communication.DatabaseConnection;
import core.communication.DatabaseHandler;

/**
 *
 * @author tecomp
 */
public class DataWorker {
    
    private static DatabaseConnection dbConnection;
    private static Cache cache;

    static {
        System.out.println("DataWorker static block execution");
        dbConnection = new DatabaseConnection();
        cache = new Cache();
    }
    
    public static User searchUserById(int userId) {
        
        User user;
        user = cache.getUser(userId);
        if(user != null)
            return user;
        
        return DatabaseHandler.searchUserById(dbConnection.getConnection(), userId);
        
    }
    
    public static Topic searchTopicById(int topicId) {
        
        Topic topic;
        topic = cache.getTopic(topicId);
        if(topic != null)
            return topic;
        
        return DatabaseHandler.searchTopicById(dbConnection.getConnection(), topicId);
        
    }
    
}
