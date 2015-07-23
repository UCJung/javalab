package com.mykumi.solid.lsp;

public class LspClient {

	public static void main(String[] args) {
		LspSuper lsp = new LspSuper("mykumi");
		LspSub lsp2 = new LspSub("mykumi", null);
		lsp.setName("mkjung");
		System.out.println(lsp.getName());
		
		lsp2.setName("mkjung");
		System.out.println(lsp2.getName());
	}

}
