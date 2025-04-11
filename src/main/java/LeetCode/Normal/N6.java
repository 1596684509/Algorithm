package LeetCode.Normal;

public class N6 {


    /**
     * 将给定的字符串按照横着的s型进行排列后转换即可
     * 需要维护前进的方向，当行数为0时前进方向向下，当行数到达底部时，更改前进方向向上
     * 时间复杂度O(n) n = s.length()
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;  // 如果只有一行，直接返回

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int index = 0;  // 当前行索引
        int direction = 1;  // 方向，1表示向下，-1表示向上

        for (char c : s.toCharArray()) {
            rows[index].append(c);

            if (index == 0) {
                direction = 1;  // 到达顶部，向下
            } else if (index == numRows - 1) {
                direction = -1; // 到达底部，向上
            }

            index += direction;
        }

        // 拼接所有行
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }


}
