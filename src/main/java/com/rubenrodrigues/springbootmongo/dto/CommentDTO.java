package com.rubenrodrigues.springbootmongo.dto;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String text;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant instant;
	private AuthorDTO author;
	
	public CommentDTO() {
		
	}

	public CommentDTO(String text, Instant instant, AuthorDTO author) {
		super();
		this.text = text;
		this.instant = instant;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getInstant() {
		return instant;
	}

	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

}
