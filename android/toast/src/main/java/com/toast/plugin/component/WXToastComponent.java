package com.toast.plugin.component;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.farwolf.weex.annotation.WeexComponent;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.toast.plugin.view.ToastView;

import java.util.HashMap;

//此toast演示了如何制作一个界面组件
//可以改名后直接在这上面改，也可以删除了自己写
//name:在vue中标签的名字
//此注解将自动注册组件到weex
@WeexComponent(name="toast")
public class WXToastComponent extends WXComponent<ToastView> {
    public WXToastComponent(WXSDKInstance instance, WXVContainer parent, BasicComponentData basicComponentData) {
        super(instance, parent, basicComponentData);
    }

    //**1.在这个方法里返回目标view
    @Override
    protected ToastView initComponentHostView(@NonNull Context context) {
        return new ToastView(context);
    }

    //2.此函数用来初始化
    @Override
    protected void onHostViewInitialized(ToastView host) {
        super.onHostViewInitialized(host);

    }


    //**组件的方法只支持异步，不支持同步，请用callback接收值
    @JSMethod
    public void getData(JSCallback callback){
        String content="this is toast!";
        Toast.makeText(getContext(), content, Toast.LENGTH_SHORT).show();
        HashMap m=new HashMap();
        m.put("name",content);
        callback.invoke(m);
    }

   //**android 是通过注解定义属性的
    @WXComponentProp(name = "color")
    public void setColor(String color){
        getHostView().setBackgroundColor(Color.parseColor(color));
        //setSeekBarColor(getHostView(), Color.parseColor(color));

    }

}
