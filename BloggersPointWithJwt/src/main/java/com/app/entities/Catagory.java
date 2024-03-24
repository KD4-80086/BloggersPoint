package com.app.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name = "Category")
public class Catagory extends BaseEntity{
	
	
	@Column(name = "catagory_name", nullable = false)
	private String catagoryName;
	
	
	@OneToMany(mappedBy = "catgory", 
			cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	private List<Blog> blog = new ArrayList<>();
	
	
	// helper method : to add blog
			public void addBlog(Blog b) {
				this.blog.add(b);// can navigate from parent --> child
				b.setCatgory(this);// can navigate from child --> parent
			}

			// helper method : to remove blog
			public void removeBlog(Blog b) {
				this.blog.remove(b);
				b.setUser(null);


}
}			
