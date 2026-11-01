package GameObjects;

import CLib.mFont;
import CLib.mGraphics;
import CLib.mSystem;
import Main.GameCanvas;
import Model.AvMain;
import Thread_More.LoadMap;

/* loaded from: KnightOnline_v403.jar:GameObjects/TimecountDown.class */
public class TimecountDown {
    short mysecond;
    String tile;
    private long currT = mSystem.currentTimeMillis();
    private long lastT = mSystem.currentTimeMillis();
    public boolean wantdestroy;

    /* renamed from: x */
    int f119x;

    /* renamed from: y */
    int f120y;

    public TimecountDown(int i, String str, int i2, int i3) {
        this.mysecond = (short) i;
        this.tile = str;
        this.f119x = i2;
        this.f120y = i3;
    }

    public void paint(mGraphics mgraphics) {
        mgraphics.drawImage(AvMain.imgBackInfo, this.f119x, this.f120y + (GameCanvas.hText / 2), 3, false);
        mFont.tahoma_7b_white.drawString(mgraphics, new StringBuffer().append(this.tile).append(" : ").append(LoadMap.converSecon2hours(this.mysecond)).toString(), this.f119x, this.f120y, 2, false);
    }

    public void update() {
        this.currT = mSystem.currentTimeMillis();
        if (this.currT - this.lastT >= 1000) {
            this.lastT = mSystem.currentTimeMillis();
            this.mysecond = (short) (this.mysecond - 1);
        }
        if (this.mysecond <= 0) {
            this.wantdestroy = true;
        }
    }
}
