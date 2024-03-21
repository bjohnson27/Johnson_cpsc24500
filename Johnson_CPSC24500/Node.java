package a5;

import java.util.Objects;

public class Node {
	private int x;
	private int y;
	
	
	// default constructor, x & y are assumed to be 0
	public Node() {
		this(0, 0);
	}
	
	
	// constructor with (x,y) parameters
	public Node(int x, int y) {
		setX(x);
		setY(y);
	}

	
	// copy constructor, creates copy of node
	public Node(Node node) {
		this(node.getX(), node.getY());
	}
	
	
	// get x method
	public int getX() {
		return x;
	}
	
	
	// set x method range [-100, 100]
	public void setX(int x) {
		if(x<-100 || x>100) {
			throw new IllegalArgumentException("X is out of range [-100, 100}");
		}
		this.x = x;
	}

	
	// get y method
	public int getY() {
		return y;
	}
	
	
	// set y method range [-100, 100]
	public void setY(int y) {
		if(y<-100 || y>100) {
			throw new IllegalArgumentException("Y is out of range [-100, 100]");
		}
		this.y = y;
	}

	
	// add two node method range [-100, 100] 
	public void add(Node node) {
		int newX = this.x + node.getX();
		int newY = this.y + node.getY();
		if (newX < -100 || newX > 100 || newY < -100 || newY > 100) {
			throw new IllegalArgumentException("Coordinate out of range [-100, 100]");
		}
		this.x = newX;
		this.y = newY;
	}
	
	
	// prints coordinates as a string
	public String toString() {
		return "(" + x  + ", " + y + ")";
	}
	
	
	// override equal method
	public boolean equals(Object obj) {
		if(this == obj) return true; // object compared with itself
		if (getClass() != obj.getClass()) return false;
		Node node = (Node) obj; // cast as a node 
		return x == node.x && y == node.y; // compare x and y coordinates
	}
	
	
	public static void main(String[] args) {
		// creating nodes
		Node node1 = new Node(); // default node (0, 0)
		Node node2 = new Node(15, 30);
		Node node3 = new Node(30, 60);
		Node node4 = new Node(node2); // copy of node2
		
		// adding nodes together
		node2.add(node4);
		System.out.println("node 2 + node 4 = " + node2);
		node1.add(node3);
		System.out.println("node 1 + node 3 = " + node1);
	
		//equality check
		System.out.println("are nodes 2 and 3 equal? " + node2.equals(node3));
		
		// get x and y
		System.out.println("node 3 x coordinate: " + node3.getX());
		System.out.println("node 3 y coordinate: " + node3.getY());

		// change x and y and toString method
		node3.setX(99);
		node3.setY(-99);
		System.out.println("node 3 new coordinates are: " + node3.toString());
	}

}
