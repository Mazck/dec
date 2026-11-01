package GameEffect;

import CLib.mGraphics;
import CLib.mSystem;
import CLib.mVector;
import GameObjects.MainObject;
import GameObjects.ObjectData;
import GameScreen.GameScreen;
import InterfaceComponents.TabRebuildItem;
import Main.GameCanvas;
import Model.CRes;
import Model.FrameImage;
import Model.Point;

/* loaded from: KnightOnline_v403.jar:GameEffect/EffectEnd.class */
public class EffectEnd extends MainEffect {
    public static final byte END_NUC_DAT = 0;
    public static final byte END_EFF_WATER_BIG = 1;
    public static final byte END_FAR_NEAR = 2;
    public static final byte END_THIEN_THACH = 3;
    public static final byte END_KILL_PS_LV2 = 4;
    public static final byte END_KILL_2KIEM_LV2 = 5;
    public static final byte END_KILL_2KIEM_LV2_BEGIN = 6;
    public static final byte END_KILL_SUNG_LV1 = 7;
    public static final byte END_ROCK = 9;
    public static final byte END_KILL_PS_LV1 = 10;
    public static final byte END_DIE_MONSTER = 11;
    public static final byte END_KILL_SUNG_LV2 = 12;
    public static final byte END_KILL_SUNG_LV2_BEGIN = 13;
    public static final byte END_PHAO_HOA = 14;
    public static final byte END_PHAO_BANG = 15;
    public static final byte END_WATER_ROCK = 19;
    public static final byte END_EFF_LV_UP = 21;
    public static final byte END_EFF_2KIEM_DOC = 24;
    public static final byte END_EFF_KIEM_LV6 = 25;
    public static final byte END_KIEM_NUC_DAT_2 = 26;
    public static final byte END_ICE_BIG = 27;
    public static final byte END_ICE_UP = 28;
    public static final byte END_XUYEN_GIAP = 29;
    public static final byte END_ROCK_FIRE_BIG = 30;
    public static final byte END_REBUILD = 31;
    public static final byte END_LEVEL_UP_REBUILD = 32;
    public static final byte END_EFF_LV_UP_REBUILD = 33;
    public static final byte END_EFF_FINISH_REBUILD = 34;
    public static final byte END_EFF_REMOVE_OBJ = 35;
    public static final byte END_EFF_REMOVE_MON_PHO_BANG = 36;
    public static final byte END_REPLACE_PLUS = 37;
    public static final byte END_NHANBAN_REVEICE = 38;
    public static final byte END_HUT_HP_MON_PHO_BANG = 39;
    public static final byte END_EFF_NAM_DAT = 40;
    public static final byte END_EFF_A_DEN_B = 41;
    public static final byte END_EFF_OPEN_BOX = 42;
    public static final byte END_EFF_DETONATE = 43;
    public static final byte END_EFF_POISON_NOVA = 44;
    public static final byte END_EFF_TORNADO = 45;
    public static final byte END_EFF_CAY_DAT = 46;
    public static final byte END_EFF_NUT_DAT_BIND = 47;
    public static final byte END_EFF_Medusa_ATK = 48;
    public static final byte END_EFF_DONG_BANG = 49;
    public static final byte END_EFF_Medusa_VongTron = 50;
    public static final byte END_PET_BAT = 51;
    public static final byte END_PET_EAGLE = 52;
    public static final byte END_PET_OWL = 53;
    public static final byte END_EFF_MOVE_BOSS = 54;
    public static final byte END_MOUNT_DUST = 55;
    public static final byte END_FOOT_SNOW = 56;
    public static final byte END_ENY = 57;
    public static final byte END_MO_TO = 58;
    mVector VecEffEnd;
    mVector VecSubEffEnd;
    int x1000;
    int y1000;
    int lT_Arc;
    int gocT_Arc;
    Point pRebuild;
    public byte[] nFrame;
    int trans;
    public long timeRemove;
    public int timeDeley;
    public EffectAuto effAuto;
    byte typeSub;
    int numEffReplace;
    int plusGoc;

