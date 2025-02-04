package genshin.item;

import Algorithm.LinkedDeQue;

/**
 * 元素祭坛
 */
public class ElementalAltar implements Cloneable {

    private int id;
    private boolean isActivation = false;
    private int priority = 0;

    public ElementalAltar(boolean isActivation) {
        this.isActivation = isActivation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public ElementalAltar(boolean isActivation, int priority) {
        this.isActivation = isActivation;
        this.priority = priority;
    }

    public boolean isActivation() {
        return isActivation;
    }

    public void setActivation(boolean activation) {
        isActivation = activation;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void activation() {
        isActivation = true;
        System.out.println(id + "号元素祭坛激活");
    }

    public void unActivation() {

        isActivation = false;
        System.out.println(id + "号元素祭坛解除激活");

    }

    @Override
    public ElementalAltar clone() throws CloneNotSupportedException {
        return (ElementalAltar) super.clone();
    }
}
