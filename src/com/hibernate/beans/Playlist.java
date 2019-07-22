package com.hibernate.beans;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="playlist")
public class Playlist {
	@Id
	@Column(name="id")
	public int id;
	
	@Column(name="name")
	public String name;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="playlist",cascade=CascadeType.ALL)
	public List<Song> songs;
	
	public Playlist() {
		
	}

	public Playlist(int id, String name, List<Song> songs) {
		this.id = id;
		this.name = name;
		this.songs = songs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + getId() + ", name=" + getName() + ", songs=" + getSongs() + "]";
	}
	
	
	
	

}
