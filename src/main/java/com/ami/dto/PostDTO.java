package com.ami.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ami.entity.PostAdd;

@XmlRootElement(name = "post_add")
public class PostDTO {

	private String addGuid;
	private String subCatGuid;
	private String typeGuid;
	// user-detail
	private String mailId;

	private String addDesc;
	private Integer price;
	private Boolean negotiable;
	
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	
	public PostDTO() {
		
	}
	
	public PostDTO(PostAdd postAdd)
	{
		setAddGuid(postAdd.getAddGuid());
		setAddDesc(postAdd.getAddDesc());
		setPrice(postAdd.getPrice());
		setNegotiable(postAdd.getNegotiable());
		setImage1(postAdd.getImage1());
		setImage2(postAdd.getImage2());
		setImage3(postAdd.getImage3());
		setImage4(postAdd.getImage4());
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
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
    
	@XmlElement(name = "subcat_id")
	public String getSubCatGuid() {
		return subCatGuid;
	}

	public void setSubCatGuid(String subCatGuid) {
		this.subCatGuid = subCatGuid;
	}
    
	@XmlElement(name = "type_id")
	public String getTypeGuid() {
		return typeGuid;
	}

	public void setTypeGuid(String typeGuid) {
		this.typeGuid = typeGuid;
	}

	@XmlElement(name = "is_negotiable")
	public Boolean getNegotiable() {
		return negotiable;
	}

	public void setNegotiable(Boolean negotiable) {
		this.negotiable = negotiable;
	}

	@XmlElement(name = "img1")
	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	@XmlElement(name = "img2")
	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	@XmlElement(name = "img3")
	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}
    
	@XmlElement(name = "img4")
	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	@XmlElement(name = "mailid")
	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	
}
