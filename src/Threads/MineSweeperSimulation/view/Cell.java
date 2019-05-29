package Threads.MineSweeperSimulation.view;

import Threads.MineSweeperSimulation.Constants.State;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ssadasivan
 * @since 3/2/2017.
 */
public class Cell extends JPanel {
	private int id;
	private Lock lock;
	private State state;
	private boolean hasBomb;

	public Cell(int id) {
		initVariables();
		setLayout(new GridLayout());
	}

	private void initVariables() {
		this.id = id;
		this.lock = new ReentrantLock();
		this.state = State.EMPTY;
		this.hasBomb = false;
	}

	public void lock() {
		try {
			lock.tryLock(10, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void unlock() {
		lock.unlock();
	}

	@Override
	public String toString() {
		return "Cell{" +
				"id=" + id +
				", state=" + state +
				", hasBomb=" + hasBomb +
				'}';
	}
}
