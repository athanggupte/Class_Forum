/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.data;

import core.communication.DatabaseHandler;
import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Post {
    
    int postId;
    String postContent;
    java.sql.Date postDate;
    int postTopic;
    int postBy;

    public int getPostId() {
	return postId;
    }

    public String getPostContent() {
	return postContent;
    }

    public Date getPostDate() {
	return postDate;
    }

    public Topic getPostTopic(java.sql.Connection dbConnection) {
	return DatabaseHandler.searchTopicById(dbConnection, postTopic);
    }

    public User getPostBy(java.sql.Connection dbConnection) {
	return DatabaseHandler.searchUserById(dbConnection, postBy);
    }
    
    
    
}
