package com.service;

public interface LoginService {
    public Object login(String account,String password,int status);
    public boolean register(Object obj,int status);
}
