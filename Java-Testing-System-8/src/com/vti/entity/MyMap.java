package com.vti.entity;


public class MyMap <K, V> {
	private K key;
	private V value;
	
	
	public MyMap(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Key: " +this.key + ";     Value: "+this.value;
	}
}
