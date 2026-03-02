package csc1060j.MyHashMap;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MyHashMap <K,V> implements Map<K,V>{
	
	private final static double LOAD_FACTOR_THRESEHOlD = 0.5;
	private final static int INITIAL_NUM_BUCKETS = 4;
	
	
	private LinkedList<Entry<K,V>>[] buckets;
	private int size;
	
	private class Entry<K,V> implements Map.Entry<K, V>{
		private K key;
		private V value;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}
		@Override
		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}
	}
		public MyHashMap() {
			buckets = new LinkedList[INITIAL_NUM_BUCKETS];
			size = 0;
		}
		@Override
		public int size() {
			
			return size;
		}
		@Override
		public boolean isEmpty() {
			return size == 0;
		}
		@Override
		public boolean containsKey(Object key) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean containsValue(Object value) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public V get(Object key) {
			
			return null;
		}
		@Override
		public V put(K key, V value) {
			int hashVal = Math.abs(key.hashCode());
			int bucketIndex = hashVal % buckets.length;
			LinkedList<Entry<K,V>> bucket = buckets[bucketIndex];
			
			//Look for existing key
			if(bucket !=null) {
				for(Entry<K,V> entry: bucket) {
					if(entry.getKey().equals(key)) {
						V oldVal = entry.setValue(value);
						return oldVal;
					}
				}
			}
			
			
			
			//key does not exist, we need to add an entry
			//TODO: check if the load factor threshold has been exceeded
			//and take action
			if(bucket == null) {
				bucket = new LinkedList<Entry<K,V>>();
				buckets[bucketIndex] = bucket;
			}
			
			bucket.add(new Entry<K,V>(key, value));
			size ++;
			return null;
		}
		
		//TODO
		private void rehash() {
			
		}
		@Override
		public V remove(Object key) {
			int hashVal = Math.abs(key.hashCode());
			int bucketIndex = hashVal % buckets.length;
			LinkedList<Entry<K,V>> bucket = buckets[bucketIndex];
			
			if(bucket !=null) {
				for(Entry<K,V> entry: bucket) {
					if(entry.getKey().equals(key)) {
						V oldVal = entry.getValue();
						bucket.remove(entry);
						size --;
						return oldVal;
					}
				}
			}
			
			return null;
		}
		@Override
		public void putAll(Map<? extends K, ? extends V> m) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void clear() {
			for(int i = 0; i < buckets.length; i++) {
				buckets[i] = null;
			}
			size = 0;
			
		}
		@Override
		public Set<K> keySet() {
			Set<K> set = new HashSet<>();
			for(LinkedList<Entry<K, V>> bucket: buckets) {
				if(buckets != null) {
					for(Entry<K, V> entry: bucket) {
						set.add(entry.getKey());
					}
				}
			}
			return set;
		}
		@Override
		public Collection<V> values() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Set<Map.Entry<K, V>> entrySet() {
			Set<Map.Entry<K,V>> set = new HashSet<>();
			for(LinkedList<Entry<K, V>> bucket: buckets) {
				if(buckets != null) {
					for(Entry<K, V> entry: bucket) {
						set.add(entry);
					}
				}
			}
			return set;
		}

	}


