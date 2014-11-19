package com.ami.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "product_category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cat_guid")
	private UUID catguid;

	@Column(name = "cat_name")
	private String catName;

	@Column(name = "cat_desc")
	private String catDesc;

	/**
	 * @return the catId
	 */
	public UUID getCatId() {
		return catguid;
	}

	/**
	 * @param uuid the catId to set
	 */
	public void setCatId(UUID uuid) {
		this.catguid = uuid;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return catName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.catName = categoryName;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return catDesc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.catDesc = desc;
	}
	
	

}
