package com.hibernate.main;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.beans.Playlist;
import com.hibernate.beans.Song;
import com.hibernate.util.EmployeeRepository;

public class Main {

	public static void main(String[] args) {
		EmployeeRepository emp = new EmployeeRepository();
		List<Song> list = new ArrayList<>();
		
//		Playlist p = new Playlist(1,"mysong",list);
//		Song s = new Song(1,"title","mylyrics","jazz","abhi",(float) 4.2,p);
//		
//		p = new Playlist(2,"hersong",list);
//		Song s2 = new Song(2,"mytitle","hislyrics","melody","sid",(float) 3.5,p);
//		
//		p = new Playlist(3,"hissong",list);
//		Song s3 = new Song(3,"histitle","herlyrics","beat","pat",(float) 2.5,p);
//		list.add(s);
//		list.add(s2);
//		list.add(s3);
		//emp.addPlaylist(p);
		//emp.deletePlaylist(3);
		emp.updateSong(2);
	

	}

}