    public EffectEnd(int i, int i2, int i3) {
        int i4;
        int random;
        this.VecEffEnd = new mVector("EffectEnd VecEffEnd");
        this.VecSubEffEnd = new mVector("EffectEnd VecSubEffEnd");
        this.trans = 0;
        this.timeDeley = ObjectData.ITEM;
        this.numEffReplace = 0;
        this.f35f = -1;
        this.typeEffect = i;
        this.f33x = i2;
        this.f34y = i3;
        switch (i) {
            case 0:
                this.fraImgEff = new FrameImage(53);
                this.fRemove = 6;
                break;
            case 1:
                this.fraImgEff = new FrameImage(29);
                this.fRemove = 3;
                break;
            case 2:
                this.fraImgEff = new FrameImage(18);
                this.fRemove = 4;
                break;
            case 3:
                this.fraImgEff = new FrameImage(27);
                this.fRemove = 15;
                for (int i5 = 0; i5 < 7; i5++) {
                    Point point = new Point();
                    point.f225x = i2 + CRes.random_Am_0(22);
                    point.f226y = i3 + CRes.random_Am_0(8);
                    point.dis = CRes.random(this.fraImgEff.nFrame);
                    this.VecEffEnd.addElement(point);
                }
                break;
            case 4:
                this.fraImgEff = new FrameImage(4);
                this.fRemove = 5;
                break;
            case 5:
                this.fraImgEff = new FrameImage(51);
                this.fRemove = 6;
                break;
            case 6:
                this.fraImgEff = new FrameImage(52);
                this.fRemove = 4;
                break;
            case 7:
                this.fraImgEff = new FrameImage(54);
                this.fRemove = 4;
                break;
            case 9:
                if (GameCanvas.lowGraphic) {
                    removeEff();
                    break;
                } else {
                    this.fraImgEff = new FrameImage(56);
                    this.fRemove = CRes.random(11, 15);
                    int random2 = CRes.random(3, 7);
                    for (int i6 = 0; i6 < random2; i6++) {
                        Point point2 = new Point();
                        point2.f225x = i2 + CRes.random_Am_0(5);
                        point2.f226y = i3 + CRes.random_Am_0(7);
                        point2.frame = CRes.random(this.fraImgEff.nFrame);
                        point2.dis = CRes.random(2);
                        point2.f232vy = -CRes.random(6, 9);
                        point2.f231vx = CRes.random(1, 4);
                        if (i6 % 2 == 0) {
                            point2.f231vx = -point2.f231vx;
                        }
                        this.VecEffEnd.addElement(point2);
                    }
                    break;
                }
            case 10:
                this.fraImgEff = new FrameImage(58);
                this.fRemove = 4;
                break;
            case 11:
                this.fraImgEff = new FrameImage(42);
                this.fRemove = 9;
                break;
            case 12:
                this.fraImgEff = new FrameImage(60);
                this.fRemove = 4;
                break;
            case 13:
                this.fraImgEff = new FrameImage(9);
                this.fRemove = 4;
                break;
            case 14:
            case 15:
                if (GameCanvas.lowGraphic) {
                    removeEff();
                    break;
                } else {
                    if (i == 14) {
                        this.fraImgEff = new FrameImage(1);
                        random = CRes.random(7, 12);
                    } else {
                        this.fraImgEff = new FrameImage(5);
                        random = CRes.random(7, 12);
                    }
                    this.fRemove = 12;
                    for (int i7 = 0; i7 < random; i7++) {
                        Point point3 = new Point();
                        point3.f225x = i2 + CRes.random_Am_0(4);
                        point3.f226y = i3 + CRes.random_Am_0(5);
                        point3.frame = CRes.random(this.fraImgEff.nFrame);
                        point3.f232vy = -CRes.random(5, 9);
                        point3.f231vx = CRes.random(0, 3);
                        if (i7 % 2 == 0) {
                            point3.f231vx = -point3.f231vx;
                        }
                        this.VecEffEnd.addElement(point3);
                    }
                    break;
                }
            case 19:
                if (GameCanvas.lowGraphic) {
                    removeEff();
                    break;
                } else {
                    this.fraImgEff = new FrameImage(28);
                    this.frame = CRes.random(2) == 0 ? 0 : 2;
                    this.fRemove = 2;
                    break;
                }
            case 21:
            case 33:
                if (this.typeEffect == 33) {
                    this.fraImgEff = new FrameImage(2);
                    i4 = 30;
                    this.fRemove = 30;
                } else {
                    this.fraImgEff = new FrameImage(66);
                    i4 = 40;
                    this.fRemove = 12;
                }
                for (int i8 = 0; i8 < i4; i8++) {
                    Point point4 = new Point();
                    point4.f225x = i2 + CRes.random_Am_0(10);
                    point4.f226y = i3 - CRes.random_Am_0(8);
                    point4.frame = CRes.random(this.fraImgEff.nFrame);
                    point4.f232vy = -CRes.random(3, 11);
                    if (this.typeEffect == 33) {
                        point4.f231vx = CRes.random(0, 4);
                    } else {
                        point4.f231vx = CRes.random(0, 3);
                    }
                    if (i8 % 2 == 0) {
                        point4.f231vx = -point4.f231vx;
                    }
                    this.VecEffEnd.addElement(point4);
                }
                break;
            case 24:
                this.fraImgEff = new FrameImage(12);
                this.fRemove = CRes.random(18, 23);
                this.levelPaint = -1;
                break;
            case 25:
            case 28:
            case 40:
                if (this.typeEffect == 25) {
                    this.fraImgEff = new FrameImage(86);
                } else if (this.typeEffect == 28) {
                    this.fraImgEff = new FrameImage(96);
                } else if (this.typeEffect == 40) {
                    int tile = GameCanvas.loadmap.getTile(i2, i3);
                    if (tile != 2 && tile != -1) {
                        this.fraImgEff = new FrameImage(19);
                    }
                }
                this.levelPaint = -1;
                this.fRemove = CRes.random(74, 85);
                fRemove_Low(20);
                break;
            case 26:
                this.levelPaint = -1;
                if (CRes.random(2) == 0) {
                    this.fraImgEff = new FrameImage(90);
                } else {
                    this.fraImgEff = new FrameImage(13);
                }
                this.fRemove = CRes.random(74, 85);
                fRemove_Low(20);
                break;
            case 27:
            case 30:
                this.fRemove = 20;
                this.levelPaint = -1;
                if (this.typeEffect == 27) {
                    this.fraImgEff = new FrameImage(92);
                } else if (this.typeEffect == 30) {
                    this.fraImgEff = new FrameImage(115);
                }
                for (int i9 = 0; i9 < 3; i9++) {
                    Point point5 = new Point();
                    point5.f225x = i2 + CRes.random_Am_0(3);
                    point5.f226y = i3 + CRes.random_Am_0(3);
                    if (CRes.random(2) == 0) {
                        if (i9 % 2 == 0) {
                            point5.f231vx = CRes.random(3);
                        } else {
                            point5.f231vx = -CRes.random(3);
                        }
                    } else {
                        point5.f231vx = CRes.random_Am_0(3);
                    }
                    point5.f232vy = -5;
                    point5.fRe = CRes.random(6, 12);
                    point5.frame = i9;
                    this.VecEffEnd.addElement(point5);
                }
                break;
            case 29:
                this.fraImgEff = new FrameImage(105);
                this.fRemove = CRes.random(11, 15);
                int random3 = CRes.random(3, 6);
                for (int i10 = 0; i10 < random3; i10++) {
                    Point point6 = new Point();
                    point6.f225x = i2 + CRes.random_Am_0(5);
                    point6.f226y = i3 + CRes.random_Am_0(7);
                    point6.frame = CRes.random(this.fraImgEff.nFrame);
                    point6.dis = CRes.random(2);
                    point6.f232vy = -CRes.random(6, 9);
                    point6.f231vx = CRes.random(1, 4);
                    if (i10 % 2 == 0) {
                        point6.f231vx = -point6.f231vx;
                    }
                    this.VecEffEnd.addElement(point6);
                }
                break;
            case 32:
                create_Level_up();
                break;
            case 34:
                this.fraImgEff = new FrameImage(14);
                this.fRemove = 18;
                break;
            case 35:
                this.fraImgEff = new FrameImage(122);
                this.fRemove = 6;
                break;
            case 36:
                this.fraImgEff = new FrameImage(4);
                this.fRemove = 10;
                break;
            case 38:
                this.fraImgEff = new FrameImage(65);
                this.fraImgSubEff = new FrameImage(122);
                this.fraImgSub2Eff = new FrameImage(14);
                this.fRemove = 12;
                break;
            case 39:
                this.fRemove = 55;
                break;
            case 42:
                this.fraImgEff = new FrameImage(7);
                this.fraImgSubEff = new FrameImage(2);
                this.fRemove = 20;
                this.gocT_Arc = 0;
                for (int i11 = 0; i11 < 8; i11++) {
                    int random4 = CRes.random(4, 6);
                    Point point7 = new Point();
                    point7.f225x = i2 * ObjectData.MONSTER;
                    point7.f226y = i3 * ObjectData.MONSTER;
                    point7.f231vx = CRes.cos(CRes.fixangle(this.gocT_Arc)) * random4;
                    point7.f232vy = CRes.sin(CRes.fixangle(this.gocT_Arc)) * random4;
                    this.gocT_Arc += 45;
                    this.VecEffEnd.addElement(point7);
                }
                break;
            case 43:
                this.fraImgEff = new FrameImage(124);
                this.fRemove = 10;
                break;
            case 44:
                this.fraImgEff = new FrameImage(70);
                this.fRemove = 4;
                break;
            case 45:
                this.fraImgEff = new FrameImage(63);
                this.fRemove = 8;
                break;
            case 46:
                this.fraImgEff = new FrameImage(86);
                this.levelPaint = -1;
                this.fRemove = 6;
                break;
            case 48:
                this.fraImgEff = new FrameImage(134);
                this.fRemove = 8;
                break;
            case 51:
                this.fraImgEff = new FrameImage(140);
                this.fRemove = 6;
                break;
            case 54:
                this.fraImgEff = new FrameImage(144);
                this.fRemove = 10;
                break;
        }
    }

