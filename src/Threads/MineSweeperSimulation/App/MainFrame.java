package Threads.MineSweeperSimulation.App;

import Threads.MineSweeperSimulation.Constants.Constants;
import Threads.MineSweeperSimulation.view.Board;
import Threads.MineSweeperSimulation.view.ButtonListener;
import Threads.MineSweeperSimulation.view.ToolBar;
import Threads.MineSweeperSimulation.workers.MineLayer;
import Threads.MineSweeperSimulation.workers.MineSweeper;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ssadasivan
 * @since 3/2/2017.
 */
public class MainFrame extends JFrame implements ButtonListener {

	private ToolBar toolBar;
	private Board board;
	private ExecutorService layerExecutor;
	private ExecutorService sweeperExecutor;
	private MineLayer[] mineLayers;
	private MineSweeper[] mineSweepers;

	public MainFrame ()  {
		super(Constants.APP_NAME);
		this.toolBar = new ToolBar();
		this.board = new Board();
		initVariables();
		toolBar.setButtonListener(this);

		add(toolBar, BorderLayout.NORTH);
		add(board, BorderLayout.CENTER);

		setSize(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initVariables() {
		mineLayers = new MineLayer[Constants.NUMBER_OF_LAYERS];
		mineSweepers = new MineSweeper[Constants.NUMBER_OF_SWEEPERS];
	}

	@Override
	public void startClicked() {
		this.layerExecutor = Executors.newFixedThreadPool(Constants.NUMBER_OF_LAYERS);
		this.sweeperExecutor = Executors.newFixedThreadPool(Constants.NUMBER_OF_SWEEPERS);

		for(int i=0;i<Constants.NUMBER_OF_LAYERS;i++){
			mineLayers[i] = new MineLayer(i, board);
			layerExecutor.execute(mineLayers[i]);
		}

		for(int i=0;i<Constants.NUMBER_OF_SWEEPERS;i++){
			mineSweepers[i] = new MineSweeper(i, board);
			sweeperExecutor.execute(mineSweepers[i]);
		}
	}

	@Override
	public void stopClicked() {
		System.gc();
		System.exit(0);
	}
}
