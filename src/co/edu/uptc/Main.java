package co.edu.uptc;

import co.edu.uptc.contract.MainContract;
import co.edu.uptc.presenter.MainPresenter;

public class Main{
    public static void main(String[] args) {
        MainContract.Presenter presenter = MainPresenter.getInstance();
        presenter.startGame();

        //new MainBoard();
        //new ClientDialog();

    }

}
