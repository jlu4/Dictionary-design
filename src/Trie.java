package src;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Trie {
	private int SIZE = 26;
	private TriNode root;// 字典树的根

	Trie() {// 初始化字典树
		root = new TriNode();
	}
	public static void insert(TriNode root, String str){//在字典树中插入一个单词
		boolean end, find;
	if(str==null||str.length()==0){
	return;
	}
	TriNode node = null;
    TriNode tmpNode = root;
    for (int i = 0; i < str.length(); i++) {
        end = false;
        find = false;
        List<TriNode> triLink = tmpNode.treeLink;
        if (i == (str.length() - 1)) {
            end = true;
        }
        char ch = str.charAt(i);
        Iterator<TriNode> iterator = triLink.iterator();
        while (iterator.hasNext()) {
            node = iterator.next();
            if (node.ch == ch) {
                find = true;
                break;
            }
        }
        if (find) {
            tmpNode = node;
        }
        else {
            TriNode tri_node = new TriNode(ch);
            triLink.add(tri_node);
            tmpNode = tri_node;
        }
        if (end) {
            root.count++;
        }
    }
	}

    
    

	public static void visit(String array, Iterator<TriNode> iterator,
		    List<String> result,String preStr) {
		        if (!iterator.hasNext()) {
		            result.add(preStr + array);
		            //System.out.println(preStr+array);
		        } else {
		            while (iterator.hasNext()) {
		                TriNode node = iterator.next();
		                array += node.ch;
		                visit(array, node.treeLink.iterator(),result,preStr);
		                array= array.substring(0, array.length()-1);
		            }
		        }
		    }
	
	public static void traverse(TriNode root,String preStr, List<String> result) {
        String array ="";
        visit(array,root.treeLink.iterator(),result,preStr);
    }
	
	public static boolean hintSearch(TriNode root,String query,List<String> result) {
        boolean isFind=false;
        TriNode tmpNode = root;
        String preStr="";
        boolean find;
        for (int i = 0; i < query.length(); i++) {
            find = false;
            char ch = query.charAt(i);
            List<TriNode> triLink = tmpNode.treeLink;
            Iterator<TriNode> iterator = triLink.iterator();
            TriNode node = null;
            while (iterator.hasNext()) {
                node = iterator.next();
                if (node.ch == ch)
                {
                    find=true;
                    preStr +=node.ch;
                    break;
                }
            }
            if (find) {
                tmpNode = node;
            }
            else {
                isFind= false;
                return isFind;
            }
        }
        traverse(tmpNode,preStr, result);
        return true;
    }







	}


