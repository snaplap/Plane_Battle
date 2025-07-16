package com.tedu.element;

import com.tedu.manager.GameElement;
import com.tedu.manager.GameLoad;

import java.awt.*;

public class Maps extends ElementObj{

    @Override
    public void showElement(Graphics g) {
        g.drawImage(this.getIcon().getImage(), this.getX(), this.getY(), this.getW(), this.getH(), null);
    }
    @Override
    public ElementObj createElement(String str) {
        this.setX(0);
        this.setY(0);
        this.setIcon(GameLoad.imgMap.get(str));
        this.setW(this.getIcon().getIconWidth());
        this.setH(this.getIcon().getIconHeight());

        return this;
    }
}
