package co.edu.uptc.contract;

import java.awt.Color;
import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;

import co.edu.uptc.entity.Ball;
import co.edu.uptc.entity.Chat;
import co.edu.uptc.entity.Client;
public interface MainContract {
	
	interface Model{
		
		public void startServer(int port);
		public void startClient(Client client);
		public void stopClient();
		public void stopServer();
		public void setPresenter(MainContract.Presenter presenter);
		public void write(String className, String text);
		public ArrayList<Client> getClients();
		public String getIp();	
		
	}
	
	interface Presenter{
		
		public void setModel(Model model);
		public void setView(View view);
		public void startServer(int port);
		public void startClient(Client createClient);
		public void startGame();
		public void write(String className, String text);
		
	}
	
	interface View{
		
		public void setPresenter(MainContract.Presenter presenter);
		public void startGame();
		public void setStatus(Status value);
        public void updateClients(ArrayList<Client> client);
		public void receivedChat(Chat chat);
		public void receivedBall(ArrayList<Ball> balls);
		
	}
    
}

