/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.data;

//import core.communication.DatabaseHandler;
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

    public Post(String postContent, Date postDate, int postTopic, int postBy) {
        this.postContent = postContent;
        this.postDate = postDate;
        this.postTopic = postTopic;
        this.postBy = postBy;
    }
    
    
/*    public int getPostId() {
	return postId;
    }
*/
    public String getPostContent() {
	return postContent;
    }

    public Date getPostDate() {
	return postDate;
    }

    public Topic getPostTopic() {
	//return DatabaseHandler.searchTopicById(dbConnection, postTopic);
        return DataWorker.searchTopicById(postTopic);
    }

    public User getPostBy() {
	//return DatabaseHandler.searchUserById(dbConnection, postBy);
        return DataWorker.searchUserById(postBy);
    }
    
    
    
}
