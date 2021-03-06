package com.vector.rxjava.test003.operator;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/** 
 * @author VectorHuang
 * @email  642378415@qq.com
 * @date 2016年1月20日 下午12:03:28 
 * @version 1.0 
 */
public class FilterOperator {

	private static final String[] events= {"Java","RxJava","Android","Netty","EventBus","Otto"};
	
	public static void main(String[] args) {
		
		/**
		 * from 生成一个发出系列String事件的公众号
		 * map 把String 事件转换为Integer 事件
		 * subscribe 用户订阅这个公众号，开始工作
		 */
		
		Observable<String> obervable = Observable.from(events);
		
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
		 * filter 操作符：只有返回true 的事件才能通过
		 * 这里把字符长度为4的都过滤掉
		 * 
		 * 同样适用Func1 接口完成
		 */
		
		.filter(new Func1<Integer,Boolean>(){

			@Override
			public Boolean call(Integer t) {
				return t != 4;
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
		 * from 生成一个发出系列String事件的公众号
		 * map 把String 事件转换为Integer 事件
		 * subscribe 用户订阅这个公众号，开始工作
		 */
		/*Observable.from(events)
			.map(s -> s.length())
			.filter(i -> i != 4)
			.subscribe(i -> System.out.println(i));*/
	}
}
