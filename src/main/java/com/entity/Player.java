package com.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_PLAYERS")
public class Player {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)        
        private Integer id;        
        
        private String lastname;
        
        @ManyToOne
        @JoinColumn(name = "team_id")
        private Team team;
        
        public Integer getId() {
			return id;
		}

		public String getLastname() {
			return lastname;
		}

		public Team getTeam() {
			return team;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public void setTeam(Team team) {
			this.team = team;
		}

		public Player(){
        	
        }

		public Player(String lastname) {
	        this.lastname = lastname;
	    }

		@Override
        public String toString() {
                return "Todo [id=" + id + ", lastname=" + lastname+"]";
        }

}