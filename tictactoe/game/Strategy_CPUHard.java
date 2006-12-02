package game;

/**
 * An extension to the computer strategy.
 * This will implement an actual TicTacToe AI of sorts
 *
 * @author Gavin
 */
public class Strategy_CPUHard extends Strategy {

    private int tempX;
    private int tempY;


    private int temp;
    private int boardState[] = new int[9];
    private int row1;
    private int row2;
    private int row3;
    private int col1;
    private int col2;
    private int col3;
    private int diag1;
    private int diag2;
    private int counter;
    //private int tempMoveWeight;
    //private int tempMinMoveWeight;
    private int bestMoveWeight;
    //private int humanMinMoveWeight;
    private int cpuWinNum[] = new int[9];
    //private int humanWinNum[] = new int[9];
    private int currentBestMove;


    Strategy_CPUHard(TicTacToeWindow window) {
        super(window);
        tempX = -1;
        tempY = -1;
        row1 = -1;
        row2 = -1;
        row3 = -1;
        col1 = -1;
        col2 = -1;
        col3 = -1;
        diag1 = -1;
        diag2 = -1;
        counter = 0;
        //tempMoveWeight = 0;
        //tempMinMoveWeight = 0;
        bestMoveWeight = 0;
        //humanMinMoveWeight = 0;
        currentBestMove = -1;
    }

    /**
     * Makes a random move on the playing board in a location that is available.
     */
    public void strategyHook() {
        minmax();
        calculateMove();
        x = tempX;
        y = tempY;
    }

    /**
     * Does nothing.
     */
    public void cleanupHook() {
        // nothing
    }

    private void minmax() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                temp = tictactoewindow.getState(j, i);

