package com.entity.iddemo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "CORSP_COMMENTS")
public class CommentEntity {
        @Id
        @TableGenerator(name="TABLE_GEN", table="TEST_SEQUENCE_TABLE", pkColumnName="SEQ_NAME",
        valueColumnName="SEQ_COUNT", pkColumnValue="CORSP_COMMENTS_SEQ",allocationSize=1)
        @GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_GEN")
        @Column(name="COMMENTID")
        private Long commentId;
        
        @Column(name="COMMENTS")
        private String comments;
        
        @Column(name="TEMPLATEID")
        private String templateId;
        
        @Column(name="TIME")
        private Date time;
        
        @Column(name="CUSTOMERID")
        private String customerId;

        public CommentEntity(){
        	
        }

        public Long getCommentId() {
			return commentId;
		}


		public String getComments() {
			return comments;
		}


		public String getTemplateId() {
			return templateId;
		}


		public Date getTime() {
			return time;
		}


		public String getCustomerId() {
			return customerId;
		}


		public void setCommentId(Long commentId) {
			this.commentId = commentId;
		}


		public void setComments(String comments) {
			this.comments = comments;
		}


		public void setTemplateId(String templateId) {
			this.templateId = templateId;
		}


		public void setTime(Date time) {
			this.time = time;
		}


		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}


		@Override
        public String toString() {
                return "Todo [commentId=" + commentId + ", comments=" + comments
                                + ",templateId="+templateId+",time="+time+
                                ",customerId="+customerId+"]";
        }

}