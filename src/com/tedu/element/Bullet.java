package com.tedu.element;

import com.tedu.manager.GameLoad;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * @class Bullet
 * @description 子弹类，用于处理子弹的绘制、移动和生命周期管理
 */
public class Bullet extends ElementObj {

    // 子弹的移动速度
    private int speed = 10;

    /**
     * 构造方法
     * @param x 子弹的初始X坐标
     * @param y 子弹的初始Y坐标
     * @param icon 子弹的图标
     */
    public Bullet(int x, int y, ImageIcon icon) {
        super(x, y, icon.getIconWidth(), icon.getIconHeight(), icon);  // 调用父类构造方法
    }

    /**
     * @method showElement
     * @description 绘制子弹
     * @param g Graphics 画笔对象
     */
    @Override
    public void showElement(Graphics g) {
        // 绘制子弹的图标
        g.drawImage(this.getIcon().getImage(), this.getX(), this.getY(), this.getW(), this.getH(), null);
    }

    /**
     * @method move
     * @description 移动子弹，每次调用时更新子弹的Y坐标，使子弹向上移动
     */
    @Override
    protected void move() {
        // 每帧移动子弹，Y值减少，子弹向上飞
        this.setY(this.getY() - speed);

        // 如果子弹超出屏幕上方，标记为死亡
        if (this.getY() < 0) {
            this.setLive(false);
        }
    }

    /**
     * @method createElement
     * @description 根据给定的图标名称创建子弹对象
     * @param str String 图标名称
     * @return Bullet 返回创建的子弹对象
     */
    @Override
    public ElementObj createElement(String str) {
        this.setIcon(GameLoad.imgMap.get(str));
        this.setW(this.getIcon().getIconWidth());
        this.setH(this.getIcon().getIconHeight());
        return this;
    }
}
