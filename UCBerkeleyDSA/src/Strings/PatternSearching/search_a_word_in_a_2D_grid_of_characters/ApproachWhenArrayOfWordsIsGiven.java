package Strings.PatternSearching.search_a_word_in_a_2D_grid_of_characters;
import java.util.ArrayList;
import java.util.List;

/*We check every cell. If cell has first character, then, we one by one try all 8 directions from that cell for a match, put this
* check in a loop. We use mover array to store the manner in which next moves are possible*/

/*Time complexity: O(R*C*len(str)*Number(str)*len(str)), all the cells will be visited and traversed in all 8 directions, where
* R and C is side of matrix, so, time complexity is O(R*C) for each string*/

//Auxiliary Space: O(R*C*Numberof(str)*len(str))

class Body {

    //making the possible moves in movers array
    private final List<List<Integer>> Mover = List.of(
            List.of(1, 0), List.of(0, 1), List.of(-1, 0),
            List.of(0, -1), List.of(1, 1), List.of(-1, -1),
            List.of(1, -1), List.of(-1, 1));

    //making the board global variable
    private List<List<Character>> Board;
    private int Rows;
    private int Cols;

    //Making a function findwords to find words along with their location which inputs the board and list of words
    public List<String> findWords(char[][] board, String[] words) {
        var result = new ArrayList<String>();
        Rows = board.length;
        Cols = board[0].length;

        //making board a global variable
        Board = new ArrayList<>(Rows);
        for (int i = 0; i < Rows; i++) {
            Board.add(new ArrayList<>());

            for (int j = 0; j < Cols; j++) {
                Board.get(i).add(board[i][j]);
            }
        }

        for (String word : words) {
            for (int i = 0; i < Rows; i++) {
                for (int j = 0; j < Cols; j++) {
                    if (Board.get(i).get(j) == word.charAt(0)) {

                        //making a function findwords to find words along with their location which inputs the board and
                        //list of words
                        if (dfs(i, j, word.substring(1), new boolean[Rows][Cols])) {
                            result.add(word + "->{" + i + "," + j + "}");
                        }
                    }
                }
            }
        }
        return result;
    }

    //depth first search for the string, with the coordinates and a visited array to take care that we do not overlap the places
    //visited already
    private boolean dfs(int x, int y, String s, boolean[][] vis) {

        //if string length becomes 0, means string is found
        if (s.isEmpty()) {
            return true;
        }

        vis[x][y] = true;

        //making a solution boolean to see if we can perform depth search to find answer
        boolean sol = false;

        //making possible moves
        for (List<Integer> move : Mover) {
            int currX = move.get(0) + x;
            int currY = move.get(1) + y;

            //checking for out of bount areas
            if (currX >= 0 && currX < Rows && currY >= 0 && currY < Cols) {

                //checking for similarity in the first letter and the visited array
                if (Board.get(currX).get(currY) == s.charAt(0) && !vis[currX][currY]) {
                    if (dfs(currX, currY, s.substring(1), vis)) {

                        //removing the first letter from the string
                        sol = true;
                    }
                }
            }
        }
        return sol;
    }
}

public class ApproachWhenArrayOfWordsIsGiven {
    public static void main(String[] args) {

        //making 1 instance of class solution as solver
        Body solver = new Body();
        char[][] board = new char[][] { { 'o', 'a', 'a', 'n' },
                { 'e', 't', 'a', 'e' },
                { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } };
        String[] words
                = new String[] { "oath", "pea", "eat", "rain" };

        // using the function findwords from our solution
        // class to find the answer
        List<String> ans = solver.findWords(board, words);
        for (String s : ans) {
            System.out.println(s);
        }
    }
}