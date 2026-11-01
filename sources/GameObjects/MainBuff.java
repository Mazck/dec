package GameObjects;

import CLib.mGraphics;
import CLib.mSystem;
import CLib.mVector;
import GameEffect.EffectSkill;
import GameScreen.GameScreen;
import Main.GameCanvas;
import Model.CRes;
import Model.FrameImage;
import Model.Line;
import Model.Point;

/* loaded from: KnightOnline_v403.jar:GameObjects/MainBuff.class */
public class MainBuff {
    long timeBegin;
    boolean isPaintLast;
    boolean isForEver;

    /* renamed from: x0 */
    int f69x0;

    /* renamed from: y0 */
    int f70y0;
    int x1000;
    int y1000;
    int timeOff;
    int indexPaint;
    int framebegin;
    long timebuff;
    public boolean isRemove;
    public int typeBuff;
    public int typeSub;
    public short idIcon;
    public byte[] frame_Buff;
    public byte frBuff;
    public MainInfoItem[] minfo;
    public MainInfoItem[] minfotam;
    public static final int BUFF_KIEM_1 = 0;
    public static final int BUFF_2KIEM_1 = 1;
    public static final int BUFF_PS_1 = 2;
    public static final int BUFF_SUNG_1 = 3;
    public static final int BUFF_HEAD = 4;
    public static final int BUFF_KIEM_2 = 5;
    public static final int BUFF_2KIEM_2 = 6;
    public static final int BUFF_PS_2 = 7;
    public static final int BUFF_SUNG_2 = 8;
    public static final int BUFF_CRAZY = 9;
    public static final int BUFF_PET = 10;
    public static final byte EFF_BUFF_GOLD = 11;
    public static final byte EFF_BUFF_AMOR = 12;
    public static final byte EFF_BUFF_DAME = 13;
    public static final byte EFF_BUFF_HUTHP = 14;
    FrameImage fraImage;
    mVector vecEff;

    public MainBuff(int i, int i2) {
        this.isPaintLast = false;
        this.isForEver = false;
        this.isRemove = false;
        this.frame_Buff = new byte[]{0, 0, 0, 1, 1, 1, 2, 2, 2};
        this.minfo = null;
        this.minfotam = null;
        this.vecEff = new mVector("MainBuff VecEff");
        this.typeBuff = i;
        this.timebuff = mSystem.currentTimeMillis() + (i2 * ObjectData.MONSTER);
        switch (this.typeBuff) {
            case 11:
                this.fraImage = new FrameImage(149);
                break;
            case 12:
                this.fraImage = new FrameImage(147);
                break;
            case 13:
                this.fraImage = new FrameImage(146);
                break;
            case 14:
                this.fraImage = new FrameImage(148);
                break;
        }
    }

    public void settimebuff(long j) {
        this.timebuff = mSystem.currentTimeMillis() + (j * 1000);
    }

    public MainBuff(int i, int i2, int i3) {
        this.isPaintLast = false;
        this.isForEver = false;
        this.isRemove = false;
        this.frame_Buff = new byte[]{0, 0, 0, 1, 1, 1, 2, 2, 2};
        this.minfo = null;
        this.minfotam = null;
        this.vecEff = new mVector("MainBuff VecEff");
        this.typeBuff = i;
        this.typeSub = i3;
        this.timeBegin = GameCanvas.timeNow;
        this.timeOff = i2;
        this.f69x0 = 0;
        this.f70y0 = 0;
        this.framebegin = CRes.random(9);
        switch (i) {
            case 0:
            case 2:
            case 5:
            case 7:
                this.fraImage = new FrameImage(88);
                break;
            case 1:
            case 3:
            case 6:
            case 8:
                this.fraImage = new FrameImage(89);
                break;
            case 4:
                this.isPaintLast = true;
                if (i3 == 3) {
                    this.fraImage = new FrameImage(81);
                    this.framebegin = 0;
                } else {
                    this.fraImage = new FrameImage(80);
                    this.framebegin = i3;
                    if (i3 > 3) {
                        this.framebegin--;
                    }
                }
                for (int i4 = 0; i4 < 3; i4++) {
                    Point point = new Point();
                    point.f225x = CRes.random_Am_0(16);
                    point.f226y = CRes.random_Am_0(10);
                    if (i3 == 3) {
                        point.f231vx = CRes.random_Am_0(3);
                        point.f232vy = CRes.random_Am_0(2);
                    }
                    this.vecEff.addElement(point);
                }
                break;
            case 9:
                this.isPaintLast = true;
                break;
            default:
                this.isRemove = true;
                break;
        }
    }

