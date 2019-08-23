package com.johnny.johnnyBlog.entity;

import java.sql.Timestamp;

public class FullTestBug {
	private String bug_id;
	private String product_name;
	private String module_name;
	private String project_name;
	private String version;
	private String person_name;
	private Timestamp deadline;
	private String bugtype_name;
	private String bug_title;
	private String bug_content;
	private String bug_content_withoutHtml;
	public String getBug_id() {
		return bug_id;
	}
	public void setBug_id(String bug_id) {
		this.bug_id = bug_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getModule_name() {
		return module_name;
	}
	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public Timestamp getDeadline() {
		return deadline;
	}
	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}
	public String getBugtype_name() {
		return bugtype_name;
	}
	public void setBugtype_name(String bugtype_name) {
		this.bugtype_name = bugtype_name;
	}
	public String getBug_title() {
		return bug_title;
	}
	public void setBug_title(String bug_title) {
		this.bug_title = bug_title;
	}
	public String getBug_content() {
		return bug_content;
	}
	public void setBug_content(String bug_content) {
		this.bug_content = bug_content;
	}
	
	@Override
	public String toString() {
		return "FullTestBug [bug_id=" + bug_id + ", product_name=" + product_name + ", module_name=" + module_name
				+ ", project_name=" + project_name + ", version=" + version + ", person_name=" + person_name
				+ ", deadline=" + deadline + ", bugtype_name=" + bugtype_name + ", bug_title=" + bug_title
				+ ", bug_content=" + bug_content + ", bug_content_withoutHtml=" + bug_content_withoutHtml + "]";
	}
	public String getBug_content_withoutHtml() {
		return bug_content_withoutHtml;
	}
	public void setBug_content_withoutHtml(String bug_content_withoutHtml) {
		this.bug_content_withoutHtml = bug_content_withoutHtml;
	}
	
	
}
