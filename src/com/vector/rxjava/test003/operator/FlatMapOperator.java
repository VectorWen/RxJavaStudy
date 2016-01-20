package com.vector.rxjava.test003.operator;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/** 
 * @author VectorHuang
 * @email  642378415@qq.com
 * @date 2016年1月20日 下午12:10:34 
 * @version 1.0 
 */
public class FlatMapOperator {

	private static final String[] events= {"Java","RxJava","Android","Netty","EventBus","Otto"};
	
	public static void main(String[] args) {
		
		/**
		 * from 生成一个发出系列String事件的公众号
		 */
		
		Observable<String> obervable = Observable.from(events);
		
		/**
		 * 
		 * flatMap 也有映射的单词Map，很明显也是用来改变事件的种类
		 * 但是flat 是什么意思呢？vt. 使变平。
		 * 结合起来之后就是，把一个事件转换为另一个订阅号（Observable）
		 * 之后这个Observable 回调得出的事件再往下传
		 * flatMap 主要作用也是用来发出一个系列事件
		 * 
		 */
		
		/**
		 * 返回一个String 事件的Observable
		 * from 来发出一个系列事件
		 * map 来添加前缀
		 */
		
		obervable.flatMap(new Func1<String,Observable<String>>(){

			@Override
			public Observable<String> call(String t) {
				return Observable.from(events).map(s-> "flatMap -- "+s);
			}
			
		})
		
		/**
		 * Action1 接口是没有返回值的，只有call 的参数
		 */
		
		.subscribe(new Action1<String>(){

			@Override
			public void call(String t) {
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
			.flatMap(s -> Observable.from(events).map(t -> "flatMap -- -- "+t))
			.subscribe(i -> System.out.println(i));*/
	}
}
