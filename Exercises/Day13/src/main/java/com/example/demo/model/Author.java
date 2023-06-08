package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	@Id
	private int authorid;
	private String authorbook;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="author_book")
	private List<Book> bookinfo;
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getAuthorbook() {
		return authorbook;
	}
	public void setAuthorbook(String authorbook) {
		this.authorbook = authorbook;
	}
	public List<Book> getBookinfo() {
		return bookinfo;
	}
	public void setBookinfo(List<Book> bookinfo) {
		this.bookinfo = bookinfo;
	}
	

}
