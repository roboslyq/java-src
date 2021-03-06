/**
 * Copyright (C), 2015-2019
 * FileName: SpiralOrder
 * Author:   luo.yongqian
 * Date:     2019/9/12 17:07
 * Description:
 * History:
 * <author>                 <time>          <version>          <desc>
 * luo.yongqian         2019/9/12 17:07      1.0.0               创建
 */
package com.roboslyq.algorithm.leetcode.lc0001to0100.lc0054_spiralorder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 〈给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author luo.yongqian
 * @create 2019/9/12
 * @since 1.0.0
 */
public class SpiralOrder {
    public static void main(String[] args) {
//        int[][] test = {
//            {1,2,3,4},
//            {4,5,6,8},
//            {7,8,9,10}
//        };
        int[][] test = {
            {1 },
            {4 },
            {7}
        };
        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> integers = spiralOrder.spiralOrder(test);
        integers.stream().forEach(System.out::println);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        //处理数组为空的情况
        if(matrix == null || matrix.length == 0){
            return  new ArrayList<>();
        }
        int y = matrix.length;
        int x = matrix[0].length;
        List<Integer> res = new ArrayList<>(x*y);
        //处理x=1的特殊情况
        if(x==1){
            for(int j=0;j<y;j++){
                res.add(matrix[j][0]);
            }
            return res;
        }
        int count = x*y;
        int c_h = 0; //high,上方高度的初始值，即第0行开始
        int c_d = y-1;//down,下方的高度值，从数据
        int c_r = x -1;
        int c_l = 0;
        int cur_x = 0;//x轴值（行数）
        int cur_y = 0;//y轴值（列数）
        int for_type = 0; // 0 : 行右，1：上下 2 行左 3 下上

        while (count-- > 0){
            res.add(matrix[cur_x][cur_y]);
            switch (for_type){
                case 0:
                    cur_y++;
                    if(cur_y == c_r){
                        c_h++;
                        for_type=1;
                    };
                    break;
                case 1:
                    cur_x++;
                    if(cur_x == c_d){
                        c_r--;
                        for_type=2;
                    }
                    break;
                case 2:
                    cur_y--;
                    if(cur_y == c_l){
                        c_d--;
                        for_type=3;
                    }
                    break;
                case 3:
                    cur_x--;
                    if(cur_x == c_h){
                        c_l++;
                        for_type = 0;
                    }
                    break;
            }
        }
        return res;

    }

}