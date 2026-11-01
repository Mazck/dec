package Model;

import GameObjects.MainObject;

/* loaded from: KnightOnline_v403.jar:Model/MagicLogic.class */
public class MagicLogic {
    public int angle;

    /* renamed from: vx */
    public int f207vx;

    /* renamed from: vy */
    public int f208vy;

    /* renamed from: va */
    public short f209va;

    /* renamed from: x */
    public int f210x;

    /* renamed from: y */
    public int f211y;

    /* renamed from: z */
    public int f212z;
    public MainObject target;
    int life;
    public int headArrowFrame;
    public int headTransform;
    public static final short[] SPEED = {1, 60, 8, 1, 1, 16, 60, 18};
    public int index = 0;
    public boolean isSpeedUp = false;
    public boolean isEnd = false;

    public void setAngle(int i) {
        this.angle = i;
        this.f207vx = (this.f209va * CRes.cos(i)) >> 10;
        this.f208vy = (this.f209va * CRes.sin(i)) >> 10;
    }

    public void set(int i, int i2, int i3, int i4, MainObject mainObject) {
        this.f210x = i2;
        this.f211y = i3;
        this.target = mainObject;
        switch (i4) {
            case 0:
                this.angle = 90;
                break;
            case 1:
                this.angle = 270;
                break;
            case 2:
                this.angle = 180;
                break;
            case 3:
                this.angle = 0;
                break;
        }
        if (i == 20) {
            i = 2;
        }
        this.f209va = (short) (256 * SPEED[i]);
        this.f212z = 0;
        this.life = 0;
        this.f207vx = (this.f209va * CRes.cos(this.angle)) >> 10;
        this.f208vy = (this.f209va * CRes.sin(this.angle)) >> 10;
    }

    public void updateAngle() {
        if (this.target == null) {
            this.isEnd = true;
            return;
        }
        int i = this.target.f74x - this.f210x;
        int i2 = (this.target.f75y - (this.target.hOne >> 1)) - this.f211y;
        this.life++;
        if ((CRes.abs(i) < 16 && CRes.abs(i2) < 16) || this.life > 60) {
            this.isEnd = true;
            return;
        }
        int angle = CRes.angle(i, i2);
        if (Math.abs(angle - this.angle) < 90 || (i * i) + (i2 * i2) > 4096) {
            if (Math.abs(angle - this.angle) < 15) {
                this.angle = angle;
            } else if ((angle - this.angle >= 0 && angle - this.angle < 180) || angle - this.angle < -180) {
                this.angle = CRes.fixangle(this.angle + 15);
            } else {
                this.angle = CRes.fixangle(this.angle - 15);
            }
        }
        if (!this.isSpeedUp && this.f209va < 8192) {
            this.f209va = (short) (this.f209va + 1024);
        }
        this.f207vx = (this.f209va * CRes.cos(this.angle)) >> 10;
        this.f208vy = (this.f209va * CRes.sin(this.angle)) >> 10;
        int i3 = i + this.f207vx;
        this.f210x += i3 >> 10;
        int i4 = i3 & 1023;
        int i5 = i2 + this.f208vy;
        this.f211y += i5 >> 10;
        int i6 = i5 & 1023;
    }
}
