import javax.sound.midi.Soundbank;
import java.util.Objects;

/**
 * @Author 於涛
 * @Date 2020/11/24-18:06
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StackData stackData = (StackData) o;
        return age == stackData.age &&
                Objects.equals(name, stackData.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

class StackInfo {
    public static int MAXSIZE = 100;
    StackData[] data = new StackData[MAXSIZE];
    //栈顶指针
    int top;
}

public class StackDemo {
    /**
     * 插入数据
     */
    public void insert(StackInfo stackInfo, StackData data) {
        if (stackInfo.top >= StackInfo.MAXSIZE) {
            System.out.println("当前栈已满，无法插入！");
            return;
        }
        stackInfo.data[stackInfo.top] = data;
        stackInfo.top++;
        return;

    }

    /**
     * 删除数据
     */
    public boolean delete(StackInfo stackInfo, StackData data) {
        int pos = stackInfo.top;
        if (stackInfo != null && stackInfo.top < 1) {
            System.out.println("栈中的元素为空");
            return false;
        }
        if (data == null) {
            System.out.println("请指定需要修改的数据对象");
            return false;
        }
       for(int i = pos;i>0;i--){
           if (data.equals(stackInfo.data[i])) {
               pos = i;
              break;
           }
       }
       for(int i = pos;i<stackInfo.top;i++){
           stackInfo.data[i] = stackInfo.data[i+1];
       }
        --stackInfo.top;
        return true;
    }

    /**
     * 修改数据
     */
    public boolean update(StackInfo stackInfo, StackData data) {

        int pos = stackInfo.top;
        if (stackInfo != null && stackInfo.top < 1) {
            System.out.println("栈中的元素为空");
            return false;
        }
        if (data == null) {
            System.out.println("请指定需要修改的数据对象");
            return false;
        }
        while (pos-- > 0) {
            //姓名相同的可以认定为是同一个人,修改年龄
            if (data.name.equals(stackInfo.data[pos].name)) {
                stackInfo.data[pos].age = data.age;
                return true;
            }
        }
        return true;
    }

    /**
     * 查找数据
     */
    public StackData getData(StackInfo stackInfo, StackData data) {
        return null;
    }

    public void printf(StackInfo stackInfo) {
        int pos = stackInfo.top;
        if (pos <= 0) {
            System.out.println("栈为空！");
        }
        while (pos-- > 0) {
            System.out.println(stackInfo.data[pos]);
        }
    }

    public static void main(String[] args) {
        StackInfo info = new StackInfo();
        StackDemo demo = new StackDemo();
        System.out.println("-----------------执行插入操作-------------");
        for (int i = 0; i < 5; i++) {
            demo.insert(info, new StackData("小明" + i, i));
        }
        //输出所有的栈元素
        demo.printf(info);
        System.out.println("-----------------执行修改操作-------------");
        demo.update(info, new StackData("小明2", 58));
        demo.printf(info);
        System.out.println("-----------------执行删除操作-------------");
        demo.delete(info, new StackData("小明2", 58));
        demo.printf(info);
    }
}
