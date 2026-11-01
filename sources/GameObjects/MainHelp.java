package GameObjects;

import Build_Indo.IndoServer;
import CLib.mFont;
import CLib.mGraphics;
import CLib.mSystem;
import CLib.mVector;
import GameScreen.GameScreen;
import GameScreen.PaintInfoGameScreen;
import GameScreen.TabScreenNew;
import InterfaceComponents.MainTabNew;
import InterfaceComponents.MsgDialog;
import InterfaceComponents.PopupChat;
import InterfaceComponents.TabMySeftNew;
import InterfaceComponents.iCommand;
import Main.GameCanvas;
import Model.AvMain;
import Model.C0002T;
import Model.CRes;
import Model.FrameImage;
import Model.Point;
import Thread_More.LoadMap;
import Thread_More.MiniMap;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/* loaded from: KnightOnline_v403.jar:GameObjects/MainHelp.class */
public class MainHelp extends AvMain {
    public int Step = -1;
    public int Next = -5;
    public int idTabHelp = -2;
    public int tickBegin = 0;
    public int timeReset = 0;
    iCommand cmdNext = new iCommand(C0002T.next, 0, this);
    iCommand cmdyes = new iCommand(C0002T.yes, 0, this);
    public static final byte FRIST = 0;
    public static final byte LAST = 1;
    public static final byte POINT_FRAME = 0;
    public static final byte POPUP_HAND = 1;
    public static final byte POS_NULL = -1;
    public static final byte POS_LEFT = 0;
    public static final byte POS_RIGHT = 1;
    public static final byte POS_CENTER = 2;
    public static final byte POS_TOP_LEFT = 3;
    public static final byte POS_TOP_RIGHT = 4;
    public static final byte POS_TOP_CENTER = 5;
    public static final byte POS_TOP_NULL = 6;
    public static final byte POS_LEFT_CENTER = 7;
    public static final byte POS_RIGHT_CENTER = 8;

    /* renamed from: p */
    public Point f72p;
    public FrameImage fra;
    String[] strpopup;
    public static int[] color = {-13427660, -16788};
    boolean isStepp5;

    public void setCaptionCmd() {
        this.cmdNext.caption = C0002T.next;
        this.cmdyes.caption = C0002T.yes;
    }

    @Override // Model.AvMain
    public void commandPointer(int i, int i2) {
        switch (i) {
            case 0:
                this.Next++;
                setNext();
                break;
            case 1:
                GameCanvas.end_Dialog_Help();
                this.f72p = null;
                this.Step = -1;
                this.Next = 0;
                setNext();
                SaveStep();
                break;
        }
    }

    public void loadBeginGame(byte[] bArr) {
        if (bArr == null) {
            this.Step = 0;
            this.Next = -5;
        }
    }

    public void LoadStep(byte[] bArr) {
        this.f72p = null;
        if (bArr == null) {
            this.Step = 0;
            this.Next = -5;
            return;
        }
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        try {
            this.Step = dataInputStream.readByte();
            this.Next = dataInputStream.readByte();
        } catch (Exception e) {
            this.Step = -1;
            this.Next = 0;
        }
        if (GameCanvas.currentScreen != GameCanvas.load) {
            setNext();
        }
    }

