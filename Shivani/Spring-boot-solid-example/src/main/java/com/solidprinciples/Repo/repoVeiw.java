package com.solidprinciples.Repo;

import org.springframework.beans.factory.annotation.Autowired;

import com.solidpriciples.modals.User;
import com.solidprinciples.services.ServiceInterface;

public class repoVeiw {
    User user;
    public repoVeiw(User user) {
    	this.user=user;
    }
    public void searchUser() {
    	//logic to search user goes here
    	//This way single responsibility is achieved
    }
    @Autowired
    private ServiceInterface service;
    public void sendOTP() {
    	//System.out.println(service.sendOTP());
    	//primary bean will be injected here
    }
    
}
