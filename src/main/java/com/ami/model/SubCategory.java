package com.ami.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "product_sub_category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SubCategory  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//private Category category;

	@Id
	@Column(name = "sub_cat_guid")
	private String subcatguid;

	@Column(name = "sub_cat_name")
	private String subCatName;

	@Column(name = "sub_cat_desc")
	private String subCatDesc;
	
	@ManyToOne
    @JoinColumn(name = "cat_guid")
	private Category category;
	
	
	public Category getCategory() {
        return category;
    }
 
    public void setCategory(Category category) {
        this.category=category;
    }
	

}
