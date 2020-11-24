import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.sun.scenario.animation.AnimationPulseMBean;

/**
 * @Author 於涛
 * @Date 2020/11/24-18:06
 *
 * @Description :对栈执行增删改查操作
 */

class StackData {
    String name;
    int age;

    public StackData() {
    }

    public StackData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "STACKData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class StackInfo{
    public static int  MAXSIZE = 100;
    StackData[] data = new StackData[MAXSIZE];
    //栈顶
    int top;
}
public class StackDemo {
    /** 插入数据*/
    public void insert(StackInfo stackInfo,StackData data){
        if(stackInfo.top>=StackInfo.MAXSIZE){
            System.out.println("当前栈已满，无法插入！");
            return;
        }
        stackInfo.data[stackInfo.top] = data;
        stackInfo.top++;
        return;

    }
    /** 删除数据*/
    public boolean delete(StackInfo stackInfo,StackData data){
        return true;
    }
    /** 修改数据*/
    public boolean update(StackInfo stackInfo,StackData data){
        return true;
    }
    /** 查找数据*/
    public StackData getData(StackInfo stackInfo,StackData data){
        return null;
    }
    public void printf(StackInfo stackInfo){
        if(stackInfo.top<=0){
            System.out.println("栈为空！");
        }
        while(stackInfo.top-->0){
            System.out.println(stackInfo.data[stackInfo.top]);
        }
    }
    public static void main(String[] args) {
        StackInfo info = new StackInfo();
        StackDemo demo = new StackDemo();
        for(int i = 0;i<10;i++){
            demo.insert(info,new StackData("小明"+i,i));
        }
        demo.printf(info);
    }
}
