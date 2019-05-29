package Threads.MineSweeperSimulation.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ssadasivan
 * @since 3/2/2017.
 */
public class ToolBar extends JPanel implements ActionListener {
	private ButtonListener buttonListener;
	private JButton startButton;
	private JButton stopButton;

	public ToolBar() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		initVariables();
		add(startButton);
		add(stopButton);
	}

	private void initVariables() {
		this.startButton = new JButton("Start Button");
		this.stopButton = new JButton("Stop Button");
		this.startButton.addActionListener(this);
		this.stopButton.addActionListener(this);
	}

	public void setButtonListener(ButtonListener buttonListener) {
		this.buttonListener = buttonListener;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (this.buttonListener != null && event.getSource() == startButton) {
			this.buttonListener.startClicked();
		} else{
			this.buttonListener.stopClicked();
		}
	}
}
