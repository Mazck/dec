package GameEffect;

import CLib.mGraphics;
import GameObjects.DataSkillEff;
import GameObjects.MainObject;
import Model.CRes;

/* loaded from: KnightOnline_v403.jar:GameEffect/ArrowEff.class */
public class ArrowEff extends MainEffect {
    public static final int[] TRANSFORM = {0, 0, 0, 7, 6, 6, 6, 2, 2, 3, 3, 4, 5, 5, 5, 1};
    public static final byte[] FRAME = {0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0};
    public static final int[] ARROWINDEX = {0, 15, 37, 52, 75, 105, 127, 142, 165, 195, 217, 232, 255, 285, 307, 322, 345, 370};

    /* renamed from: dx */
    int f10dx;

    /* renamed from: dy */
    int f11dy;
    int angle;
    int xto;
    int yto;

    /* renamed from: d */
    int f12d;
    MainObject target;
    DataSkillEff arrow;
    int transform;
    short timelive;

    ArrowEff(int i, int i2, MainObject mainObject, int i3, int i4, int i5) {
        this.f33x = i;
        this.f34y = i2;
        this.target = mainObject;
        this.xto = mainObject.f74x;
        this.yto = mainObject.f75y;
        setspeed();
        this.timelive = (short) 500;
        if (FRAME[this.f12d] == 0) {
            this.arrow = new DataSkillEff(i3, this.transform);
        } else if (FRAME[this.f12d] == 1) {
            this.arrow = new DataSkillEff(i4, this.transform);
        } else if (FRAME[this.f12d] == 2) {
            this.arrow = new DataSkillEff(i5, this.transform);
        }
    }

    ArrowEff(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f33x = i;
        this.f34y = i2;
        this.xto = i3;
        this.yto = i4;
        this.xto = this.target.f74x;
        this.yto = this.target.f75y;
        setspeed();
        this.timelive = (short) 50;
        if (FRAME[this.f12d] == 0) {
            this.arrow = new DataSkillEff(i5, this.transform);
        } else if (FRAME[this.f12d] == 1) {
            this.arrow = new DataSkillEff(i6, this.transform);
        } else if (FRAME[this.f12d] == 2) {
            this.arrow = new DataSkillEff(i7, this.transform);
        }
    }

    public void setspeed() {
        this.f10dx = this.xto - this.f33x;
        this.f11dy = (this.yto - 0) - this.f34y;
        this.angle = CRes.angle(this.f10dx, this.f11dy);
        this.f36vx = (1 * CRes.cos(this.angle)) >> 10;
        this.f37vy = (1 * CRes.sin(this.angle)) >> 10;
        this.f12d = findDirIndexFromAngle(CRes.angle(this.f10dx, -this.f11dy));
        this.transform = TRANSFORM[this.f12d];
    }

    public static int findDirIndexFromAngle(int i) {
        for (int i2 = 0; i2 < ARROWINDEX.length - 1; i2++) {
            if (i >= ARROWINDEX[i2] && i <= ARROWINDEX[i2 + 1]) {
                if (i2 >= 16) {
                    return 0;
                }
                return i2;
            }
        }
        return 0;
    }

    @Override // GameEffect.MainEffect
    public void paint(mGraphics mgraphics) {
        this.arrow.paintTopArrow(mgraphics, this.f33x, this.f34y);
        this.arrow.paintBottomArrow(mgraphics, this.f33x, this.f34y);
    }

    @Override // GameEffect.MainEffect
    public void update() {
        if (this.arrow != null) {
            this.arrow.updateArrow();
        }
        this.f33x += this.f36vx;
        this.f34y += this.f37vy;
        this.timelive = (short) (this.timelive - 1);
        if (this.timelive < 0) {
            this.isRemove = true;
        }
    }
}
