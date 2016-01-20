package com.vector.rxjava.test002.array;

import rx.Observable;
import rx.functions.Action1;

/** 
 * @author VectorHuang
 * @email  642378415@qq.com
 * @date 2016年1月20日 下午4:02:01 
 * @version 1.0 
 */
public class ArrayEvent {
	
	/**
	 * 发出一个数组事件，我们就把下面的events 发出去
	 */
	
	private static final String[] events= {"Java","RxJava","Android","Netty","EventBus","Otto"};
	
	public static void main(String[] args) {
		
		/**
		 * 很简单，from(T[] array) 静态方法，当然还有很多形式的from(xxx) 方法，自行查看
		 */
		Observable<String> observable = Observable.from(events);
		
		/**
		 * Action1 是RxJava 内置的ActionX 系列接口，只有一个call 方法，
		 * 用来转换为Subcribe(用户，就是这个家伙去订阅公众号的)的。
		 * Action1 证明call 方法只有1 个参数
		 * Action2 证明call 方法只有2 个参数
		 * Action3 证明call 方法只有X 个参数
		 */
		Action1<String> book = new Action1<String>() {

			@Override
			public void call(String t) {
				System.out.println(t);
			}
		};
		
		/**
		 * 同样去订阅
		 * 打印：
		 * Java
		 * RxJava
		 * Android
		 * Netty
		 * EventBus
		 * Otto
		 */
		observable.subscribe(book);
		
		//lambda 表达式，不建议使用lambda，因为会覆盖很多原理性的东西。
		//Observable.from(events).subscribe(b -> System.out.println(b));
	}
	
}
