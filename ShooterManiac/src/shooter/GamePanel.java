package shooter;

import javax.swing.JPanel;

import org.jspace.*;

public class GamePanel extends JPanel{
private static final long serialVersionUID = 1L;
private static Manager manager;

	public static void main(String[] args) {
		 // parse arguments
        int port = 31145;
        if (args.length < 1 || args.length > 2) {
            System.out.println("Wrong number of arguments");
            System.out.println("Usage: java -jar run main.jar <number of players> [port]");
            return;
        }
        if (args.length >= 2) {
            port = Integer.parseInt(args[1]);
        }
        GamePanel game = new GamePanel(port);
        
	}
	
	public GamePanel(int port) {
		// create a repository
		String uri = "tcp://localhost:" + port + "/?conn";
		SpaceRepository repository = new SpaceRepository();
		repository.addGate(uri);
		Space board = new SequentialSpace();
		repository.add("board", board);
		new Thread(new Manager(board, this)).start();
		System.out.println("got here");
	}

	
}

class Manager implements Runnable {
private Space board;
private GamePanel gamePanel;
	public Manager(Space space, GamePanel panel) {
		this.board = space;
		this.gamePanel = panel;
		try {
			board.put("player 1");
			board.put("player 2");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(true) {
			try {
//			Object[] opdate = board.get(new ActualField("update"), new FormalField(Object.class));
				System.out.println("running");
				
			board.put("done");
			} catch (InterruptedException e) {}			
		}
	}
	
}
