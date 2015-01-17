//
//  CalculatorBrain.h
//  Caculator
//
//  Created by Maya Gort on 1/16/15.
//  Copyright (c) 2015 Maya Gort. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface CalculatorBrain : NSObject

-(void)pushOperand: (double)operand;
-(double)performOperation: (NSString *)operation;

@end