    public void SaveStep() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeByte(this.Step);
            dataOutputStream.writeByte(this.Next);
            CRes.saveRMSName((byte) 1, byteArrayOutputStream.toByteArray());
            dataOutputStream.close();
        } catch (Exception e) {
        }
    }

    public void SaveStep(byte b, byte b2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeByte(b);
            dataOutputStream.writeByte(b2);
            CRes.saveRMSName((byte) 1, byteArrayOutputStream.toByteArray());
            dataOutputStream.close();
        } catch (Exception e) {
        }
    }

    public void SaveBegin() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeByte(0);
            CRes.saveRMSName((byte) 2, byteArrayOutputStream.toByteArray());
            dataOutputStream.close();
        } catch (Exception e) {
        }
    }

    public void NextStep() {
        this.Step++;
        this.Next = 0;
    }

    public void setNext() {
        if (GameCanvas.loadmap.idMap != 0 || GameScreen.isFinishHelp) {
            return;
        }
        this.cmdNext.caption = C0002T.next;
        this.idTabHelp = -2;
        if (isSave()) {
            SaveStep();
        }
        if (!GameCanvas.isVNLanguage && !IndoServer.isIndoSv) {
            if (this.Step == 0 && this.Next == 1) {
                this.Step = 0;
                this.Next = 2;
                SaveStep();
            }
            if (this.Step == 1 && this.Next == 8) {
                this.Step = 1;
                this.Next = 9;
                SaveStep();
            }
            if (this.Step == 2 && this.Next == 6) {
                this.Step = 2;
                this.Next = 7;
                SaveStep();
            }
            if (this.Step == 2 && this.Next == 11) {
                this.Step = 4;
                this.Next = 9;
                SaveStep();
            }
            if (this.Step == 7 && this.Next == 1) {
                this.Step = 8;
                this.Next = 0;
                SaveStep();
            }
            if (this.Step == 6 && this.Next == 1) {
                this.Step = 6;
                this.Next = 2;
                SaveStep();
            }
        }
        String[][] strArr = C0002T.mHelp;
        if (GameCanvas.isTouch) {
            switch (this.Step) {
                case 0:
                    if (this.Next == 2) {
                        GameCanvas.end_Dialog_Help();
                        if (this.Next < C0002T.mHelpPoint[this.Step].length && C0002T.mHelpPoint[this.Step][this.Next].length() > 0) {
                            MsgDialog msgDialog = new MsgDialog();
                            msgDialog.setDiaHelp(C0002T.mHelpPoint[this.Step][this.Next], this.cmdNext, PaintInfoGameScreen.xPointMove - 45, (PaintInfoGameScreen.yPointMove - PaintInfoGameScreen.wArrowMove) - 5, 2, false, 90);
                            GameCanvas.currentDialog = msgDialog;
                            return;
                        }
                        return;
                    }
                    if (this.Next == 3) {
                        strArr = C0002T.mHelpPoint;
                        break;
                    }
                    break;
                case 1:
                    if (this.Next == 0) {
                        GameCanvas.end_Dialog_Help();
                        if (this.Next < C0002T.mHelpPoint[this.Step].length && C0002T.mHelpPoint[this.Step][this.Next].length() > 0) {
                            MsgDialog msgDialog2 = new MsgDialog();
                            msgDialog2.setDiaHelp(C0002T.mHelpPoint[this.Step][this.Next], this.cmdNext, PaintInfoGameScreen.xPointKill - 40, PaintInfoGameScreen.yPointKill - 40, 2, false, 80);
                            GameCanvas.currentDialog = msgDialog2;
                            return;
                        }
                        return;
                    }
                    if (this.Next == 8) {
                        GameCanvas.end_Dialog_Help();
                        if (this.Next < C0002T.mHelpPoint[this.Step].length && C0002T.mHelpPoint[this.Step][this.Next].length() > 0) {
                            MsgDialog msgDialog3 = new MsgDialog();
                            msgDialog3.setDiaHelp(C0002T.mHelpPoint[this.Step][this.Next], this.cmdNext, PaintInfoGameScreen.mPosOther[0][0], PaintInfoGameScreen.mPosOther[0][1] + 22, 3, false, 90);
                            GameCanvas.currentDialog = msgDialog3;
                            return;
                        }
                        return;
                    }
                    if (this.Next == 9) {
                        GameCanvas.end_Dialog_Help();
                        if (this.Next < C0002T.mHelpPoint[this.Step].length && C0002T.mHelpPoint[this.Step][this.Next].length() > 0) {
                            this.f72p = new Point();
                            this.f72p.f225x = PaintInfoGameScreen.mPosOther[0][0];
                            this.f72p.f229w = 80;
                            this.strpopup = mFont.tahoma_7_black.splitFontArray(C0002T.mHelpPoint[this.Step][this.Next], this.f72p.f229w);
                            this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
                            this.f72p.f226y = PaintInfoGameScreen.mPosOther[0][1] + 22 + this.f72p.f230h;
                            this.f72p.fRe = 3;
                            this.f72p.dis = 1;
                            this.f72p.frame = 1;
                            return;
                        }
                        return;
                    }
                    break;
                case 2:
                    switch (this.Next) {
                        case 2:
                        case 3:
                        case 7:
                            strArr = C0002T.mHelpPoint;
                            break;
                        case 4:
                        case 9:
                        case 10:
                            GameCanvas.end_Dialog_Help();
                            if (this.Next < C0002T.mHelpPoint[this.Step].length && C0002T.mHelpPoint[this.Step][this.Next].length() > 0) {
                                this.f72p = new Point();
                                this.f72p.f225x = MainTabNew.m8gI().xTab + MainTabNew.wOneItem + (MainTabNew.wOne5 * 4);
                                this.f72p.f229w = 80;
                                this.strpopup = mFont.tahoma_7_black.splitFontArray(C0002T.mHelpPoint[this.Step][this.Next], this.f72p.f229w);
                                this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
                                this.f72p.f226y = MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + this.f72p.f230h;
                                this.f72p.fRe = 3;
                                this.f72p.dis = 1;
                                this.f72p.frame = 1;
                            }
                            this.idTabHelp = 0;
                            return;
                    }
                case 3:
                    switch (this.Next) {
                        case 4:
                            if (!GameCanvas.isVNLanguage && !IndoServer.isIndoSv) {
                                GameCanvas.end_Dialog_Help();
                                int i = 3;
                                int i2 = 0;
                                while (true) {
                                    if (i2 < Item.VecInvetoryPlayer.size()) {
                                        if (((MainItem) Item.VecInvetoryPlayer.elementAt(i2)).ItemCatagory != 3) {
                                            i2++;
                                        } else {
                                            i = i2 + 1;
                                        }
                                    }
                                }
                                mSystem.println(new StringBuffer().append("index ").append(i).toString());
                                if (this.Next < C0002T.mHelpPoint[this.Step].length && C0002T.mHelpPoint[this.Step][this.Next].length() > 0) {
                                    this.f72p = new Point();
                                    this.f72p.f225x = ((MainTabNew.m8gI().xTab + (MainTabNew.wOneItem * i)) - 40) + (MainTabNew.wOne5 * 4);
                                    this.f72p.f229w = 80;
                                    this.strpopup = mFont.tahoma_7_black.splitFontArray(C0002T.mHelpPoint[this.Step][this.Next], this.f72p.f229w);
                                    this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
                                    this.f72p.f226y = MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + this.f72p.f230h;
                                    this.f72p.fRe = 5;
                                    this.f72p.dis = 1;
                                    this.f72p.frame = 1;
                                }
                                this.idTabHelp = 0;
                                return;
                            }
                            GameCanvas.end_Dialog_Help();
                            if (this.Next < C0002T.mHelpPoint[this.Step].length && C0002T.mHelpPoint[this.Step][this.Next].length() > 0) {
                                this.f72p = new Point();
                                this.f72p.f225x = ((MainTabNew.m8gI().xTab + (MainTabNew.wOneItem * 3)) - 40) + (MainTabNew.wOne5 * 4);
                                this.f72p.f229w = 80;
                                this.strpopup = mFont.tahoma_7_black.splitFontArray(C0002T.mHelpPoint[this.Step][this.Next], this.f72p.f229w);
                                this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
                                this.f72p.f226y = MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + this.f72p.f230h;
                                this.f72p.fRe = 5;
                                this.f72p.dis = 1;
                                this.f72p.frame = 1;
                            }
                            this.idTabHelp = 0;
                            return;
                        case 8:
                            strArr = C0002T.mHelpPoint;
                            break;
                    }
                case 4:
                    if (this.Next == 9) {
                        GameCanvas.end_Dialog_Help();
                        if (this.Next < C0002T.mHelpPoint[this.Step].length && C0002T.mHelpPoint[this.Step][this.Next].length() > 0) {
                            this.f72p = new Point();
                            this.f72p.f225x = TabScreenNew.xback;
                            this.f72p.f226y = TabScreenNew.yback - iCommand.hButtonCmd;
                            this.f72p.f229w = 80;
                            this.strpopup = mFont.tahoma_7_black.splitFontArray(C0002T.mHelpPoint[this.Step][this.Next], this.f72p.f229w);
                            this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
                            this.f72p.fRe = 0;
                            this.f72p.dis = 1;
                            this.f72p.frame = 1;
                        }
                        this.idTabHelp = -1;
                        return;
                    }
                    break;
                case 5:
                    switch (this.Next) {
                        case 1:
                            GameCanvas.end_Dialog_Help();
                            if (this.Next < C0002T.mHelpPoint[this.Step].length && C0002T.mHelpPoint[this.Step][this.Next].length() > 0) {
                                MsgDialog msgDialog4 = new MsgDialog();
                                String str = C0002T.mHelpPoint[this.Step][this.Next];
                                iCommand icommand = this.cmdNext;
                                int i3 = GameCanvas.f180w - 96;
                                int i4 = GameCanvas.minimap.maxY;
                                MiniMap miniMap = GameCanvas.minimap;
                                msgDialog4.setDiaHelp(str, icommand, i3, (i4 * MiniMap.wMini) + 16, 5, false, 90);
                                GameCanvas.currentDialog = msgDialog4;
                                break;
                            }
                            break;
                        case 2:
                            GameCanvas.end_Dialog_Help();
                            if (this.Next < C0002T.mHelpPoint[this.Step].length && C0002T.mHelpPoint[this.Step][this.Next].length() > 0) {
                                MsgDialog msgDialog5 = new MsgDialog();
                                String str2 = C0002T.mHelpPoint[this.Step][this.Next];
                                iCommand icommand2 = this.cmdNext;
                                int i5 = GameCanvas.f180w - 96;
                                int i6 = GameCanvas.minimap.maxY;
                                MiniMap miniMap2 = GameCanvas.minimap;
                                msgDialog5.setDiaHelp(str2, icommand2, i5, (i6 * MiniMap.wMini) + 16, 6, false, 90);
                                GameCanvas.currentDialog = msgDialog5;
                            }
                            GameCanvas.minimap.setPoint(51, 2, GameCanvas.loadmap.idMap);
                            break;
                        case 4:
                            GameCanvas.end_Dialog_Help();
                            if (this.Next < C0002T.mHelpPoint[this.Step].length && C0002T.mHelpPoint[this.Step][this.Next].length() > 0) {
                                MsgDialog msgDialog6 = new MsgDialog();
                                String str3 = C0002T.mHelpPoint[this.Step][this.Next];
                                iCommand icommand3 = this.cmdNext;
                                int i7 = GameCanvas.f180w;
                                int i8 = GameCanvas.minimap.maxX;
                                MiniMap miniMap3 = GameCanvas.minimap;
                                msgDialog6.setDiaHelp(str3, icommand3, (i7 - (i8 * MiniMap.wMini)) - 96, 45, 4, false, 90);
                                GameCanvas.currentDialog = msgDialog6;
                                break;
                            }
                            break;
                        case 5:
                            GameCanvas.end_Dialog_Help();
                            if (this.Next < C0002T.mHelpPoint[this.Step].length && C0002T.mHelpPoint[this.Step][this.Next].length() > 0) {
                                MsgDialog msgDialog7 = new MsgDialog();
                                msgDialog7.setDiaHelp(C0002T.mHelpPoint[this.Step][this.Next], this.cmdNext, (PaintInfoGameScreen.mPosOther[3][0] - 96) + 25, PaintInfoGameScreen.mPosOther[3][1] - 10, 1, false, 90);
                                GameCanvas.currentDialog = msgDialog7;
                                break;
                            }
                            break;
                        case 6:
                            GameCanvas.end_Dialog_Help();
                            if (this.Next < C0002T.mHelpPoint[this.Step].length && C0002T.mHelpPoint[this.Step][this.Next].length() > 0) {
                                MsgDialog msgDialog8 = new MsgDialog();
                                msgDialog8.setDiaHelp(C0002T.mHelpPoint[this.Step][this.Next], this.cmdNext, (PaintInfoGameScreen.mPosOther[2][0] - 96) + 25, PaintInfoGameScreen.mPosOther[2][1] - 10, 1, false, 90);
                                GameCanvas.currentDialog = msgDialog8;
                                break;
                            }
                            break;
                        case 7:
                            GameCanvas.end_Dialog_Help();
                            if (this.Next < C0002T.mHelpPoint[this.Step].length && C0002T.mHelpPoint[this.Step][this.Next].length() > 0) {
                                MsgDialog msgDialog9 = new MsgDialog();
                                msgDialog9.setDiaHelp(C0002T.mHelpPoint[this.Step][this.Next], this.cmdNext, PaintInfoGameScreen.mPosOther[1][0], PaintInfoGameScreen.mPosOther[1][1] + 45, 3, false, 90);
                                GameCanvas.currentDialog = msgDialog9;
                                break;
                            }
                            break;
                    }
                case 6:
                    if (this.Next == 2) {
                        GameCanvas.end_Dialog_Help();
                        if (this.Next < C0002T.mHelpPoint[this.Step].length && C0002T.mHelpPoint[this.Step][this.Next].length() > 0) {
                            this.f72p = new Point();
                            this.f72p.f225x = PaintInfoGameScreen.mPosOther[0][0];
                            this.f72p.f229w = 80;
                            this.strpopup = mFont.tahoma_7_black.splitFontArray(C0002T.mHelpPoint[this.Step][this.Next], this.f72p.f229w);
                            this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
                            this.f72p.f226y = PaintInfoGameScreen.mPosOther[0][1] + this.f72p.f230h + 22;
                            this.f72p.fRe = 3;
                            this.f72p.dis = 1;
                            this.f72p.frame = 1;
                            return;
                        }
                        return;
                    }
                    break;
                case 7:
                    switch (this.Next) {
                        case 6:
                        case 9:
                            strArr = C0002T.mHelpPoint;
                            break;
                    }
                case 8:
                    if (this.Next == 7) {
                        strArr = C0002T.mHelpPoint;
                        break;
                    }
                    break;
                case 9:
                    if (this.Next == 1 || this.Next == 5) {
                        strArr = C0002T.mHelpPoint;
                        break;
                    }
                    break;
            }
        }
        switch (this.Step) {
            case 0:
                Step0(strArr);
                break;
            case 1:
                Step1(strArr);
                break;
            case 2:
                Step2(strArr);
                break;
            case 3:
                Step3(strArr);
                break;
            case 4:
                Step4(strArr);
                break;
            case 5:
                Step5(strArr);
                break;
            case 6:
                Step6(strArr);
                break;
            case 7:
                Step7(strArr);
                break;
            case 8:
                Step8(strArr);
                break;
            case 9:
                Step9(strArr);
                break;
        }
    }

    public boolean isSave() {
        switch (this.Step) {
            case 0:
                if (this.Next == 0) {
                }
                break;
            case 1:
                if (this.Next == 1 || this.Next == 9) {
                }
                break;
            case 2:
                if (this.Next == 4 || this.Next == 9) {
                }
                break;
            case 3:
                if (this.Next == 4 || this.Next == 8) {
                }
                break;
            case 5:
                if (this.Next == 0 || this.Next == 8) {
                }
                break;
            case 6:
                if (this.Next == 2 || this.Next == 0) {
                }
                break;
            case 7:
                if (this.Next == 6 || this.Next == 9) {
                }
                break;
            case 8:
                if (this.Next == 7 || this.Next == 10) {
                }
                break;
            case 9:
                if (this.Next == 1 || this.Next == 7) {
                }
                break;
        }
        return true;
    }

    public boolean setStep_Next(int i, int i2) {
        if (this.Step == i && this.Next == i2) {
            return true;
        }
        return false;
    }

    public void updateHelp() {
        if (this.Step >= 0) {
            if (this.timeReset > 0) {
                this.timeReset--;
                if (this.timeReset == 1) {
                    if (GameCanvas.currentDialog == null && GameCanvas.subDialog == null) {
                        setNext();
                    } else {
                        this.timeReset = 20;
                    }
                }
            }
            switch (this.Step) {
                case 0:
                    if (this.Next == -4 || this.Next == -2) {
                        this.tickBegin++;
                        if (GameCanvas.currentDialog != null) {
                            GameCanvas.end_Dialog_Help();
                            this.timeReset = -1;
                        }
                        if (GameScreen.player.posTransRoad == null && this.tickBegin > 10) {
                            this.Next++;
                            setNext();
                        }
                    }
                    if (this.Next == -3) {
                        if (GameCanvas.currentDialog != null) {
                            GameCanvas.end_Dialog_Help();
                        }
                        this.tickBegin++;
                        if (this.tickBegin > 60) {
                            this.Next++;
                            setNext();
                            this.tickBegin = 0;
                        }
                    }
                    if (this.Next == 5 && this.f72p != null && CRes.abs(GameScreen.player.f74x - this.f72p.f225x) < 10 && CRes.abs(GameScreen.player.f75y - this.f72p.f226y) < 10) {
                        this.f72p = null;
                        NextStep();
                        setNext();
                        break;
                    }
                    break;
                case 2:
                    if (!GameCanvas.menu2.isShowMenu && this.Next == 10) {
                        this.Next = 9;
                        break;
                    }
                    break;
                case 5:
                    if (this.Next == 0) {
                        this.tickBegin++;
                        if (this.tickBegin >= 20) {
                            this.Next++;
                            setNext();
                            break;
                        }
                    }
                    break;
            }
        }
    }

    public void paintHelpFrist(mGraphics mgraphics) {
        if (this.Step != 2 && this.Step != 3 && this.Step != 4 && this.Step != 7 && this.Step != 8) {
            if ((this.Step != 9 || this.Next == 0) && this.f72p != null && this.f72p.dis == 0 && this.fra != null) {
                this.fra.drawFrame((GameCanvas.gameTick / 2) % this.fra.nFrame, this.f72p.f225x, this.f72p.f226y, 0, 3, mgraphics);
            }
        }
    }

    public void paintHelpLast(mGraphics mgraphics) {
        if (this.Step != 2 && this.Step != 3 && this.Step != 4 && this.Step != 7 && this.Step != 8) {
            if ((this.Step != 9 || this.Next == 0) && this.f72p != null && this.f72p.dis == 1) {
                if (this.f72p.frame == 0) {
                    if (this.fra != null) {
                        this.fra.drawFrame((GameCanvas.gameTick / 2) % this.fra.nFrame, this.f72p.f225x, this.f72p.f226y, 0, 3, mgraphics);
                    }
                } else if (this.f72p.frame == 1) {
                    paintPopup(mgraphics, this.f72p.f225x, this.f72p.f226y, this.f72p.f229w, this.f72p.f230h, this.f72p.fRe, this.strpopup);
                }
            }
        }
    }

    public int itemMenuHelp() {
        switch (this.Step) {
            case 1:
                if (this.Next == 9) {
                }
                break;
            case 2:
                if (this.Next != 4) {
                    if (this.Next != 9) {
                        if (this.Next == 10) {
                        }
                    }
                }
                break;
            case 3:
                if (this.Next == 4) {
                }
                break;
            case 6:
                if (this.Next == 2) {
                }
                break;
        }
        return 0;
    }

    public void itemTabHelp(mGraphics mgraphics, Item item, byte b) {
        if (this.idTabHelp != b && this.idTabHelp != -1) {
        }
        switch (this.Step) {
            case 2:
                if (GameCanvas.isVNLanguage || IndoServer.isIndoSv || (this.Next != 4 && this.Next != 9)) {
                    if ((this.Next == 4 || this.Next == 9) && item != null && item.ItemCatagory == 4 && item.typePotion == 0 && this.f72p != null) {
                        GameCanvas.resetTrans(mgraphics);
                        paintPopup(mgraphics, this.f72p.f225x, this.f72p.f226y, this.f72p.f229w, this.f72p.f230h, this.f72p.fRe, this.strpopup);
                        break;
                    }
                }
                break;
            case 3:
                if (this.Next == 4 && item != null && item.ItemCatagory == 3 && item.type_Only_Item == 6 && this.f72p != null) {
                    GameCanvas.resetTrans(mgraphics);
                    paintPopup(mgraphics, this.f72p.f225x, this.f72p.f226y, this.f72p.f229w, this.f72p.f230h, this.f72p.fRe, this.strpopup);
                }
                if (this.Next == 8 && this.f72p != null) {
                    GameCanvas.resetTrans(mgraphics);
                    paintPopup(mgraphics, this.f72p.f225x, this.f72p.f226y, this.f72p.f229w, this.f72p.f230h, this.f72p.fRe, this.strpopup);
                    break;
                }
                break;
            case 4:
                if (this.Next == 9 && this.f72p != null) {
                    GameCanvas.resetTrans(mgraphics);
                    paintPopup(mgraphics, this.f72p.f225x, this.f72p.f226y, this.f72p.f229w, this.f72p.f230h, this.f72p.fRe, this.strpopup);
                    break;
                }
                break;
            case 7:
                if ((this.Next == 6 || this.Next == 9) && this.f72p != null) {
                    GameCanvas.resetTrans(mgraphics);
                    paintPopup(mgraphics, this.f72p.f225x, this.f72p.f226y, this.f72p.f229w, this.f72p.f230h, this.f72p.fRe, this.strpopup);
                    break;
                }
                break;
            case 8:
                if (this.Next == 7 && this.f72p != null) {
                    GameCanvas.resetTrans(mgraphics);
                    paintPopup(mgraphics, this.f72p.f225x, this.f72p.f226y, this.f72p.f229w, this.f72p.f230h, this.f72p.fRe, this.strpopup);
                    break;
                }
                break;
            case 9:
                if (this.Next == 1 && this.f72p != null) {
                    GameCanvas.resetTrans(mgraphics);
                    paintPopup(mgraphics, this.f72p.f225x, this.f72p.f226y, this.f72p.f229w, this.f72p.f230h, this.f72p.fRe, this.strpopup);
                    break;
                }
                break;
        }
    }

    public static void paintPopup(mGraphics mgraphics, int i, int i2, int i3, int i4, int i5, String[] strArr) {
        int i6 = i2 - i4;
        mgraphics.setColor(color[0]);
        mgraphics.fillRect(i - 3, i6, i3 + 6, i4, false);
        mgraphics.fillRect(i, i6 - 3, i3, i4 + 6, false);
        mgraphics.setColor(color[1]);
        mgraphics.fillRect(i - 2, i6 - 2, i3 + 4, i4 + 4, false);
        mgraphics.drawRegion(PopupChat.mPopup[0], 0, 0, 3, 3, 0, i - 3, i6 - 3, 0, false);
        mgraphics.drawRegion(PopupChat.mPopup[0], 0, 3, 3, 3, 0, i + i3, i6 - 3, 0, false);
        mgraphics.drawRegion(PopupChat.mPopup[0], 0, 9, 3, 3, 0, i - 3, i6 + i4, 0, false);
        mgraphics.drawRegion(PopupChat.mPopup[0], 0, 6, 3, 3, 0, i + i3, i6 + i4, 0, false);
        for (int i7 = 0; i7 < strArr.length; i7++) {
            mFont.tahoma_7_black.drawString(mgraphics, strArr[i7], i + (i3 / 2), i6 + 1 + (i7 * GameCanvas.hText), 2, false);
        }
        switch (i5) {
            case 0:
                mgraphics.drawImage(AvMain.imgSelect, i, i2 + 2 + ((GameCanvas.gameTick / 2) % 4), 0, false);
                break;
            case 1:
                mgraphics.drawImage(AvMain.imgSelect, i + i3, i2 + 2 + ((GameCanvas.gameTick / 2) % 4), 24, false);
                break;
            case 2:
                if (GameCanvas.isVNLanguage || IndoServer.isIndoSv || GameScreen.help.Step != 8 || (GameScreen.help.Next != 3 && GameScreen.help.Next != 2)) {
                    mgraphics.drawImage(AvMain.imgSelect, i + (i3 / 2), i2 + 2 + ((GameCanvas.gameTick / 2) % 4), 17, false);
                    break;
                }
                break;
            case 3:
                mgraphics.drawRegion(AvMain.imgSelect, 0, 0, 12, 16, 1, i, ((i2 - i4) - 20) + 2 + ((GameCanvas.gameTick / 2) % 4), 0, false);
                break;
            case 4:
                mgraphics.drawRegion(AvMain.imgSelect, 0, 0, 12, 16, 1, i + i3, ((i2 - i4) - 20) + 2 + ((GameCanvas.gameTick / 2) % 4), 24, false);
                break;
            case 5:
                mgraphics.drawRegion(AvMain.imgSelect, 0, 0, 12, 16, 1, i + (i3 / 2), ((i2 - i4) - 20) + 2 + ((GameCanvas.gameTick / 2) % 4), 17, false);
                break;
            case 7:
                mgraphics.drawRegion(AvMain.imgSelect, 0, 0, 12, 16, 5, i + ((GameCanvas.gameTick / 2) % 4), i2 - (i4 / 2), 10, false);
                break;
            case 8:
                mgraphics.drawRegion(AvMain.imgSelect, 0, 0, 12, 16, 4, i + i3 + 1 + ((GameCanvas.gameTick / 2) % 4), i2 - (i4 / 2), 6, false);
                break;
        }
    }

    public void Step0(String[][] strArr) {
        switch (this.Next) {
            case -5:
                break;
            case -4:
                this.tickBegin = 0;
                SaveBegin();
                Player.isLockKey = true;
                GameScreen.player.posTransRoad = null;
                GameScreen.player.resetAction();
                GameScreen.player.toX = GameScreen.player.f74x;
                GameScreen.player.toY = GameScreen.player.f75y;
                GameScreen.player.xStopMove = 0;
                GameScreen.player.yStopMove = 0;
                GameScreen.player.posTransRoad = GameCanvas.game.updateFindRoad(10, 16, GameScreen.player.f74x / LoadMap.wTile, GameScreen.player.f75y / LoadMap.wTile, 40);
                break;
            case -3:
                Player.isLockKey = true;
                GameScreen.player.posTransRoad = null;
                GameScreen.player.resetAction();
                GameScreen.player.Direction = 2;
                GameScreen.player.strChatPopup = "...";
                this.tickBegin = 0;
                break;
            case -2:
                this.tickBegin = 0;
                Player.isLockKey = true;
                GameScreen.player.resetAction();
                GameScreen.player.toX = GameScreen.player.f74x;
                GameScreen.player.toY = GameScreen.player.f75y;
                GameScreen.player.xStopMove = 0;
                GameScreen.player.yStopMove = 0;
                GameScreen.player.posTransRoad = GameCanvas.game.updateFindRoad(24 + CRes.random_Am_0(3), 21 + CRes.random_Am_0(3), GameScreen.player.f74x / LoadMap.wTile, GameScreen.player.f75y / LoadMap.wTile, 40);
                break;
            case -1:
                mVector mvector = new mVector("MainHelp menu");
                mvector.addElement(this.cmdyes);
                mvector.addElement(new iCommand(C0002T.f246no, 1, this));
                GameCanvas.start_Select_Dialog(C0002T.hoihelp, mvector);
                break;
            case 0:
            case 1:
            case 2:
            case 3:
            default:
                GameCanvas.end_Dialog_Help();
                dialogCenter(strArr);
                break;
            case 4:
                if (Player.isLockKey) {
                    Player.isLockKey = false;
                }
                if (!Player.isSendMove) {
                    Player.isSendMove = true;
                }
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    int i = GameCanvas.f180w - 30;
                    if (i > 200) {
                        i = 200;
                    }
                    int i2 = GameCanvas.f182hw - (i / 2);
                    int i3 = GameCanvas.f181h - (GameCanvas.hCommand * 2);
                    MsgDialog msgDialog = new MsgDialog();
                    msgDialog.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, i2, i3, -1, false, i);
                    GameCanvas.currentDialog = msgDialog;
                }
                int i4 = 80;
                int i5 = 0;
                boolean z = false;
                do {
                    i5++;
                    int random_Am = GameScreen.player.f74x + CRes.random_Am(40, i4);
                    int random_Am2 = GameScreen.player.f75y + CRes.random_Am(40, i4);
                    int tile = GameCanvas.loadmap.getTile(random_Am, random_Am2);
                    if (GameScreen.setIsInScreen(random_Am, random_Am2) && tile != -1 && tile != 1) {
                        z = true;
                        this.f72p = new Point();
                        this.f72p.f225x = random_Am;
                        this.f72p.f226y = random_Am2;
                        this.f72p.dis = 0;
                        this.f72p.frame = 0;
                        this.fra = PaintInfoGameScreen.fraFocusIngame;
                    }
                    if (i5 > 10) {
                        i4 += 10;
                        i5 = 0;
                    }
                } while (!z);
                break;
            case 5:
                GameCanvas.end_Dialog_Help();
                break;
        }
    }

    public void Step1(String[][] strArr) {
        switch (this.Next) {
            case 2:
                GameCanvas.end_Dialog_Help();
                break;
            case 5:
                GameCanvas.end_Dialog_Help();
                break;
            case 9:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    this.f72p = new Point();
                    this.f72p.f225x = 3;
                    this.f72p.f226y = (GameCanvas.f181h - GameCanvas.hCommand) - 14;
                    this.f72p.f229w = 80;
                    this.strpopup = mFont.tahoma_7_black.splitFontArray(strArr[this.Step][this.Next], this.f72p.f229w);
                    this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
                    this.f72p.fRe = 2;
                    this.f72p.dis = 1;
                    this.f72p.frame = 1;
                    break;
                }
                break;
            default:
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    int i = GameCanvas.f180w - 30;
                    if (i > 200) {
                        i = 200;
                    }
                    int i2 = GameCanvas.f182hw - (i / 2);
                    int i3 = GameCanvas.f181h - (GameCanvas.hCommand * 2);
                    MsgDialog msgDialog = new MsgDialog();
                    msgDialog.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, i2, i3, -1, false, i);
                    GameCanvas.currentDialog = msgDialog;
                    break;
                }
                break;
        }
    }

    private void Step2(String[][] strArr) {
        switch (this.Next) {
            case 0:
                GameCanvas.end_Dialog_Help();
                leftTab(0, strArr);
                break;
            case 1:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog = new MsgDialog();
                    msgDialog.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, MainTabNew.m8gI().xTab + MainTabNew.wOneItem + (MainTabNew.wOne5 * 3), MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + 22, 5, false, 90);
                    GameCanvas.currentDialog = msgDialog;
                    break;
                }
                break;
            case 2:
            case 3:
            case 7:
            case 8:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog2 = new MsgDialog();
                    msgDialog2.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, MainTabNew.m8gI().xTab + MainTabNew.wOneItem + (MainTabNew.wOne5 * 4), MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + 22, 3, false, 90);
                    GameCanvas.currentDialog = msgDialog2;
                    break;
                }
                break;
            case 4:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    this.f72p = new Point();
                    this.f72p.f225x = GameCanvas.f182hw - 40;
                    this.f72p.f226y = (GameCanvas.f181h - GameCanvas.hCommand) - 14;
                    this.f72p.f229w = 80;
                    this.strpopup = mFont.tahoma_7_black.splitFontArray(strArr[this.Step][this.Next], this.f72p.f229w);
                    this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
                    this.f72p.fRe = 2;
                    this.f72p.dis = 1;
                    this.f72p.frame = 1;
                }
                this.idTabHelp = 0;
                break;
            case 5:
            case 6:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog3 = new MsgDialog();
                    msgDialog3.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, GameCanvas.f182hw - 45, MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + 22, 6, false, 90);
                    GameCanvas.currentDialog = msgDialog3;
                    break;
                }
                break;
            case 9:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    this.f72p = new Point();
                    this.f72p.f225x = GameCanvas.f182hw - 40;
                    this.f72p.f226y = (GameCanvas.f181h - GameCanvas.hCommand) - 14;
                    this.f72p.f229w = 80;
                    this.strpopup = mFont.tahoma_7_black.splitFontArray(strArr[this.Step][this.Next], this.f72p.f229w);
                    this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
                    this.f72p.fRe = 2;
                    this.f72p.dis = 1;
                    this.f72p.frame = 1;
                }
                this.idTabHelp = 0;
                break;
            case 10:
                this.idTabHelp = 0;
                break;
            case 11:
            case 12:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog4 = new MsgDialog();
                    msgDialog4.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, MainTabNew.m8gI().xTab + (MainTabNew.wOneItem * 2) + (MainTabNew.wOne5 * 4), MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + 22, 3, false, 90);
                    GameCanvas.currentDialog = msgDialog4;
                    break;
                }
                break;
            case 13:
                NextStep();
                setNext();
                break;
        }
    }

    public void Step3(String[][] strArr) {
        switch (this.Next) {
            case 0:
            case 1:
            case 2:
            case 3:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog = new MsgDialog();
                    msgDialog.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, ((MainTabNew.m8gI().xTab + (MainTabNew.wOneItem * 3)) - 40) + (MainTabNew.wOne5 * 4), MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + 22, 5, false, 90);
                    GameCanvas.currentDialog = msgDialog;
                    break;
                }
                break;
            case 4:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    this.f72p = new Point();
                    this.f72p.f225x = GameCanvas.f182hw - 40;
                    this.f72p.f226y = (GameCanvas.f181h - GameCanvas.hCommand) - 14;
                    this.f72p.f229w = 80;
                    this.strpopup = mFont.tahoma_7_black.splitFontArray(strArr[this.Step][this.Next], this.f72p.f229w);
                    this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
                    this.f72p.fRe = 2;
                    this.f72p.dis = 1;
                    this.f72p.frame = 1;
                }
                this.idTabHelp = 0;
                break;
            case 5:
            case 6:
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog2 = new MsgDialog();
                    msgDialog2.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, GameCanvas.f182hw - 45, MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + 22, 6, false, 90);
                    GameCanvas.currentDialog = msgDialog2;
                    break;
                }
                break;
            case 7:
                GameCanvas.end_Dialog_Help();
                leftTab(1, strArr);
                break;
            case 8:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    this.f72p = new Point();
                    this.f72p.f225x = MainTabNew.m8gI().xTab + MainTabNew.wOne5 + (MainTabNew.wOne5 / 2);
                    this.f72p.f229w = 80;
                    this.strpopup = mFont.tahoma_7_black.splitFontArray(strArr[this.Step][this.Next], this.f72p.f229w);
                    this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
                    this.f72p.f226y = MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + 16 + this.f72p.f230h;
                    this.f72p.fRe = 3;
                    this.f72p.dis = 1;
                    this.f72p.frame = 1;
                }
                this.idTabHelp = -1;
                break;
        }
    }

    public void Step4(String[][] strArr) {
        switch (this.Next) {
            case 0:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog = new MsgDialog();
                    msgDialog.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, GameCanvas.f182hw - 45, MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + 22, 6, false, 90);
                    GameCanvas.currentDialog = msgDialog;
                    break;
                }
                break;
            case 1:
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog2 = new MsgDialog();
                    msgDialog2.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, MainTabNew.m8gI().xTab + MainTabNew.wOneItem + (MainTabNew.wOne5 * 3) + ((MainTabNew.wblack / 5) * 2) + TabMySeftNew.delta + 16, MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + (((MainTabNew.hblack / 12) * 8) / 2), 7, false, 90);
                    GameCanvas.currentDialog = msgDialog2;
                    break;
                }
                break;
            case 2:
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog3 = new MsgDialog();
                    msgDialog3.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, ((((MainTabNew.m8gI().xTab + MainTabNew.wOneItem) + (MainTabNew.wOne5 * 3)) + ((MainTabNew.wblack / 5) * 2)) + TabMySeftNew.delta) - 16, MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + (((MainTabNew.hblack / 12) * 8) / 2), 8, false, 90);
                    GameCanvas.currentDialog = msgDialog3;
                    break;
                }
                break;
            case 3:
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog4 = new MsgDialog();
                    msgDialog4.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, MainTabNew.m8gI().xTab + (MainTabNew.wblack / 2), (((((MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5)) + MainTabNew.wOneItem) + MainTabNew.hblack) - (MainTabNew.wOneItem * 2)) - MainTabNew.wOne5) - 20, 2, false, 90);
                    GameCanvas.currentDialog = msgDialog4;
                    break;
                }
                break;
            case 9:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    this.f72p = new Point();
                    this.f72p.f225x = GameCanvas.f180w - 83;
                    this.f72p.f226y = (GameCanvas.f181h - GameCanvas.hCommand) - 14;
                    this.f72p.f229w = 80;
                    this.strpopup = mFont.tahoma_7_black.splitFontArray(strArr[this.Step][this.Next], this.f72p.f229w);
                    this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
                    this.f72p.fRe = 2;
                    this.f72p.dis = 1;
                    this.f72p.frame = 1;
                }
                this.idTabHelp = -1;
                break;
        }
    }

    public void Step5(String[][] strArr) {
        switch (this.Next) {
            case 0:
                if (GameCanvas.isVNLanguage || IndoServer.isIndoSv) {
                    GameCanvas.end_Dialog_Help();
                    this.f72p = null;
                    GameScreen.player.strChatPopup = C0002T.timduongtoilang;
                    this.tickBegin = 0;
                    break;
                }
                break;
            case 1:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog = new MsgDialog();
                    String str = strArr[this.Step][this.Next];
                    iCommand icommand = this.cmdNext;
                    int i = GameCanvas.f180w - 96;
                    int i2 = GameCanvas.f181h - 23;
                    int i3 = GameCanvas.minimap.maxY;
                    MiniMap miniMap = GameCanvas.minimap;
                    msgDialog.setDiaHelp(str, icommand, i, (i2 - (i3 * MiniMap.wMini)) - 16, 2, false, 90);
                    GameCanvas.currentDialog = msgDialog;
                    break;
                }
                break;
            case 2:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog2 = new MsgDialog();
                    String str2 = strArr[this.Step][this.Next];
                    iCommand icommand2 = this.cmdNext;
                    int i4 = GameCanvas.f180w - 96;
                    int i5 = GameCanvas.f181h - 23;
                    int i6 = GameCanvas.minimap.maxY;
                    MiniMap miniMap2 = GameCanvas.minimap;
                    msgDialog2.setDiaHelp(str2, icommand2, i4, (i5 - (i6 * MiniMap.wMini)) - 16, -1, false, 90);
                    GameCanvas.currentDialog = msgDialog2;
                }
                GameCanvas.minimap.setPoint(51, 2, GameCanvas.loadmap.idMap);
                break;
            case 3:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog3 = new MsgDialog();
                    msgDialog3.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, 3, 60, 5, false, 90);
                    GameCanvas.currentDialog = msgDialog3;
                    break;
                }
                break;
            case 4:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog4 = new MsgDialog();
                    msgDialog4.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, GameCanvas.f180w - 93, 45, 5, false, 90);
                    GameCanvas.currentDialog = msgDialog4;
                    break;
                }
                break;
            case 5:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog5 = new MsgDialog();
                    msgDialog5.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, GameCanvas.f180w - 93, GameCanvas.f181h - GameCanvas.hCommand, 2, false, 90);
                    GameCanvas.currentDialog = msgDialog5;
                    break;
                }
                break;
            case 6:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog6 = new MsgDialog();
                    msgDialog6.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, GameCanvas.f182hw - 45, ((GameCanvas.f181h - GameCanvas.hCommand) - 14) - 25, 2, false, 90);
                    GameCanvas.currentDialog = msgDialog6;
                    break;
                }
                break;
            case 7:
                GameCanvas.end_Dialog_Help();
                dialogCenter(strArr);
                break;
            case 8:
                if (!GameCanvas.isVNLanguage && !IndoServer.isIndoSv) {
                    if (!this.isStepp5) {
                        GameCanvas.end_Dialog_Help();
                        this.f72p = null;
                        GameScreen.player.strChatPopup = C0002T.timduongtoilang;
                        this.tickBegin = 0;
                        GameCanvas.end_Dialog_Help();
                        this.isStepp5 = true;
                        break;
                    }
                } else {
                    GameCanvas.end_Dialog_Help();
                    break;
                }
                break;
        }
    }

    public void Step6(String[][] strArr) {
        switch (this.Next) {
            case 0:
            case 1:
                dialogCenter(strArr);
                break;
            case 2:
                GameCanvas.end_Dialog_Help();
                PopupLeft(strArr);
                break;
        }
    }

    public void Step7(String[][] strArr) {
        switch (this.Next) {
            case 0:
                GameCanvas.end_Dialog_Help();
                leftTab(2, strArr);
                break;
            case 1:
            case 2:
            case 3:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog = new MsgDialog();
                    int i = 20;
                    if (GameCanvas.isTouch) {
                        i = 24;
                    }
                    msgDialog.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, MainTabNew.m8gI().xTab + (MainTabNew.wblack / 2), (i * C0002T.mKyNang.length) + MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + MainTabNew.wOneItem + 20, 5, false, 90);
                    GameCanvas.currentDialog = msgDialog;
                    break;
                }
                break;
            case 4:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog2 = new MsgDialog();
                    int i2 = 20;
                    if (GameCanvas.isTouch) {
                        i2 = 24;
                    }
                    msgDialog2.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, MainTabNew.m8gI().xTab + (MainTabNew.wblack / 2), (i2 * C0002T.mKyNang.length) + MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + MainTabNew.wOneItem, 2, false, 90);
                    GameCanvas.currentDialog = msgDialog2;
                    break;
                }
                break;
            case 5:
            case 7:
            case 8:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog3 = new MsgDialog();
                    msgDialog3.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, GameCanvas.f182hw - 45, MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + 22, 6, false, 90);
                    GameCanvas.currentDialog = msgDialog3;
                    break;
                }
                break;
            case 6:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    int i3 = MainTabNew.m8gI().xTab + (MainTabNew.wblack / 4) + 30;
                    int i4 = MainTabNew.m8gI().yTab + GameCanvas.hText + (GameCanvas.f181h / 5) + 4 + (GameCanvas.isTouch ? 4 : 0);
                    this.f72p = new Point();
                    this.f72p.f225x = i3;
                    this.f72p.f229w = 80;
                    this.strpopup = mFont.tahoma_7_black.splitFontArray(strArr[this.Step][this.Next], this.f72p.f229w);
                    this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
                    this.f72p.f226y = i4;
                    this.f72p.fRe = 2;
                    this.f72p.dis = 1;
                    this.f72p.frame = 1;
                }
                this.idTabHelp = 2;
                break;
            case 9:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    this.f72p = new Point();
                    this.f72p.f225x = MainTabNew.m8gI().xTab + MainTabNew.wOne5 + (MainTabNew.wOne5 / 2);
                    this.f72p.f229w = 80;
                    this.strpopup = mFont.tahoma_7_black.splitFontArray(strArr[this.Step][this.Next], this.f72p.f229w);
                    this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
                    this.f72p.f226y = MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + MainTabNew.wOneItem + (MainTabNew.wOneItem * 3) + 16 + this.f72p.f230h;
                    this.f72p.fRe = 3;
                    this.f72p.dis = 1;
                    this.f72p.frame = 1;
                }
                this.idTabHelp = -1;
                break;
        }
    }

    private void Step8(String[][] strArr) {
        switch (this.Next) {
            case 0:
                if (!GameCanvas.isVNLanguage && !IndoServer.isIndoSv) {
                    GameCanvas.end_Dialog_Help();
                    leftTab(3, strArr);
                    GameCanvas.AllInfo.selectTab = 3;
                    break;
                } else {
                    GameCanvas.end_Dialog_Help();
                    if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                        MsgDialog msgDialog = new MsgDialog();
                        msgDialog.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, GameCanvas.f182hw - 45, MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + 22, 6, false, 90);
                        GameCanvas.currentDialog = msgDialog;
                        break;
                    }
                }
                break;
            case 1:
                if (!GameCanvas.isVNLanguage && !IndoServer.isIndoSv) {
                    GameCanvas.end_Dialog_Help();
                    leftTab(4, strArr);
                    GameCanvas.AllInfo.selectTab = 4;
                    break;
                } else {
                    GameCanvas.end_Dialog_Help();
                    if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                        MsgDialog msgDialog2 = new MsgDialog();
                        msgDialog2.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, MainTabNew.m8gI().xTab + MainTabNew.wOne5 + (MainTabNew.wblack / 2) + (MainTabNew.wblack / 8), MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + MainTabNew.wOneItem + (MainTabNew.hblack / 2), 7, false, 90);
                        GameCanvas.currentDialog = msgDialog2;
                        break;
                    }
                }
                break;
            case 2:
                if (!GameCanvas.isVNLanguage && !IndoServer.isIndoSv) {
                    GameCanvas.end_Dialog_Help();
                    if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                        MsgDialog msgDialog3 = new MsgDialog();
                        msgDialog3.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, MainTabNew.m8gI().xTab + MainTabNew.wOne5 + (MainTabNew.wblack / 2) + (MainTabNew.wblack / 8), MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + MainTabNew.wOneItem + (MainTabNew.hblack / 2), 2, false, 90);
                        GameCanvas.currentDialog = msgDialog3;
                        break;
                    }
                } else {
                    GameCanvas.end_Dialog_Help();
                    if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                        MsgDialog msgDialog4 = new MsgDialog();
                        msgDialog4.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, MainTabNew.m8gI().xTab + MainTabNew.wOne5 + (MainTabNew.wblack / 2) + (MainTabNew.wblack / 8), MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + MainTabNew.wOneItem + (MainTabNew.hblack / 2), 7, false, 90);
                        GameCanvas.currentDialog = msgDialog4;
                        break;
                    }
                }
                break;
            case 3:
                if (!GameCanvas.isVNLanguage && !IndoServer.isIndoSv) {
                    GameCanvas.end_Dialog_Help();
                    if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                        MsgDialog msgDialog5 = new MsgDialog();
                        msgDialog5.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, MainTabNew.m8gI().xTab + MainTabNew.wOne5 + ((MainTabNew.wblack / 4) * 3), MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + MainTabNew.wOneItem + (MainTabNew.hblack / 2), 2, false, 90);
                        GameCanvas.currentDialog = msgDialog5;
                        break;
                    }
                } else {
                    GameCanvas.end_Dialog_Help();
                    if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                        MsgDialog msgDialog6 = new MsgDialog();
                        msgDialog6.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, MainTabNew.m8gI().xTab + MainTabNew.wOne5 + ((MainTabNew.wblack / 4) * 3), MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + MainTabNew.wOneItem + (MainTabNew.hblack / 2), 8, false, 90);
                        GameCanvas.currentDialog = msgDialog6;
                        break;
                    }
                }
                break;
            case 4:
                if (!GameCanvas.isVNLanguage && !IndoServer.isIndoSv) {
                    GameCanvas.end_Dialog_Help();
                    this.Step = -1;
                    this.Next = 0;
                    SaveStep();
                    break;
                } else {
                    GameCanvas.end_Dialog_Help();
                    if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                        MsgDialog msgDialog7 = new MsgDialog();
                        msgDialog7.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, GameCanvas.f182hw - 45, MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + 22, 6, false, 90);
                        GameCanvas.currentDialog = msgDialog7;
                        break;
                    }
                }
                break;
            case 5:
            case 6:
            case 8:
            case 9:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog8 = new MsgDialog();
                    msgDialog8.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, GameCanvas.f182hw - 45, MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + 22, 6, false, 90);
                    GameCanvas.currentDialog = msgDialog8;
                    break;
                }
                break;
            case 7:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    this.f72p = new Point();
                    this.f72p.f225x = MainTabNew.m8gI().xTab + MainTabNew.wOne5 + (MainTabNew.wOne5 / 2) + ((MainTabNew.wblack / 8) * 3);
                    this.f72p.f229w = 80;
                    this.strpopup = mFont.tahoma_7_black.splitFontArray(strArr[this.Step][this.Next], this.f72p.f229w);
                    this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
                    this.f72p.f226y = MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + MainTabNew.wOneItem;
                    this.f72p.fRe = -1;
                    this.f72p.dis = 1;
                    this.f72p.frame = 1;
                }
                this.idTabHelp = 3;
                break;
            case 10:
                GameCanvas.end_Dialog_Help();
                break;
        }
    }

    public void Step9(String[][] strArr) {
        switch (this.Next) {
            case 0:
                GameCanvas.end_Dialog_Help();
                dialogCenter(strArr);
                break;
            case 1:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    this.f72p = new Point();
                    this.f72p.f225x = MainTabNew.m8gI().xTab + MainTabNew.wOne5 + (MainTabNew.wOne5 / 2);
                    this.f72p.f229w = 80;
                    this.strpopup = mFont.tahoma_7_black.splitFontArray(strArr[this.Step][this.Next], this.f72p.f229w);
                    this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
                    this.f72p.f226y = MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 5) + 16 + this.f72p.f230h;
                    this.f72p.fRe = 3;
                    this.f72p.dis = 1;
                    this.f72p.frame = 1;
                }
                this.idTabHelp = -1;
                break;
            case 2:
            case 5:
            case 6:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog = new MsgDialog();
                    msgDialog.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, GameCanvas.f182hw - 45, MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + (MainTabNew.wOneItem * 2) + 22, 6, false, 90);
                    GameCanvas.currentDialog = msgDialog;
                    break;
                }
                break;
            case 3:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog2 = new MsgDialog();
                    msgDialog2.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, ((MainTabNew.m8gI().xTab + MainTabNew.wOneItem) + (MainTabNew.wblack / 4)) - 45, MainTabNew.m8gI().yTab + MainTabNew.wOneItem + (GameCanvas.f181h / 5) + 22, 5, false, 90);
                    GameCanvas.currentDialog = msgDialog2;
                    break;
                }
                break;
            case 4:
                GameCanvas.end_Dialog_Help();
                if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
                    MsgDialog msgDialog3 = new MsgDialog();
                    msgDialog3.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, ((MainTabNew.m8gI().xTab + MainTabNew.wOneItem) + ((MainTabNew.wblack / 4) * 3)) - 45, MainTabNew.m8gI().yTab + MainTabNew.wOneItem + (GameCanvas.f181h / 5) + 22, 5, false, 90);
                    GameCanvas.currentDialog = msgDialog3;
                    break;
                }
                break;
            case 7:
                GameCanvas.end_Dialog_Help();
                this.Step = -1;
                this.Next = 0;
                SaveStep();
                break;
        }
    }

    public void PopupLeft(String[][] strArr) {
        if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
            this.f72p = new Point();
            this.f72p.f225x = 3;
            this.f72p.f226y = (GameCanvas.f181h - GameCanvas.hCommand) - 14;
            this.f72p.f229w = 80;
            this.strpopup = mFont.tahoma_7_black.splitFontArray(strArr[this.Step][this.Next], this.f72p.f229w);
            this.f72p.f230h = this.strpopup.length * GameCanvas.hText;
            this.f72p.fRe = 2;
            this.f72p.dis = 1;
            this.f72p.frame = 1;
        }
    }

    public void dialogCenter(String[][] strArr) {
        if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
            int i = GameCanvas.f180w - 30;
            if (i > 200) {
                i = 200;
            }
            int i2 = GameCanvas.f182hw - (i / 2);
            int i3 = GameCanvas.f181h - (GameCanvas.hCommand * 2);
            MsgDialog msgDialog = new MsgDialog();
            msgDialog.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, i2, i3, -1, false, i);
            GameCanvas.currentDialog = msgDialog;
        }
    }

    public void leftTab(int i, String[][] strArr) {
        GameCanvas.end_Dialog_Help();
        if (this.Next < strArr[this.Step].length && strArr[this.Step][this.Next].length() > 0) {
            MsgDialog msgDialog = new MsgDialog();
            msgDialog.setDiaHelp(strArr[this.Step][this.Next], this.cmdNext, MainTabNew.m8gI().xTab + MainTabNew.wOne5 + (MainTabNew.wOne5 / 2), MainTabNew.m8gI().yTab + (GameCanvas.f181h / 5) + MainTabNew.wOneItem + 16 + (i * MainTabNew.wOneItem), 3, false, 90);
            GameCanvas.currentDialog = msgDialog;
        }
    }
}
