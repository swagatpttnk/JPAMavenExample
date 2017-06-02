package com.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CORSP_COMMENTS")
public class CorspComment {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long commentId;
        private String comments;
        private String templateId;
        private Date time;
        private String customerId;

        public CorspComment(){
        	
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