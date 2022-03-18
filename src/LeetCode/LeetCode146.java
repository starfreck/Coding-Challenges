package LeetCode;

import java.util.HashMap;

/**
 * 146. LRU Cache
 * URL: https://leetcode.com/problems/lru-cache/
 */


class Node {
    int key;
    int val;
    Node pre,next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LeetCode146 { // class LRUCache
    
    int capacity, size;
	Node head, tail;
	HashMap<Integer,Node> map;

	public LeetCode146(int capacity){ // LRUCache() 

		this.size = 0;
		this.capacity = capacity;

		this.head = new Node(0,0);
		this.tail = new Node(0,0);

		this.head.next = tail;
		this.tail.pre = head;

		this.map = new HashMap<>();
	}

	// O(1)
	// Add at the start (at Head)
	private void add(Node node){
		node.pre = head;
		node.next = head.next;
		head.next.pre = node;
		head.next = node;
	}


	// O(1)
	// Remove the Node 
	private void remove(Node node){
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	// O(1)
	// Move Node to front
	private void update(Node node){
		remove(node);
		add(node);
	}

	// O(1)
	public int get(int key){

		Node node = map.get(key);

		if(node == null) return -1;

		// Move Node to front
		update(node);

		return node.val;

	}

	// O(1)
	public void put(int key, int value){

		Node node = map.get(key);

		if(node == null){
			
			node = new Node(key,value);
			// Add to the front
			add(node);
			// Add to Map
			map.put(key,node);
			size++;

		} else{
			// Update the Value
			node.val = value;
			// Update the Node in List
			update(node);

		}

		if(size > capacity) {
			Node temp = tail.pre;
			remove(temp);
			map.remove(temp.key);
			size--;
		}

	}

    public static void main(String[] args) {
        var lru = new LeetCode146(2);
        lru.put(1,1);
        System.out.println("null");
        lru.put(2,2);
        System.out.println("null");
        System.out.println(lru.get(1));
        lru.put(3,3);
        System.out.println("null");
        System.out.println(lru.get(2));
        lru.put(4,4);
        System.out.println("null");
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }
}