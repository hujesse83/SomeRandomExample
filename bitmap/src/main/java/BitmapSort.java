import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 1、Bitmap 快速排序 前提条件没有重复的数据.
 * @Description: 将要排序的数据加入到Bitmap中，这样在二维数组的角度来看是排好序的了。
 * 我们再从0-目标范围遍历，看bitmap是否包含这个值。yes 加入结果集。
 * defect：
 *        所有的数据不能重复。即不可对重复的数据进行排序和查找。
 *        只有当数据比较密集时才有优势
 *advantages：
 *        运算效率高，不需要进行比较和移位；
 *        占用内存少，比如N=10000000；只需占用内存为N/8=1250000Byte=1.25M
 *
 * 2、Bitmap快速去重
 * 接下来的任务就是把这20亿个数字放进去（存储），如果对应的状态位为00，则将其变为01，表示存在一次；
 * 如果对应的状态位为01，则将其变为11，表示已经有一个了，即出现多次；如果为11，则对应的状态位保持不变，仍表示出现多次。
 * 最后，统计状态位为01的个数，就得到了不重复的数字个数，时间复杂度为O(n)
 *
 * 3、Bitmap快速查找
 * int数组中的一个元素是4字节占32位，那么除以32就知道元素的下标，对32求余数（%32）就知道它在哪一位，如果该位是1，则表示存在。
 */
public class BitmapSort {
    public static void main(String[] args) {
        AddElement addElement = new AddElement();
        byte[] bytes = addElement.create(100); // 0——100的数据进行排序
        List<Integer> list = Arrays.asList(1, 4, 2, 5, 7, 11, 44, 33, 78, 99, 32, 54);
        for (Integer integer : list) {
            addElement.add(bytes, integer);
        }
        ArrayList<Integer> res = new ArrayList<>(list.size());
        for (int i = 0; i < 100; i++) {
            boolean contains = addElement.contains(bytes, i);
            if (contains){
                res.add(i);
            }
        }
        System.out.println(res);
        System.out.println(Integer.MAX_VALUE);
    }

}
