package com.akon.springboot.mybatis.utils;

import java.util.List;

public class CollectionsUtil {

    public  static <T> boolean  isEmpty(List<T> list){
        if(list==null||list.isEmpty()){
            return true;
        }
        return false;
    }
}
