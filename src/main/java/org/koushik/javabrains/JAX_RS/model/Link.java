package org.koushik.javabrains.JAX_RS.model;

public class Link {
	
	private String link;
	private String rel;
	
	public Link(){
		
	}
	
	public Link(String link, String rel){
		this.link= link;
		this.rel = rel;
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	
	 public boolean equals(Object obj) {
		    Link linkToCompare = (Link)obj;
	        return (this.link == linkToCompare.link && this.rel == linkToCompare.rel);
	    }

}
