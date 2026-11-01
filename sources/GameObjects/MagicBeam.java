package GameObjects;

import CLib.mGraphics;
import GameEffect.EffectEnd;
import GameScreen.GameScreen;
import Model.EffectManager;
import Model.FrameImage;

/* loaded from: KnightOnline_v403.jar:GameObjects/MagicBeam.class */
public class MagicBeam extends IArrow {
    public int power;
    public int type;
    public short effect;
    public int hpLost;
    public int frame;
    public int idfollow;
    public int idend;

    /* renamed from: w */
    public int f59w;

    /* renamed from: h */
    public int f60h;

    /* renamed from: x */
    public int f61x;

    /* renamed from: y */
    public int f62y;
    public int Efftail;
    public int Effend;
    MainObject owner;
    MainObject target;
    public MagicLogic arrow = new MagicLogic();
    byte fra;
    private FrameImage img;

    @Override // GameObjects.IArrow
    public void setAngle(int i) {
        this.arrow.setAngle(i);
    }

    public void setEff(int i, int i2) {
        this.Efftail = i;
        this.Effend = i2;
    }

    @Override // GameObjects.IArrow
    public void set(int i, int i2, int i3, int i4, short s, MainObject mainObject, MainObject mainObject2) {
        this.arrow.set(i, i2, i3, mainObject.getDir(), mainObject2);
        this.type = i;
        this.owner = mainObject;
        this.effect = s;
        if (i == 20) {
        }
        this.hpLost = i4;
        this.Efftail = -1;
        this.Effend = -1;
        this.power = i4;
        this.wantDestroy = false;
        this.img = new FrameImage(s);
        this.target = mainObject2;
    }

    @Override // GameObjects.IArrow
    public void update() {
        this.arrow.updateAngle();
        this.f61x = this.arrow.f66x;
        this.f62y = this.arrow.f67y;
        if (this.Efftail != -1) {
            EffectManager.addHiEffect(new EffectEnd(57, this.Efftail, this.f61x, this.f62y));
        }
        if (this.arrow.isEnd) {
            onArrowTouchTarget();
        }
    }

    @Override // GameObjects.IArrow
    public void onArrowTouchTarget() {
        if (this.Effend != -1) {
            if (this.power < 0) {
                GameScreen.addEffectNum(new StringBuffer().append("").append(this.power).toString(), this.target.f74x, this.target.f75y - this.target.hOne, 2, this.target.f84ID);
            }
            if (this.power > 0) {
                GameScreen.addEffectNum(new StringBuffer().append("+").append(this.power).toString(), this.target.f74x, this.target.f75y - this.target.hOne, 0, this.target.f84ID);
            }
            GameScreen.addEffectEndFromSv(57, this.Effend, this.f61x, this.f62y);
        }
        this.wantDestroy = true;
    }

    @Override // GameObjects.IArrow
    public void paint(mGraphics mgraphics) {
        if (this.img != null) {
            this.img.drawFrameEffectSkill(this.fra, this.f61x, this.f62y, this.arrow.headTransform, 3, mgraphics);
        }
    }

    @Override // GameObjects.IArrow
    public void SetEffFollow(int i) {
        this.idfollow = i;
    }
}
