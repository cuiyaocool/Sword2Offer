package _18hasSubTree;

public class HasSubTree {
	public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode root1 = new BinaryTreeNode();
        root1.value = 8;
        root1.right = new BinaryTreeNode();
        root1.right.value = 7;
        root1.left = new BinaryTreeNode();
        root1.left.value = 8;
        root1.left.left = new BinaryTreeNode();
        root1.left.left.value = 9;
        root1.left.right = new BinaryTreeNode();
        root1.left.right.value = 2;
        root1.left.right.left = new BinaryTreeNode();
        root1.left.right.left.left = new BinaryTreeNode();
        root1.left.right.left.left.value = 4;
        root1.left.right.left.right = new BinaryTreeNode();
        root1.left.right.left.right.value = 7;
        BinaryTreeNode root2 = new BinaryTreeNode();
        root2.value = 8;
        root2.left = new BinaryTreeNode();
        root2.left.value = 9;
        root2.right = new BinaryTreeNode();
        root2.right.value = 2;
        System.out.println(hasSubtree(root1, root2));
        System.out.println(hasSubtree(root2, root1));
        System.out.println(hasSubtree(root1, root1.left));
        System.out.println(hasSubtree(root1, null));
        System.out.println(hasSubtree(null, root2));
        System.out.println(hasSubtree(null, null));
    }
	private static boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
		// TODO Auto-generated method stub
		boolean res = false;
		// ֻҪ����������ͬһ���ͷ���true
        // ��ע��˴����鱾�ϵĲ�ͬ���鱾�ϵ�û����һ����
        if (root1 == root2) {
            return true;
        }
        // ֻҪ��B�ĸ�����Ϊ�վͷ���true
        if (root2 == null) {
            return true;
        }
        // ��B�ĸ���㲻Ϊ�գ������A�ĸ����Ϊ�վͷ���false
        if (root1 == null) {
            return false;
        }
		if (root1 != null && root2 != null) {
			if (root1.value == root2.value) {
				res = docore(root1, root2);
			}
			if (!res) {
				res = hasSubtree(root1.left, root2);
			}
			if (!res) {
				res = hasSubtree(root1.right, root2);
			}
		}
		return res;
	}
	private static boolean docore(BinaryTreeNode root1, BinaryTreeNode root2) {
		// TODO Auto-generated method stub
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		if (root1.value != root2.value) {
			return false;
		}
		return docore(root1.left, root2.left) && docore(root1.right, root2.right);
	}
}
