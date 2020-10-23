import basic.TreeNode;
import javafx.beans.binding.IntegerBinding;

import java.util.*;

/**
 * @Title: LeetCode每日一题
 * @Description:
 * @Author: jinzbone
 * @Date: 2020年07月25日19:06:15
 * @Version: 1.0
 */

public class LeetCodeDaily {

    Set<List<Integer>> resultList = new LinkedHashSet<>();
    List<String> result_findSubsequences = new ArrayList<>();
    boolean flag = false;
    int N;              // 记录n
    char[][] board;     // 模拟棋盘
    List<List<String>> schemes = new LinkedList<>();    // 存放合法方案
    List<String> result_binaryTreePaths = new ArrayList<>();
    List<String> result_getPermutation = new ArrayList<>();
    List<List<Integer>> result_permute = new ArrayList<>();
    public static void main(String[] args) {
        LeetCodeDaily lcd = new LeetCodeDaily();
        int[] nums = new int[]{1,2,3};
        lcd.permute(nums);
    }

    

    /**
     * @Title: 46. 全排列
     * @Description: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     * @Param: int[] nums
     * @return: List<List<Integer>>
     */
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        dfs_permute(nums, path);
        System.out.println(result_permute);
        return result_permute;
    }
    public void dfs_permute(int[] nums, List<Integer> path){
        if (path.size() == nums.length){
            result_permute.add(path);
            return;
        }
        for (int i = 0; i < nums.length ; i++) {
            if (!path.contains(nums[i])){
                path.add(nums[i]);
                dfs_permute(nums, new ArrayList<>(path));
                path.remove(path.size()-1);
            }
        }
    }

    /**
     * @Title: 257. 二叉树的所有路径
     * @Description: 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * @Param: TreeNode root
     * @return: List<String>
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs_binaryTreePaths(result, root, new StringBuilder(""));
        return result;
    }
    public void dfs_binaryTreePaths(List<String> result, TreeNode root, StringBuilder path){
        if (root == null) return;
        path.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(path.toString());
            return;
        }
        path.append("->");
        if (root.left != null) {
            dfs_binaryTreePaths(result, root.left, new StringBuilder(path));
        }
        if (root.right != null) {
            dfs_binaryTreePaths(result, root.right, new StringBuilder(path));
        }
    }

    /**
     * @Title: 51. N 皇后
     * @Description:
     * @Param:
     * @return:
     */
    public List<List<String>> solveNQueens(int n) {
        N = n;
        board = new char[N][N];
        for (char[] line : board) {     // 初始化
            Arrays.fill(line, '.');
        }
        dfs_solveNQueens(0);   // 从第 1 行开始放皇后
        return schemes;
    }
    public void dfs_solveNQueens(int r) {
        // 结束条件
        if (r == N) {
            // 添加方案
            List<String> scheme = new LinkedList<>();
            for (char[] line : board) {
                scheme.add(String.valueOf(line));
            }
            schemes.add(scheme);
            return;
        }
        // 选择列表
        for (int j = 0; j < N; j++) {
            if (isValid(r, j)) {             // 合法才能选
                board[r][j] = 'Q';          // 选择
                dfs_solveNQueens(r + 1);           // 往下一层搜索
                board[r][j] = '.';          // 撤销选择，以免影响同一行其他位置的摆放
            }
        }
    }
    public boolean isValid(int x, int y) {
        // 同一行
        for (int j = 0; j < y; j++) {
            if (board[x][j] == 'Q') {
                return false;
            }
        }
        // 同一列
        for (int i = 0; i < x; i++) {
            if (board[i][y] == 'Q') {
                return false;
            }
        }
        // 主对角线
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 副对角线
        for (int i = x - 1, j = y + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * @Title: 剑指 Offer 20. 表示数值的字符串
     * @Description: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
     * @Param: String s
     * @return: boolean
     */
    public boolean isNumber(String s) {
        if (s.length()==0 || s==null) return false;
        char[] ss = s.trim().toCharArray();
        int n = ss.length;
        boolean isNum = false, isDot = false, iseOrE = false;
        for (int i = 0; i < n; i++) {
            char c = ss[i];
            if (c>='0' && c<='9') isNum = true;
            else if (c=='.'){
                if (isDot || iseOrE) return false;
                isDot = true;
            }
            else if (c=='e' || c=='E'){
                if (!isNum || iseOrE) return false;
                iseOrE = true;
                isNum = false;
            }
            else if (c=='+' || c=='-'){
                if (i!=0 && ss[i-1]!='e' && ss[i-1]!='E') return false;
            }
            else return false;
        }
        return isNum;
    }

    /**
     * @Title: 486. 预测赢家
     * @Description: 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
     * @Param: int[] nums
     * @return: boolean
     */
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = n-1; i >=0; i--) {
            for (int j = i+1; j < n; j++) {
                dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][n-1]>=0;
    }

    /**
     * @Title: 841. 钥匙和房间
     * @Description: 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
     * @Param: List<List<Integer>> rooms
     * @return: boolean
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs_canVisitAllRooms(rooms, 0, path);
        return flag;
    }
    public void dfs_canVisitAllRooms(List<List<Integer>> rooms, int roomId, List<Integer> path){
        boolean temp = true;
        for (int i = 0; i < rooms.size(); i++) {
            if (!path.contains(i)){
                temp=false;
                break;
            }
        }
        if (path.size()>=8) System.out.println(path);
        if (temp){
            flag=true;
            return;
        }
        List<Integer> keys = rooms.get(roomId); // roomId的钥匙list
        for (int i = 0; i < keys.size(); i++) {
            int key = keys.get(i);
            if (!path.contains(key)){
                path.add(key);
                dfs_canVisitAllRooms(rooms, key, path);
            }
        }
    }

    /**
     * @Title: 557. 反转字符串中的单词 III
     * @Description: 输入："Let's take LeetCode contest"  输出："s'teL ekat edoCteeL tsetnoc"
     * @Param: String s
     * @return: String
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        while (i<n){
            int start = i;
            while (i<n && s.charAt(i)!=' ') i++;
            for (int j = i-1; j >=start; j--) sb.append(s.charAt(j));
            if (i!=n){
                sb.append(' ');
                i ++;
            }
        }
        return sb.toString();
    }

    /**
     * @Title: 28. 实现 strStr()
     * @Description: 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * @Param: String haystack, String needle
     * @return: int
     */
    public int strStr(String haystack, String needle) {
        if (needle.equals(""))return 0;
        int m = haystack.length(), n = needle.length();
        if (m < n) return -1;
        for (int i = 0; i < m; i++) {
            if (haystack.charAt(i)==needle.charAt(0) && m-i>=n){
                boolean flag = true;
                for (int j = 1; j < n; j++) {
                    if (haystack.charAt(i+j)!=needle.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if (flag==true)return i;
            }
        }
        return -1;
    }

    /**
     * @Title: 657. 机器人能否返回原点
     * @Description: 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
     * @Param: String moves
     * @return: boolean
     */
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        if (n==0) return true;
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            char c = moves.charAt(i);
            if (c=='U') y += 1;
            else if (c=='D') y -= 1;
            else if (c=='L') x -= 1;
            else if (c=='R') x += 1;
        }
        if (x==0 && y==0) return true;
        return false;
    }

    /**
     * @Title: 17. 电话号码的字母组合
     * @Description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * @Param: String s
     * @return: List<String>
     */
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a','b','c'));
        map.put(3, Arrays.asList('d','e','f'));
        map.put(4, Arrays.asList('g','h','i'));
        map.put(5, Arrays.asList('j','k','l'));
        map.put(6, Arrays.asList('m','n','o'));
        map.put(7, Arrays.asList('p','q','r','s'));
        map.put(8, Arrays.asList('t','u','v'));
        map.put(9, Arrays.asList('w','x','y','z'));
        if (digits.length()==0) return new ArrayList<>();
        dfs_letterCombinations(digits, 0, new StringBuilder(), map);
        return result_findSubsequences;
    }
    public void dfs_letterCombinations(String s, int idx, StringBuilder sb, HashMap<Integer, List<Character>> map){
        if (idx==s.length()){
            result_findSubsequences.add(sb.toString());
            return;
        }
        int n = s.charAt(idx) - '0'; //数字
        List<Character> list = map.get(n); //它的list
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            dfs_letterCombinations(s, idx+1, sb, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    /**
     * @Title: 491. 递增子序列
     * @Description: 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     * @Param: int[] nums
     * @return: List<List<Integer>>
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> path = new ArrayList<>();
        dfs_findSubsequences(nums, 0, path);
        System.out.println(resultList);
        return new ArrayList<>(resultList);
    }
    public void dfs_findSubsequences(int[] nums, int idx, List<Integer> path){
        Set<Integer> set = new HashSet<>();

        if (path.size()>=2 && !resultList.contains(path)){
//            resultList.add(path); //这种写法，错误！因为在Java中这是引用类型。
            resultList.add(new ArrayList<>(path));
        }
        if (idx == nums.length){
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if (path.size()==0 || nums[i]>=path.get(path.size()-1)) {
                path.add(nums[i]);
                dfs_findSubsequences(nums, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * @Title: 构建一棵树（用于测试）
     * @Description:
     * @Param:
     * @return:
     */
    public TreeNode buildTree(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        return t1;
    }

    /**
     * @Title: 100. 相同的树
     * @Description: 给定两个二叉树，编写一个函数来检验它们是否相同。
     * @Param: TreeNode r1, TreeNode r2
     * @return: boolean
     */
    public boolean isSameTree(TreeNode r1, TreeNode r2){
        if (r1==null && r2==null)return true;
        else if (r1==null || r2==null || r1.val!=r2.val) return false;
        return isSameTree(r1.left, r2.left) && isSameTree(r1.right, r2.right);

    }

    /**
     * @Title: 415. 字符串相加
     * @Description: 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     * @Param: String num1, String num2
     * @return: String
     */
    public String addString(String num1, String num2){
        int m = num1.length();
        int n = num2.length();
        if (m==0 && n==0) return "";
        else if (m==0) return num2;
        else if (n==0) return num1;
        int i = m-1, j = n-1;
        int bonus = 0;
        StringBuilder sb = new StringBuilder();
        while (i>=0 || j>=0){
            int ni = i>=0?num1.charAt(i)-'0':0;
            int nj = j>=0?num2.charAt(j)-'0':0;
            int temp = ni+nj+bonus;
            bonus = temp/10;
            sb.append(temp%10);
            i -= 1;
            j -= 1;
        }
        if (bonus==1)sb.append(1);
        return sb.reverse().toString();
    }

    /**
     * @Title: 104. 二叉树的最大深度
     * @Description: 给定一个二叉树，找出其最大深度。
     * @Param: TreeNode root
     * @return: int depth
     */
    public int maxDepth(TreeNode root){
        return recursive_maxDepth(root);
    }
    public int recursive_maxDepth(TreeNode root){
        if (root==null){ //循环跳出的条件（也就是到达了假叶子节点）
            return 0;
        }
        return 1+Math.max(recursive_maxDepth(root.left), recursive_maxDepth(root.right));
    }

    /**
     * @Title: 392. 判断子序列
     * @Description: （区分子串）如 "abc"是"ahbgdc"的一个子序列
     * @Param: String s, String t
     * @return: boolean
     */
    public boolean isSubsequence(String s, String t){
        int m = s.length();
        int n = t.length();
        int j = 0;
        if (m==0) return true;
        if (n==0) return false;
        for (int i = 0; i < n; i++) {
            if (t.charAt(i)==s.charAt(j)){
                j += 1;
                if(j==m) return true;
            }
        }
        return false;
    }

    /**
     * @Title: 剑指 Offer 11. 旋转数组的最小数字
     * @Description: 一个有序数组，右边的一部分旋转到左边，找到这个旋转之后的数组中最小的数字。
     * @Param: int[] nums
     * @return: int num
     */
    public int minArray(int[] nums){
        int n = nums.length;
        int i = 0, j = n-1;
        while (i<j){
            int mid = (i+j)/2;
            if (nums[mid]>nums[j]){
                i = mid + 1;
            }else if (nums[mid]<nums[j]){
                j = mid;
            }else if (nums[mid] == nums[j]){
                j -= 1;
            }
        }
        return nums[i];
    }

    /**
     * @Title: 面试题 17.13. 恢复空格
     * @Description:
     * @Param:
     * @return:
     */
    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();
        int m = dictionary.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int j = 0; j < m; j++) {
                if (i < dictionary[j].length()) continue;
                if (sentence.substring(i - dictionary[j].length(), i).equals(dictionary[j])) {
                    dp[i] = Math.max(dp[i - dictionary[j].length()] + dictionary[j].length(), dp[i]);
                }
            }
        }
        return n - dp[n];
    }

    /**
     * @Title: 309. 最佳买卖股票时机含冷冻期
     * @Description:
     * @Param:
     * @return:
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 1) return 0;
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 0; i < n; i++) {
            int newf0 = Math.max(f0, f2 - prices[i]);
            int newf1 = f0 + prices[i];
            int newf2 = Math.max(f1, f2);
            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }
        return Math.max(f1, f2);
    }

    /**
     * @Title: 生成一棵二叉树 用于代码测试
     * @Description:
     * @Param:
     * @return:
     */
    public TreeNode generateTree(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        return t1;
    }
}

/**
 * @Title: Trie树
 * @Description: 字典树，在字符串查找、前缀匹配等中应用很广泛，其高效率是以空间为代价的。
 * @Author: jinzbone
 * @Date: 2020年07月26日22:01:43
 * @Version: 1.0
 */
class Trie{
    Trie[] child = new Trie[26];
    boolean isEndNode = false;
    public Trie(){}
    public void insert(String word){
        Trie root = this;
        for (char c:word.toCharArray()) {
            if (root.child[c-'a'] == null){
                root.child[c-'a'] = new Trie();
            }
            root = root.child[c-'a'];
        }
        root.isEndNode = true;
    }
    public boolean search(String word){
        Trie root = this;
        for (char c:word.toCharArray()){
            if (root.child[c-'a']==null){
                return false;
            }
            root = root.child[c-'a'];
        }
        return root.isEndNode;
    }
    public boolean startsWith(String word){
        Trie root = this;
        for (char c: word.toCharArray()){
            if (root.child[c-'a']==null){
                return false;
            }
            root = root.child[c-'a'];
        }
        return true;
    }
}