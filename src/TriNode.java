/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class TriNode {
    public int count=0;
    public LinkedList<TriNode> treeLink;
    public char ch;
    public TriNode(char ch)
    {
        this.ch=ch;
        treeLink=new LinkedList<TriNode>();
    }
    public TriNode()
    {
        treeLink=new LinkedList<TriNode>();
    }
}
