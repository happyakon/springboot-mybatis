package com.akon.springboot.mybatis.utils;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsUtil {
    public static void main(String[] args) {
        List list=new ArrayList();
        boolean empty = CollectionUtils.isEmpty(list);
        System.out.println(empty);
    }

    public  static <T> boolean  isEmpty(List<T> list){
        if(list==null||list.isEmpty()){
            return true;
        }
        return false;
    }
}
