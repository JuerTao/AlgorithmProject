import java.util.Optional;

/**
 * @Author
 * @Date 2020/11/20-14:23
 * <p>
 * 顺序表的 新增、删除、查找
 */

class DataType {
    String name;
    int age;

    public DataType(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "DataType{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class SLType {
    public static final int MAXSIZE = 100;
    DataType[] listData = new DataType[MAXSIZE];
    int length;
}

public class LOCDemo {

    /**
     * 初始化顺序表
     */
    public void SLInit(SLType slType) {
        slType.length = 0;
    }

    /**
     * 插入操作
     */
    public int slInsert(SLType slType, int n, DataType dataType) {
        if (n >= SLType.MAXSIZE) {
            System.out.println("线性表已满");
            return 0;
        }
        for (int i = slType.length; i >= n; i--) {
            slType.listData[i + 1] = slType.listData[i];
        }
        slType.listData[n] = dataType;
        slType.length++;
        return 1;
    }

    //随机删除
    public int delete(SLType slType, int position) {
        if (position > slType.length || position < 1) {
            System.out.println("删除的位置不正确");
            return 0;
        }
        for (int i = position; i < slType.length; i++) {
            slType.listData[position] = slType.listData[position + 1];
        }
        slType.length--;
        return 1;
    }

    //查找操作
    public DataType findByName(SLType slType, String keyName) {
        for (int i = 0; i < slType.length; i++) {
            if (slType.listData[i].name.equals(keyName)) {
                return slType.listData[i];
            }
        }
        System.out.println("不存在这个人！");
        return null;
    }

    public void sout(SLType slType) {
        for (int i = 0; i < slType.length; i++) {
            System.out.println(slType.listData[i]);
        }
    }

    public static void main(String[] args) {
        SLType slType = new SLType();
        LOCDemo t = new LOCDemo();
        t.SLInit(slType);
        for (int i = 0; i < 10; i++) {
            t.slInsert(slType, i, new DataType("xiaoming" + i, i));
        }
        System.out.println("------------执行了添加操作---------------");
        t.sout(slType);
        t.delete(slType, 3);
        System.out.println("------------执行了删除操作：删除第3位---------------");
        t.sout(slType);
        System.out.println("------------查找名字为xiaoming7的对象---------------");
        DataType data = t.findByName(slType, "xiaoming7");
        System.out.println(Optional.ofNullable(data).get());
    }
}
