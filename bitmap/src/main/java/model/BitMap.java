package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/3/19 20:01
 * index: 保存在数组那个下标中
 * position： 数据在下标元素的那个位置
 */
@Data
public class BitMap {
    // 数据容器
    private byte[] byteBites;
    // 最大值
    private int maxValue;
    // 容量 即为byte数组个数
    private int capacity;
    private int size;

    // 创建最大值为X的bitmap
    public BitMap(int maxValue) {
        this.maxValue = maxValue;
        this.capacity = (maxValue / 8) + 1;
        byteBites = new byte[capacity];
    }

    // 添加数据
    public void add(int num) {
        int index = num >> 3; // num / 8
        int position = num & 0x07;   // num % 8
        byteBites[index] |= 1 << position;
        maxValue = Math.max(num, maxValue);
        size++;
    }

    // 判断数据是否存在
    public boolean contains(int num) {
        int index = num >> 3;
        int position = num & 0x07;
        return (byteBites[index] & 1 << position) != 0;
    }

    //删除某个数字
    public void remove(int num) {
        int index = num >> 3;
        int position = num & 0x07;
        byteBites[index] &= ~(1 << position);
        if (contains(num)) {
            size--;
        }
    }

    // 打印bit数组
    public void showByte(byte b) {
        byte[] array = new byte[8];
        for (int i = 8; i > 0; i--) {
            array[i - 1] = (byte) (b & 1);
            b = (byte) (b >> 1);  // b右移一位
        }
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    public List<Integer> sort(List<Integer> list, int maxValue) {
        BitMap bitMap = new BitMap(maxValue);
        for (Integer item : list) {
            bitMap.add(item);
        }
        ArrayList<Integer> res = new ArrayList<>(list.size());
        for (int i = 0; i < maxValue; i++) {
            if (bitMap.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(100);
        List<Integer> list = Arrays.asList(1, 4, 2, 5, 7, 11, 44, 33, 78, 99, 32, 54);
        for (Integer item : list) {
            bitMap.add(item);
        }
        for (byte byteBite : bitMap.getByteBites()) {
            bitMap.showByte(byteBite);
        }
        List<Integer> res = bitMap.sort(list, 100);
        System.out.println(res);

    }

}
