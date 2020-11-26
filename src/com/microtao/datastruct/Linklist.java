package com.microtao.datastruct;

/**
 * @Author Microtao
 * @Date 2020/11/20-17:16
 * <p>
 * com.microtao.datastruct.Node 类用于描述节点的属性
 * <p>
 * com.microtao.datastruct.LNode 类用于描述单链表的抽象：
 * node ：代表单链表中的节点
 * nextNode:保存的是下一个节点的地址
 */
class Node {
    String name;
    int age;

    public Node() {
    }

    public Node(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "DATA{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class LNode {
    Node node = new Node();
    LNode nextNode;
}

public class Linklist {

    /**
     * 插入数据到链表
     */
    public LNode insert(LNode head, Node nodeData) {
        //LNode用于保存当前需要保存节点的信息，tempNode用于寻找整个链表
        LNode lNode, tempNode;
        if ((lNode = new LNode()) == null) {
            System.out.println("内存空间已满，创建节点失败");
            return null;
        }
        //保存节点
        lNode.node = nodeData;
        lNode.nextNode = null;
        if (head == null) {
            lNode = head;
            return lNode;
        }
        tempNode = head;
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = lNode;
        return head;
    }

    /**
     * 查找某个单链表中是否存在某个节点，如果存在删除它
     *
     * @param name 给定用户名
     */
    public boolean deleteNodeByName(LNode node, String name) {
        LNode tempNode;
        if (node == null) {
            System.out.println("单链表为空，无法执行删除操作");
            return false;
        }
        tempNode = node;
        while (tempNode.nextNode != null) {
            if (tempNode.nextNode.node.name.equals(name)) {
                tempNode.nextNode = tempNode.nextNode.nextNode;
                return true;
            } else {
                tempNode = tempNode.nextNode;
            }
        }
        return true;
    }

    /**
     * 输出链表
     * <p>
     * head节点中是没有保存数据的，所以需要找到head节点的nextNode节点才是实际存放数据的第一个节点
     */
    public void printLinlist(LNode head) {
        while (head.nextNode != null) {
            System.out.println("name:" + head.nextNode.node.name + " age:" + head.nextNode.node.age);
            head = head.nextNode;
        }
        return;
    }

    public static void main(String[] args) {
        LNode head = new LNode();
        Linklist linklist = new Linklist();
        //执行插入操作
        linklist.insert(head, new Node("小强", 12));
        linklist.insert(head, new Node("小强1", 13));
        linklist.insert(head, new Node("小强2", 14));
        linklist.insert(head, new Node("小强3", 15));
        linklist.insert(head, new Node("小强4", 16));
        linklist.insert(head, new Node("小强5", 17));
        linklist.insert(head, new Node("小强6", 18));
        System.out.println("-----------删除之前----------");
        //输出整个链表
        linklist.printLinlist(head);
        //执行删除操作
        linklist.deleteNodeByName(head, "小强2");
        System.out.println("-----------删除之后----------");
        linklist.printLinlist(head);
    }

}
