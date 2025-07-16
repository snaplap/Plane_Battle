package com.tedu.element;

import com.tedu.manager.GameLoad;
import java.awt.Graphics;
import javax.swing.ImageIcon;


public class Bullet extends ElementObj {

    // 子弹的移动速度
    private int speed = 40;

    public Bullet(int x, int y, ImageIcon icon) {
        super(x, y, icon.getIconWidth(), icon.getIconHeight(), icon);  // 调用父类构造方法
    }

    public Bullet() {

    }


    @Override
    public void showElement(Graphics g) {
        // 绘制子弹的图标
        g.drawImage(this.getIcon().getImage(), this.getX(), this.getY(), this.getW(), this.getH(), null);
    }


    @Override
    protected void move() {
        // 每帧移动子弹，Y值减少，子弹向上飞
        this.setY(this.getY() - speed);

        // 如果子弹超出屏幕上方，标记为死亡
        if (this.getY() < 0) {
            this.setLive(false);
        }
    }


    @Override
    public ElementObj createElement(String str) {
        try {
            // 预期格式为 "x,y,图标名"
            String[] parts = str.split(",");
            if (parts.length >= 3) {
                int x = Integer.parseInt(parts[0].trim());
                int y = Integer.parseInt(parts[1].trim());
                String iconName = parts[2].trim();

                // 设置子弹的坐标
                this.setX(x+50);
                this.setY(y);

                // 设置图标及宽高
                this.setIcon(GameLoad.imgMap.get(iconName));
                this.setW(this.getIcon().getIconWidth());
                this.setH(this.getIcon().getIconHeight());
            } else {
                System.err.println("子弹 createElement 参数格式错误：" + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

}