    public EffectEnd(int i, int i2, int i3, int i4, byte b) {
        this.VecEffEnd = new mVector("EffectEnd VecEffEnd");
        this.VecSubEffEnd = new mVector("EffectEnd VecSubEffEnd");
        this.trans = 0;
        this.timeDeley = ObjectData.ITEM;
        this.numEffReplace = 0;
        this.f35f = -1;
        this.typeEffect = i;
        this.f33x = i2;
        this.f34y = i3;
        this.Direction = i4;
        switch (i) {
            case 55:
                this.nFrame = new byte[]{0, 0, 0, 1, 1, 1, 2, 2, 2};
                int tile = GameCanvas.loadmap.getTile(i2, i3);
                if (tile != 2 && tile != -1) {
                    this.fraImgEff = new FrameImage(145);
                    this.levelPaint = b;
                    break;
                }
                break;
            case 56:
                this.fraImgEff = new FrameImage(152);
                this.levelPaint = b;
                this.fRemove = CRes.random(20, 30);
                fRemove_Low(20);
                break;
            case 58:
                this.fraImgEff = new FrameImage(164);
                this.levelPaint = b;
                this.fRemove = CRes.random(20, 30);
                fRemove_Low(20);
                break;
        }
    }

    public EffectEnd(int i, int i2, int i3, int i4) {
        this.VecEffEnd = new mVector("EffectEnd VecEffEnd");
        this.VecSubEffEnd = new mVector("EffectEnd VecSubEffEnd");
        this.trans = 0;
        this.timeDeley = ObjectData.ITEM;
        this.numEffReplace = 0;
        this.f35f = -1;
        this.typeEffect = i;
        this.f33x = i3;
        this.f34y = i4;
        this.fraImgEff = new FrameImage(i2);
        this.fRemove = this.fraImgEff.getNFrame();
    }

