package com.project.news.prajathathva.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="newspub")
public class NewsPublish {
	@Id
	@GeneratedValue
	private int id ;
	@Column(name="title")
	private String title ;
	@Column(name="matter")
	private String matter ;
	@Column(name="image")
	private byte[] image ;
	@Column(name="author")
	private String author ;
	@Column(name="cat")
	private String cat ;
	@Column(name="edate")
	private Date date ;
	
	
	public NewsPublish() {
		super();
	}
	
	
	public NewsPublish(String title, String matter, byte[] image, String author, String cat, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.matter = matter;
		this.image = image;
		this.author = author;
		this.cat = cat;
		this.date = date;
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
	public String getMatter() {
		return matter;
	}
	public void setMatter(String matter) {
		this.matter = matter;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
