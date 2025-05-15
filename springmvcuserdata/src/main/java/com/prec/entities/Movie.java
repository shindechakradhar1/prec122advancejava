package com.prec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies_info")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movies_id")
	private int id;
	@Column(name = "movies_name")
	private String movieName;
	@Column(name = "movies_release_date")
	private String releaseDate;
	@Column(name = "movies_actor_name")
	private String actorName;

	public Movie() {}

	public Movie(int id, String movieName, String releaseDate, String actorName) {
		this.id = id;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.actorName = actorName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", releaseDate=" + releaseDate + ", actorName="
				+ actorName + "]";
	}

}
