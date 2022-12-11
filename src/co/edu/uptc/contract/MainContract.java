package co.edu.uptc.contract;

import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;

import co.edu.uptc.models.Ball;
import co.edu.uptc.models.Chat;
import co.edu.uptc.models.Client;
public interface MainContract {
	
	interface Model{
		
		public void startServer();
		public void startClient();
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

