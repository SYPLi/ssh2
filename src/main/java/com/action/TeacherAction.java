package com.action;

import com.beans.Stu_Tea;
import com.beans.Student;
import com.beans.Teacher;
import com.opensymphony.xwork2.ActionContext;
import com.service.StudentService;
import com.service.TeacherService;
import com.service.impl.StudentServiceImpl;
import com.service.impl.TeacherServiceImpl;

import java.util.Map;

public class TeacherAction extends TeacherParamsAction {
    public String initialize(){
        Teacher teacher=(Teacher)getRequest().getSession().getAttribute("teacher");
        TeacherService teacherService=new TeacherServiceImpl();
        Map<String,Object> map=teacherService.initialize(teacher.getId());
        ActionContext.getContext().put("messages",map);
        return "success";
    }
    public void accept(){
        TeacherService teacherService=new TeacherServiceImpl();
        teacherService.accept_refuse(getId(),1);
    }
    public void refuse(){
        TeacherService teacherService=new TeacherServiceImpl();
        teacherService.accept_refuse(getId(),2);
    }
    public void cancel(){
        TeacherService teacherService=new TeacherServiceImpl();
        teacherService.cancel(getId());
    }
}
