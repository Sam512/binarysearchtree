//Code by Samarth Dave
import java.util.Scanner;
public class BinarySearchTree {
	static Scanner s;
	public static void main(String[] args) {
		System.out.println("Tree and Tester by Samarth Dave");
		Tree<Integer> tree = new Tree<>();
		s = new Scanner(System.in);
		int i;
		do {
			i = -1;
			System.out.printf("\n%20s\n1.  %-15s  2.  %-15s\n3.  %-15s  4.  %-15s", "-Menu-", "Print", "Size", "Clear", "Empty?");
			System.out.printf("\n5.  %-15s  6.  %-15s\n7.  %-15s  8.  %-15s", "Add/Insert", "Remove", "Contains", "Min Value");
			System.out.printf("\n9.  %-15s  10. %-15s\n0. %-15s\n", "Max Value", "Max Depth", "Exit");
			i = validInt("Enter selection: ");
			switch(i) {
				case 1:
					//print
					if(tree.empty()) {
						out("The tree is empty. There is nothing to print.");
						break;
					}
					out("--Menu--");
					System.out.print("1. Pre order\n2. In order\n3. Post order\n");
					int g = validInt("Enter selection: ");
					if(g == 1) {
						out("Pre order: " + tree.preOrder());
					} else if(g == 2) {
						out("In order: " + tree.inOrder());
					} else {
						out("Post order: " + tree.postOrder());
					}
					break;
				case 2:
					//size
					out("The size of the tree is " + tree.size() + ".");
					break;
				case 3:
					//clear
					if(tree.empty()) {
						out("The tree is already empty.");
						break;
					}
					tree.clear();
					out("The tree has been cleared.");
					break;
				case 4:
					//empty
					out((tree.empty()) ? "The tree is empty." : "The tree is not empty.");
					break;
				case 5:
					//add / insert
					int r = validInt("Enter the value you want to add: ");
					out((tree.add(r)) ? r + " was added." : r + " was not added.");
					break;
				case 6:
					//remove
					if(tree.empty()) {
						out("You can't remove anything. The tree is empty.");
						break;
					}
					int num = validInt("Enter the item you want to remove: ");
					out((tree.remove(num) ? num + " was removed." : num + " was not removed."));
					break;
				case 7:
					//contains
					int b = validInt("Enter the value you want to search for: ");
					out((tree.contains(b)) ? b + " was found in the tree." : b + " was not found in the tree.");
					break;
				case 8:
					//min value
					if(tree.empty()) {
						out("The tree is empty.");
						break;
					}
					out("The smallest value in the tree is " + tree.minValue() + ".");
					break;
				case 9:
					//max value
					if(tree.empty()) {
						out("The tree is empty.");
						break;
					}
					out("The largest value in the tree is " + tree.maxValue() + ".");
					break;
				case 10:
					//max depth
					if(tree.empty()) {
						out("The tree is empty. The depth is 0.");
						break;
					}
					out("The max depth in the tree is " + tree.maxDepth() + ".");
					break;
			}
		} while(i != 0);
		s.close();
		out("User exited.");
	}
	public static int validInt(String g) {
		int i = -1;
		System.out.print(g);
		while(!s.hasNextInt()) {
			System.out.print("Error, try again: ");
			s.next();
		}
		i = s.nextInt();
		s.nextLine();
		return i;
	}
	public static void out(String s) {
		System.out.println("\n" + s);
	}
}




























