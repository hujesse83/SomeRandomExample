import java.util.Arrays;


/**
 * Bitmap description 32位机器上，对于一个整型数，比如int a=1 在内存中占32bit位，这是为了方便计算机的运算。
 * 但是对于某些应用场景而言，这属于一种巨大的浪费，因为我们可以用对应的32bit位对应存储十进制的0-31个数
 * ，而这就是Bit-map的基本思想。Bit-map算法利用这种思想处理大量数据的排序、查询以及去重。
 * 存20亿个数：2G内存
 */
public class AddElement {

    /**
     * 创建bitmap数组
     */
    public byte[] create(int n){
        byte[] bits = new byte[getIndex(n) + 1];
        for(int i = 0; i < n; i++){
            add(bits, i);
        }
        System.out.println(contains(bits, 1));
        int index = 1;
        for(byte bit : bits){
            System.out.println("-------" + index++ + "-------");
            showByte(bit);
        }
        return bits;
    }

    /**
     * 标记指定数字（num）在bitmap中的值，标记其已经出现过<br/>
     * 将1左移position后，那个位置自然就是1，然后和以前的数据做|，这样，那个位置就替换成1了
     */
    public void add(byte[] bits, int num){
        bits[getIndex(num)] |= 1 << getPosition(num);  // 将1左移 箭头指向左边便是左移
    }

    /**
     * 判断指定数字num是否存在<br/>
     * 将1左移position后，那个位置自然就是1，然后和以前的数据做&，判断是否为0即可
     */
    public boolean contains(byte[] bits, int num){
        return (bits[getIndex(num)] & 1 << getPosition(num)) != 0;
    }

    /**
     * num/8得到byte[]的index
     */
    public int getIndex(int num){
        return num >> 3;
    }

    /**
     * num%8得到在byte[index]的位置
     */
    public int getPosition(int num){
        return num & 0x07;
       // return num^8;
    }

    /**
     * 重置某一数字对应在bitmap中的值 也就是删除
     * 对1进行左移，然后取反，最后与byte[index]作与操作。
     */
    public void clear(byte[] bits, int num){
        bits[getIndex(num)] &= ~(1 << getPosition(num));
    }

    /**
     * 打印byte类型的变量<br/>
     * 将byte转换为一个长度为8的byte数组，数组每个值代表bit
     */

    public void showByte(byte b){
        byte[] array = new byte[8];
        for(int i = 8; i > 0; i--){
            array[i-1] = (byte)(b & 1);
            b = (byte)(b >> 1);  // b右移一位
        }
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 100;
        new AddElement().create(n);
        byte i = 5;
        new AddElement().showByte(i);
        System.out.println(48^31);
        System.out.println(16 & 0x07);
    }
}