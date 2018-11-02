package com.qa.classroom.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import com.qa.classroom.utils.JSONUtil;


public class Runner
{
    public static void main( String[] args )
    {
        Trainee ben = new Trainee("Ben");
        List<Trainee> list = new ArrayList<>();
        list.add(ben);
        Classroom c = new Classroom("Matt", list);
        
        JSONUtil util = new JSONUtil();
        String s = util.getJSONfromObject(c);
        
    }
}
