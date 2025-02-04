package genshin.elementaltar;

import genshin.item.ElementalAltar;
import genshin.item.TreasureChest;

public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {

        TreasureChest treasureChest = new TreasureChest();
        ElementalAltar elementalAltar1 = new ElementalAltar(false);
        elementalAltar1.setId(1);
        ElementalAltar elementalAltar2 = elementalAltar1.clone();
        elementalAltar2.setId(2);
        ElementalAltar elementalAltar3 = elementalAltar1.clone();
        elementalAltar3.setId(3);

        TreasureChestHandler treasureChestHandler = new TreasureChestHandler(treasureChest);
        treasureChestHandler.addElementalAltar(elementalAltar1);
        treasureChestHandler.addElementalAltar(elementalAltar2);
        treasureChestHandler.addElementalAltar(elementalAltar3);

        treasureChestHandler.alartActivation(2);
        treasureChestHandler.alartActivation(0);
        treasureChestHandler.alartActivation(1);
        treasureChestHandler.open();


    }

}
