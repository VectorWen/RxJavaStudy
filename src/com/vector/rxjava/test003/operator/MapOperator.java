package com.vector.rxjava.test003.operator;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/** 
 * @author VectorHuang
 * @email  642378415@qq.com
 * @date 2016年1月20日 下午11:43:27 
 * @version 1.0 
 */
public class MapOperator {

	public static void main(String[] args) {
		
		/**
		 * just 生成一个发出String事件的公众号
		 * map 把String 事件转换为Integer 事件
		 * subscribe 用户订阅这个公众号，开始工作
		 */
		
		Observable<String> obervable = Observable.just("Map 操作符是把一个事件映射成另外一个事件的");
		
		/**
		 * FuncX 系列接口，有一个返回值，对应的call 方法有X 个参数。想知道更多可以到jar 包里面查看，很整齐的排列的
		 * map 操作符：把一个事件转换为另外一个对象。
		 */
		obervable.map(new Func1<String,Integer>(){

			@Override
			public Integer call(String t) {
				return t.length();
			}
			
		})
		
		/**
		 * Action1 接口是没有返回值的，只有call 的参数
		 */
		
		.subscribe(new Action1<Integer>(){

			@Override
			public void call(Integer t) {
				System.out.println(t);
			}
			
		});
		
		/**
		 * lambda 表达式
		 */
		
		/**
		 * just 生成一个发出String事件的公众号
		 * map 把String 事件转换为Integer 事件
		 * subscribe 用户订阅这个公众号，开始工作
		 */
		Observable.just("Map 操作符是把一个事件映射成另外一个事件的")
			.map(s -> s.length())
			.subscribe(i -> System.out.println(i));
	}
}
