package GameScreen;

import CLib.mFont;
import CLib.mGraphics;
import CLib.mImage;
import GameEffect.EffectSkill;
import GameObjects.Monstervantieu;
import InterfaceComponents.MainTabNew;
import InterfaceComponents.iCommand;
import Main.GameCanvas;
import Model.AvMain;
import Model.C0002T;
import Model.CRes;
import Thread_More.MiniMap;

/* loaded from: KnightOnline_v403.jar:GameScreen/MapScr.class */
public class MapScr extends MainScreen {
    private static MapScr instance;
    boolean modeCurrentMap;
    public static int mapW;
    public static int mapH;
    public static int mfx;
    public static int mfy;
    public static int mpoint;
    public static int tick3;
    public static int mcmtoX;
    public static int mcmtoY;
    public static int mcmvx;
    public static int mcmvy;
    public static int mcmdx;
    public static int mcmdy;
    public static int mcmx;
    public static int mcmy;
    public static int mcmxLim;
    public static int mcmyLim;
    public static int taskmapId;
    public static String[] mapNames;
    int maxPX;
    int maxPY;

    /* renamed from: xM */
    int f144xM;

    /* renamed from: yM */
    int f145yM;
    boolean trans = false;
    int lastX;
    int lastY;
    public static mImage imgMap = null;

    /* renamed from: dx */
    private static int f140dx = 0;

    /* renamed from: dy */
    private static int f141dy = 0;
    public static int cmdH = 22;
    public static int TOP_CENTER = 17;
    public static int TOP_LEFT = 20;
    public static int TOP_RIGHT = 24;
    public static int BOTTOM_HCENTER = 33;
    public static int BOTTOM_LEFT = 36;
    public static int BOTTOM_RIGHT = 40;
    public static int VCENTER_HCENTER = 3;
    public static int VCENTER_LEFT = 6;