                /*
                 * setting temp to -1 if not played, also for making evaluating winning rows/
                 * cols/diags with simple math
                 */
                if (temp == 0) {
                    temp = -1;
                }
                /*
                 * setting temp to a lower value to evaluate winning rows/cols/diags
                 * easier with simple math
                 */
                if (temp == 1) {
                    temp = -10;
                }
                boardState[counter] = temp;
                counter = counter + 1;

            }
        }
        currentBestMove = evalWins();

        for (int i = 0; i < 9; i++) {
            cpuWinNum[i] = 0;
        }
        counter = 0;

    }

    private void calculateMove() {
        if (currentBestMove == 0) {
            tempX = 0;
            tempY = 0;
        } else if (currentBestMove == 1) {
            tempX = 1;
            tempY = 0;
        } else if (currentBestMove == 2) {
            tempX = 2;
            tempY = 0;
        } else if (currentBestMove == 3) {
            tempX = 0;
            tempY = 1;
        } else if (currentBestMove == 4) {
            tempX = 1;
            tempY = 1;
        } else if (currentBestMove == 5) {
            tempX = 2;
            tempY = 1;
        } else if (currentBestMove == 6) {
            tempX = 0;
            tempY = 2;
        } else if (currentBestMove == 7) {
            tempX = 1;
            tempY = 2;
        } else if (currentBestMove == 8) {
            tempX = 2;
            tempY = 2;
        }

        // kind of a trapper to ensure we do actually
        // get a valid piece on the board
        if (!isValidMove(tempX + 1, tempY + 1)) {
            currentBestMove++;
            if (currentBestMove > 8)
                currentBestMove = 0;
            calculateMove();
        }
    }

    private int evalWins() {
        /*
         * calculates move "weight" based on possible wins
         * for the cpu
         */
        int tempBestMove = -1;
        row1 = (boardState[0] + boardState[1] + boardState[2]);
        row2 = (boardState[3] + boardState[4] + boardState[5]);
        row3 = (boardState[6] + boardState[7] + boardState[8]);

        col1 = (boardState[0] + boardState[3] + boardState[6]);
        col2 = (boardState[1] + boardState[4] + boardState[7]);
        col3 = (boardState[2] + boardState[5] + boardState[8]);

        diag1 = (boardState[0] + boardState[4] + boardState[8]);
        diag2 = (boardState[2] + boardState[4] + boardState[6]);

        for (int i = 0; i < 9; i++) {
            if (boardState[i] == -1) {
                System.out.println("Empty, checking");

                if (i == 0 || i == 1 || i == 2) {
                    if (row1 == -21 || row1 == 3) {
                        cpuWinNum[i] = 100;
                    } else if (row1 == 0 || row1 == -3) {
                        if (cpuWinNum[i] < 100) {
                            cpuWinNum[i] = cpuWinNum[i] + 1;
                        }
                    }
                }

                if (i == 3 || i == 4 || i == 5) {
                    if (row2 == -21 || row2 == 3) {
                        cpuWinNum[i] = 100;
                    } else if (row2 == 0 || row2 == -3) {
                        if (cpuWinNum[i] < 100) {
                            cpuWinNum[i] = cpuWinNum[i] + 1;
                        }
                    }
                }

                if (i == 6 || i == 7 || i == 8) {
                    if (row3 == -21 || row3 == 3) {
                        cpuWinNum[i] = 100;
                    } else if (row3 == 0 || row3 == -3) {
                        if (cpuWinNum[i] < 100) {
                            cpuWinNum[i] = cpuWinNum[i] + 1;
                        }
                    }
                }

                if (i == 0 || i == 3 || i == 6) {
                    if (col1 == -21 || col1 == 3) {
                        cpuWinNum[i] = 100;
                    } else if (col1 == 0 || col1 == -3) {
                        if (cpuWinNum[i] < 100) {
                            cpuWinNum[i] = cpuWinNum[i] + 1;
                        }
                    }
                }

                if (i == 1 || i == 4 || i == 7) {
                    if (col2 == -21 || col2 == 3) {
                        cpuWinNum[i] = 100;
                    } else if (col2 == 0 || col2 == -3) {
                        if (cpuWinNum[i] < 100) {
                            cpuWinNum[i] = cpuWinNum[i] + 1;
                        }
                    }
                }

                if (i == 2 || i == 5 || i == 8) {
                    if (col3 == -21 || col3 == 3) {
                        cpuWinNum[i] = 100;
                    } else if (col3 == 0 || col3 == -3) {
                        if (cpuWinNum[i] < 100) {
                            cpuWinNum[i] = cpuWinNum[i] + 1;
                        }
                    }
                }

                if (i == 0 || i == 4 || i == 8) {
                    if (diag1 == -21 || diag1 == 3) {
                        cpuWinNum[i] = 100;
                    } else if (diag1 == 0 || diag1 == -3) {
                        if (cpuWinNum[i] < 100) {
                            cpuWinNum[i] = cpuWinNum[i] + 1;
                        }
                    }
                }

                if (i == 2 || i == 4 || i == 6) {
                    if (diag2 == -21 || diag2 == 3) {
                        cpuWinNum[i] = 100;
                    } else if (diag2 == 0 || diag2 == -3) {
                        if (cpuWinNum[i] < 100) {
                            cpuWinNum[i] = cpuWinNum[i] + 1;
                        }
                    }
                }
            }//*** end if boardState[i] == -1***

            else if (boardState[i] != -1) {
                System.out.println("Checked, Not empty");
                System.out.println(i);
                System.out.println(boardState[i]);
            }

            if (cpuWinNum[i] == 100) {
                return i;
            } else if (cpuWinNum[i] >= bestMoveWeight) {
                if (cpuWinNum[i] != 100) {
                    bestMoveWeight = cpuWinNum[i];
                    tempBestMove = i;
                }
            }


        }//*** end for loop ***


        System.out.println("Cpu move weights");
        for (int g = 0; g < 9; g++) {

            System.out.println(cpuWinNum[g]);
        }

        System.out.println("Board State Values");

        for (int g = 0; g < 9; g++) {

            System.out.println(boardState[g]);
        }
        return tempBestMove;
    }

}
