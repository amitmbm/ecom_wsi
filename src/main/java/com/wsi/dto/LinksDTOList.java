package com.wsi.dto;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class LinksDTOList {

	ArrayList<LinksDTO> linksDTOs;
	public LinksDTOList() {}
	
	@XmlElement(name = "links")
	public ArrayList<LinksDTO> getLinksDTOs() {
		return linksDTOs;
	}

	public void setLinksDTOs(ArrayList<LinksDTO> linksDTOs) {
		this.linksDTOs = linksDTOs;
	}
}
