package com.action;

import com.beans.Student;
import com.beans.Teacher;
import com.opensymphony.xwork2.ActionContext;
import com.service.LoginService;
import com.service.impl.LoginServiceImpl;

public class LoginAction extends LoginParamsAction {
    public String login(){
        LoginService loginService=new LoginServiceImpl();
        Object obj=loginService.login(getAccount(),getPassword(),getStatus());
        if(obj!=null){
            if(getStatus()==0){
                Student student=(Student)obj;
                getRequest().getSession().setAttribute("student",student);
                ActionContext.getContext().put("pageName","stumain.jsp");
            }
            else{
                Teacher teacher=(Teacher)obj;
                getRequest().getSession().setAttribute("teacher",teacher);
                ActionContext.getContext().put("pageName","teamain.jsp");
            }
            return "success";
        }
        else{
            ActionContext.getContext().put("pageName","login.jsp");
            return "failure";
        }
    }
    public String register(){
        LoginService loginService=new LoginServiceImpl();
        boolean flag=false;
        if(getStatus()==1){
            flag=loginService.register(getTeacher(),getStatus());
        }
        else{
            flag=loginService.register(getStudent(),getStatus());
        }
        if(flag){
            ActionContext.getContext().put("messages","注册成功");
        }
        else {
            ActionContext.getContext().put("messages","注册失败");
        }
        return "success";
    }
}
