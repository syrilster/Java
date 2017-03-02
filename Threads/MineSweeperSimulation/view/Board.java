package Threads.MineSweeperSimulation.view;

import Threads.MineSweeperSimulation.Constants.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * @author ssadasivan
 * @since 3/2/2017.
 */
public class Board extends JPanel {
	private Cell[] cells;
	private int numberOfMines;

	public synchronized void incrementNumberOfMines() {
		this.numberOfMines++;
	}

	public synchronized void decrementNumberOfMines() {
		this.numberOfMines--;
	}

	public Board() {
		initializeClass();
		setLayout(new GridLayout(Constants.BOARD_ROWS, Constants.BOARD_COLUMNS));
		initializeBoard();
	}

	private void initializeClass() {
		this.cells = new Cell[Constants.BOARD_ROWS * Constants.BOARD_COLUMNS];
		this.numberOfMines = 0;
	}

	private void initializeBoard() {
		for (int i = 0; i < Constants.BOARD_ROWS * Constants.BOARD_COLUMNS; i++) {
			cells[i] = new Cell(i + 1);
			add(cells[i]);
			int row = (i / Constants.BOARD_ROWS) % 2;
			if (row == 0) {
				cells[i].setBackground(i % 2 == 0 ? Color.GRAY : Color.WHITE);
			} else {
				cells[i].setBackground(i % 2 == 0 ? Color.WHITE : Color.GRAY);
			}
		}
	}

	public void setMine(int index) {
		cells[index].lock();
		incrementNumberOfMines();
		cells[index].setBackground(Color.RED);
		cells[index].unlock();
		sleepThread(500);
	}

	private void sleepThread(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void sweepMine(int index) {
		cells[index].lock();
		decrementNumberOfMines();

		int row = (index / Constants.BOARD_ROWS) % 2;
		if (row == 0) {
			cells[index].setBackground(index % 2 == 0 ? Color.GRAY : Color.WHITE);
		} else {
			cells[index].setBackground(index % 2 == 0 ? Color.WHITE : Color.GRAY);
		}

		cells[index].unlock();
		sleepThread(500);
	}

	public int getNumberOfMines() {
		return numberOfMines;
	}
}
