package com.johnny.johnnyBlog.entity;

import java.sql.Timestamp;

public class TestBug {
	private String bug_id;
	private String product_id;
	private String module_id;
	private String project_id;
	private String version;
	private String person_id;
	private Timestamp deadline;
	private String bugtype_id;
	private String bug_title;
	private String bug_content;
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getModule_id() {
		return module_id;
	}
	public void setModule_id(String module_id) {
		this.module_id = module_id;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public Timestamp getDeadline() {
		return deadline;
	}
	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}
	public String getBugtype_id() {
		return bugtype_id;
	}
	public void setBugtype_id(String bugtype_id) {
		this.bugtype_id = bugtype_id;
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
	public String getBug_id() {
		return bug_id;
	}
	public void setBug_id(String bug_id) {
		this.bug_id = bug_id;
	}
	@Override
	public String toString() {
		return "TestBug [bug_id=" + bug_id + ", product_id=" + product_id + ", module_id=" + module_id + ", project_id="
				+ project_id + ", version=" + version + ", person_id=" + person_id + ", deadline=" + deadline
				+ ", bugtype_id=" + bugtype_id + ", bug_title=" + bug_title + ", bug_content=" + bug_content + "]";
	}
	
}
