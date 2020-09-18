package chess;

import util.IChess;

/**
 * 功能: 人类线程
 * 作者: 黄欢欢  时间: 2016-09-28
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
     * 作者: 黄欢欢  时间: 2016-09-28
     */
    public void run() {
        //期盼添加鼠标监听器
        chessTable.addMouseListener(chessTable.new MouseHandler());
    }

}
