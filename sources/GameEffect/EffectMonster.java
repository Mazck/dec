package GameEffect;

import CLib.mGraphics;
import CLib.mImage;
import CLib.mSystem;
import CLib.mVector;
import GameObjects.MainMonster;
import GameObjects.MainObject;
import GameScreen.GameScreen;
import Map.ItemMap;
import Model.FrameImage;

/* loaded from: KnightOnline_v403.jar:GameEffect/EffectMonster.class */
public class EffectMonster {
    FrameImage imgAuto;
    FrameImage imgDie;
    FrameImage imgEff;

    /* renamed from: x */
    int f19x;

    /* renamed from: y */
    int f20y;

    /* renamed from: w */
    int f21w;

    /* renamed from: h */
    int f22h;

    /* renamed from: dx */
    int f23dx;

    /* renamed from: dy */
    int f24dy;

    /* renamed from: f */
    int f25f;
    int idMon;
    int wImg;
    int hImg;
    int fDie;
    int dxDie;
    int dyDie;
    MainObject monster;
    public static final byte mon_Tower1 = 89;
    public static final byte mon_Tower2 = 90;
    public static final byte mon_Tower3 = 91;
    public static final byte mon_Tower4 = 92;
    public static mVector listEffectMonster = new mVector("EffectMonster listEffectMonster");
    public static boolean buffDame = false;
    boolean isPaint = true;
    boolean isUpdate = false;
    boolean isPaintDie = true;
    public byte[] nFrame = {0, 0, 1, 1, 2, 2, 3, 3};
    public byte[] nFramedie = {0, 0, 0, 0, 0, 0, 0, 0};

    public static void addEffectMonster(MainMonster mainMonster) {
        EffectMonster effectMonster = new EffectMonster();
        effectMonster.idMon = mainMonster.catalogyMonster;
        effectMonster.monster = mainMonster;
        if (effectMonster.monster.isMonsterHouse()) {
            if (effectMonster.idMon == 89) {
                effectMonster.imgAuto = new FrameImage(mImage.createImage("/eff/g128.png"), 53, 49);
                effectMonster.imgDie = ItemMap.img_HouseArena_Die[0];
                effectMonster.f23dx = -3;
                effectMonster.f24dy = 70;
                effectMonster.dxDie = 0;
                effectMonster.dyDie = (-effectMonster.imgDie.frameHeight) - 2;
            } else if (effectMonster.idMon == 90) {
                effectMonster.imgAuto = new FrameImage(mImage.createImage("/eff/g129.png"), 44, 44);
                effectMonster.imgDie = ItemMap.img_HouseArena_Die[1];
                effectMonster.f23dx = 0;
                effectMonster.f24dy = 30;
                effectMonster.dxDie = 0;
                effectMonster.dyDie = -effectMonster.imgDie.frameHeight;
            } else if (effectMonster.idMon == 91) {
                effectMonster.imgAuto = new FrameImage(mImage.createImage("/eff/g130.png"), 50, 51);
                effectMonster.imgDie = ItemMap.img_HouseArena_Die[2];
                effectMonster.f23dx = 0;
                effectMonster.f24dy = 20;
                effectMonster.dxDie = 5;
                effectMonster.dyDie = -effectMonster.imgDie.frameHeight;
            } else if (effectMonster.idMon == 92) {
                effectMonster.imgAuto = new FrameImage(mImage.createImage("/eff/g131.png"), 40, 40);
                effectMonster.imgDie = ItemMap.img_HouseArena_Die[3];
                effectMonster.f23dx = 22;
                effectMonster.f24dy = 22;
                effectMonster.dxDie = 5;
                effectMonster.dyDie = -effectMonster.imgDie.frameHeight;
            }
            effectMonster.f19x = mainMonster.f74x;
            effectMonster.f20y = mainMonster.f75y;
            effectMonster.f22h = -1;
            effectMonster.f21w = -1;
            effectMonster.f22h = mainMonster.hOne;
            effectMonster.wImg = effectMonster.imgAuto.frameWidth;
            effectMonster.hImg = effectMonster.imgAuto.frameHeight;
            effectMonster.isPaint = true;
            effectMonster.isUpdate = true;
            effectMonster.isPaintDie = false;
            effectMonster.f25f = 0;
            effectMonster.fDie = 0;
            effectMonster.imgEff = new FrameImage(68);
            listEffectMonster.addElement(effectMonster);
        }
    }

    public void setTurnOff() {
        if (this.isPaintDie) {
            this.isPaint = false;
        }
        if (!this.isPaintDie) {
            this.isPaintDie = true;
        }
    }

    public void update() {
        if (this.isUpdate) {
            if (buffDame) {
                if (this.nFrame != new byte[]{0, 0, 1, 1, 2, 2, 3, 3}) {
                    this.nFrame = new byte[]{0, 0, 1, 1, 2, 2, 3, 3};
                }
            } else if (this.nFrame != new byte[]{0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}) {
                this.nFrame = new byte[]{0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3};
            }
            if (this.monster.f81hp > 0) {
                this.f25f++;
                if (this.f25f > this.nFrame.length - 1) {
                    this.f25f = 0;
                }
                this.f19x = this.monster.f74x;
                this.f20y = this.monster.f75y;
            } else {
                setTurnOff();
            }
            if (GameScreen.timeArena != 0 && mSystem.currentTimeMillis() - GameScreen.timeArena > 2700000) {
                setTurnOff();
            }
        }
    }

    public void paint(mGraphics mgraphics) {
        try {
            if (this.isPaint && this.imgAuto != null) {
                if (this.f21w < 0) {
                    this.f21w = this.monster.wOne;
                    this.f22h = this.monster.hOne;
                }
                this.imgAuto.drawFrame(this.nFrame[this.f25f], (this.f19x - (this.wImg / 2)) + this.f23dx, ((this.f20y - this.f22h) - this.hImg) + this.f24dy, 0, mgraphics);
            }
        } catch (Exception e) {
            this.isPaint = false;
            this.isUpdate = false;
            this.isPaintDie = false;
        }
    }

    public void paintDie(mGraphics mgraphics) {
        try {
            if (this.isPaintDie && this.imgDie != null) {
                if (this.f21w < 0) {
                    this.f21w = this.monster.wOne;
                    this.f22h = this.monster.hOne;
                }
                this.imgDie.drawFrame(this.nFramedie[this.fDie], (this.f19x - (this.f21w / 2)) + this.dxDie, this.f20y + this.dyDie, 0, mgraphics);
            }
        } catch (Exception e) {
            this.isPaint = false;
            this.isUpdate = false;
            this.isPaintDie = false;
        }
    }
}
