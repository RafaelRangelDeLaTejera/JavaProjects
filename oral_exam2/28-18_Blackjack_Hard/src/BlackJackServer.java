import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlackJackServer extends JFrame {

    private  int totalPlayers = 0;
    private BlackJackGame currentGame = new BlackJackGame();
    private int dealerTotal;
    private ArrayList<Player> players = new ArrayList<>();
    private ServerSocket dealer; // server socket to listen to clients and establich connections
    private ExecutorService game;
    private JTextArea gameDetails; // show messages about the game

    // set up simple GUI that will display the events of the game
    public BlackJackServer() {
        super("Server");

        gameDetails = new JTextArea(); // create enterField
        gameDetails.setEditable(false);
        gameDetails.setText("Sever opened");
        add(new JScrollPane(gameDetails), BorderLayout.CENTER);
        setSize(150, 150); // set size of window
        setVisible(true); // show window

        gameDetails.setText("Waiting for connection\n");
        game = Executors.newCachedThreadPool();

        try {
            dealer = new ServerSocket(23765, 100); // set up ServerSocket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void startServer(){
        while(true){
            try // wait for connection, create Player, start runnable
            {
                players.add(new Player(dealer.accept()));
                game.execute(players.get(totalPlayers-1)); // execute player runnable
            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.exit(1);
            }
        }

    }


    // private inner class Player manages each Player as a runnable so that program can run in parallel
    public  class Player implements Runnable {
        private Socket connection; // connection to client
        //these streams will write arrays to the clients
        private ObjectInputStream input; // input from client
        private ObjectOutputStream output; // output to client
        private int cardSum = 0;
        private int dealerSum = 0;
        private boolean isGameOver = false;
        private int[] informationArray = new int[5];//0 - Bet
                                                            //1 - Bet available
                                                            //2 - Player total
                                                            //3 - Dealer total
                                                            //4 - Card message
        private HashMap<String,Integer> information = new HashMap<>();

        public Player(Socket connection) {
            this.connection = connection;

            totalPlayers++; //add to the number of players

            try // obtain streams from Socket
            {
                input = new ObjectInputStream(connection.getInputStream());
                output = new ObjectOutputStream(connection.getOutputStream());

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }

        @Override
        public void run() {

            gameDetails.setText(gameDetails.getText()+"Player " + totalPlayers + " connected\n");

            //initial conditions for game
            int playerTotal = 0;
            int dealerTotal = 0;
            int playerBettingLot = 10;
            int bet = 0;
            Cards CardDrawn;
            Deck gameDeck = new Deck();
            HashMap<Cards, Integer> usedCards = new HashMap<>();
            Random randomNumber = new Random();

            //send the amount available to bet
            try {
                information.put("keyPlayerTotal",0);
                information.put("keyDealerTotal",0);
                information.put("keyBetAvailable",10);
                information.put("keyBet",0);
                information.put("keyCard",0);
                output.writeObject(information);
                output.flush();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //draw cards

            String message;
            try{
                while (!isGameOver) {

                    try {
                        message = (String) input.readObject();
                        gameDetails.setText(gameDetails.getText() + message);

                        if(message == "double"){

                        }
                        else if(message == "hit"){

                        }
                        else if(message == "stay"){

                        }
                        else if (message == "out"){

                        }
                        else if (message == "playAgain"){

                        }
                    } catch (ClassNotFoundException exception) {
                        exception.printStackTrace();
                    }
                }
            }
            catch (IOException ioException){
                ioException.printStackTrace();
            }
            finally{
                closeConnection();
            }
        }

        // send message to client
        private void sendData(String message) {
            try // send data to client
            {
                output.writeObject("SERVER>>> " + message);
                output.flush(); // flush output to client
                gameDetails.setText(gameDetails.getText()+ "\nSERVER>>> " + message);
            } catch (IOException ioException) {
                gameDetails.setText(gameDetails.getText()+ "\nerror sending -> " + message);
            }
        }

        // close streams and socket
        private void closeConnection() {
            gameDetails.setText(gameDetails.getText()+"\nTerminating connection with player \n");

            try {
                output.close(); // close output stream
                input.close(); // close input stream
                connection.close(); // close socket

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }


}
