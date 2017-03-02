package Threads.MineSweeperSimulation.workers;

import Threads.MineSweeperSimulation.Constants.Constants;
import Threads.MineSweeperSimulation.view.Board;

import java.util.Random;

/**
 * @author ssadasivan
 * @since 3/2/2017.
 */
public class MineLayer implements Runnable{
	private int id;
	private Board board;

	public MineLayer(int id, Board board) {
		this.id = id;
		this.board = board;
	}

	@Override
	public void run() {
		Random random = new Random();
		while(true){
			int index = random.nextInt(Constants.BOARD_ROWS * Constants.BOARD_COLUMNS);
			board.setMine(index);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "MineLayer{" +
				"id=" + id +
				'}';
	}
}
