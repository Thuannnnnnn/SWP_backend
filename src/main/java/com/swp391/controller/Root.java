package com.swp391.controller;

import java.sql.Date;
import java.util.ArrayList;


public class Root{
    public String at_hash;
    public String sub;
    public boolean email_verified;
    public String iss;
    public String given_name;
    public String locale;
    public String nonce;
    public String picture;
    public ArrayList<String> aud;
    public String azp;
    public String name;
    public Date exp;
    public String family_name;
    public Date iat;
    public String email;
    
    
    public Root() {
		// TODO Auto-generated constructor stub
	}
	public String getAt_hash() {
		return at_hash;
	}
	public void setAt_hash(String at_hash) {
		this.at_hash = at_hash;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public boolean isEmail_verified() {
		return email_verified;
	}
	public void setEmail_verified(boolean email_verified) {
		this.email_verified = email_verified;
	}
	public String getIss() {
		return iss;
	}
	public void setIss(String iss) {
		this.iss = iss;
	}
	public String getGiven_name() {
		return given_name;
	}
	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public ArrayList<String> getAud() {
		return aud;
	}
	public void setAud(ArrayList<String> aud) {
		this.aud = aud;
	}
	public String getAzp() {
		return azp;
	}
	public void setAzp(String azp) {
		this.azp = azp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getExp() {
		return exp;
	}
	public void setExp(Date exp) {
		this.exp = exp;
	}
	public String getFamily_name() {
		return family_name;
	}
	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}
	public Date getIat() {
		return iat;
	}
	public void setIat(Date iat) {
		this.iat = iat;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
    
}