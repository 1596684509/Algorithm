package genshin.elementaltar;

import genshin.item.ElementalAltar;
import genshin.item.TreasureChest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TreasureChestHandler {

    private List<ElementalAltar> group;
    private TreasureChest chest;

    public TreasureChestHandler(TreasureChest chest) {
        this.chest = chest;
    }

    public void addElementalAltar(ElementalAltar elementalAltar) {

        if(group == null) {

            group = new ArrayList<>();

        }

        group.add(elementalAltar);
        group.sort(new Comparator<ElementalAltar>() {
            @Override
            public int compare(ElementalAltar o1, ElementalAltar o2) {
                return o2.getPriority() - o1.getPriority();
            }
        });

    }


    /**
     * 可以优化
     * 因为在添加的时候已经将数组进行由大到小的排序
     * 因此在检测是否按照顺序激活的时候
     * 只需要对比起上一个元素是否激活即可
     */
    public void alartActivation(int index) {

        if(group == null || index >= group.size()) {
            return;
        }

        ElementalAltar elementalAltar = group.get(index);

        if(elementalAltar.isActivation()) {
            return;
        }

        elementalAltar.activation();

        for (ElementalAltar altar : group) {

            if(altar.getPriority() > elementalAltar.getPriority() && !altar.isActivation()) {

                for (ElementalAltar elementalAltar1 : group) {
                    elementalAltar1.unActivation();
                }

                return;

            }

        }

    }

    public void open() {

        if(altarAllActivation()) {

            chest.unlock();

        }else {
            chest.lock();
        }

        chest.open();

    }


    private boolean altarAllActivation () {

        if(group == null) {
            return true;
        }

        for (ElementalAltar elementalAltar : group) {

            if(!elementalAltar.isActivation()) {
                return false;
            }

        }

        return true;


    }

}
