class Solution {
    public boolean isValidSudoku(char[][] board) {
        // hashset single pass: TC & SN: O(n ^ 2)
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char cell = board[r][c];
                if(cell == '.') continue;
                String squareKey = (r / 3) + "_" + (c / 3);
                if(
                    rows.computeIfAbsent(r, k -> new HashSet<>()).contains(cell) ||
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(cell) ||
                    squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(cell)
                ){
                    return false;
                }
                rows.get(r).add(cell);
                cols.get(c).add(cell);
                squares.get(squareKey).add(cell);
            }
        }
        return true;
    }
}
