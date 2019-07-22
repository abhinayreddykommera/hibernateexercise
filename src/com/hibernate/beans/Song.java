package com.hibernate.beans;


import javax.persistence.*;


@Entity
@Table(name = "song")
public class Song {
	
	@Id
	@Column(name = "id")
	public int id;
	
	@Column(name = "title")
	public String title;
	
	@Column(name = "lyrics")
	public String lyrics;
	
	@Column(name = "description")
	public String description;
	
	@Column(name = "author")
	public String author;
	
	@Column(name = "duration")
	public float duration;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "pid")
	public Playlist playlist;
	
	

	public Song(int id, String title, String lyrics, String description, String author, float duration,
			Playlist playlist) {
		
		this.id = id;
		this.title = title;
		this.lyrics = lyrics;
		this.description = description;
		this.author = author;
		this.duration = duration;
		this.playlist = playlist;
	}


	public Song() {
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}


	
	

}
