/**
 * @Author 於涛
 * @Date 2020/11/20-17:16
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
     * 插入链表数据
     * */
    public LNode insert(LNode head, Node nodeData) {
        //LNode用于保存当前需要保存节点的信息，tempNode用于寻找整个链表
        LNode lNode, tempNode;
        if ((lNode = new LNode()) == null) {
            System.out.println("创建节点失败");
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
             tempNode = tempNode.nextNode ;
        }
        tempNode.nextNode = lNode;
        return head;
    }

    /**
     * 输出链表
     * */
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
        LNode node1 = linklist.insert(head, new Node("小明", 12));
        LNode node2 = linklist.insert(node1, new Node("小强1", 13));
        LNode node3 = linklist.insert(node2, new Node("小强2", 14));
        LNode node4 = linklist.insert(node3, new Node("小强3", 15));
        LNode node5 = linklist.insert(node4, new Node("小强4", 16));
        LNode node6 = linklist.insert(node5, new Node("小强5", 17));
        LNode node7 = linklist.insert(node6, new Node("小强6", 18));
        linklist.printLinlist(node7);
    }

}
