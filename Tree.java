//Code by Samarth Dave
public class Tree<E extends Comparable> {
	Node<E> root;
	public Tree() {
		//root is already null but set it here if you want
	}
	public Tree(E data) {
		//init with data
		root = new Node<>(data);
	}
	public String preOrder() {
		return "[" + preOrderHelper(root) + "]";
	}
	private String preOrderHelper(Node<E> elem) {
		if(elem == null)
			return "";
		return elem + " " + preOrderHelper(elem.right) + " " + preOrderHelper(elem.left);
	}
	public String inOrder() {
		return "[" + inOrderHelper(root) + "]";
	}
	private String inOrderHelper(Node<E> elem) {
		if(elem == null)
			return "";
		return inOrderHelper(elem.left) + " " + elem + " " + inOrderHelper(elem.right);
	}
	public String postOrder() {
		return "[" + postOrderHelper(root) + "]";
	}
	private String postOrderHelper(Node<E> elem) {
		if(elem == null)
			return "";
		return postOrderHelper(elem.left) + " " + postOrderHelper(elem.right) + " " + elem;
	}
	public E minValue() {
		Node<E> temp = root;
		//loop left until at the bottom
		while(temp.left != null) {
			temp = temp.left;
		}
		return temp.data;
	}
	public E maxValue() {
		Node<E> temp = root;
		//loop right until at the bottom
		while(temp.right != null) {
			temp = temp.right;
		}
		return temp.data;
	}
	public int maxDepth() {
		if(root == null)
			return 0;
		return maxDepthHelper(root, 0);
	}
	private int maxDepthHelper(Node<E> elem, int c) {
		if(elem == null)
			return c;
		c++;
		int l = maxDepthHelper(elem.left, c);
		int r = maxDepthHelper(elem.right,c);
		return (l > r) ? l : r;
	}
	public void clear() {
		root = null;
	}
	public int size() {
		return sizeHelper(root);
	}
	public int sizeHelper(Node<E> elem) {
		if(elem == null)
			return 0;
		return sizeHelper(elem.left) + 1 + sizeHelper(elem.right);
	}
	public boolean empty() {
		return size() == 0;
	}
	public boolean contains(E value) {
		// helper counts up to only 1, containsHelper can also have return of boolean
		// but I used int
		return containsHelper(root, value) == 1;
	}
	private int containsHelper(Node<E> node, E value) {
		if(node == null)
			return 0;
		if(node.data == value)
			return 1;
		return containsHelper(node.left, value) + containsHelper(node.right, value) + 0;
	}
	public boolean insert(E data) {
		return add(data);
	}
	public boolean add(E data) {
		if(contains(data)) {
			return false;
		} else {
			if(root == null) {
				//if empty() would work too
				root = new Node<>(data);
				return true;
			}
			Node<E> temp = root;
			while(true) {
				// compare both and see which is greater
				// you can also convert "E data" to "Integer data"
				// or the object type of your choice
				if(data.compareTo(temp.data) < 0) {
					if(temp.left == null) {
						temp.left = new Node<>(data);
						return true;
					} else {
						temp = temp.left;
					}
				} else {
					if(temp.right == null) {
						temp.right = new Node<>(data);
						return true;
					} else {
						temp = temp.right;
					}
				}
			}
		}
	}
	// the following two methods are adapted from
	// http://www.newthinktank.com/2013/03/binary-trees-in-java-2/
	public boolean remove(E data) {
		if(!contains(data)) {
			return false;
		}
		Node<E> focus = root;
		Node<E> parent = root;
		boolean isLeft = true;
		while(focus.data != data) {
			parent = focus;
			if(data.compareTo(focus.data) < 0) {
				isLeft = true;
				focus = focus.left;
			} else {
				isLeft = false;
				focus = focus.right;
			}
			if(focus == null) {
				return false;
			}
		}
		if(focus.left == null && focus.right == null) {
			if(focus == root) {
				root = null;
			} else if(isLeft) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if(focus.right == null) {
			if(focus == root) {
				root = focus.left;
			} else if(isLeft) {
				parent.left = focus.left;
			} else {
				parent.right = focus.left;
			}
		} else if(focus.left == null) {
			if(focus == root) {
				root = focus.right;
			} else if(isLeft) {
				parent.left = focus.right;
			} else {
				parent.right = focus.left;
			}
		} else {
			Node<E> replace = getReplacementNode(focus);
			if(focus == root) {
				root = replace;
			} else if(isLeft) {
				parent.left = replace;
			} else {
				parent.right = replace;
			}
			replace.left = focus.left;
		}
		return true;
	}
	private Node<E> getReplacementNode(Node<E> replacedNode) {
		Node<E> replaceParent = replacedNode;
		Node<E> replacement = replacedNode;
		Node<E> focus = replacedNode.right;
		while(focus != null) {
			replaceParent = replacement;
			replacement = focus;
			focus = focus.left;
		}
		if(replacement != replacedNode.right) {
			replaceParent.left = replacement.right;
			replacement.right = replacedNode.right;
		}
		return replacement;
	}
}