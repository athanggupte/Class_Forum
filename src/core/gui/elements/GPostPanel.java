/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.gui.elements;

import core.data.Post;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author ADMIN
 */
public class GPostPanel extends JPanel{

    JLabel postTopicLabel;
    JLabel postContentLabel;
    JLabel postByLabel;
    JLabel postDateLabel;
    
    public GPostPanel(Post post) {
	
        postTopicLabel = new JLabel(post.getPostTopic().getTopicName());
        postContentLabel = new JLabel(post.getPostContent());
        postDateLabel = new JLabel(post.getPostDate().toString());
        postByLabel = new JLabel(post.getPostBy().getUserName());
        
        GroupLayout groupLayout = new GroupLayout(this);
        
        groupLayout.setAutoCreateContainerGaps(true);
        groupLayout.setAutoCreateGaps(true);
        
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(postByLabel)
                        .addComponent(postTopicLabel)
                        .addComponent(postContentLabel, GroupLayout.Alignment.CENTER)
        );
        
        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addComponent(postByLabel)
                        .addComponent(postTopicLabel)
                        .addGap(3)
                        .addComponent(postContentLabel)
        
        );
        setLayout(groupLayout);
        
        setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.lightGray, Color.DARK_GRAY));
        
        
    }
    
    
    
}
