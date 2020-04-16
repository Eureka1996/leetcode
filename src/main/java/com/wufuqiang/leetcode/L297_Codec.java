package com.wufuqiang.leetcode;

import com.wufuqiang.leetcode.entries.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L297_Codec {
	public static void main(String[] args) {
		String data = "[10,5,-3,3,2,null,11,3,-2,null,1]";
		data ="[1,3,null,null,4,5,null,null,6]";
//		data = "[1,2,null,3,null,4,null,5]";
//		data = "[1,2,2,3,null,null,3,4,null,null,4]";
		L297_Codec codec = new L297_Codec();
		TreeNode root = codec.deserialize(data);
		String str = codec.serialize(root);
		System.out.println(data);
		System.out.println(str);

	}

	public String serialize(TreeNode root){
		if(root == null) return "[]";
		List<String> list = new ArrayList<>();
		LinkedList<TreeNode> queue =new LinkedList<>();
		queue.offerLast(root);
		list.add(Integer.toString(root.val));
		while(!queue.isEmpty()){
			TreeNode node = queue.pollFirst();
			if(node.left == null){
				list.add("null");
			}else{
				list.add(Integer.toString(node.left.val));
				queue.offerLast(node.left);
			}

			if(node.right == null){
				list.add("null");
			}else{
				list.add(Integer.toString(node.right.val));
				queue.offerLast(node.right);
			}
		}
		int i =0;
		for( i=list.size()-1;i>=0;i--){
			if(!"null".equals(list.get(i))){
				break;
			}
		}

		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int j = 0;j<=i;j++){
			sb.append(list.get(j));
			if(j!=i){
				sb.append(",");
			}
		}
		sb.append("]");

		return sb.toString();
	}

	public String serialize2(TreeNode root) {
		if(root == null) return "[]";
		//记录最终的结果
		StringBuffer sb = new StringBuffer();
		sb.append("[");

		LinkedList<TreeNode> queue = new LinkedList<>();
		//记录每一个结点的位置编号
		LinkedList<Integer> position = new LinkedList<>();
		//记录每层的个数
		int levelCount = 1;
		position.offerLast(1);
		queue.offerLast(root);

		//记录每一层开始的编号
		int levelBeginIndex = 1;
		boolean isRoot = true;
		while(!queue.isEmpty()){
			//累计下层的节点个数
			int newLevelCount = 0;
			//记录下一层的开始节点
			int newLevelBeginIndex = 0;
			int tmpLevelCount = levelCount;

			//遍历每一层
			while(levelCount>0){
				TreeNode node = queue.pollFirst();
				int pos = position.pollFirst();
				if(tmpLevelCount==levelCount){
					newLevelBeginIndex = pos*2-1;
				}
				levelCount-=1;

				if(node.left != null){
					queue.offerLast(node.left);
					position.offerLast(pos*2-1);
					newLevelCount+=1;
				}
				if(node.right != null){
					queue.offerLast(node.right);
					position.offerLast(pos*2);
					newLevelCount+=1;
				}
				for(int i = levelBeginIndex;i<pos;i++){
					sb.append("null,");
				}
				sb.append(node.val);
				if(!queue.isEmpty()) {
					sb.append(",");
				}
				levelBeginIndex=pos+1;
			}
			if(!isRoot && levelBeginIndex % 2 == 0 && !queue.isEmpty()) sb.append("null,");
			isRoot = false;
			levelCount = newLevelCount;
			levelBeginIndex = newLevelBeginIndex;

		}
		sb.append("]");
		return sb.toString();
	}


	public TreeNode deserialize(String data) {
		if("[]".equals(data)) return null;
		String[] splited = data.split(",");
		splited[0] = splited[0].substring(1);
		splited[splited.length-1] = splited[splited.length-1].substring(0,splited[splited.length-1].length()-1);

		LinkedList<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.parseInt(splited[0]));
		queue.offerLast(root);
		int index = 1;
		while(!queue.isEmpty()){
			TreeNode node = queue.pollFirst();
			System.out.print("node:"+node.val);
			if(index < splited.length && !"null".equals(splited[index])){
				TreeNode leftNode = new TreeNode(Integer.parseInt(splited[index]));
				node.left = leftNode;
				System.out.print(",left:"+leftNode.val);
				queue.offerLast(leftNode);
			}
			index+=1;
			if(index < splited.length && !"null".equals(splited[index])){
				TreeNode rightNode = new TreeNode(Integer.parseInt(splited[index]));
				node.right = rightNode;
				System.out.print(",right:"+rightNode.val);
				queue.offerLast(rightNode);
			}
			System.out.println();
			index+=1;
		}

		return root;
	}
}
