package com.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.beans.Playlist;
import com.hibernate.beans.Song;


public class EmployeeRepository {
	
	Session session = null;
	SessionFactory sessionFactory = null;
	public void addPlaylist(Playlist playlist) {
		Transaction transaction=null;
		
		try {
			Session session=getHibernateSession();
			transaction=session.beginTransaction();
			session.save(playlist);
			transaction.commit();
			System.out.println("An employee added successfully");
		}catch(HibernateException e) {
			System.out.println(e.getMessage());
			if(transaction!=null) {
				transaction.rollback();
			}
		}finally {
		//	session.flush();
			session.close();
		}
	}
	
	public void deletePlaylist(int playlistId) {
		Transaction transaction=null;
		Playlist p = new Playlist();
	
		try {
			Session session=getHibernateSession();
			transaction=session.beginTransaction();
			p=session.get(Playlist.class, playlistId);
			session.delete(p);
			transaction.commit();
			System.out.println("An employee has been removed successfully");
		}catch(HibernateException e) {
			System.out.println(e.getMessage());
			if(transaction!=null) {
				transaction.rollback();
			}
		}finally {
			session.close();
		}
	}
	
	public void updateSong(int songId) {
		Transaction transaction=null;
		Song s = new Song();
		try {
			
			Session session=getHibernateSession();
			transaction=session.beginTransaction();
			
			s=findSong(songId);
			s.setTitle("mySong");
			s.setLyrics("mcncnn");
			s.setDescription("jazz");
			s.setAuthor("abhinay");
			s.setDuration((float) 2.5);
			session.update(s);
			transaction.commit();
			System.out.println("An employee has been successfully updated");
		}catch(HibernateException e) {
			System.out.println(e.getMessage());
			if(transaction!=null) {
				transaction.rollback();
			}
		}finally {
			//session.flush();
			session.close();
		}
	}
	
	public Song findSong(int id) {
		Song s = new Song();
		Transaction transaction=null;
		try {
			Session session=getHibernateSession();
			transaction=session.beginTransaction();
			s=session.get(Song.class, id);
			transaction.commit();
			
		}catch(HibernateException e) {
			System.out.println(e.getMessage());
			if(transaction!=null) {
				transaction.rollback();
		}
		}finally {
			session.close();
		}
		return s;
	}
	
	public Session getHibernateSession() {
		//session = getHibernateSessionFactory().getCurrentSession();
		session=getHibernateSessionFactory().openSession();
		return session;
	}
	
	
	@SuppressWarnings("deprecation")
	public SessionFactory getHibernateSessionFactory() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory;
	}


}
