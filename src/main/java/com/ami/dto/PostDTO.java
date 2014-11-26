package com.ami.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ami.entity.PostAdd;

@XmlRootElement(name = "subcategory")
public class PostDTO {

	private String addGuid;
	private String addDesc;
	private int price;
	private Byte negotiable;
	
	public PostDTO() {
		
	}
	
	public PostDTO(PostAdd postAdd)
	{
		setAddGuid(postAdd.getAddGuid());
		setAddDesc(postAdd.getAddDesc());
		setPrice(postAdd.getPrice());
		setNegotiable(postAdd.getNegotiable());
	}

	@XmlElement(name = "id")
	public String getAddGuid() {
		return addGuid;
	}

	public void setAddGuid(String addGuid) {
		this.addGuid = addGuid;
	}

	@XmlElement(name = "desc")
	public String getAddDesc() {
		return addDesc;
	}

	public void setAddDesc(String addDesc) {
		this.addDesc = addDesc;
	}

	@XmlElement(name = "price")
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@XmlElement(name = "isnegotiable")
	public Byte getNegotiable() {
		return negotiable;
	}

	public void setNegotiable(Byte negotiable) {
		this.negotiable = negotiable;
	}
	
	
	
}
