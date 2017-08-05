package com.neo.hashmap;

import java.util.HashMap;

public class HashTest {

	public static void main(String[] args) {
		
		int hashMapSize = 10000;
		
    //不好的哈希算法
		HashMap<BadHash, Integer> badHashMap = new HashMap<BadHash,Integer>();
		long begin = System.currentTimeMillis();
		for (int i = 0; i < hashMapSize; i++) 
		{
			badHashMap.put(new BadHash(Double.valueOf(i)), Integer.valueOf(i));
		}
		for (int i = 0; i < hashMapSize; i++) {
			badHashMap.get(new BadHash(Double.valueOf(i)));
		}
		
		System.out.println(System.currentTimeMillis() - begin);
		
		//好的哈希算法
		HashMap<GoodHash, Integer> goodHashMap = new HashMap<GoodHash,Integer>();
		long beginGood = System.currentTimeMillis();
		for (int i = 0; i < hashMapSize; i++) 
		{
			goodHashMap.put(new GoodHash(Double.valueOf(i)), Integer.valueOf(i));
		}
		for (int i = 0; i < hashMapSize; i++) {
			goodHashMap.get(new GoodHash(Double.valueOf(i)));
		}
		
		System.out.println(System.currentTimeMillis() - beginGood);
	}

}
