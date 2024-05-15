package lk.ijse.dep.service;

public interface BoardUI {
    void update(int col, boolean isHuman);  //public, abstract method

    void notifyWinner(Winner winner);   //public, abstract method
}
