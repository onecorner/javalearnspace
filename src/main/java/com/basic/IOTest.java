package com.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @ClassName
 * @since: created in  2019-03-22 10:24
 * @author: htj
 * @modified by:
 * @version:
 **/
public class IOTest {

    public static void main(String[] args) throws IOException {
        URL resource = IOTest.class.getClassLoader().getResource("test.txt");
        BufferedReader fr = new BufferedReader(new FileReader(resource.getPath()));
        String str;
        while ((str = fr.readLine())!=null) {
            System.out.println(str);
        }
        fr.close();
        InputStream resourceAsStream = IOTest.class.getResourceAsStream("/test.txt");
        BufferedReader bf = new BufferedReader(new InputStreamReader(resourceAsStream));
        while((str = bf.readLine())!=null){
            System.out.println(str);
        }
        bf.close();

    }
}
