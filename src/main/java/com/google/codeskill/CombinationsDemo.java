package com.google.codeskill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jhons on 2019/1/10.
 */
/*
* @since: 2019-01-10 15:26
* @author:htj
* ((1,2,3,4,5),2)
*��1~5������ȡ2�����ֽ������
*
*/
public class CombinationsDemo {

    public void combinations(List<Integer> selected,List<Integer> data, int num) {
        if(num==0){

            for(Integer i : selected){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        if (data.isEmpty()) {
            return;
        }

        selected.add(data.get(0));
        combinations(selected,data.subList(1, data.size()), num - 1);

        selected.remove(selected.size()-1);
        combinations(selected,data.subList(1, data.size()), num);
    }

    public static void main(String[] args) {
        CombinationsDemo com = new CombinationsDemo();
        com.combinations(new ArrayList<>(), Arrays.asList(1,2,3,4,5,6),4);
    }
}
