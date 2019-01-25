package com.service;

import com.beans.Stu_Tea;

import java.util.Map;

public interface StudentService {
    public Map<String,Object> initialize(int id);
    public void apply(Stu_Tea stu_tea);
}
