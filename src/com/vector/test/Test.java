package com.vector.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/** 
 * @author VectorHuang
 * @email  642378415@qq.com
 * @date 2016年1月20日 下午5:04:38 
 * @version 1.0 
 */
public class Test {

//	public static final String url = "http://www.koudaihk.com:8080/server/api/user/custom/getMyFriends?version=271&apiVersion=2.0&platform=0&access_token=62617d87-095e-4ed6-8839-baadca23f827";
	public static final String url = "http://www.baidu.com";
	
	public static void main(String[] args) {
		OkHttpClient okHttpClient = new OkHttpClient.Builder()
				.connectTimeout(20, TimeUnit.SECONDS)
				.build();
		
		Request request = new Request.Builder()
				.url(url)
				.build();
		
		okHttpClient.newCall(request).enqueue(new Callback() {
			
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				System.out.println("11 -- "+response.code());
				System.out.println(response.body().string());
			}
			
			@Override
			public void onFailure(Call call, IOException e) {
				e.printStackTrace();
				okHttpClient.dispatcher();
			}
		});
	}
	
}
