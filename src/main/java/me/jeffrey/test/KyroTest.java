package me.jeffrey.test;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.MapSerializer;
import org.objenesis.strategy.StdInstantiatorStrategy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class KyroTest {
    public static void main(String[] args) {
       test1();
       test2();
    }

    public static void test1(){
        long start = System.currentTimeMillis();
        try {
            setSerializableObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Kryo 序列化时间:" + (System.currentTimeMillis() - start) + " ms" );
        start = System.currentTimeMillis();
        getSerializableObject();
        System.out.println("Kryo 反序列化时间:" + (System.currentTimeMillis() - start) + " ms");
    }

    public static void setSerializableObject() throws FileNotFoundException{
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.setRegistrationRequired(false);
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
        kryo.register(HashMap.class, new MapSerializer());
        Output output = new Output(new FileOutputStream("D:/file1.bin"));
        for (int i = 0; i < 100000; i++) {
            HashMap<String,Integer> map = new HashMap<String, Integer>(2);
            map.put("zhang0", i);
            map.put("zhang1", i);
            kryo.writeObject(output, map);
        }
        output.flush();
        output.close();
    }
    public static void getSerializableObject(){
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.setRegistrationRequired(false);
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
        Input input;
        try {
            input = new Input(new FileInputStream("D:/file1.bin"));
            HashMap simple =null;
            while((simple=kryo.readObject(input, HashMap.class)) != null){
                //System.out.println(simple.getAge() + " " + simple.getName() + " " + simple.getMap().toString());
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(KryoException e){
        }
    }

    public static void test2(){
        long start = System.currentTimeMillis();
        try {
            setSerializableObject1();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Kryo 序列化时间:" + (System.currentTimeMillis() - start) + " ms" );
        start = System.currentTimeMillis();
        getSerializableObject1();
        System.out.println("Kryo 反序列化时间:" + (System.currentTimeMillis() - start) + " ms");
    }

    public static void setSerializableObject1() throws FileNotFoundException{
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.setRegistrationRequired(false);
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
        kryo.register(ArrayList.class);
        Output output = new Output(new FileOutputStream("D:/file1.bin"));
        for (int i = 0; i < 1000; i++) {
            ArrayList<HashMap<String,Integer>> arrayList = new ArrayList<HashMap<String, Integer>>(100);
            for(int j = 0; j < 100; j++){
                HashMap<String,Integer> map = new HashMap<String, Integer>(2);
                map.put("zhang0", i);
                map.put("zhang1", i);
                arrayList.add(map);
            }

            kryo.writeObject(output, arrayList);
        }
        output.flush();
        output.close();
    }
    public static void getSerializableObject1(){
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.setRegistrationRequired(false);
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
        Input input;
        try {
            input = new Input(new FileInputStream("D:/file1.bin"));
            ArrayList simple =null;
            while((simple=kryo.readObject(input, ArrayList.class)) != null){
                //System.out.println(simple.getAge() + " " + simple.getName() + " " + simple.getMap().toString());
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(KryoException e){
        }
    }


}