    public EffectEnd(int i, int i2, int i3, long j) {
        this.VecEffEnd = new mVector("EffectEnd VecEffEnd");
        this.VecSubEffEnd = new mVector("EffectEnd VecSubEffEnd");
        this.trans = 0;
        this.timeDeley = ObjectData.ITEM;
        this.numEffReplace = 0;
        this.f35f = -1;
        this.typeEffect = i;
        this.f33x = i2;
        this.f34y = i3;
        switch (i) {
            case 47:
                this.timeRemove = j + this.timeDeley;
                this.fraImgEff = new FrameImage(86);
                this.levelPaint = -1;
                this.fRemove = CRes.random(74, 85);
                fRemove_Low(20);
                break;
            case 49:
                this.timeRemove = j;
                this.effAuto = new EffectAuto(51, i2, i3, 0, 0, 0, 0);
                this.levelPaint = -1;
                this.fRemove = 6;
                break;
            case 50:
                this.timeRemove = j;
                this.fraImgEff = new FrameImage(137);
                this.levelPaint = -1;
                this.fRemove = 12;
                break;
        }
    }

    public EffectEnd(int i, int i2, int i3, byte b) {
        this.VecEffEnd = new mVector("EffectEnd VecEffEnd");
        this.VecSubEffEnd = new mVector("EffectEnd VecSubEffEnd");
        this.trans = 0;
        this.timeDeley = ObjectData.ITEM;
        this.numEffReplace = 0;
        this.f35f = -1;
        this.typeEffect = i;
        this.typeSub = b;
        this.f33x = i2;
        this.f34y = i3;
    }

