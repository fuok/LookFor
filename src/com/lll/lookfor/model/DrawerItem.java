package com.lll.lookfor.model;

public class DrawerItem {
	public int id;
	public int logo;
	public String title;

	public DrawerItem() {
		super();
	}

	public DrawerItem(int logo, String title) {
		super();
		this.logo = logo;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLogo() {
		return logo;
	}

	public void setLogo(int logo) {
		this.logo = logo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "DrawerItem [id=" + id + ", logo=" + logo + ", title=" + title
				+ "]";
	}
}
