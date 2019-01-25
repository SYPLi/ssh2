package com.action;

import com.beans.Stu_Tea;
import com.beans.Student;
import com.opensymphony.xwork2.ActionContext;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;

import java.util.Map;

public class StudentAction extends StudentParamsAction {
    public String initialize(){
        Student student=(Student) getRequest().getSession().getAttribute("student");
        StudentService studentService=new StudentServiceImpl();
        Map<String,Object> map=studentService.initialize(student.getId());
        ActionContext.getContext().put("messages",map);
        return "success";
    }
    public void apply(){
        Student student=(Student) getRequest().getSession().getAttribute("student");
        Stu_Tea stu_tea=new Stu_Tea();
        stu_tea.setStu_id(student.getId());
        stu_tea.setTea_id(getTea_id());
        stu_tea.setStatus(0);
        StudentService studentService=new StudentServiceImpl();
        studentService.apply(stu_tea);
    }
}
