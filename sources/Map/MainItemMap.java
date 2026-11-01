package Map;

import CLib.mGraphics;
import CLib.mImage;
import GameObjects.ObjectData;
import GameScreen.MainScreen;
import Main.GameCanvas;
import Model.MainImage;

/* loaded from: KnightOnline_v403.jar:Map/MainItemMap.class */
public class MainItemMap {
    public byte TypeItem;
    public static final byte ITEM_MAP = 0;
    public static final byte EFF_MAP = 1;
    public static final byte EFF_FROM_SV = 2;
    public static final byte EFF_SKILL_FROM_SV = 3;
    public static final byte EFF_MAT_NA = 4;
    public short IDItem;
    public short IDImage;

    /* renamed from: dx */
    public int f186dx;

    /* renamed from: dy */
    public int f187dy;

    /* renamed from: x */
    public int f188x;

    /* renamed from: y */
    public int f189y;
    public int wOne;
    public int hOne;
    public short idActor;
    public int[][] Block;
    mImage img;

    public MainItemMap() {
    }

    public void setDataEff(byte[] bArr) {
    }

    public MainItemMap(short s, short s2, int i, int i2, int[][] iArr) {
        this.IDItem = s;
        this.IDImage = s2;
        this.f186dx = i;
        this.f187dy = i2;
        this.Block = iArr;
    }

    public void paint(mGraphics mgraphics) {
    }

    public void update() {
    }

    public boolean isInScreen() {
        if (this.hOne == 0 || this.wOne == 0) {
            MainImage imagePartItemMap = ObjectData.getImagePartItemMap(this.IDItem);
            if (imagePartItemMap.img != null) {
                this.wOne = mImage.getImageWidth(imagePartItemMap.img.image);
                this.hOne = mImage.getImageHeight(imagePartItemMap.img.image);
            }
        }
        if (this.f188x + this.f186dx + this.wOne < MainScreen.cameraMain.xCam || (this.f188x + this.f186dx) - this.wOne > MainScreen.cameraMain.xCam + GameCanvas.f180w || this.f189y + this.f187dy + this.hOne < MainScreen.cameraMain.yCam || (this.f189y + this.f187dy) - this.hOne > MainScreen.cameraMain.yCam + GameCanvas.f181h) {
            return false;
        }
        return true;
    }
}
