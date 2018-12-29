package _58getNextInBinaryTree;
/**
 * ��Ŀ������һ�ö����������е�һ����㣬
 * ����ҳ��������˳�����һ����㣿
 * ���еĽ������������ֱ�ָ�������ӽ���ָ�����⣬����һ��ָ�򸸽ڵ��ָ��
 * 
 * ����˼·
 * ���һ�����������������ô������һ�������������������е����ӽ�㡣
 * Ҳ����˵���ӽ�����һֱ����ָ�����ӽ���ָ�룬���Ǿ����ҵ�������һ����㡣
 * 
 * �������Ƿ���һ�����û�������������Ρ��������������ڵ�����ӽ�㣬��ô������һ�����������ĸ���㡣
 * 
 * ���һ������û�������������������������������ӽ�㣬�������ξͱȽϸ��ӡ�
 * ���ǿ�������ָ�򸸽ڵ��ָ��һֱ���ϱ�����ֱ���ҵ�һ���������������ӽ��Ľ�㡣��������Ľ����ڣ�
 * ��ô������ĸ�����������Ҫ�ҵ���һ����㡣
 * @author cy
 *
 */

public class GetNextInBinaryTree {
	
	 private static class BinaryTreeNode {
	        private char val;
	        private BinaryTreeNode left;
	        private BinaryTreeNode right;
	        private BinaryTreeNode parent;
//	        public BinaryTreeNode() {
//	        }
	        public BinaryTreeNode(char val) {
	            this.val = val;
	        }
	        @Override
	        public String toString() {
	            return val + " ";
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode b1 = new BinaryTreeNode('a');
		BinaryTreeNode b2 = new BinaryTreeNode('b');
		BinaryTreeNode b3 = new BinaryTreeNode('c');
		BinaryTreeNode b4 = new BinaryTreeNode('d');
		BinaryTreeNode b5 = new BinaryTreeNode('e');
		BinaryTreeNode b6 = new BinaryTreeNode('f');
		BinaryTreeNode b7 = new BinaryTreeNode('g');
		BinaryTreeNode b8 = new BinaryTreeNode('h');
		BinaryTreeNode b9 = new BinaryTreeNode('i');
		
		b1.left = b2;
		b1.right = b3;
		
		b2.left = b4;
		b2.right = b5;
		
		b3.left = b6;
		b3.right = b7;
		
		b5.left = b8;
		b5.right = b9;
		
		b2.parent = b1;
		b3.parent = b1;
		b4.parent = b2;
		b5.parent = b2;
		b6.parent = b3;
		b7.parent = b3;
		b8.parent = b5;
		b9.parent = b5;
		
		InOrderTree(b1);
		
		System.out.println();
		System.out.println("-------------------------");
		System.out.println("node" + ": " + b1 + "  next is : " + getNext(b1));
		System.out.println("node" + ": " + b3 + "  next is : " + getNext(b3));
		System.out.println("node" + ": " + b7 + "  next is : " + getNext(b7));
		System.out.println("node" + ": " + b8 + "  next is : " + getNext(b8));
		
		/**
		 * d b h e i a f c g 
		 * -------------------------
		 * node: a   next is : f 
		 * node: c   next is : g 
		 * node: g   next is : null
		 * node: h   next is : e 
		 */
	}

	private static BinaryTreeNode getNext(BinaryTreeNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return null;
		}
		
		if (node.right != null) {
			BinaryTreeNode temp = node.right;
			while (temp.left != null) {
				temp = temp.left;
			}
			return temp;
		}
		
		
		if (node.parent != null && node.parent.left == node && node.right == null) {
			return node.parent;
		}
		
		if (node.parent != null && node.parent.right == node && node.right == null) {
			BinaryTreeNode temp = node.parent;
			while (temp.parent != null && temp.parent.left != temp) {
				temp = temp.parent;
			}
			if (temp.parent == null) {
				return null;
			}else {
				return temp.parent;
			}
		}
		return null;
	}

	private static void InOrderTree(BinaryTreeNode b1) {
		// TODO Auto-generated method stub
		if (b1 == null) {
			return;
		}
		InOrderTree(b1.left);
		System.out.print(b1);
		InOrderTree(b1.right);
	}

}
