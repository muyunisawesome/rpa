package chess;

import util.IChess;

/**
 * 功能: 人类线程
 */
public class HumanThread implements Runnable {
  private IChess chess;
  private ChessTable chessTable;

  public HumanThread(ChessTable chessTable, IChess chess) {
    this.chessTable = chessTable;
    this.chess = chess;
  }

  /**
   * 人类线程开启鼠标监听
   */
  public void run() {
    chessTable.addMouseListener(chessTable.new MouseHandler());
  }

}
