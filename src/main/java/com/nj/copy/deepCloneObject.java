package com.nj.copy;

import java.io.*;

/**
 * 深度
 * 序列化:对象转为流，传输
 * 反序列化：流转为对象
 * 某个属性如果不想序列化，只需要定义transient
 */
public class deepCloneObject {
    public static <T extends Serializable> T deepCloneObject(T object){
        T deepClone = null;
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            bais = new ByteArrayInputStream(baos
                    .toByteArray());
            ois = new ObjectInputStream(bais);
            deepClone = (T)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                if(bais != null) {
                    bais.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                if(ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return deepClone;
    }
}
