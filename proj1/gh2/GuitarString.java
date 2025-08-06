package gh2;

import deque.Deque;
import deque.LinkedListDeque;

public class GuitarString {

    private static final int SR = 44100;      // 采样率
    private static final double DECAY = .996; // 能量衰减因子

    /* Buffer for storing sound data. */
     private Deque<Double> buffer;

    /* 用给定的 frequency 创造一个吉他弦 */
    public GuitarString(double frequency) {
        //  创建一个缓冲区（buffer），其容量（capacity）为 采样率（SR）除以频率（frequency）。
        //  这个除法运算的结果强制转换为整数（int）。为了获得更高的精度，在强制转换之前使用 Math.round () 函数。
        //  初始时，你的缓冲区数组应填充零。

        int capacity = (int) Math.round( SR / frequency);
        buffer = new LinkedListDeque<>();
        for(int i=0;i<capacity;i++){
            buffer.addLast(0.0);
        }
    }


    /* 通过用白噪声替换缓冲区来模拟拨动吉他弦的动作。 */
    public void pluck() {
        // 清空缓冲区中的所有内容，并用-0.5到0.5之间的随机数重新填充
        // 可以通过以下方式获取这样的随机数：
        // double r = Math.random() - 0.5;
        //
        // 确保生成的随机数彼此不同。这并不是说你需要检查每个数字是否与其他数字不同，
        // 而是意味着你应该为每个数组索引重复调用Math.random() - 0.5来生成新的随机数。
        for(int i = 0; i<buffer.size(); i++){
            double r = Math.random() - 0.5;
            buffer.removeFirst();
            buffer.addLast(r);
        }
    }

    /* 执行一次 the Karplus-Strong algorithm的迭代*/

    public void tic() {
        double newDouble = (buffer.removeFirst() + buffer.get(0)) * 0.5 * DECAY;
        buffer.addLast(newDouble);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.get(0);
    }
}