    public EffectEnd(int i, int i2, int i3, int i4, int i5, int i6) {
        this.VecEffEnd = new mVector("EffectEnd VecEffEnd");
        this.VecSubEffEnd = new mVector("EffectEnd VecSubEffEnd");
        this.trans = 0;
        this.timeDeley = ObjectData.ITEM;
        this.numEffReplace = 0;
        this.typeEffect = i;
        this.f33x = i2;
        this.f34y = i3;
        this.toX = i4;
        this.toY = i5;
        switch (i) {
            case 31:
                create_Arc_Big_Small();
                break;
            case 37:
                this.fraImgEff = new FrameImage(7);
                this.fraImgSubEff = new FrameImage(2);
                this.fRemove = 100;
                this.lT_Arc = 40;
                this.gocT_Arc = 0;
                this.numEffReplace = i6;
                this.plusGoc = 360 / i6;
                break;
            case 41:
                this.fraImgEff = new FrameImage(7);
                this.fraImgSubEff = new FrameImage(2);
                this.fRemove = 18;
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // GameEffect.MainEffect
    public void paint(mGraphics mgraphics) {
        int i;
        int i2;
        int i3;
        try {
            switch (this.typeEffect) {
                case 0:
                case 2:
                case 5:
                case 11:
                case 35:
                case 36:
                case 51:
                case 54:
                case 57:
                    if (this.fraImgEff != null) {
                        this.fraImgEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                    }
                    break;
                case 1:
                case 4:
                case 6:
                case 7:
                case 10:
                case 12:
                case 13:
                case 44:
                case 45:
                    if (this.fraImgEff != null) {
                        this.fraImgEff.drawFrameEffectSkill(this.f35f % this.fraImgEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                    }
                    break;
                case 3:
                    for (int i4 = 0; i4 < this.VecEffEnd.size(); i4++) {
                        Point point = (Point) this.VecEffEnd.elementAt(i4);
                        if (this.fraImgEff != null) {
                            this.fraImgEff.drawFrameEffectSkill(((point.f235f + this.f35f) / 2) % this.fraImgEff.nFrame, point.f225x, point.f226y, 0, 3, mgraphics);
                        }
                    }
                    break;
                case 9:
                case 27:
                case 29:
                case 30:
                    for (int i5 = 0; i5 < this.VecEffEnd.size(); i5++) {
                        Point point2 = (Point) this.VecEffEnd.elementAt(i5);
                        if (this.fraImgEff != null) {
                            this.fraImgEff.drawFrameEffectSkill(point2.frame, point2.f225x, point2.f226y, 0, 3, mgraphics);
                        }
                    }
                    break;
                case 14:
                case 15:
                case 21:
                    for (int i6 = 0; i6 < this.VecEffEnd.size(); i6++) {
                        Point point3 = (Point) this.VecEffEnd.elementAt(i6);
                        if (this.f35f < (this.fRemove / 3) * 2) {
                            if (this.fraImgEff != null) {
                                this.fraImgEff.drawFrameEffectSkill(point3.frame, point3.f225x, point3.f226y, 0, 3, mgraphics);
                            }
                        } else if (this.fraImgEff != null) {
                            this.fraImgEff.drawFrameEffectSkill(point3.frame == 0 ? 3 : point3.frame, point3.f225x, point3.f226y, 0, 3, mgraphics);
                        }
                    }
                    break;
                case 19:
                    if (this.fraImgEff != null) {
                        this.fraImgEff.drawFrameEffectSkill(this.frame + (this.f35f % this.fraImgEff.nFrame), this.f33x - (this.fraImgEff.frameWidth / 2), this.f34y - (this.fraImgEff.frameHeight / 2), 0, 0, mgraphics);
                    }
                    break;
                case 24:
                    int i7 = 0;
                    if (this.f35f > this.fRemove - 5) {
                        i7 = (this.f35f - (this.fRemove - 4)) / 2;
                    }
                    if (i7 < 3 && this.fraImgEff != null) {
                        this.fraImgEff.drawFrameEffectSkill(i7, this.f33x, this.f34y, 0, 3, mgraphics);
                    }
                    break;
                case 25:
                case 28:
                case 40:
                case 46:
                    if (this.f35f <= this.fRemove) {
                        if (this.f35f < 2) {
                            int i8 = this.f35f;
                        }
                        if (this.f35f > this.fRemove - 5) {
                            i3 = ((this.fRemove - 1) - this.f35f) / 2;
                        } else {
                            i3 = 2;
                        }
                        if (this.fraImgEff != null) {
                            this.fraImgEff.drawFrameEffectSkill(i3, this.f33x, this.f34y, 0, 3, mgraphics);
                        }
                    }
                    break;
                case 26:
                    if (this.f35f < 2) {
                        if (this.fraImgEff != null) {
                            this.fraImgEff.drawFrameEffectSkill(this.f35f, this.f33x, this.f34y, 0, 3, mgraphics);
                        }
                    } else if (this.f35f < this.fRemove - 4) {
                        if (this.fraImgEff != null) {
                            this.fraImgEff.drawFrameEffectSkill(2, this.f33x, this.f34y, 0, 3, mgraphics);
                        }
                    } else if (this.f35f < this.fRemove && this.fraImgEff != null) {
                        this.fraImgEff.drawFrameEffectSkill(((this.fRemove - 1) - this.f35f) / 2, this.f33x, this.f34y, 0, 3, mgraphics);
                    }
                    break;
                case 31:
                    for (int i9 = 0; i9 < this.VecEffEnd.size(); i9++) {
                        Point point4 = (Point) this.VecEffEnd.elementAt(i9);
                        if (this.fraImgSubEff != null) {
                            this.fraImgSubEff.drawFrameEffectSkill(point4.f235f / 2, point4.f225x, point4.f226y, 0, 3, mgraphics);
                        }
                    }
                    if (this.lT_Arc > 5 && this.fraImgEff != null) {
                        this.fraImgEff.drawFrameEffectSkill(this.pRebuild.f228v, (this.pRebuild.f233x2 + this.pRebuild.f231vx) / ObjectData.MONSTER, (this.pRebuild.f234y2 + this.pRebuild.f232vy) / ObjectData.MONSTER, 0, 3, mgraphics);
                    }
                    break;
                case 32:
                    if (this.fraImgSubEff != null) {
                        this.fraImgSubEff.drawFrameEffectSkill(0, this.f33x, this.f34y - ((this.f35f - (this.fRemove / 2)) * 2), 0, 3, mgraphics);
                    }
                    break;
                case 33:
                    for (int i10 = 0; i10 < this.VecEffEnd.size(); i10++) {
                        Point point5 = (Point) this.VecEffEnd.elementAt(i10);
                        if (this.fraImgEff != null) {
                            this.fraImgEff.drawFrameEffectSkill((point5.frame + (point5.f235f / 2)) % this.fraImgEff.nFrame, point5.f225x, point5.f226y, 0, 3, mgraphics);
                        }
                    }
                    break;
                case 34:
                    if (this.fraImgEff != null) {
                        this.fraImgEff.drawFrameEffectSkill((this.f35f / 3) % this.fraImgEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                    }
                    break;
                case 37:
                case 41:
                case 42:
                    for (int i11 = 0; i11 < this.VecEffEnd.size(); i11++) {
                        Point point6 = (Point) this.VecEffEnd.elementAt(i11);
                        if (this.fraImgEff != null) {
                            this.fraImgEff.drawFrameEffectSkill((point6.f235f / 2) % this.fraImgEff.nFrame, point6.f225x / ObjectData.MONSTER, point6.f226y / ObjectData.MONSTER, 0, 3, mgraphics);
                        }
                    }
                    for (int i12 = 0; i12 < this.VecSubEffEnd.size(); i12++) {
                        Point point7 = (Point) this.VecSubEffEnd.elementAt(i12);
                        if (this.fraImgSubEff != null) {
                            this.fraImgSubEff.drawFrameEffectSkill(point7.f235f / 2, point7.f225x, point7.f226y, 0, 3, mgraphics);
                        }
                    }
                    break;
                case 38:
                    if (this.f35f < 6) {
                        if (this.fraImgEff != null) {
                            this.fraImgEff.drawFrameEffectSkill(this.f35f, this.f33x, this.f34y, 0, 3, mgraphics);
                        }
                        if (this.fraImgSubEff != null) {
                            this.fraImgSubEff.drawFrameEffectSkill(2 - (this.f35f / 2), this.f33x, this.f34y, 0, 33, mgraphics);
                        }
                    } else if (this.fraImgSub2Eff != null) {
                        this.fraImgSub2Eff.drawFrameEffectSkill(this.f35f - 6, this.f33x, this.f34y - 20, 0, 3, mgraphics);
                    }
                    break;
                case 43:
                    if (this.fraImgEff != null) {
                        this.fraImgEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                    }
                    break;
                case 47:
                    if (this.timeRemove - mSystem.currentTimeMillis() >= 0) {
                        long currentTimeMillis = (this.timeRemove - mSystem.currentTimeMillis()) / 1000;
                        if (currentTimeMillis >= 2) {
                            i2 = 2;
                        } else if (currentTimeMillis >= 1) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        if (this.fraImgEff != null) {
                            this.fraImgEff.drawFrameEffectSkill(i2, this.f33x, this.f34y, 0, 3, mgraphics);
                        }
                    }
                    break;
                case 48:
                case 50:
                    if (this.fraImgEff != null) {
                        this.fraImgEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                    }
                    break;
                case 49:
                    if (this.effAuto != null) {
                        this.effAuto.paint(mgraphics);
                    }
                    break;
                case 55:
                    try {
                        if (this.fraImgEff != null) {
                            this.fraImgEff.drawFrameEffectSkill(this.nFrame[this.f35f], this.f33x, this.f34y, this.trans, 3, mgraphics);
                        }
                    } catch (Exception e) {
                        mSystem.println(new StringBuffer().append("err mountdust f:").append(this.nFrame.length).append("  ").append(this.f35f).toString());
                    }
                    break;
                case 56:
                    if (this.f35f <= this.fRemove) {
                        if (this.f35f < 2) {
                            int i13 = this.f35f;
                        }
                        if (this.f35f > this.fRemove - 5) {
                            i = ((this.fRemove - 1) - this.f35f) / 2;
                        } else {
                            i = 2;
                        }
                        if (this.fraImgEff != null) {
                            this.fraImgEff.drawFrameEffectSkill(i, this.f33x, this.f34y, this.trans, 3, mgraphics);
                        }
                    }
                    break;
                case 58:
                    if (this.f35f <= this.fRemove) {
                        if (this.f35f < 2) {
                            int i14 = this.f35f;
                        }
                        if (this.f35f > this.fRemove - 5) {
                            int i15 = ((this.fRemove - 1) - this.f35f) / 2;
                        }
                        if (this.fraImgEff != null) {
                            this.fraImgEff.drawFrameEffectSkill(0, this.f33x, this.f34y, this.trans, 3, mgraphics);
                        }
                    }
                    break;
            }
        } catch (Exception e2) {
            mSystem.println(new StringBuffer().append("/ ").append(this.typeEffect).append(e2.toString()).toString());
        }
    }

    @Override // GameEffect.MainEffect
    public void update() {
        this.f35f++;
        this.subf++;
        switch (this.typeEffect) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 11:
            case 12:
            case 13:
            case 19:
            case 24:
            case 25:
            case 26:
            case 28:
            case 34:
            case 35:
            case 40:
            case 44:
            case 46:
            case 51:
            case 54:
            case 57:
                if (this.f35f >= this.fRemove) {
                    removeEff();
                    break;
                }
                break;
            case 3:
                for (int i = 0; i < this.VecEffEnd.size(); i++) {
                    Point point = (Point) this.VecEffEnd.elementAt(i);
                    if (CRes.random(3) == 0) {
                        point.f225x = this.f33x + CRes.random_Am_0(22);
                        point.f226y = this.f34y + CRes.random_Am_0(8);
                        point.f235f = CRes.random(this.fraImgEff.nFrame);
                    }
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                    break;
                }
                break;
            case 9:
            case 14:
            case 15:
            case 29:
                for (int i2 = 0; i2 < this.VecEffEnd.size(); i2++) {
                    Point point2 = (Point) this.VecEffEnd.elementAt(i2);
                    point2.update();
                    point2.f232vy++;
                    if (this.f35f == this.fRemove && GameScreen.isWater(point2.f225x, point2.f226y)) {
                        GameScreen.addEffectEndKill(19, point2.f225x, point2.f226y);
                    }
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                    break;
                }
                break;
            case 21:
                for (int i3 = 0; i3 < this.VecEffEnd.size(); i3++) {
                    Point point3 = (Point) this.VecEffEnd.elementAt(i3);
                    point3.update();
                    if (point3.f232vy < 0) {
                        point3.f232vy++;
                    } else {
                        point3.f232vy = 0;
                        point3.f231vx = 0;
                    }
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                    break;
                }
                break;
            case 27:
            case 30:
                for (int i4 = 0; i4 < this.VecEffEnd.size(); i4++) {
                    Point point4 = (Point) this.VecEffEnd.elementAt(i4);
                    point4.f235f++;
                    if (point4.f235f < point4.fRe) {
                        point4.f225x += point4.f231vx;
                        point4.f226y += point4.f232vy;
                    }
                    point4.f232vy++;
                }
                if (this.f35f > this.fRemove) {
                    removeEff();
                    break;
                }
                break;
            case 31:
                int i5 = 0;
                while (i5 < this.VecEffEnd.size()) {
                    Point point5 = (Point) this.VecEffEnd.elementAt(i5);
                    point5.f235f++;
                    if (point5.f235f / 2 >= 4) {
                        this.VecEffEnd.removeElement(point5);
                        i5--;
                    }
                    i5++;
                }
                this.pRebuild.f228v = (this.f35f / 2) % 2;
                if (this.f35f > 4) {
                    if (this.lT_Arc > 5) {
                        this.pRebuild.f235f += 14;
                        this.pRebuild.f232vy = CRes.sin(CRes.fixangle(this.pRebuild.f235f % 360)) * this.lT_Arc;
                        this.pRebuild.f231vx = CRes.cos(CRes.fixangle(this.pRebuild.f235f % 360)) * this.lT_Arc;
                        if (this.f35f % 2 == 0) {
                            this.lT_Arc--;
                            this.pRebuild.f235f += 14;
                        }
                        Point point6 = new Point();
                        point6.f225x = ((this.pRebuild.f233x2 + this.pRebuild.f231vx) / ObjectData.MONSTER) + CRes.random_Am(-1, 2);
                        point6.f226y = ((this.pRebuild.f234y2 + this.pRebuild.f232vy) / ObjectData.MONSTER) + CRes.random_Am(-1, 2);
                        this.VecEffEnd.addElement(point6);
                        break;
                    } else if (this.VecEffEnd.size() == 0) {
                        removeEff();
                        break;
                    }
                }
                break;
            case 32:
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                if (this.f35f < this.fRemove / 2) {
                    for (int i6 = 0; i6 < this.VecEffEnd.size(); i6++) {
                        Point point7 = (Point) this.VecEffEnd.elementAt(i6);
                        if (CRes.random(3) == 0) {
                            if (point7.fRe == 1) {
                                point7.fRe = 0;
                            } else {
                                point7.fRe = 1;
                                point7.frame = CRes.random(4);
                            }
                        }
                    }
                    break;
                }
                break;
            case 33:
                for (int i7 = 0; i7 < this.VecEffEnd.size(); i7++) {
                    Point point8 = (Point) this.VecEffEnd.elementAt(i7);
                    point8.update();
                    point8.f232vy++;
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                    break;
                }
                break;
            case 36:
                if (this.f35f == 1) {
                    GameScreen.addEffectEndKill(14, this.f33x, this.f34y);
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                    break;
                }
                break;
            case 37:
                if (this.f35f % 3 == 0 && this.VecEffEnd.size() < this.numEffReplace && this.f35f < 50) {
                    Point point9 = new Point();
                    point9.f225x = this.f33x * ObjectData.MONSTER;
                    point9.f226y = this.f34y * ObjectData.MONSTER;
                    point9.f231vx = CRes.cos(CRes.fixangle(this.gocT_Arc)) * 4;
                    point9.f232vy = CRes.sin(CRes.fixangle(this.gocT_Arc)) * 4;
                    point9.f233x2 = this.toX * ObjectData.MONSTER;
                    point9.f234y2 = this.toY * ObjectData.MONSTER;
                    this.gocT_Arc += this.plusGoc;
                    this.VecEffEnd.addElement(point9);
                    if (this.VecEffEnd.size() == this.numEffReplace) {
                        this.f35f = 50;
                    }
                }
                if (this.f35f == 80) {
                    for (int i8 = 0; i8 < this.VecEffEnd.size(); i8++) {
                        Point point10 = (Point) this.VecEffEnd.elementAt(i8);
                        point10.f231vx = (point10.f233x2 - point10.f225x) / 8;
                        point10.f232vy = (point10.f234y2 - point10.f226y) / 8;
                        point10.f235f = 100;
                    }
                }
                int i9 = 0;
                while (i9 < this.VecEffEnd.size()) {
                    Point point11 = (Point) this.VecEffEnd.elementAt(i9);
                    point11.update();
                    if (point11.f235f % 3 == 0) {
                        Point point12 = new Point();
                        point12.f225x = (point11.f225x / ObjectData.MONSTER) + CRes.random_Am(5, 12);
                        point12.f226y = (point11.f226y / ObjectData.MONSTER) + CRes.random_Am(5, 12);
                        this.VecSubEffEnd.addElement(point12);
                    }
                    if (point11.f235f == 10) {
                        point11.f231vx = 0;
                        point11.f232vy = 0;
                    }
                    if (point11.f235f > 108) {
                        this.VecEffEnd.removeElement(point11);
                        i9--;
                    }
                    i9++;
                }
                int i10 = 0;
                while (i10 < this.VecSubEffEnd.size()) {
                    Point point13 = (Point) this.VecSubEffEnd.elementAt(i10);
                    point13.f235f++;
                    if (point13.f235f / 2 >= 4) {
                        this.VecSubEffEnd.removeElement(point13);
                        i10--;
                    }
                    i10++;
                }
                if (this.f35f > 80 && this.VecEffEnd.size() == 0) {
                    TabRebuildItem.addEffectEnd_ReBuild_ss(32, this.toX, this.toY - 11);
                    TabRebuildItem.addEffectEnd_ReBuild_ss(33, this.toX, this.toY);
                    TabRebuildItem.addEffectEnd_ReBuild_ss(34, this.toX, this.toY);
                    removeEff();
                    break;
                }
                break;
            case 38:
                if (this.f35f >= this.fRemove) {
                    removeEff();
                    break;
                }
                break;
            case 39:
                if (CRes.random(2) == 0) {
                    GameScreen.addEffectKill(83, this.f33x, this.f34y, 400, (short) -1, (byte) 0);
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                    break;
                }
                break;
            case 41:
                if (this.f35f == 1) {
                    Point point14 = new Point();
                    point14.f225x = this.f33x * ObjectData.MONSTER;
                    point14.f226y = this.f34y * ObjectData.MONSTER;
                    point14.f233x2 = this.toX * ObjectData.MONSTER;
                    point14.f234y2 = this.toY * ObjectData.MONSTER;
                    point14.f231vx = 0;
                    point14.f232vy = 0;
                    this.VecEffEnd.addElement(point14);
                }
                int i11 = 0;
                while (i11 < this.VecEffEnd.size()) {
                    Point point15 = (Point) this.VecEffEnd.elementAt(i11);
                    point15.update();
                    if (point15.f235f == 4) {
                        point15.f231vx = (point15.f233x2 - point15.f225x) / 12;
                        point15.f232vy = (point15.f234y2 - point15.f226y) / 12;
                    }
                    if (point15.f235f % 3 == 0) {
                        Point point16 = new Point();
                        point16.f225x = (point15.f225x / ObjectData.MONSTER) + CRes.random_Am(5, 12);
                        point16.f226y = (point15.f226y / ObjectData.MONSTER) + CRes.random_Am(5, 12);
                        this.VecSubEffEnd.addElement(point16);
                    }
                    if (point15.f235f == 16) {
                        point15.f231vx = 0;
                        point15.f232vy = 0;
                        this.VecEffEnd.removeElement(point15);
                        i11--;
                    }
                    i11++;
                }
                int i12 = 0;
                while (i12 < this.VecSubEffEnd.size()) {
                    Point point17 = (Point) this.VecSubEffEnd.elementAt(i12);
                    point17.f235f++;
                    if (point17.f235f / 2 >= 4) {
                        this.VecSubEffEnd.removeElement(point17);
                        i12--;
                    }
                    i12++;
                }
                if (this.f35f >= this.fRemove && this.VecSubEffEnd.size() == 0 && this.VecEffEnd.size() == 0) {
                    removeEff();
                    break;
                }
                break;
            case 42:
                int i13 = 0;
                while (i13 < this.VecEffEnd.size()) {
                    Point point18 = (Point) this.VecEffEnd.elementAt(i13);
                    point18.update();
                    if (point18.f235f % 3 == 0) {
                        Point point19 = new Point();
                        point19.f225x = (point18.f225x / ObjectData.MONSTER) + CRes.random_Am(5, 12);
                        point19.f226y = (point18.f226y / ObjectData.MONSTER) + CRes.random_Am(5, 12);
                        this.VecSubEffEnd.addElement(point19);
                    }
                    if (point18.f235f == this.fRemove) {
                        point18.f231vx = 0;
                        point18.f232vy = 0;
                        this.VecEffEnd.removeElement(point18);
                        i13--;
                    }
                    i13++;
                }
                int i14 = 0;
                while (i14 < this.VecSubEffEnd.size()) {
                    Point point20 = (Point) this.VecSubEffEnd.elementAt(i14);
                    point20.f235f++;
                    if (point20.f235f / 2 >= 4) {
                        this.VecSubEffEnd.removeElement(point20);
                        i14--;
                    }
                    i14++;
                }
                if (this.f35f >= this.fRemove && this.VecEffEnd.size() == 0 && this.VecSubEffEnd.size() == 0) {
                    removeEff();
                    break;
                }
                break;
            case 43:
                if (this.f35f == 1) {
                    GameScreen.addEffectEndKill(14, this.f33x, this.f34y);
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                    break;
                }
                break;
            case 45:
                if (this.f35f == 1) {
                    GameScreen.addEffectEndKill(9, this.f33x, this.f34y + 20);
                    GameScreen.addEffectEndKill(46, this.f33x, this.f34y + 20);
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                    break;
                }
                break;
            case 47:
            case 50:
                if (this.timeRemove - mSystem.currentTimeMillis() < 0) {
                    removeEff();
                    break;
                }
                break;
            case 48:
                if (this.f35f >= this.fRemove) {
                    removeEff();
                    break;
                }
                break;
            case 49:
                if (this.effAuto != null) {
                    this.effAuto.update();
                }
                if (this.timeRemove - mSystem.currentTimeMillis() < 0) {
                    removeEff();
                    GameScreen.addEffectEndKill(15, this.f33x, this.f34y);
                    break;
                }
                break;
            case 55:
                if (this.f35f < 0) {
                    this.f35f = 0;
                }
                if (this.Direction == 2) {
                    this.trans = 0;
                } else if (this.Direction == 3) {
                    this.trans = 2;
                }
                if (this.Direction == 1) {
                    this.trans = 3;
                }
                if (this.Direction == 0) {
                    this.trans = 0;
                }
                if (this.f35f > this.nFrame.length - 1) {
                    this.f35f = 0;
                    removeEff();
                    break;
                }
                break;
            case 56:
                if (this.Direction == 2) {
                    this.trans = 4;
                } else if (this.Direction == 3) {
                    this.trans = 7;
                }
                if (this.Direction == 1) {
                    this.trans = 0;
                }
                if (this.Direction == 0) {
                    this.trans = 3;
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                    break;
                }
                break;
            case 58:
                if (this.Direction == 2) {
                    this.trans = 4;
                } else if (this.Direction == 3) {
                    this.trans = 7;
                }
                if (this.Direction == 1) {
                    this.trans = 0;
                }
                if (this.Direction == 0) {
                    this.trans = 3;
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                    break;
                }
                break;
        }
    }

    public void removeEff() {
        this.isStop = true;
        this.isRemove = true;
    }

    private void create_Arc_Big_Small() {
        this.fraImgEff = new FrameImage(7);
        this.fraImgSubEff = new FrameImage(2);
        this.x1000 = this.f33x * ObjectData.MONSTER;
        this.y1000 = this.f34y * ObjectData.MONSTER;
        this.fRemove = 15;
        this.lT_Arc = MainObject.getDistance(this.toX, this.toY, this.f33x, this.f34y);
        this.gocT_Arc = CRes.angle(this.f33x - this.toX, this.f34y - this.toY);
        this.pRebuild = new Point(this.toX * ObjectData.MONSTER, this.toY * ObjectData.MONSTER);
        this.pRebuild.f233x2 = this.toX * ObjectData.MONSTER;
        this.pRebuild.f234y2 = this.toY * ObjectData.MONSTER;
        this.pRebuild.f235f = this.gocT_Arc;
        this.pRebuild.f232vy = CRes.sin(CRes.fixangle(this.pRebuild.f235f % 360)) * this.lT_Arc;
        this.pRebuild.f231vx = CRes.cos(CRes.fixangle(this.pRebuild.f235f % 360)) * this.lT_Arc;
        this.pRebuild.f228v = 0;
    }

    private void create_Level_up() {
        this.fraImgSubEff = new FrameImage(67);
        this.fRemove = 23;
    }

    public void fRemove_Low(int i) {
        if (GameCanvas.lowGraphic) {
            this.fRemove = CRes.random(i - 4, i + 5);
        }
    }
}
