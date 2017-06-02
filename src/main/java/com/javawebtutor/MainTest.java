package com.javawebtutor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.entity.CorspComment;
import com.entity.Player;
import com.entity.Team;
import com.entity.iddemo.CommentEntity;


public class MainTest {
        private static final String PERSISTENCE_UNIT_NAME = "CORSPLOCAL";
        private static EntityManagerFactory factory;

        public static void main(String[] args) {
        	MainTest main=new MainTest();
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                EntityManager em = factory.createEntityManager();
                EntityTransaction txn=em.getTransaction();
                txn.begin();
                main.testIdGen(em);
                txn.commit();
                //main.demoManyToOneBidirectional(em);               
                //main.getPlayersByTeam(em,1);
                //main.getTeamByPlayer(em,2);
               /* List<Player> players = new ArrayList<Player>();
                Team team=new Team();
                team.setId(2);
                team.setName("MancesterUnited");
                team.setPlayers(players);
                main.addTeam(em,team);
                
                em.getTransaction().commit();
                em.close();
                System.out.println("Before Adding player to Team.........");
                Team team=em.find(Team.class, 2);
                main.getPlayersByTeam(em,team.getId());
                */
               /* System.out.println("Now Adding player to Team.........");
                Player player=new Player();
                player.setId(3);player.setLastname("Peresa");
                main.addPlayer(em,player,team);
                
                em.getTransaction().commit();
                
                System.out.println("After Adding player to Team.........");
                main.getPlayersByTeam(em,team.getId());*/
                em.close();
        }
        void testIdGen( EntityManager em){
        	
            CommentEntity cm=new CommentEntity();
            //cm.setCommentId(commentId);
            cm.setComments("Used TABLE Generator");
            cm.setCustomerId("DMCST1");
            cm.setTemplateId("EEM_RR_NEPG");            
            em.persist(cm);
        }
        void getPlayersByTeam(EntityManager em,Integer teamId){
        	Team team=em.find(Team.class, teamId);
        	System.out.println("team_Id:"+team.getId()+" ,team_name:"+team.getName());
        	List<Player> players=team.getPlayers();
        	for(Player player:players){
        		System.out.println("player_Id:"+player.getId()+" ,player_lastname:"+player.getLastname());
        	}
        }
        void getTeamByPlayer(EntityManager em,Integer playerId){
        	Player player=em.find(Player.class, playerId);
        	Team team=player.getTeam();
        	System.out.println("Team "+team.getName()+" is associated with Player"+ player.getLastname());
        }
        void addTeam(EntityManager em,Team team){
        	em.persist(team);
        }
        void addPlayer(EntityManager em,Player player,Team team){
        	
        	player.setTeam(team);
        	em.merge(player);
        }
        void getPlayerByCriteria(EntityManager em){
        	
        	List<Player> players = new ArrayList<Player>();
    		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    		CriteriaQuery<Player> criteriaQuery = criteriaBuilder.createQuery(Player.class);
    		Root<Player> root = criteriaQuery.from(Player.class);
    		criteriaQuery.select(root);
    		criteriaQuery.where(criteriaBuilder.equal(root.<String>get("cmsOutboundStatus"), "START"));
    		System.out.println(" size :"+em.createQuery(criteriaQuery).getResultList().size());
    		players= em.createQuery(criteriaQuery).getResultList();
        }
        void demoManyToOneBidirectional(EntityManager em){
        	Team team = new Team("Barcelona");
        	team.setId(1);
            List<Player> players = new ArrayList<Player>();
             
            Player p1 = new Player("Messi");
            Player p2 = new Player("Xavi");
            
            p1.setId(1);            
            p2.setId(2);
            
            p1.setTeam(team);
            p2.setTeam(team);
             
            players.add(p1);
            players.add(p2);
            
            
            team.setPlayers(players);
            
            em.persist(team);
        }
        void demoSimplePersist(EntityManager em){
        	CorspComment c1=new CorspComment();
            /*Long commentId=new Long(1);
            c1.setCommentId(commentId);*/
            c1.setComments("Bla kgasdkjas Blka");
            c1.setCustomerId("BCBSTN");
            c1.setTemplateId("223");
            c1.setTime(new Date());
            em.persist(c1);
        }
}