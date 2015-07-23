package com.mykumi.solid.lsp;

public class LspSub extends LspSuper {
	private String title;
	
	public LspSub(String name, String title) {
		super(name);
		this.title = title;
	}	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setName(String name) {
		if (this.title != null)
			this.name = this.title + " / " + this.name;
	}
}
