package com.action;

import com.beans.Student;
import com.beans.User;
import com.opensymphony.xwork2.ActionContext;
import com.utils.HibUtil;

public class Test {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String query(){
        User user=(User)HibUtil.get(User.class,1);
        ActionContext.getContext().getSession().put("user",user);
        ActionContext.getContext().put("messages",user);
        return "success";
    }
    public String update(){
        User user=(User)ActionContext.getContext().getSession().get("user");
        user.setName(name);
        boolean flag=HibUtil.update(user);
        if(flag){
            ActionContext.getContext().put("messages","修改成功");
        }
        else{
            ActionContext.getContext().put("messages","修改失败");
        }
        return "success";
    }
}
