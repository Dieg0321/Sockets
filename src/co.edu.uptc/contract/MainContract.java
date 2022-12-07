package co.edu.uptc.contract;

import java.awt.*;
import java.util.ArrayList;

import co.edu.uptc.entity.Figure;
import co.edu.uptc.models.Figures;

public interface MainContract {
	
	interface Model{
		
		public void addFigure();
		public ArrayList<Figure> getFigures();
		public void setPresenter(MainContract.Presenter presenter);
		public void stop();
		public void start();
		public void setFigureDimension(Dimension dimension);
		public Dimension getFigureDimension();
		
	}
	
	interface Presenter{
		
		public void setView(View view);
		public void setModel(Model model);
		public void createFigure(Figure figure);
		public void starGame();
		public void stopGame();
		public void setRoute(String key, String title);
		public void setFigureDimension(Dimension dimension);
		public Dimension getSize();
		public void setBackgroundColor(Color color);
		
	}
	
	interface View{
		
		public void setPresenter(MainContract.Presenter presenter);
		public void showFigures(ArrayList<Figure> figures);
		public void setBackgroundColor(Color color);
        public Dimension getFrameDimension();
		
		
	}
    
}
