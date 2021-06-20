package com.wufuqiang.leetcode;

import java.util.*;

/**
 * @author: Wu Fuqiang
 * @create: 2021-06-20 21:35
 */
public class L1600_ThroneInheritance {
    public static void main(String[] args) {

    }
}
class ThroneInheritance {
    private Map<String, List<String>> edges ;
    private Set<String> dead;
    private String king;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        edges = new HashMap<>();
        dead = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        List<String> children = edges.getOrDefault(parentName, new ArrayList<>());
        children.add(childName);
        edges.put(parentName,children);
    }

    public void death(String name) {
        dead.add(name);

    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        preorder(ans,this.king);
        return ans;
    }
    private void preorder(List<String> preList,String root){
        if(!dead.contains(root)){
            preList.add(root);
        }
        List<String> children = edges.getOrDefault(root, new ArrayList<>());
        for(String child:children){
            preorder(preList,child);
        }
    }
}
