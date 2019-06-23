//
//  WXToastComponent.h
//  AFNetworking
//
//  Created by 郑江荣 on 2019/5/29.
//

#import <Foundation/Foundation.h>
#import "farwolf.h"
#import "farwolf_weex.h"
#import <WeexPluginLoader/WeexPluginLoader.h>
#import <WeexSDK/WXEventModuleProtocol.h>
#import <WeexSDK/WXModuleProtocol.h>


@interface WXToastComponent : WXComponent
    
@property(nonatomic,strong)NSString* color;
    
@end


