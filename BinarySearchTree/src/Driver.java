import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	ArrayList<Integer> nodelist = new ArrayList<>();

	public static Node newNode(int z) {
		Node temp = new Node();
		temp.left = null;
		temp.right = null;
		temp.data = z;

		return temp;

	}

	public void insert(Node root, Node nn) {
		if (nn.data > root.data) {
			if (root.left == null) {
				root.left = nn;
			} else {
				insert(root.left, nn);
			}
		} else {
			if (root.right == null) {
				root.right = nn;
			} else {
				insert(root.right, nn);
			}
		}
	}

	private void traverse(Node root) {
		if (root!=null) {
			traverse(root.left);
			nodelist.add(root.data);
			traverse(root.right);
		}
	}

	public static void main(String args[]) {
		Driver newnode = new Driver();
		Node root = null;
		Node nn = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of Nodes");

		int k = sc.nextInt();
		int i;
		for (i = 0; i < k; i++) {
			System.out.println("Enter the value on Node");
			int n = sc.nextInt();
			nn = newNode(n);
			if (root == null) {
				root = nn;
			}

			else {
				newnode.insert(root, nn);
			}

		}
		newnode.traverse(root);
		System.out.println("Enter the Sum");
		int sum = sc.nextInt();
		int flag=0;
		
		for(i=0;i<newnode.nodelist.size();i++) {
			if(newnode.nodelist.contains(sum-newnode.nodelist.get(i)) && newnode.nodelist.get(i)!=sum-newnode.nodelist.get(i)) {
				int a=newnode.nodelist.get(i);
				int b=sum-newnode.nodelist.get(i);
				System.out.println("Pair Found"+"["+a+","+b+"]");
				flag=1;
				break;
			}
		}
		if(flag==0) {
			System.out.println("Pair not found");
		}
		
	}

}
