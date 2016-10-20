public class Node<E extends Comparable> {
	E data;
	Node<E> left, right;
	public Node(E data) {
		this.data = data;
		left = null;
		right = null;
	}
	//second constructor for node objects with left and right
	public Node(E data, Node<E> l, Node<E> r) {
		this.data = data;
		left = l;
		right = r;
	}
	//the getters and setters that i'm never going to use
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public Node<E> getLeft() {
		return left;
	}
	public void setLeft(Node<E> left) {
		this.left = left;
	}
	public Node<E> getRight() {
		return right;
	}
	public void setRight(Node<E> right) {
		this.right = right;
	}
	public String toString() {
		return data + "";
	}
}