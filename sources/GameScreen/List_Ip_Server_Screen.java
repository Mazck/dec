package GameScreen;

import Build_Indo.IndoServer;
import Build_Usa.Usa_Server;
import CLib.Session_ME;
import CLib.mFont;
import CLib.mGraphics;
import CLib.mSystem;
import CLib.mVector;
import InterfaceComponents.MainList;
import InterfaceComponents.iCommand;
import Main.GameCanvas;
import Map.BackGround;
import Model.AvMain;
import Model.C0002T;
import Model.C0003TE;
import Model.TIndo;
import Model.TSpain;

/* loaded from: KnightOnline_v403.jar:GameScreen/List_Ip_Server_Screen.class */
public class List_Ip_Server_Screen extends MainScreen {

    /* renamed from: x */
    int f129x;

    /* renamed from: y */
    int f130y;

    /* renamed from: w */
    int f131w;

    /* renamed from: h */
    int f132h;
    int idSelect;
    int hItem;
    MainList list;
    String serverListStatus;
    mVector vecChoice = new mVector("List_Ip_Server_Screen vecchoice");

    public List_Ip_Server_Screen() {
        this.serverListStatus = new StringBuffer().append(LogoScreen.serverListSource).append(":").append(mSystem.listServer.length).append(LogoScreen.refreshServerList() ? "" : "!").toString();
        this.hItem = GameCanvas.hCommand;
        this.f131w = GameCanvas.f180w - 20;
        if (this.f131w > 180) {
            this.f131w = 180;
        }
        this.f132h = mSystem.listServer.length * this.hItem;
        int i = 0;
        if (this.f132h > (GameCanvas.f181h / 5) * 4) {
            i = this.f132h - ((GameCanvas.f181h / 5) * 4);
            this.f132h = (GameCanvas.f181h / 5) * 4;
        }
        this.f129x = GameCanvas.f182hw - (this.f131w / 2);
        this.f130y = (GameCanvas.f183hh - (this.f132h / 2)) + (this.hItem / 2);
        this.vecChoice.removeAllElements();
        for (int i2 = 0; i2 < mSystem.listServer.length; i2++) {
            this.vecChoice.addElement(new iCommand(mSystem.listServer[i2][0], 0, i2, this));
        }
        if (GameCanvas.isTouch) {
            this.idSelect = -1;
        }
        this.list = new MainList(this.f129x, this.f130y, this.f131w, this.f132h, this.hItem, mSystem.listServer.length, i, this.idSelect, this.vecChoice);
    }

    public void checkIPSV() {
    }

    @Override // Model.AvMain
    public void commandPointer(int i, int i2) {
        switch (i) {
            case 0:
                if (Session_ME.m0gI().connected) {
                    Session_ME.m0gI().close();
                }
                GameCanvas.IndexServer = (byte) i2;
                LoginScreen.saveIndexServer();
                GameCanvas.login.Show();
                boolean z = GameCanvas.isVNLanguage;
                GameCanvas.isVNLanguage = GameCanvas.langServer[GameCanvas.IndexServer] == 0;
                if (GameCanvas.isVNLanguage != z) {
                    LogoScreen.setChangeLang();
                    GameCanvas.start_Ok_Dialog(C0002T.TchangSv);
                }
                if (GameCanvas.isVNLanguage) {
                    LoginScreen.isPaintHotLine = true;
                } else {
                    LoginScreen.isPaintHotLine = false;
                }
                if (IndoServer.isIndoSv) {
                    LoginScreen.isPaintHotLine = false;
                    GameCanvas.f178t = new TIndo();
                    LogoScreen.setChangeLang();
                    if (mSystem.isIphone) {
                    }
                }
                if (Usa_Server.isUsa_server) {
                    LoginScreen.isPaintHotLine = false;
                    if (GameCanvas.IndexServer == 0) {
                        GameCanvas.f178t = new C0003TE();
                    } else if (GameCanvas.IndexServer == 1) {
                        GameCanvas.f178t = new TSpain();
                    }
                    LogoScreen.setChangeLang();
                }
                GameCanvas.login.checkLoginAgain(GameCanvas.IndexServer);
                break;
        }
    }

    @Override // GameScreen.MainScreen, Model.AvMain
    public void paint(mGraphics mgraphics) {
        BackGround.paint(mgraphics);
        if (PaintInfoGameScreen.paint18plush == 0) {
            if (!mSystem.isIphone) {
                mgraphics.drawImage(AvMain.img18Plus, 0, 0, 0, false);
            }
        } else if (PaintInfoGameScreen.paint18plush == 1) {
            PaintInfoGameScreen.paintinfo18plush(mgraphics);
        }
        BackGround.paintLight(mgraphics);
        paintFormList(mgraphics, this.f129x, this.f130y - this.hItem, this.f131w, this.f132h + this.hItem, new StringBuffer().append(C0002T.listserver).append(" [").append(this.serverListStatus).append("]").toString());
        mgraphics.setClip(this.f129x, this.f130y, this.f131w, this.f132h);
        mgraphics.saveCanvas();
        mgraphics.ClipRec(this.f129x, this.f130y, this.f131w, this.f132h);
        mgraphics.translate(0, -this.list.cmx);
        if (this.idSelect > -1) {
            paintFocus(mgraphics);
        }
        for (int i = 0; i < this.vecChoice.size(); i++) {
            mFont.tahoma_7b_white.drawString(mgraphics, ((iCommand) this.vecChoice.elementAt(i)).caption, this.f129x + (this.f131w / 2), ((this.f130y + (this.hItem / 2)) + (i * this.hItem)) - 6, 2, true);
            if (i < this.vecChoice.size() - 1) {
                mgraphics.setColor(AvMain.color[4]);
                mgraphics.fillRect(this.f129x + 8, (this.f130y + ((i + 1) * this.hItem)) - 1, this.f131w - 16, 1, true);
            }
        }
        mGraphics.resetTransAndroid(mgraphics);
        mgraphics.restoreCanvas();
        mgraphics.endClip();
    }

    public void paintFocus(mGraphics mgraphics) {
        mgraphics.setColor(-3689060);
        mgraphics.fillRect(this.f129x + 5, ((this.f130y + (this.idSelect * this.hItem)) + (this.hItem / 2)) - 11, this.f131w - 10, 22, false);
    }

    @Override // GameScreen.MainScreen, Model.AvMain
    public void update() {
        this.list.updateMenu();
        this.idSelect = this.list.value;
        if (this.idSelect >= this.vecChoice.size()) {
            this.idSelect = -1;
            this.list.value = -1;
        }
        BackGround.updateSky();
    }
}
