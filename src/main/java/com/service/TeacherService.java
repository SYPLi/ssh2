package com.service;

import java.util.Map;

public interface TeacherService {
    public Map<String,Object> initialize(int id);
    public void accept_refuse(int id,int status);
    public void cancel(int id);
}
