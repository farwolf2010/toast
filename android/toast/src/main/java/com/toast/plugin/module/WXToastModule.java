package com.toast.plugin.module;


import android.widget.Toast;

import com.farwolf.weex.annotation.WeexModule;
import com.farwolf.weex.base.WXModuleBase;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;

import java.util.HashMap;

//此注解将自动注册module到weex
@WeexModule(name="toast")
public class WXToastModule extends WXModuleBase {


    @JSMethod
    public void open(HashMap param){
        String content="";
        if(param.containsKey("msg"))
            content= param.get("msg")+"";
        Toast.makeText(mWXSDKInstance.getContext(), content, Toast.LENGTH_SHORT).show();
    }


//    //**
//    //异步返回
//    @JSMethod
//    public void log(JSCallback callback){
//        Log.e("error","");
//        HashMap m=new HashMap();
//        m.put("code",0);
//        callback.invoke(m);
//    }
//
//
//
    //**
    //同步返回
    @JSMethod(uiThread = false)
    public String  getData(){
        return "name";
    }

    //**
    //异步返回
    @JSMethod
    public void  getDataSyc(JSCallback callback){
        HashMap m=new HashMap();
        m.put("name","张三");
        callback.invoke(m);
    }




}
