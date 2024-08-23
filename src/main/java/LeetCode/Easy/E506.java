package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.*;

public class E506 {

    @Test
    public void t() {

        findRelativeRanks(new int[]{1, 3, 5, 2, 4, 7});

    }

    public String[] findRelativeRanks(int[] score) {
        //   创建一个HashMap将得分与其排名建立联系
        int len=score.length;
        // 不去改变原数组，创建一个新的数组进行排序
        int[] nums=new int[len];
        for(int i=0;i<len;i++){
            nums[i]=score[i];
        }
        // 对数组进行排序
        Arrays.sort(nums);
        //  创建一个HashMap建立联系
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<len;i++){
            map.put(nums[i],len-i);
        }

        // 创建一个String[] 数组来保存数据
        String[] str=new String[len];
        // 根据score中的分数生成相应的奖励
        for(int i=0;i<len;i++){
            int mc=map.get(score[i]);
            if(mc==1){
                str[i]="Gold Medal";
            }else if(mc==2){
                str[i]="Silver Medal";
            }else if(mc==3){
                str[i]="Bronze Medal";
            }else{
                str[i]=mc+"";
            }
        }

        return str;
    }

}
