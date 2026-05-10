class Solution {
    public boolean isValidSudoku(char[][] board) {
        // row validation
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char cell = board[row][i];
                if (cell == '.')
                    continue;
                if (seen.contains(cell))
                    return false;
                seen.add(cell);
            }
        }
        // column validation
        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char cell = board[i][col];
                if (cell == '.')
                    continue;
                if (seen.contains(cell))
                    return false;
                seen.add(cell);
            }
        }
        // 3 x 3 boxes validation
        for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            int initialRow = (square / 3) * 3;
            int initialCol = (square % 3) * 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = initialRow + i;
                    int col = initialCol + j;
                    char cell = board[row][col];
                    if(cell == '.') continue;
                    if(seen.contains(cell)) return false;
                    seen.add(cell);
                }
            }
        }
        // else valid
        return true;
    }
}
