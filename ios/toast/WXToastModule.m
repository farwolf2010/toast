//
//  WXToastModule.m
//  AFNetworking
//
//  Created by 郑江荣 on 2019/5/28.
//

#import "WXToastModule.h"
#import "Toast.h"

//注册module，名字叫toast
WX_PlUGIN_EXPORT_MODULE(toast, WXToastModule)

@implementation WXToastModule
    
@synthesize weexInstance;
//异步方法
WX_EXPORT_METHOD(@selector(log:callback:))
WX_EXPORT_METHOD(@selector(open:))
//同步返回方法注册
WX_EXPORT_METHOD_SYNC(@selector(getData))
WX_EXPORT_METHOD(@selector(getDataSyc:))
    
    
   
-(void)open:(NSMutableDictionary*)param{
    NSString *content=@"";
    if(param[@"msg"]){
        content=param[@"msg"];
    }
      [[Toast create:[UIApplication sharedApplication].keyWindow] toast:content];
}
    
-(void)log:(NSMutableDictionary*)param  callback:(WXModuleCallback)callback{
    NSLog(@"invoke");
}
    
-(NSString*)getData{
    return @"name";
}
    
-(void)getDataSyc:(WXModuleCallback)callback{
//    NSMutableDictionary *res=[NSMutableDictionary new];
//    res[@"name"]=@"张三";
//      callback(res);
    callback(@{@"name":@"张三"});
}
    
 
@end
