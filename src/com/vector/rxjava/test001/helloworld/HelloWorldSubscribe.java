package com.vector.rxjava.test001.helloworld;

import rx.Observable;
import rx.Observer;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

/**
 * @author VectorHuang
 * @email 642378415@qq.com
 * @date 2016年1月20日 下午3:39:27
 * @version 1.0
 */
public class HelloWorldSubscribe {

	public static void main(String[] args) {

		
		/**
		 * 为了方便学习我们称ObServable 公众号，微信公众号专门发送消息的。 -- 可被订阅者，被观察者
		 * Observer & Subscribe 是用户，来订阅公众号的。 -- 订阅者，观察者
		 */
		
		/**
		 * create 静态方法可以创建一个公众号，但是也集成了很多其他的静态方法来创建
		 * just(T t)：创建一个只发出一个消息就调用onComplete()的公众号
		 */
		Observable<String> observable = Observable.just("Hello Wrold!!");

		/**
		 * Subscriber 也是用户的一种，当订阅了公众号后会做处理的
		 */
		Subscriber<String> subscribe = new Subscriber<String>() {

			/**
			 * 下面三个方法都是被回调的，定了公众号后自动回调
			 * onCompleted() &onError(Throwable e) 两者一定调用其中一个，调用了一个之后就完毕了，不会两个都调用的
			 */
			
			@Override
			public void onCompleted() {
				System.out.println("onCompleted()");
			}

			@Override
			public void onError(Throwable e) {
				e.printStackTrace();
			}

			@Override
			public void onNext(String t) {
				System.out.println(t);
			}
		};

		/**
		 * 用户订阅公众号，会触发公众号的call 方法
		 * 
		 * 打印结果
		 * Hello Wrold!!
		 * onCompleted()
		 * 
		 */
		observable.subscribe(subscribe);
		
	}

}
