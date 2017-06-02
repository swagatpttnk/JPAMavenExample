package com.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_TEAMS")
public class Team {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String name;

        @OneToMany(mappedBy="team", cascade=CascadeType.ALL)
        private List<Player> players;        
        
        public Integer getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public List<Player> getPlayers() {
			return players;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setPlayers(List<Player> players) {
			this.players = players;
		}

		public Team(){
        	
        }

		public Team(String name) {
	        this.name = name;
	    }

		@Override
        public String toString() {
                return "Todo [id=" + id + ", name=" + name+"]";
        }

}