package GameObjects;

import Model.CRes;

/* loaded from: KnightOnline_v403.jar:GameObjects/MagicLogic.class */
public class MagicLogic {
    public int angle;

    /* renamed from: vx */
    public int f63vx;

    /* renamed from: vy */
    public int f64vy;

    /* renamed from: va */
    public short f65va;

    /* renamed from: x */
    public int f66x;

    /* renamed from: y */
    public int f67y;

    /* renamed from: z */
    public int f68z;
    public MainObject target;
    int life;
    public int headArrowFrame;
    public int headTransform;
    public int index = 0;
    public boolean isSpeedUp = false;
    public boolean isEnd = false;

    public void setAngle(int i) {
        this.angle = i;
        this.f63vx = (this.f65va * CRes.cos(i)) >> 10;
        this.f64vy = (this.f65va * CRes.sin(i)) >> 10;
    }

    public void set(int i, int i2, int i3, int i4, MainObject mainObject) {
        this.f66x = i2;
        this.f67y = i3;
        this.target = mainObject;
        this.isEnd = false;
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
        }
        this.f65va = (short) 15360;
        this.f68z = 0;
        this.life = 0;
        this.f63vx = (this.f65va * CRes.cos(this.angle)) >> 10;
        this.f64vy = (this.f65va * CRes.sin(this.angle)) >> 10;
    }

    public void updateAngle() {
        if (this.target == null) {
            this.isEnd = true;
            return;
        }
        int i = this.target.f74x - this.f66x;
        int height = (this.target.f75y - (this.target.getHeight() >> 1)) - this.f67y;
        this.life++;
        if (CRes.abs(i) < 16 && CRes.abs(height) < 16) {
            this.isEnd = true;
            return;
        }
        int angle = CRes.angle(i, height);
        if (Math.abs(angle - this.angle) < 90 || (i * i) + (height * height) > 4096) {
            if (Math.abs(angle - this.angle) < 15) {
                this.angle = angle;
            } else if ((angle - this.angle >= 0 && angle - this.angle < 180) || angle - this.angle < -180) {
                this.angle = CRes.fixangle(this.angle + 15);
            } else {
                this.angle = CRes.fixangle(this.angle - 15);
            }
        }
        if (!this.isSpeedUp && this.f65va < 8192) {
            this.f65va = (short) (this.f65va + 1024);
        }
        this.f63vx = (this.f65va * CRes.cos(this.angle)) >> 10;
        this.f64vy = (this.f65va * CRes.sin(this.angle)) >> 10;
        int i2 = i + this.f63vx;
        int i3 = i2 >> 10;
        this.f66x += i3;
        int i4 = i2 & 1023;
        int i5 = height + this.f64vy;
        int i6 = i5 >> 10;
        this.f67y += i6;
        int i7 = i5 & 1023;
        this.index = Arrow.findDirIndexFromAngle(CRes.angle(i3, -i6));
        this.headArrowFrame = Arrow.FRAME[this.index];
        this.headTransform = Arrow.TRANSFORM[this.index];
    }
}
