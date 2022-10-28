import java.util.ArrayList;
import java.util.List;

public class Homework3 {
    List<List<Integer>> combinations = new ArrayList<>();

    /**
     * Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
     * например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение
     * или сообщить, что его нет.
     */
    public List<String> getExpressionVariants(String expression) {
        List<String> exprVariants = new ArrayList<>();
        expression = expression.replaceAll(" ", "");
        char[] exprChars = expression.toCharArray();
        List<Integer> questionMarks = new ArrayList<>();
        for (int i = 0; i < exprChars.length; i++) {
            if (exprChars[i] == '?') {
                questionMarks.add(i);
            }
        }
        prepareCombinations(new ArrayList<>(), questionMarks.size());
        for (List<Integer> comb : combinations) {
            for (int qMarkIndex = 0; qMarkIndex < questionMarks.size(); qMarkIndex++) {
                exprChars[questionMarks.get(qMarkIndex)] = Character.forDigit(comb.get(qMarkIndex), 10);
            }
            String exprVariant = new String(exprChars);
            String[] exprParts = exprVariant.split("[/+=]");
            int sum = Integer.parseInt(exprParts[2]);
            if (Integer.parseInt(exprParts[0]) + Integer.parseInt(exprParts[1]) == sum) {
                exprVariants.add(exprVariant);
            }
        }
        return exprVariants;
    }

    private void prepareCombinations(List<Integer> comb, int k) {
        if (comb.size() == k) {
            combinations.add(new ArrayList<>(comb));
            return;
        }
        for (int i = 0; i <= 9; i++) {
            comb.add(i);
            prepareCombinations(comb, k);
            comb.remove(comb.size() - 1);
        }
    }

    /**
     * https://leetcode.com/problems/number-of-islands/
     */
    public int numIslands(char[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        int countIslands = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    countIslands++;
                    clearIsland(grid, i, j, length, width);
                }
            }
        }
        return countIslands;
    }

    private void clearIsland(char[][] grid, int i, int j, int length, int width) {
        grid[i][j] = '0';
        if (i + 1 < length && grid[i + 1][j] == '1') {
            clearIsland(grid, i + 1, j, length, width);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            clearIsland(grid, i - 1, j, length, width);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            clearIsland(grid, i, j - 1, length, width);
        }
        if (j + 1 < width && grid[i][j + 1] == '1') {
            clearIsland(grid, i, j + 1, length, width);
        }
    }
}
