package com.spsoft.leetcode.easy.matrix;

public class L733FloodFill {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int srcColor = image[sr][sc];
            if(srcColor != color){
                floodFillHelper(image,sr, sc, srcColor, color);
            }
            return image;

        }

        public void floodFillHelper(int [][] image, int sr, int sc, int srcColor, int targetColor){
            if((sr < 0 || sr >= image.length) || (sc < 0 || sc >= image[0].length) || (image[sr][sc] != srcColor) || (image[sr][sc] == targetColor))
                return;

            image[sr][sc] = targetColor;

            floodFillHelper(image, sr -1, sc, srcColor, targetColor);
            floodFillHelper(image, sr +1, sc, srcColor, targetColor);
            floodFillHelper(image, sr , sc -1, srcColor, targetColor);
            floodFillHelper(image, sr, sc + 1, srcColor, targetColor);

        }
    }
}
