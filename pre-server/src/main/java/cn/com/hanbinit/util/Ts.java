package cn.com.hanbinit.util;

import java.nio.ByteBuffer;

/**
 * Created by icer on 2017/12/6.
 */
public class Ts {

    public Ts() {
    }

    /**
     * @param args
     * @author: tanyaowu
     */
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(6);
        byteBuffer.put((byte) 3);

        byteBuffer.position(0);  //设置position到0位置，这样读数据时就从这个位置开始读
        byteBuffer.limit(1);     //设置limit为1，表示当前bytebuffer的有效数据长度是1

        byte bs = byteBuffer.get();
        System.out.println(byteBuffer);
    }
}
