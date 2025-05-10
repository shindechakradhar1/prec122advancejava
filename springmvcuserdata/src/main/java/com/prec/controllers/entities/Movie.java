package com.prec.controllers.entities;

public class Movie {
	private String movieName;
	private String releaseDate;
	private String actorName;

	public Movie() {}

	public Movie(String movieName, String releaseDate, String actorName) {
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.actorName = actorName;
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
		return "Movie [movieName=" + movieName + ", releaseDate=" + releaseDate + ", actorName=" + actorName + "]";
	}

}
