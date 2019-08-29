/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.data;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Topic {
    
    int topicId;
    String topicName;
    Subject topicSubject;
    int topicUser;
    java.sql.Date topicDate;

    public Topic(String topicName, String topicSubject, int topicUser) {
	this.topicName = topicName;
     //   this.topicSubject = 
    }

    public String getTopicName() {
        return topicName;
    }

    public Subject getTopicSubject() {
        return topicSubject;
    }

    public int getTopicUser() {
        return topicUser;
    }

    public Date getTopicDate() {
        return topicDate;
    }
    
    
}
