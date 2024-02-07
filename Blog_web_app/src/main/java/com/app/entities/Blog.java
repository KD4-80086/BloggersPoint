package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "blog")
public class Blog extends BaseEntity{
	
	
	private static final int MIN_TITLE_LENGTH = 7;
	
	@Length(min = MIN_TITLE_LENGTH, message = "Title must be at least " + MIN_TITLE_LENGTH + " characters long")
	@NotEmpty(message = "Please enter the title")
	@Column(name = "title", nullable = false)
	private String title;
	
	@NotEmpty(message = "Write something for the love of Internet...")
	@Column(name = "body", columnDefinition = "TEXT", nullable = false)
	private String body;
	
	@CreationTimestamp
	@Column(name = "creation_date", nullable = false,updatable=false)
	private LocalDate creationDate;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;
	


	
}