    public void paint(mGraphics mgraphics, int i, int i2) {
        if (this.isRemove) {
        }
        switch (this.typeBuff) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 10:
                if (this.fraImage != null) {
                    this.fraImage.drawFrameEffectSkill(2 - (((GameCanvas.gameTick + this.framebegin) / 3) % this.fraImage.nFrame), i + this.f69x0, i2 + this.f70y0, 0, 3, mgraphics);
                    break;
                }
                break;
            case 2:
            case 3:
            case 7:
            case 8:
                if (this.fraImage != null) {
                    this.fraImage.drawFrameEffectSkill(((GameCanvas.gameTick + this.framebegin) / 3) % this.fraImage.nFrame, i + this.f69x0, i2 + this.f70y0, 0, 3, mgraphics);
                    break;
                }
                break;
            case 4:
                if (this.fraImage != null && this.vecEff != null) {
                    for (int i3 = 0; i3 < this.vecEff.size(); i3++) {
                        Point point = (Point) this.vecEff.elementAt(i3);
                        if (point != null) {
                            this.fraImage.drawFrameEffectSkill((this.framebegin * 3) + (point.f235f % this.fraImage.nFrame), i + point.f225x, i2 + point.f226y, 0, 3, mgraphics);
                        }
                    }
                    break;
                }
                break;
            case 9:
                for (int size = this.vecEff.size() - 1; size >= 0; size--) {
                    Line line = (Line) this.vecEff.elementAt(size);
                    if (line != null) {
                        mgraphics.setColor(EffectSkill.colorStar[0][line.idColor]);
                        mgraphics.drawLine(line.f200x0, line.f201y0, line.f202x1, line.f203y1, false);
                        if (line.is2Line) {
                            mgraphics.drawLine(line.f200x0 + 1, line.f201y0, line.f202x1 + 1, line.f203y1, false);
                        }
                    }
                }
                this.x1000 = i;
                this.y1000 = i2;
                break;
            case 11:
            case 12:
            case 13:
            case 14:
                if (this.fraImage != null) {
                    this.fraImage.drawFrameEffectSkill(this.frame_Buff[this.frBuff], i, i2 - 2, 0, 3, mgraphics);
                    break;
                }
                break;
        }
    }

    public void update() {
        if (!this.isRemove) {
            if (!this.isForEver) {
                if (this.typeBuff == 4) {
                    if (CRes.random(2) == 0) {
                        Point point = new Point();
                        point.f225x = CRes.random_Am_0(16);
                        point.f226y = CRes.random_Am_0(10);
                        if (this.typeSub == 3) {
                            point.f231vx = CRes.random_Am_0(3);
                            point.f232vy = CRes.random_Am_0(2);
                        }
                        this.vecEff.addElement(point);
                    }
                    int i = 0;
                    while (i < this.vecEff.size()) {
                        Point point2 = (Point) this.vecEff.elementAt(i);
                        point2.update();
                        if (point2.f235f >= 3) {
                            this.vecEff.removeElement(point2);
                            i--;
                        }
                        i++;
                    }
                } else if (this.typeBuff == 9) {
                    if (GameCanvas.gameTick % 2 == 0) {
                        create_Line_NHANBAN_LV2();
                    }
                    int i2 = 0;
                    while (i2 < this.vecEff.size()) {
                        Line line = (Line) this.vecEff.elementAt(i2);
                        line.update();
                        if (line.f206f >= line.fRe) {
                            this.vecEff.removeElement(line);
                            i2--;
                        }
                        i2++;
                    }
                } else if (this.typeBuff > 10 && this.typeBuff < 15) {
                    this.frBuff = (byte) (this.frBuff + 1);
                    if (this.frBuff > this.frame_Buff.length - 1) {
                        this.frBuff = (byte) 0;
                    }
                    if (this.timebuff - mSystem.currentTimeMillis() < 0) {
                        this.isRemove = true;
                    }
                }
                if (GameCanvas.gameTick % 10 == 0 && this.typeBuff < 11 && GameCanvas.timeNow - this.timeBegin > this.timeOff) {
                    this.isRemove = true;
                }
            }
            if (this.minfotam != null) {
                this.minfo = this.minfotam;
                this.minfotam = null;
            }
        }
    }

    public static void setEffHead(int i, int i2, MainObject mainObject) {
        for (int i3 = 0; i3 < mainObject.vecBuff.size(); i3++) {
            MainBuff mainBuff = (MainBuff) mainObject.vecBuff.elementAt(i3);
            if (mainBuff.typeBuff == 4 && mainBuff.typeSub == i) {
                mainBuff.timeBegin = GameCanvas.timeNow;
                mainBuff.timeOff = i2 * ObjectData.MONSTER;
                return;
            }
        }
        mainObject.addBuff(4, i2 * ObjectData.MONSTER, i);
    }

    public static MainBuff getBuff(int i, int i2) {
        for (int i3 = 0; i3 < GameScreen.player.vecBuff.size(); i3++) {
            MainBuff mainBuff = (MainBuff) GameScreen.player.vecBuff.elementAt(i3);
            if (mainBuff.typeBuff == i && mainBuff.typeSub == i2) {
                return mainBuff;
            }
        }
        return null;
    }

    public void create_Line_NHANBAN_LV2() {
        int i;
        int random = CRes.random(1, 4);
        for (int i2 = 0; i2 < random; i2++) {
            Line line = new Line();
            int random2 = CRes.random(3, 12);
            if (random2 <= 5) {
                line.fRe = 16;
                i = 2;
            } else if (random2 <= 8) {
                i = 4;
                line.fRe = 12;
            } else {
                i = 5;
                line.fRe = 9;
            }
            line.is2Line = CRes.random(5) == 0;
            int random_Am_0 = this.x1000 + CRes.random_Am_0(15);
            int random_Am_02 = this.y1000 - CRes.random_Am_0(10);
            line.setLine(random_Am_0, random_Am_02, random_Am_0, random_Am_02 - random2, 0, -i, line.is2Line);
            line.idColor = CRes.random(3);
            this.vecEff.addElement(line);
        }
    }

    public void clearData() {
        if (this.fraImage != null) {
            this.fraImage.clearData();
        }
    }
}
