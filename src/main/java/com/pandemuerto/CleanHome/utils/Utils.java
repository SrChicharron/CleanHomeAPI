package com.pandemuerto.CleanHome.utils;

import java.util.UUID;

public class Utils {

    public String getUUIDName(String originalName){
        return UUID.randomUUID()+"_"+originalName;
    }
}
