package com.anthony.io;

import java.io.*;
import java.nio.charset.Charset;

public class IOOperate {
    public static void main(String[] args) throws IOException {
        oprate1();
        oprate2();
        oprate3();
        oprate4();
    }

    /**
     * InputStream、OutputStream（字节流）
     */
    private static void oprate1() throws IOException {
        //要读取的文件
        File fileInput = new File("D:/ioTest.txt");
        //要写入的文件
        File fileOutput = new File("D:/oprate1OutPut.txt");
        //读取文件
        InputStream inputStream = new FileInputStream(fileInput);
        //写入文件
        OutputStream outputStream = new FileOutputStream(fileOutput);
        try {
            //每次读取多少字节
            byte[] bytes = new byte[2048];
            while (inputStream.read(bytes, 0, bytes.length) != -1) {
                //控制台看一下读取的字符
                System.out.println(new String(bytes, "GBK"));
                //写入文件
                outputStream.write(bytes);
            }
        } finally {
            //关闭流
            inputStream.close();
            outputStream.close();
        }
    }

    /**
     * BufferedInputStream、BufferedOutputStream（缓存字节流）使用方式和字节流差不多，但是效率更高（数据量大时推荐使用）
     */
    private static void oprate2() throws IOException {
        //要读取的文件
        File fileInput = new File("D:/ioTest.txt");
        //要写入的文件
        File fileOutput = new File("D:/oprate2OutPut.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileInput));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileOutput));
        try {
            //每次读取多少字节
            byte[] bytes = new byte[2048];
            while (bufferedInputStream.read(bytes) != -1) {
                //控制台看一下读取的字符
                System.out.println(new String(bytes, "GBK"));
                //写入文件
                bufferedOutputStream.write(bytes);
            }
        } finally {
            //清除缓存
            bufferedOutputStream.flush();
            bufferedInputStream.close();
            bufferedOutputStream.close();
        }
    }

    /**
     * InputStreamReader、OutputStreamWriter（字符流）
     *
     * @throws IOException
     */
    private static void oprate3() throws IOException {
        //要读取的文件
        File fileInput = new File("D:/ioTest.txt");
        //要写入的文件
        File fileOutput = new File("D:/oprate3OutPut.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileInput), "GBK");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(fileOutput));
        try {
            //每次读取多少字符
            char[] chars = new char[2048];
            while (inputStreamReader.read(chars) != -1) {
                //控制台看一下读取的字符
                System.out.println(new String(chars));
                //写入文件
                outputStreamWriter.write(chars);
            }
        } finally {
            //清除缓存
            outputStreamWriter.flush();
            inputStreamReader.close();
            outputStreamWriter.close();
        }
    }

    /**
     * BufferedReader、BufferedWriter（缓存字符流）
     *
     * @throws IOException
     */
    private static void oprate4() throws IOException {
        //要读取的文件
        File fileInput = new File("D:/ioTest.txt");
        //要写入的文件
        File fileOutput = new File("D:/oprate4OutPut.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileInput), "GBK"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOutput), "GBK"));
        try {
            //每次读取多少字节
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                //控制台看一下读取的字符
                System.out.println(str);
                //写入文件
                bufferedWriter.write(str);
                //换行(写入换行符)
                bufferedWriter.newLine();
            }
        } finally {
            //清除缓存
            bufferedWriter.flush();
            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
