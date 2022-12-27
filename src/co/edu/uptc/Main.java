package co.edu.uptc;

import co.edu.uptc.contract.MainContract;
import co.edu.uptc.presenter.MainPresenter;
import co.edu.uptc.views.MainBoard;

public class Main{
    public static void main(String[] args) {
        MainContract.Presenter presenter = MainPresenter.getInstance();
        presenter.startGame();

    }

}