    /* renamed from: x */
    public static int[] f142x = {108, EffectSkill.EFF_SUNG_NGU, Monstervantieu.ID_TEMPLATE_BO_TRANG, 93, 76, 58, 39, EffectSkill.EFF_PET_EAGLE, 83, 66, 49, 121, 135, 154, 160, 100, 94, 80, Monstervantieu.ID_TEMPLATE_LUA_DEN, 73, 100, 88, 53, 83, 73, 127, EffectSkill.EFF_PHAPSU_BANG, 89, 72, 171, 172, 185, 202, 134, EffectSkill.EFF_SMALL_SWORD_115, 157, 135, 99, EffectSkill.EFF_PET_EAGLE, 122, 139, 156, 47, 44, 28, 23, 0, 47, 87, 0, 133, 159, 23, 207, 207, 239, 226, 207, 207, 168, 182, 217, 23, 71, 24, 88, 25, 66, 99, 40, 47, 28, 64, 47, 47, 67, 83, 98, EffectSkill.EFF_SUNG_NGU, Monstervantieu.ID_TEMPLATE_LUA_DEN, 0, 0, EffectSkill.EFF_SMALL_SWORD_115, 219, 191, 219, 241, 218, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    /* renamed from: y */
    public static int[] f143y = {247, 233, 220, 235, 236, 238, 237, 216, 212, 216, 205, 210, 204, 203, 182, 196, 180, 172, 183, EffectSkill.EFF_SMALL_SWORD_115, 144, Monstervantieu.ID_TEMPLATE_LAC_DA_DEN, 134, 146, 134, 162, 160, 160, 160, 141, 125, 114, EffectSkill.EFF_BIG_SWORD_115, 145, 144, 147, Monstervantieu.ID_TEMPLATE_LUA_DEN, EffectSkill.EFF_SUNG_115, 98, 96, 88, 75, 149, 165, 165, 181, 0, EffectSkill.EFF_SUNG_115, 224, 0, 235, 59, 200, 201, 187, 162, 167, Monstervantieu.ID_TEMPLATE_LAC_DA_TRANG, 143, 171, 171, 166, 217, 57, 62, 60, 83, 92, 72, 92, 69, 43, 42, 35, 18, 14, 8, 14, 28, 27, 0, 0, Monstervantieu.ID_TEMPLATE_BO_DEN, EffectSkill.EFF_BIG_SWORD_115, 96, 71, 94, 94, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    public MapScr() {
        this.center = new iCommand(C0002T.close, 0, this);
    }

    protected void resetCMLim() {
        int i = GameCanvas.loadmap.idMap;
        if (i > f142x.length) {
            i = f142x.length - 1;
        }
        int imageWidth = mImage.getImageWidth(MiniMap.imgMiniMap.image);
        this.f144xM = (GameCanvas.f180w - imageWidth) / 2;
        this.f145yM = ((GameCanvas.f181h - 20) - mImage.getImageHeight(MiniMap.imgMiniMap.image)) / 2;
        if (this.f144xM < 0) {
            this.f144xM = 0;
        }
        if (this.f145yM < 0) {
            this.f145yM = 0;
        }
        if (this.modeCurrentMap) {
            mcmxLim = (imageWidth + 20) - GameCanvas.f180w;
            mcmyLim = (mImage.getImageHeight(MiniMap.imgMiniMap.image) + 40) - GameCanvas.f181h;
            this.maxPX = imageWidth + 20;
            this.maxPY = imageWidth + 40;
            if (this.maxPY < GameCanvas.f181h - 26) {
                this.maxPY = GameCanvas.f181h - 26;
            }
            if (this.maxPX < GameCanvas.f180w) {
                this.maxPX = GameCanvas.f180w;
            }
            mfx = this.f144xM + (GameScreen.player.f74x / 12);
            mfy = this.f145yM + (GameScreen.player.f75y / 12);
        } else {
            mcmxLim = 340 - GameCanvas.f180w;
            mcmyLim = 340 - GameCanvas.f181h;
            mfx = f142x[i] + f140dx;
            mfy = f143y[i] + f141dy;
            this.maxPX = 330 + f140dx;
            this.maxPY = 310 + f141dy;
        }
        this.maxPX -= 10;
        this.maxPY -= 10;
        if (mcmxLim < 0) {
            mcmxLim = 0;
        }
        if (mcmyLim < 0) {
            mcmyLim = 0;
        }
        mcmy = 0;
        mcmx = 0;
        mcmtoY = 0;
        mcmtoX = 0;
        mcmtoX = mfx - GameCanvas.f182hw;
        mcmtoY = mfy - GameCanvas.f183hh;
    }

    /* renamed from: gI */
    public static MapScr m5gI() {
        if (instance == null) {
            instance = new MapScr();
        }
        return instance;
    }

    @Override // GameScreen.MainScreen
    public void Show() {
        super.Show();
        this.center = new iCommand(C0002T.close, 0, this);
        if (imgMap == null) {
            imgMap = mImage.createImage("/wm.png");
            mapW = mImage.getImageWidth(imgMap.image);
            mapH = mImage.getImageWidth(imgMap.image);
        }
        if (GameCanvas.f180w > mapW) {
            f140dx = (GameCanvas.f180w / 2) - (mapW / 2);
        }
        if (GameCanvas.f181h > mapH) {
            f141dy = (GameCanvas.f181h / 2) - (mapH / 2);
        }
        resetCMLim();
        findMapNearestPoint();
        System.gc();
        mapNames = C0002T.mapName;
    }

    @Override // GameScreen.MainScreen, Model.AvMain
    public void paint(mGraphics mgraphics) {
        mgraphics.setColor(0);
        mgraphics.fillRect(0, 0, GameCanvas.f180w, GameCanvas.f181h, false);
        mgraphics.translate(10, 10);
        mgraphics.translate(-mcmx, -mcmy);
        if (GameCanvas.f180w > mapW && GameCanvas.f181h > mapH) {
            mgraphics.drawImage(imgMap, GameCanvas.f182hw, GameCanvas.f183hh, VCENTER_HCENTER, false);
        } else if (GameCanvas.f180w > mapW) {
            mgraphics.drawImage(imgMap, GameCanvas.f182hw, 0, TOP_CENTER, false);
        } else if (GameCanvas.f181h > mapH) {
            mgraphics.drawImage(imgMap, 0, GameCanvas.f183hh, VCENTER_LEFT, false);
        } else {
            mgraphics.drawImage(imgMap, 0, 0, 0, false);
        }
        if (GameCanvas.loadmap.idMap < mapNames.length && GameCanvas.loadmap.idMap >= 0) {
            int i = 0;
            if (f142x[GameCanvas.loadmap.idMap] != 1 || f143y[GameCanvas.loadmap.idMap] != 1) {
                i = f142x[GameCanvas.loadmap.idMap] < 100 ? 0 : f142x[GameCanvas.loadmap.idMap] > 200 ? 1 : 2;
                mgraphics.drawRegion(AvMain.imgFocusMap, 0, (GameCanvas.gameTick % 3) * 10, 10, 10, 0, f142x[GameCanvas.loadmap.idMap] + f140dx, f143y[GameCanvas.loadmap.idMap] + f141dy, 3, false);
            }
            int i2 = 0;
            if (f142x[GameCanvas.loadmap.idMap] != 1 || f143y[GameCanvas.loadmap.idMap] != 1) {
                i2 = f143y[GameCanvas.loadmap.idMap] - 20;
                mFont.tahoma_7b_black.drawString(mgraphics, mapNames[GameCanvas.loadmap.idMap], f142x[GameCanvas.loadmap.idMap] + f140dx + 1, ((f143y[GameCanvas.loadmap.idMap] + f141dy) - 20) + 1, i, false);
                mFont.tahoma_7b_yellow.drawString(mgraphics, mapNames[GameCanvas.loadmap.idMap], f142x[GameCanvas.loadmap.idMap] + f140dx, (f143y[GameCanvas.loadmap.idMap] + f141dy) - 20, i, false);
            }
            if (mpoint >= 0 && ((taskmapId < 0 && GameCanvas.loadmap.idMap != mpoint) || (taskmapId >= 0 && mpoint != taskmapId))) {
                int i3 = f142x[mpoint] < 100 ? 0 : f142x[mpoint] > 200 ? 1 : 2;
                int i4 = f142x[mpoint];
                int i5 = f143y[mpoint] - 20;
                if (i5 > i2 && i5 - i2 < 30) {
                    i5 += 40;
                }
                if (i5 < i2 && i2 - i5 < 20) {
                    i5 -= 5;
                }
                mFont.tahoma_7b_black.drawString(mgraphics, mapNames[mpoint], i4 + f140dx + 1, i5 + f141dy + 1, i3, false);
                mFont.tahoma_7b_yellow.drawString(mgraphics, mapNames[mpoint], i4 + f140dx, i5 + f141dy, i3, false);
            }
        }
        if (!GameCanvas.isTouch) {
            mgraphics.drawRegion(MainTabNew.imgTab[5], 0, 0, 10, 10, 0, mfx - 2, mfy, 0, false);
        } else if (mpoint >= 0) {
            mgraphics.drawRegion(MainTabNew.imgTab[5], 0, 0, 10, 10, 0, (f142x[mpoint] - 9) + f140dx, f143y[mpoint] + f141dy, 0, false);
        }
        mgraphics.translate(-mgraphics.getTranslateX(), -mgraphics.getTranslateY());
        super.paint(mgraphics);
    }

    @Override // Model.AvMain
    public void updatekey() {
        super.updatekey();
        tick3++;
        if (tick3 > 10000) {
            tick3 = 0;
        }
        if (mcmx != mcmtoX || mcmy != mcmtoY) {
            mcmvx = (mcmtoX - mcmx) << 1;
            mcmvy = (mcmtoY - mcmy) << 1;
            mcmdx += mcmvx;
            mcmx += mcmdx >> 4;
            mcmdx &= 15;
            mcmdy += mcmvy;
            mcmy += mcmdy >> 4;
            mcmdy &= 15;
            if (mcmx < 0) {
                mcmx = 0;
            }
            if (mcmx > mcmxLim) {
                mcmx = mcmxLim;
            }
            if (mcmy < 0) {
                mcmy = 0;
            }
            if (mcmy > mcmyLim) {
                mcmy = mcmyLim;
            }
        }
        boolean z = false;
        if (GameCanvas.keyMyHold[2]) {
            mfy -= 4;
            if (mfy < f141dy - 10) {
                mfy = f141dy - 10;
            }
            z = true;
        }
        if (GameCanvas.keyMyHold[8]) {
            mfy += 4;
            if (mfy > this.maxPY) {
                mfy = this.maxPY;
            }
            z = true;
        }
        if (GameCanvas.keyMyHold[4]) {
            mfx -= 4;
            if (mfx < f140dx - 10) {
                mfx = f140dx - 10;
            }
            z = true;
        }
        if (GameCanvas.keyMyHold[6]) {
            mfx += 4;
            if (mfx > this.maxPX) {
                mfx = this.maxPX;
            }
            z = true;
        }
        if (z) {
            mcmtoX = mfx - GameCanvas.f182hw;
            mcmtoY = mfy - GameCanvas.f183hh;
            findMapNearestPoint();
        }
        if (GameCanvas.isPointerClick && GameCanvas.f185py < GameCanvas.f181h - cmdH) {
            GameCanvas.isPointerClick = false;
            this.trans = true;
            this.lastX = GameCanvas.f184px;
            this.lastY = GameCanvas.f185py;
        } else if (GameCanvas.isPointerDown && this.trans) {
            mcmtoX -= GameCanvas.f184px - this.lastX;
            mcmtoY -= GameCanvas.f185py - this.lastY;
            if (mcmtoX < 0) {
                mcmtoX = 0;
            }
            if (mcmtoY < 0) {
                mcmtoY = 0;
            }
            if (mcmtoX > mcmxLim) {
                mcmtoX = mcmxLim;
            }
            if (mcmtoY > mcmyLim) {
                mcmtoY = mcmyLim;
            }
            mcmx = mcmtoX;
            mcmy = mcmtoY;
            this.lastX = GameCanvas.f184px;
            this.lastY = GameCanvas.f185py;
        }
        if (GameCanvas.isPointerRelease) {
            int i = GameCanvas.pxLast - GameCanvas.f184px;
            int i2 = GameCanvas.pyLast - GameCanvas.f185py;
            if (i < 10 && i2 < 10) {
                mfx = (mcmx + GameCanvas.pxLast) - 8;
                mfy = (mcmy + GameCanvas.pyLast) - 8;
                findMapNearestPoint();
            }
            this.trans = false;
            GameCanvas.isPointerRelease = false;
        }
        if (GameCanvas.isTouch && GameCanvas.f180w >= 320) {
            this.center.xCmd = (GameCanvas.f180w / 2) - 35;
        }
    }

    private static void findMapNearestPoint() {
        mpoint = -1;
        int i = 10;
        if (!GameCanvas.isTouch) {
            i = 13;
        }
        for (int i2 = 0; i2 < f142x.length; i2++) {
            if (CRes.abs(mfx - (f142x[i2] + f140dx)) < i && CRes.abs(mfy - (f143y[i2] + f141dy)) < i) {
                mpoint = i2;
                return;
            }
        }
    }

    @Override // Model.AvMain
    public void commandPointer(int i, int i2) {
        switch (i) {
            case 0:
                imgMap = null;
                GameScreen.m3gI().Show();
                break;
            case 1:
                this.modeCurrentMap = !this.modeCurrentMap;
                resetCMLim();
                break;
        }
    }
}
