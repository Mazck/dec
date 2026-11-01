package InterfaceComponents;

import CLib.TField;
import CLib.mFont;
import CLib.mGraphics;
import CLib.mHashtable;
import CLib.mImage;
import CLib.mSystem;
import CLib.mVector;
import GameObjects.Item;
import GameObjects.MainItem;
import GameObjects.MainObject;
import GameObjects.ObjectData;
import GameObjects.PetItem;
import GameObjects.Player;
import GameObjects.item_sell;
import GameScreen.GameScreen;
import GameScreen.MainScreen;
import GameScreen.PaintInfoGameScreen;
import GameScreen.TabScreenNew;
import Main.GameCanvas;
import Model.AvMain;
import Model.C0002T;
import Model.CRes;
import Model.FrameImage;
import Model.MainImage;
import Model.MainTemplateItem;
import Model.Menu2;
import Skill.HotKey;
import netcommand.global.GlobalService;
import netcommand.global.ReadMessenge;

/* loaded from: KnightOnline_v403.jar:InterfaceComponents/TabShopNew.class */
public class TabShopNew extends MainTabNew {
    public static boolean isTabHopNL;
    public static short priceSellPotion;
    public static short priceSellItem;
    public static short hesoLv;
    public static short hesoColor;
    public static short maxPriceItem;
    public static short PriceIconClan;
    int IDTab;
    int numW;
    int numH;
    int numHPaint;
    int maxSize;
    InputDialog inputWorld;
    mVector vecShop;
    public byte numofGem;
    private byte currentTab;
    public static byte maxTab;
    iCommand cmdHoiMua;
    iCommand cmdSelect;
    iCommand cmdBuyPotion;
    iCommand cmdMua;
    iCommand cmdHoiXoaItem;
    iCommand cmdXoaItem;
    iCommand cmdMenuInven;
    iCommand cmdSetKey;
    iCommand cmdHoiSell;
    iCommand cmdSell;
    iCommand cmdGetChest;
    iCommand cmdSetChest;
    iCommand cmdGetPotionChest;
    iCommand cmdSetPotionChest;
    iCommand cmdSellMore;
    iCommand cmdRebuild;
    iCommand cmdUnRebuild;
    iCommand cmdNextIcon;
    iCommand cmdReplace;
    iCommand cmdWing;
    iCommand cmdCreateWing;
    iCommand cmdDepositPet;
    iCommand cmdWithdrawPet;
    iCommand cmdFoodPet;
    iCommand cmdPetInfo;
    iCommand cmdPetFeed;
    iCommand cmdSelectReward;
    iCommand cmdHopNguyeLieu;
    iCommand cmdMua1;
    iCommand cmdMua10;
    iCommand cmdMua30;
    iCommand cmdKhamgoc;
    iCommand cmdDuclo;
    iCommand cmdGhepNgoc;
    iCommand cmdBovao;
    iCommand cmdLayra;
    iCommand cmdMuaNhieu;
    iCommand cmdHoidaugia;
    iCommand cmdDaugia;
    iCommand cmdHoanThanh;
    iCommand cmdOkSell;
    iCommand cmdBuyItemOtherplayer;
    iCommand cmdhuy;
    iCommand cmdNghiban;
    iCommand cmdChatWorld;
    iCommand cmdlaynguyenlieura;
    iCommand cmdHoprac;
    iCommand cmdlayracra;
    iCommand cmdbanNguyenLieu;
    iCommand cmdHopAn;
    iCommand cmdNextInven;
    iCommand cmdKhacItem;
    InputDialog inputDialog;
    ListNew list;
    byte isTypeShop;
    boolean isShop;
    public static byte NORMAL = 0;
    public static byte TOC = 1;
    public static byte INVEN_AND_CHEST = 2;
    public static byte INVEN_AND_REBUILD = 3;
    public static byte SHOP_BANG = 4;
    public static byte INVEN_BANG = 5;
    public static byte INVEN_AND_REPLACE = 6;
    public static byte INVEN_AND_WING = 7;
    public static byte WING = 7;
    public static byte INVEN_AND_PET_KEEPER = 8;
    public static byte INVEN_FOOD_PET = 9;
    public static byte INVEN_LOTTERY = 10;
    public static byte SHOP_VANTIEU = 11;
    public static byte SHOP_KHAM_NGOC = 12;
    public static byte SHOP_GHEP_NGOC = 13;
    public static byte SHOP_DUC_LO = 14;
    public static byte SHOP_STORE_OTHER_PLAYER = 15;
    public static byte SHOP_ANY_NGUYEN_LIEU = 16;
    public static byte SHOP_HOP_AN = 17;
    public static byte SHOP_NANG_CAP_MEDEL = 18;
    public static byte UPDATE = -1;
    public static byte GET_CHEST = 0;
    public static byte SET_CHEST = 1;
    public static byte UPDATE_PET_EAT = 2;
    public static byte WITHDRAW_PET = 0;
    public static byte DEPOSIT_PET = 1;
    public static short priceSellQuest = 1;
    public static short PriceChatWorld = 0;
    public static boolean isSortInven = false;
    public static int IdTabSave = -1;
    public static short idSeller = 0;
    public static mHashtable allidNgocKham = new mHashtable();
    int idSelect = 0;
    int hcmd = 0;
    String textWorld = "";
    public PetItem petCur = null;
    public boolean isShop_Other_Player = false;
    mVector vecListCmd = new mVector("list cmd");
    String nameCmdBuy = "";

    public TabShopNew(mVector mvector, byte b, String str, int i, byte b2) {
        this.numW = 6;
        this.numH = 6;
        this.maxSize = 60;
        this.vecShop = new mVector("TabShopNew vecShop");
        this.isTypeShop = (byte) 0;
        this.typeTab = b;
        this.isShop = false;
        this.xBegin = this.xTab + MainTabNew.wOneItem + (MainTabNew.wOne5 * 3);
        this.yBegin = this.yTab + (GameCanvas.f181h / 5) + MainTabNew.wOneItem + 1;
        this.numW = MainTabNew.wblack / MainTabNew.wOneItem;
        this.numHPaint = MainTabNew.hblack / MainTabNew.wOneItem;
        this.maxSize = mvector.size();
        if (this.maxSize % this.numW != 0) {
            this.maxSize += this.numW - (this.maxSize % this.numW);
        }
        if (this.typeTab == 0 || this.typeTab == 16) {
            this.vecShop = Item.VecInvetoryPlayer;
            if (this.maxSize < Player.maxInven) {
                this.maxSize = Player.maxInven;
            }
        } else if (this.typeTab == 15) {
            this.vecShop = Item.VecItemSell;
        } else if (this.typeTab == 9) {
            this.vecShop = Item.VecChestPlayer;
            if (this.maxSize < Player.maxChest) {
                this.maxSize = Player.maxChest;
            }
        } else if (this.typeTab == 13) {
            this.vecShop = Item.VecPetContainer;
            if (this.maxSize < Player.maxPet) {
                this.maxSize = Player.maxChest;
            }
        } else if (this.typeTab == 12) {
            this.vecShop = Item.VecClanInvetory;
        } else {
            this.vecShop = mvector;
            IdTabSave = i;
            this.isShop = true;
        }
        this.maxSize = 42;
        this.currentTab = (byte) 0;
        maxTab = (byte) (Player.maxInven / 42);
        if (this.typeTab == 13) {
            maxTab = (byte) (Player.maxPet / 42);
        }
        if (this.isShop) {
            this.maxSize = this.vecShop.size();
        }
        this.numH = ((this.maxSize - 1) / this.numW) + 1;
        this.nameTab = str;
        this.IDTab = i;
        this.isTypeShop = b2;
        if (b2 == SHOP_KHAM_NGOC) {
            this.numofGem = (byte) 2;
        }
        if (b2 == SHOP_GHEP_NGOC || b2 == SHOP_ANY_NGUYEN_LIEU) {
            this.numofGem = (byte) 5;
        }
        if (str == null || str.length() == 0) {
            this.nameTab = "Name Tab";
        }
        this.cmdHoiMua = new iCommand(C0002T.buy, 0, this);
        this.cmdSelect = new iCommand(C0002T.use, 6, this);
        this.cmdBack = new iCommand(C0002T.back, -1, this);
        if (GameCanvas.isTouch) {
            this.cmdBack.caption = C0002T.close;
        }
        this.cmdBuyPotion = new iCommand(C0002T.buy, 2, this);
        this.cmdMua = new iCommand(C0002T.buy, 3, this);
        this.cmdHoiXoaItem = new iCommand(C0002T.vucbo, 4, this);
        this.cmdXoaItem = new iCommand(C0002T.vucbo, 5, this);
        this.cmdMenuInven = new iCommand(C0002T.select, 7, this);
        this.cmdSetKey = new iCommand(C0002T.setKey, 8, this);
        this.cmdHoiSell = new iCommand(C0002T.sell, 11, this);
        this.cmdSell = new iCommand(C0002T.sell, 10, this);
        this.cmdGetChest = new iCommand(C0002T.layra, 13, this);
        this.cmdSetChest = new iCommand(C0002T.catvao, 14, this);
        this.cmdGetPotionChest = new iCommand(C0002T.layra, 15, this);
        this.cmdSetPotionChest = new iCommand(C0002T.catvao, 16, this);
        this.cmdSellMore = new iCommand(C0002T.sellmore, 17, this);
        this.cmdRebuild = new iCommand(C0002T.dapdo, 20, this);
        this.cmdUnRebuild = new iCommand(C0002T.layra, 21, this);
        this.cmdNextIcon = new iCommand(C0002T.next, 22, this);
        this.cmdReplace = new iCommand(C0002T.replace, 23, this);
        this.cmdWing = new iCommand(C0002T.nangcap, 24, this);
        this.cmdCreateWing = new iCommand(C0002T.taoCanh, 3, this);
        this.cmdDepositPet = new iCommand(C0002T.aptrung, 25, this);
        this.cmdWithdrawPet = new iCommand(C0002T.use, 26, this);
        this.cmdFoodPet = new iCommand(C0002T.choan, 27, this);
        this.cmdPetInfo = new iCommand(C0002T.info, 28, this);
        this.cmdPetFeed = new iCommand(C0002T.choan, 29, this);
        this.cmdHopNguyeLieu = new iCommand(C0002T.hopThanh, 30, this);
        this.cmdMua1 = new iCommand(new StringBuffer().append(C0002T.buy).append(" 1").toString(), 31, this);
        this.cmdMua10 = new iCommand(new StringBuffer().append(C0002T.buy).append(" 10").toString(), 32, this);
        this.cmdMua30 = new iCommand(new StringBuffer().append(C0002T.buy).append(" 30").toString(), 33, this);
        this.cmdKhamgoc = new iCommand(C0002T.khamNgoc, 36, this);
        this.cmdBovao = new iCommand(C0002T.bovao, 37, this);
        this.cmdGhepNgoc = new iCommand(C0002T.bovao, 38, this);
        this.cmdLayra = new iCommand(C0002T.layra, 39, this);
        this.cmdMuaNhieu = new iCommand(C0002T.muaNhieu, 0, this);
        this.cmdDuclo = new iCommand(C0002T.DucLo, 40, this);
        this.cmdHoidaugia = new iCommand(C0002T.daugia, 41, this);
        this.cmdDaugia = new iCommand(C0002T.daugia, 42, this);
        this.cmdHoanThanh = new iCommand(C0002T.hoanthanh, 44, this);
        this.cmdOkSell = new iCommand(C0002T.hoanthanh, 45, this);
        this.cmdBuyItemOtherplayer = new iCommand(C0002T.buy, 46, this);
        this.cmdhuy = new iCommand(C0002T.cancel, 47, this);
        this.cmdNghiban = new iCommand(C0002T.NghiBan, 48, this);
        this.cmdChatWorld = new iCommand(C0002T.text2kenhthegioi, 49, this);
        this.cmdHoprac = new iCommand(C0002T.hoprac, 52, this);
        this.cmdlayracra = new iCommand(C0002T.layra, 53, this);
        this.cmdHopAn = new iCommand(C0002T.bovao, 54, this);
        this.cmdbanNguyenLieu = new iCommand(C0002T.daugia, 55, this);
        this.cmdNextInven = new iCommand(C0002T.tabhanhtrang, 56, this);
        this.cmdKhacItem = new iCommand(C0002T.khac, 57, this);
        init();
    }

    @Override // InterfaceComponents.MainTabNew
    public void setNameCmd(String str) {
        this.nameCmdBuy = str;
        this.cmdHoiMua.caption = str;
        this.cmdMua.caption = str;
    }

    @Override // InterfaceComponents.MainTabNew
    public void init() {
        int size;
        if (GameCanvas.isTouch) {
            this.idSelect = -1;
        } else {
            this.idSelect = 0;
        }
        MainTabNew.timePaintInfo = 0;
        if (this.typeTab == 0 || this.typeTab == 16) {
            if (isSortInven) {
                Item.VecInvetoryPlayer = CRes.selectionSortInven(Item.VecInvetoryPlayer);
                isSortInven = false;
            }
            size = Item.VecInvetoryPlayer.size();
        } else if (this.typeTab == 15) {
            size = Item.VecItemSell.size();
        } else if (this.typeTab == 9) {
            size = Item.VecChestPlayer.size();
        } else if (this.typeTab == 12) {
            size = Item.VecClanInvetory.size();
        } else if (this.typeTab == 13) {
            size = Item.VecPetContainer.size();
        } else {
            size = this.vecShop.size();
        }
        MainScreen.cameraSub.setAll(0, (((this.numH * MainTabNew.wOneItem) - MainTabNew.hblack) - MainTabNew.wOne5) + 8, 0, 0);
        this.list = new ListNew(this.xBegin, this.yBegin, MainTabNew.wblack, MainTabNew.hblack, 0, 0, MainScreen.cameraSub.yLimit);
        this.listContent = null;
        if (size == 0) {
            MainTabNew.Focus = (byte) 0;
        } else if (!GameCanvas.isTouch) {
            if (this.typeTab == 8) {
                if (this.isTypeShop == SHOP_BANG) {
                    this.center = this.cmdMenuInven;
                } else if (this.isTypeShop == WING) {
                    this.center = this.cmdCreateWing;
                } else {
                    this.center = this.cmdHoiMua;
                }
            } else if (this.typeTab == 9 || this.typeTab == 15) {
                if (Item.VecChestPlayer.size() > 0) {
                    this.center = this.cmdMenuInven;
                }
            } else if (this.typeTab == 12) {
                if (Item.VecClanInvetory.size() > 0) {
                    this.center = this.cmdMenuInven;
                }
            } else if (this.typeTab == 0 || this.typeTab == 16) {
                if (Item.VecInvetoryPlayer.size() > 0) {
                    this.center = this.cmdMenuInven;
                }
            } else if (this.typeTab == 13 && Item.VecPetContainer.size() > 0) {
                this.center = this.cmdMenuInven;
            }
            this.right = this.cmdBack;
        }
        this.currentTab = (byte) 0;
        super.init();
    }

    @Override // InterfaceComponents.MainTabNew
    public void backTab() {
        MainTabNew.Focus = (byte) 0;
        this.idSelect = 0;
        super.backTab();
    }

    @Override // Model.AvMain
    public void commandPointer(int i, Object obj) {
        mVector mvector;
        mSystem.outz(new StringBuffer().append("commandPointer index = ").append(i).toString());
        if (this.typeTab == 15) {
            mvector = Item.VecItemSell;
        } else if (this.typeTab == 0 || this.typeTab == 16) {
            mvector = Item.VecInvetoryPlayer;
        } else if (this.typeTab == 9) {
            mvector = Item.VecChestPlayer;
        } else if (this.typeTab == 13) {
            mvector = Item.VecPetContainer;
        } else if (this.typeTab == 12) {
            mvector = Item.VecClanInvetory;
        } else {
            mvector = this.vecShop;
        }
        if (this.idSelect < 0 && i > 0) {
            return;
        }
        if (MainTabNew.longwidth == 0) {
            MainTabNew.timePaintInfo = 0;
        }
        switch (i) {
            case 43:
                MainItem mainItem = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem != null) {
                    item_sell item_sellVar = (item_sell) obj;
                    int i2 = 0;
                    short s = 1;
                    if (item_sellVar != null) {
                        try {
                            i2 = item_sellVar.price;
                            s = item_sellVar.soluuong;
                        } catch (Exception e) {
                            GameCanvas.start_Ok_Dialog(C0002T.nhapsai);
                            return;
                        }
                    }
                    Item.VecItem_Sell_in_store.addElement(new item_sell((short) mainItem.f58Id, i2, s, mainItem.ItemCatagory));
                    if (mainItem.ItemCatagory == 4) {
                        MainItem clonePotion = mainItem.clonePotion();
                        clonePotion.numPotion = s;
                        Item.VecItemSell.addElement(clonePotion);
                    } else if (mainItem.ItemCatagory == 7) {
                        MainItem cloneNguyenLieu = mainItem.cloneNguyenLieu();
                        cloneNguyenLieu.numPotion = s;
                        Item.VecItemSell.addElement(cloneNguyenLieu);
                    } else {
                        Item.VecItemSell.addElement(mainItem);
                    }
                }
                if (this.vecListCmd != null) {
                    this.vecListCmd.removeAllElements();
                }
                GameCanvas.end_Dialog();
                break;
        }
        if (obj != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v541, types: [int] */
    /* JADX WARN: Type inference failed for: r0v564, types: [int] */
    @Override // Model.AvMain
    public void commandPointer(int i, int i2) {
        mVector mvector;
        short s;
        iCommand icommand;
        MainImage imageItem;
        MainImage imageItem2;
        int i3;
        mSystem.outz(new StringBuffer().append("commandPointer index = ").append(i).toString());
        if (this.typeTab == 15) {
            mvector = Item.VecItemSell;
        } else if (this.typeTab == 0 || this.typeTab == 16) {
            mvector = Item.VecInvetoryPlayer;
        } else if (this.typeTab == 9) {
            mvector = Item.VecChestPlayer;
        } else if (this.typeTab == 13) {
            mvector = Item.VecPetContainer;
        } else if (this.typeTab == 12) {
            mvector = Item.VecClanInvetory;
        } else {
            mvector = this.vecShop;
        }
        if (this.idSelect < 0 && i > 0) {
        }
        if (MainTabNew.longwidth == 0) {
            MainTabNew.timePaintInfo = 0;
        }
        switch (i) {
            case -1:
                backTab();
                break;
            case 0:
                Item item = (Item) mvector.elementAt(this.idSelect);
                if (item != null && !item.setNameNull()) {
                    if (this.isTypeShop == SHOP_STORE_OTHER_PLAYER && (!GameCanvas.isTouch || (GameCanvas.isTouch && mSystem.isj2me))) {
                        this.cmdBuyItemOtherplayer.perform();
                        break;
                    } else if (item.diaHoiEvent != "") {
                        GameCanvas.start_Left_Dialog(item.diaHoiEvent, this.cmdMua);
                        break;
                    } else if (item.ItemCatagory == 4 || item.ItemCatagory == 7) {
                        this.inputDialog = new InputDialog();
                        this.inputDialog.setinfoSmallNew(C0002T.nhapsoluongcanmua, this.cmdBuyPotion, true, -1, item.priceItem, C0002T.buySell, item.getPriceType());
                        GameCanvas.currentDialog = this.inputDialog;
                        break;
                    } else if (item.ItemCatagory == 3) {
                        this.cmdMua.caption = C0002T.buy;
                        GameCanvas.start_Left_Dialog(new StringBuffer().append(C0002T.hoiBuy).append("1 ").append(item.itemName).append(". ").append(C0002T.voigia).append(item.priceItem).append(item.getPriceType()).append("?").toString(), this.cmdMua);
                        break;
                    } else if (item.ItemCatagory == 6) {
                        if (item.priceItem > 0) {
                            this.cmdMua.caption = C0002T.buy;
                            GameCanvas.start_Left_Dialog(new StringBuffer().append(C0002T.hoiBuy).append(item.itemName).append(". ").append(C0002T.voigia).append(item.priceItem).append(item.getPriceType()).append("?").toString(), this.cmdMua);
                            break;
                        } else if (item.imageId == GameScreen.player.hair) {
                            GameCanvas.start_Ok_Dialog(C0002T.dangdungtocnay);
                            break;
                        } else {
                            this.cmdMua.caption = C0002T.use;
                            GameCanvas.start_Left_Dialog(C0002T.dungitem, this.cmdMua);
                            break;
                        }
                    } else if (item.ItemCatagory == 8) {
                        this.cmdMua.caption = C0002T.select;
                        GameCanvas.start_Left_Dialog(C0002T.hoichoniconclan, this.cmdMua);
                        break;
                    }
                }
                break;
            case 1:
                if (((Item) mvector.elementAt(this.idSelect)) != null) {
                    GameCanvas.start_Left_Dialog(C0002T.dungitem, new iCommand(C0002T.use, 6, this));
                    break;
                }
                break;
            case 2:
                MainItem mainItem = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem != null) {
                    try {
                        i3 = Integer.parseInt(this.inputDialog.tfInput.getText());
                    } catch (Exception e) {
                        i3 = 1;
                    }
                    GlobalService.m14gI().buy_item((byte) this.IDTab, (short) mainItem.f58Id, (short) i3);
                    GameCanvas.end_Dialog();
                    break;
                }
                break;
            case 3:
            case 31:
                MainItem mainItem2 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem2 != null && !mainItem2.setNameNull()) {
                    GlobalService.m14gI().buy_item((byte) this.IDTab, (short) mainItem2.f58Id, (short) 1);
                    GameCanvas.end_Dialog();
                    break;
                }
                break;
            case 4:
                MainItem mainItem3 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem3 != null && !mainItem3.setNameNull()) {
                    GameCanvas.start_Left_Dialog(new StringBuffer().append(C0002T.hoiDelItem).append(mainItem3.itemName).append("?").toString(), this.cmdXoaItem);
                    break;
                }
                break;
            case 5:
                MainItem mainItem4 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem4 != null && !mainItem4.setNameNull()) {
                    GlobalService.m14gI().delete_Item((byte) mainItem4.ItemCatagory, (short) mainItem4.f58Id, (byte) 0);
                    MainTabNew.timePaintInfo = 0;
                    GameCanvas.end_Dialog();
                    break;
                }
                break;
            case 6:
                MainItem mainItem5 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem5 != null) {
                    if (mainItem5.ItemCatagory == 5) {
                        GameCanvas.start_Ok_Dialog(C0002T.khongthedung);
                        break;
                    } else {
                        if (mainItem5.ItemCatagory == 4) {
                            if (mainItem5.typePotion > 1 || Player.timeDelayPotion[mainItem5.typePotion].value <= 0) {
                                if (GameScreen.help.setStep_Next(2, 4) && mainItem5.typePotion == 0) {
                                    GameScreen.help.Next++;
                                    GameScreen.help.setNext();
                                }
                                if (mainItem5.typePotion >= 2 || ((mainItem5.typePotion != 0 || GameScreen.player.f81hp != GameScreen.player.maxHp) && (mainItem5.typePotion != 1 || GameScreen.player.f82mp != GameScreen.player.maxMp))) {
                                    if (mainItem5.typePotion == Item.ID_TEM_VE_MUA_BAN) {
                                        if (!GameScreen.player.isSelling()) {
                                            GameScreen.m3gI().doSellItem();
                                        }
                                    } else {
                                        GlobalService.m14gI().Use_Potion((short) mainItem5.f58Id);
                                        if (mainItem5.typePotion < 2) {
                                            Player.timeDelayPotion[mainItem5.typePotion].value = ObjectData.ITEM;
                                            Player.timeDelayPotion[mainItem5.typePotion].limit = ObjectData.ITEM;
                                            Player.timeDelayPotion[mainItem5.typePotion].timebegin = mSystem.currentTimeMillis();
                                        }
                                    }
                                }
                            }
                        } else {
                            int i4 = 0;
                            if (mainItem5.type_Only_Item < 12) {
                                i4 = MainTemplateItem.mItem_Rotate_Tem_Equip[mainItem5.type_Only_Item];
                            }
                            if (i4 == -1) {
                                mVector mvector2 = new mVector("TabShopNew menu");
                                iCommand icommand2 = new iCommand(C0002T.leftRing, 12, 0, this);
                                Item item2 = (Item) Item.VecEquipPlayer.get("3");
                                if (item2 != null && (imageItem2 = ObjectData.getImageItem((short) item2.imageId)) != null && imageItem2.img != null) {
                                    if (imageItem2.f213w == 0 || imageItem2.f214h == 0) {
                                        imageItem2.f214h = (short) mImage.getImageHeight(imageItem2.img.image);
                                        imageItem2.f213w = (short) mImage.getImageWidth(imageItem2.img.image);
                                    }
                                    icommand2.setFraCaption(new FrameImage(imageItem2.img, imageItem2.f213w, imageItem2.f214h));
                                }
                                iCommand icommand3 = new iCommand(C0002T.rightRing, 12, 1, this);
                                Item item3 = (Item) Item.VecEquipPlayer.get("9");
                                if (item3 != null && (imageItem = ObjectData.getImageItem((short) item3.imageId)) != null && imageItem.img != null) {
                                    if (imageItem.f213w == 0 || imageItem.f214h == 0) {
                                        imageItem.f214h = (short) mImage.getImageHeight(imageItem.img.image);
                                        imageItem.f213w = (short) mImage.getImageWidth(imageItem.img.image);
                                    }
                                    icommand3.setFraCaption(new FrameImage(imageItem.img, imageItem.f213w, imageItem.f214h));
                                }
                                mvector2.addElement(icommand2);
                                mvector2.addElement(icommand3);
                                GameCanvas.menu2.startAt(mvector2, 2, C0002T.Ring, false, null);
                            } else {
                                if (mainItem5.ItemCatagory == 7) {
                                    GlobalService.m14gI().doUseMaterial((short) mainItem5.f58Id);
                                } else {
                                    GlobalService.m14gI().Use_Item((byte) mainItem5.f58Id, (byte) i4);
                                }
                                if (GameScreen.help.setStep_Next(3, 4)) {
                                    GameScreen.help.Next++;
                                    GameScreen.help.setNext();
                                }
                            }
                        }
                        MainTabNew.timePaintInfo = 0;
                        if (!GameScreen.help.setStep_Next(2, 5) && !GameScreen.help.setStep_Next(3, 5)) {
                            GameCanvas.end_Dialog();
                            break;
                        }
                    }
                }
                break;
            case 7:
                Item item4 = (Item) mvector.elementAt(this.idSelect);
                if (item4 != null) {
                    new mVector("TabShopNew menu2");
                    mVector doMenu = doMenu(item4);
                    String str = C0002T.item;
                    if (this.isTypeShop == SHOP_BANG) {
                        str = C0002T.iconclan;
                    }
                    GameCanvas.menu2.startAt(doMenu, 2, str, false, null);
                    if (GameScreen.help.setStep_Next(2, 9) || GameScreen.help.setStep_Next(2, 4) || GameScreen.help.setStep_Next(3, 4)) {
                        Menu2.isHelp = true;
                        break;
                    }
                }
                break;
            case 8:
                mVector mvector3 = new mVector("TabShopNew menu3");
                for (int i5 = 0; i5 < 5; i5++) {
                    if (!GameCanvas.isTouch) {
                        if (TField.isQwerty) {
                            icommand = new iCommand(new StringBuffer().append(C0002T.phim).append(PaintInfoGameScreen.mValueChar[i5]).toString(), 9, i5, this);
                        } else {
                            icommand = new iCommand(new StringBuffer().append(C0002T.phim).append(PaintInfoGameScreen.mValueHotKey[i5]).toString(), 9, i5, this);
                        }
                    } else {
                        icommand = new iCommand(new StringBuffer().append(C0002T.oso).append(i5 + 1).toString(), 9, i5, this);
                    }
                    mvector3.addElement(icommand);
                }
                GameCanvas.menu2.startAt(mvector3, 2, C0002T.setKey, false, null);
                if (GameScreen.help.Step >= 0 && GameScreen.help.setStep_Next(2, 9)) {
                    GameScreen.help.Next = 10;
                    Menu2.isHelp = true;
                    break;
                }
                break;
            case 9:
                MainItem mainItem6 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem6 != null && mainItem6.typePotion <= 1) {
                    if (i2 == 2) {
                        GameCanvas.start_Ok_Dialog(C0002T.khongganmauvaophimnay);
                        break;
                    } else {
                        Player.mhotkey[Player.levelTab][i2].setHotKey(mainItem6.f58Id, HotKey.POTION, mainItem6.typePotion);
                        TabSkillsNew.saveSkill();
                        if (GameScreen.help.Step >= 0) {
                            if (GameScreen.help.setStep_Next(2, 9) || GameScreen.help.setStep_Next(2, 10)) {
                                GameScreen.help.Next = 11;
                                GameScreen.help.setNext();
                                break;
                            }
                        }
                    }
                }
                break;
            case 10:
                MainItem mainItem7 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem7 != null && !mainItem7.setNameNull()) {
                    GlobalService.m14gI().delete_Item((byte) mainItem7.ItemCatagory, (short) mainItem7.f58Id, (byte) 1);
                    if (GameCanvas.isTouch) {
                        this.idSelect = -1;
                    }
                    MainTabNew.timePaintInfo = 0;
                    GameCanvas.end_Dialog();
                    break;
                }
                break;
            case 11:
                MainItem mainItem8 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem8 != null && !mainItem8.setNameNull()) {
                    if (mainItem8.ItemCatagory == 3) {
                        s = (((1 + (mainItem8.LvItem / hesoLv)) * priceSellItem) * (100 + (mainItem8.colorNameItem * hesoColor))) / 100;
                        if (s > maxPriceItem) {
                            s = maxPriceItem;
                        }
                    } else if (mainItem8.ItemCatagory == 5) {
                        s = mainItem8.numPotion * priceSellQuest;
                    } else {
                        s = priceSellPotion;
                    }
                    if (mainItem8.ItemCatagory == 3) {
                        if (mainItem8.colorNameItem == 0) {
                            s = 1;
                        }
                        if (mainItem8.colorNameItem == 1) {
                            s = 3;
                        }
                    }
                    GameCanvas.start_Left_Dialog(new StringBuffer().append(C0002T.hoisell).append(mainItem8.itemName).append("? ").append(C0002T.voigia).append((int) s).append(" ").append(C0002T.coin).append(".").toString(), this.cmdSell);
                    break;
                }
                break;
            case 12:
                MainItem mainItem9 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem9 != null) {
                    if (i2 == 0) {
                        GlobalService.m14gI().Use_Item((byte) mainItem9.f58Id, (byte) 3);
                        break;
                    } else if (i2 == 1) {
                        GlobalService.m14gI().Use_Item((byte) mainItem9.f58Id, (byte) 9);
                        break;
                    }
                }
                break;
            case 13:
                MainItem mainItem10 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem10 != null) {
                    int i6 = 1;
                    if (mainItem10.ItemCatagory == 4 || mainItem10.ItemCatagory == 7) {
                        try {
                            i6 = Integer.parseInt(this.inputDialog.tfInput.getText());
                        } catch (Exception e2) {
                            i6 = 1;
                        }
                    }
                    GlobalService.m14gI().Update_Char_Chest(GET_CHEST, (short) mainItem10.f58Id, (byte) mainItem10.ItemCatagory, (short) i6);
                    if (GameCanvas.isTouch) {
                        this.idSelect = -1;
                    }
                }
                GameCanvas.end_Dialog();
                break;
            case 14:
                MainItem mainItem11 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem11 != null) {
                    int i7 = 1;
                    if (mainItem11.ItemCatagory == 4 || mainItem11.ItemCatagory == 7) {
                        try {
                            i7 = Integer.parseInt(this.inputDialog.tfInput.getText());
                        } catch (Exception e3) {
                            i7 = 1;
                        }
                    }
                    GlobalService.m14gI().Update_Char_Chest(SET_CHEST, (short) mainItem11.f58Id, (byte) mainItem11.ItemCatagory, (short) i7);
                    if (GameCanvas.isTouch) {
                        this.idSelect = -1;
                    }
                }
                GameCanvas.end_Dialog();
                break;
            case 15:
                MainItem mainItem12 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem12 != null) {
                    if (mainItem12.ItemCatagory == 4 || mainItem12.ItemCatagory == 7) {
                        this.inputDialog = new InputDialog();
                        this.inputDialog.setinfo(C0002T.nhapsoluongcanlay, this.cmdGetChest, true, C0002T.chest);
                        GameCanvas.currentDialog = this.inputDialog;
                        break;
                    }
                }
                break;
            case 16:
                MainItem mainItem13 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem13 != null) {
                    if (mainItem13.ItemCatagory == 4 || mainItem13.ItemCatagory == 7) {
                        this.inputDialog = new InputDialog();
                        this.inputDialog.setinfo(C0002T.nhapsoluongcancat, this.cmdSetChest, true, C0002T.tabhanhtrang);
                        GameCanvas.currentDialog = this.inputDialog;
                        break;
                    }
                }
                break;
            case 17:
                mVector mvector4 = new mVector("TabShopNew menusell");
                mvector4.addElement(new iCommand(C0002T.banhettrang, 19, 0, this));
                mvector4.addElement(new iCommand(C0002T.banhetxanh, 19, 1, this));
                GameCanvas.menu2.startAt(mvector4, 2, C0002T.sell, false, null);
                break;
            case 18:
                for (int i8 = 0; i8 < Item.VecInvetoryPlayer.size(); i8++) {
                    MainItem mainItem14 = (MainItem) Item.VecInvetoryPlayer.elementAt(i8);
                    if (i2 == 0) {
                        if (mainItem14.ItemCatagory == 3 && mainItem14.colorNameItem == 0 && mainItem14.tier == 0) {
                            GlobalService.m14gI().delete_Item((byte) mainItem14.ItemCatagory, (short) mainItem14.f58Id, (byte) 1);
                        }
                    } else if (i2 == 1 && mainItem14.ItemCatagory == 3 && mainItem14.colorNameItem == 1 && mainItem14.tier == 0) {
                        GlobalService.m14gI().delete_Item((byte) mainItem14.ItemCatagory, (short) mainItem14.f58Id, (byte) 1);
                    }
                }
                if (GameCanvas.isTouch) {
                    this.idSelect = -1;
                }
                GameCanvas.end_Dialog();
                break;
            case 19:
                int i9 = 0;
                for (int i10 = 0; i10 < Item.VecInvetoryPlayer.size(); i10++) {
                    MainItem mainItem15 = (MainItem) Item.VecInvetoryPlayer.elementAt(i10);
                    if (i2 == 0) {
                        if (mainItem15.ItemCatagory == 3 && mainItem15.colorNameItem == 0) {
                            i9++;
                        }
                    } else if (i2 == 1 && mainItem15.ItemCatagory == 3 && mainItem15.colorNameItem == 1) {
                        i9++;
                    }
                }
                if (i9 == 0) {
                    if (i2 == 0) {
                        GameCanvas.start_Ok_Dialog(C0002T.khongcontrang);
                        break;
                    } else if (i2 == 1) {
                        GameCanvas.start_Ok_Dialog(C0002T.khongconxanh);
                        break;
                    }
                } else if (i2 == 0) {
                    GameCanvas.start_Left_Dialog(new StringBuffer().append(C0002T.hoisell).append(i9).append(C0002T.dotrang).toString(), new iCommand(C0002T.sell, 18, 0, this));
                    break;
                } else if (i2 == 1) {
                    GameCanvas.start_Left_Dialog(new StringBuffer().append(C0002T.hoisell).append(i9).append(C0002T.doxanh).toString(), new iCommand(C0002T.sell, 18, 1, this));
                    break;
                }
                break;
            case 20:
                MainItem mainItem16 = (MainItem) Item.VecInvetoryPlayer.elementAt(this.idSelect);
                if (mainItem16 != null) {
                    GlobalService.m14gI().Rebuild_Item((byte) 0, (short) mainItem16.f58Id, (byte) mainItem16.ItemCatagory);
                    if (MainTabNew.longwidth > 0) {
                        this.idSelect = -1;
                        MainTabNew.timePaintInfo = 0;
                        break;
                    }
                }
                break;
            case 21:
                MainItem mainItem17 = (MainItem) Item.VecInvetoryPlayer.elementAt(this.idSelect);
                if (mainItem17 != null) {
                    GlobalService.m14gI().Rebuild_Item(MainObject.isMaHopNguyenLieu(mainItem17.f58Id) ? (byte) 6 : (byte) 1, (short) mainItem17.f58Id, (byte) mainItem17.ItemCatagory);
                    if (MainTabNew.longwidth > 0) {
                        this.idSelect = -1;
                        MainTabNew.timePaintInfo = 0;
                        break;
                    }
                }
                break;
            case 22:
                GlobalService.m14gI().NextClan((byte) 8);
                GameCanvas.start_Wait_Dialog(C0002T.pleaseWait, new iCommand(C0002T.close, -1));
                break;
            case 23:
                MainItem mainItem18 = (MainItem) Item.VecInvetoryPlayer.elementAt(this.idSelect);
                if (mainItem18 != null) {
                    GlobalService.m14gI().Replace_Item((byte) 0, (short) mainItem18.f58Id);
                    break;
                }
                break;
            case 24:
                MainItem mainItem19 = (MainItem) Item.VecInvetoryPlayer.elementAt(this.idSelect);
                if (mainItem19 != null) {
                    GlobalService.m14gI().Rebuild_Wing((byte) 2, 0, (short) mainItem19.f58Id);
                    break;
                }
                break;
            case 25:
                mSystem.outz("Deposit pet ------- ");
                Item item5 = (Item) mvector.elementAt(this.idSelect);
                if (item5 != null) {
                    GlobalService.m14gI().Update_Pet_Container(DEPOSIT_PET, (short) item5.f58Id, (byte) item5.ItemCatagory, (short) 1);
                    mSystem.println(new StringBuffer().append("ap trung ").append(item5.f58Id).append(" ").append(item5.ItemCatagory).append(" ").append(1).toString());
                    if (GameCanvas.isTouch) {
                        this.idSelect = -1;
                    }
                }
                GameCanvas.end_Dialog();
                break;
            case 26:
                mSystem.outz("withdraw pet ------- ");
                Item item6 = (Item) mvector.elementAt(this.idSelect);
                if (item6 != null) {
                    GlobalService.m14gI().Update_Pet_Container(WITHDRAW_PET, (short) item6.f58Id, (byte) item6.ItemCatagory, (short) 1);
                    if (GameCanvas.isTouch) {
                        this.idSelect = -1;
                    }
                } else {
                    mSystem.println("null cmnr");
                }
                GameCanvas.end_Dialog();
                break;
            case 27:
                if (this.petCur != null) {
                    Item item7 = (Item) mvector.elementAt(this.idSelect);
                    GlobalService.m14gI().Pet_Eat((short) this.petCur.f58Id, (short) item7.f58Id, (byte) item7.ItemCatagory, MsgDialog.isInven_Equip);
                    break;
                }
                break;
            case 28:
                Item item8 = (Item) mvector.elementAt(this.idSelect);
                if (item8 != null && item8.ItemCatagory == 9) {
                    GameCanvas.start_Pet_Info((PetItem) item8, (byte) 0);
                    break;
                }
                break;
            case 29:
                Item item9 = (Item) Item.VecPetContainer.elementAt(this.idSelect);
                if (item9 != null && item9.ItemCatagory == 9) {
                    GameCanvas.start_Pet_Info((PetItem) item9, (byte) 0);
                }
                mVector mvector5 = new mVector("TabShopNew vectab");
                TabShopNew tabShopNew = new TabShopNew(Item.VecInvetoryPlayer, (byte) 0, C0002T.choan, -1, INVEN_FOOD_PET);
                tabShopNew.petCur = MsgDialog.pet;
                mvector5.addElement(tabShopNew);
                GameCanvas.foodPet = new TabScreenNew();
                GameCanvas.foodPet.selectTab = 0;
                GameCanvas.foodPet.addMoreTab(mvector5);
                GameCanvas.foodPet.Show(GameCanvas.currentScreen);
                break;
            case 30:
                MainItem mainItem20 = (MainItem) Item.VecInvetoryPlayer.elementAt(this.idSelect);
                if (mainItem20 != null) {
                    GlobalService.m14gI().Rebuild_Item((byte) 4, (short) mainItem20.f58Id, (byte) mainItem20.ItemCatagory);
                    if (MainTabNew.longwidth > 0) {
                        this.idSelect = -1;
                        MainTabNew.timePaintInfo = 0;
                        break;
                    }
                }
                break;
            case 32:
                MainItem mainItem21 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem21 != null && !mainItem21.setNameNull()) {
                    mVector mvector6 = new mVector("TabShopNew menu4");
                    String stringBuffer = new StringBuffer().append(C0002T.hoiBuy).append(" ").append(10).append(" ").append(mainItem21.itemName).append(" ").append(C0002T.voigia).append(" ").append(mainItem21.priceItem * 10).append(" ").append(mainItem21.priceType == 0 ? C0002T.coin : C0002T.gem).toString();
                    mvector6.addElement(new iCommand(C0002T.yes, 34, 10, this));
                    mvector6.addElement(new iCommand(C0002T.cancel, 35, this));
                    GameCanvas.start_Select_Dialog(stringBuffer, mvector6);
                    break;
                }
                break;
            case 33:
                MainItem mainItem22 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem22 != null && !mainItem22.setNameNull()) {
                    mVector mvector7 = new mVector("TabShopNew menu5");
                    String stringBuffer2 = new StringBuffer().append(C0002T.hoiBuy).append(" ").append(30).append(" ").append(mainItem22.itemName).append(" ").append(C0002T.voigia).append(" ").append(mainItem22.priceItem * 30).append(" ").append(mainItem22.priceType == 0 ? C0002T.coin : C0002T.gem).toString();
                    mvector7.addElement(new iCommand(C0002T.yes, 34, 30, this));
                    mvector7.addElement(new iCommand(C0002T.cancel, 35, this));
                    GameCanvas.start_Select_Dialog(stringBuffer2, mvector7);
                    break;
                }
                break;
            case 34:
                MainItem mainItem23 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem23 != null && !mainItem23.setNameNull()) {
                    GlobalService.m14gI().buy_item((byte) this.IDTab, (short) mainItem23.f58Id, (short) i2);
                    GameCanvas.end_Dialog();
                    break;
                }
                break;
            case 35:
                GameCanvas.end_Dialog();
                break;
            case 36:
            case 40:
                MainItem mainItem24 = (MainItem) Item.VecInvetoryPlayer.elementAt(this.idSelect);
                if (mainItem24 != null) {
                    TabRebuildItem.itemRe = mainItem24;
                    TabRebuildItem.countSetpaintinfo = (byte) 1;
                    if (MainTabNew.longwidth > 0) {
                        this.idSelect = -1;
                        MainTabNew.timePaintInfo = 0;
                        break;
                    }
                }
                break;
            case 37:
                MainItem mainItem25 = (MainItem) Item.VecInvetoryPlayer.elementAt(this.idSelect);
                if (mainItem25 != null) {
                    if (TabRebuildItem.vecGem.size() > this.numofGem) {
                        GameCanvas.start_Ok_Dialog(C0002T.khongbothem);
                        break;
                    } else {
                        TabRebuildItem.addGem(mainItem25);
                        if (MainTabNew.longwidth > 0) {
                            this.idSelect = -1;
                            MainTabNew.timePaintInfo = 0;
                            break;
                        }
                    }
                }
                break;
            case 38:
                TabRebuildItem.vecGem.removeAllElements();
                TabRebuildItem.itemRe = null;
                MainItem mainItem26 = (MainItem) Item.VecInvetoryPlayer.elementAt(this.idSelect);
                if (mainItem26 != null) {
                    if (mainItem26.numPotion < this.numofGem) {
                        GameCanvas.start_Ok_Dialog(C0002T.hetNgoc);
                        break;
                    } else {
                        for (int i11 = 0; i11 < this.numofGem; i11++) {
                            TabRebuildItem.addGem(mainItem26);
                            if (MainTabNew.longwidth > 0) {
                                this.idSelect = -1;
                                MainTabNew.timePaintInfo = 0;
                            }
                        }
                        break;
                    }
                }
                break;
            case 39:
                MainItem mainItem27 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem27 != null) {
                    if (this.isTypeShop == SHOP_KHAM_NGOC) {
                        if (TabRebuildItem.isKham(mainItem27)) {
                            TabRebuildItem.removeKhamNgoc(mainItem27);
                            break;
                        }
                    } else if (this.isTypeShop == SHOP_GHEP_NGOC) {
                        TabRebuildItem.vecGem.removeAllElements();
                        break;
                    }
                }
                break;
            case 41:
                this.inputDialog = new InputDialog();
                this.inputDialog.setinfo(new String[]{C0002T.nhapgiaban}, this.cmdDaugia, (short) -1, (short) 0, C0002T.daugia);
                GameCanvas.currentDialog = this.inputDialog;
                break;
            case 42:
                MainItem mainItem28 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem28 != null) {
                    int i12 = 1;
                    int i13 = 1;
                    String[] strArr = this.inputDialog.getarrayText();
                    if (strArr != null) {
                        try {
                            if (strArr.length == 1) {
                                if (strArr[0] != null) {
                                    i12 = Integer.parseInt(strArr[0]);
                                }
                            } else if (strArr.length == 2) {
                                if (strArr[0] != null) {
                                    i12 = Integer.parseInt(strArr[0]);
                                }
                                if (strArr[1] != null) {
                                    i13 = Integer.parseInt(strArr[1]);
                                }
                            }
                        } catch (Exception e4) {
                            GameCanvas.start_Ok_Dialog(C0002T.nhapsai);
                            return;
                        }
                    }
                    String stringBuffer3 = new StringBuffer().append(C0002T.hoidaugia).append(mainItem28.itemName).append(" ").append(C0002T.voigia).append(" ").append(MainItem.getDotNumber(i12)).append(" ").append(C0002T.coin).append(" ?").toString();
                    if (i13 > 1) {
                        stringBuffer3 = new StringBuffer().append(C0002T.hoidaugia).append(" ").append(i13).append(" ").append(mainItem28.itemName).append(" ").append(C0002T.voigia).append(" ").append(MainItem.getDotNumber(i12)).append(" ").append(C0002T.coin).append(" ?").toString();
                    }
                    item_sell item_sellVar = new item_sell();
                    item_sellVar.price = i12;
                    item_sellVar.soluuong = (short) i13;
                    mVector mvector8 = new mVector();
                    mvector8.addElement(new iCommand(C0002T.yes, 43, item_sellVar, this));
                    mvector8.addElement(new iCommand(C0002T.cancel, 35, this));
                    GameCanvas.start_Select_Dialog(stringBuffer3, mvector8);
                    break;
                }
                break;
            case 44:
                this.inputDialog = new InputDialog();
                this.inputDialog.setinfoSmallNew(C0002T.nhapSlogan, this.cmdOkSell, false, -1, 0L, "");
                GameCanvas.currentDialog = this.inputDialog;
                break;
            case 45:
                GlobalService.m14gI().do_Buy_Sell_Item(0, Item.VecItem_Sell_in_store, this.inputDialog.tfInput.getText(), (short) 0, 0, (byte) 0);
                GameCanvas.end_Dialog();
                if (this.vecListCmd != null) {
                    this.vecListCmd.removeAllElements();
                    this.vecListCmd.addElement(this.cmdNghiban);
                    setPosCmd(this.vecListCmd);
                    break;
                }
                break;
            case 46:
                MainItem mainItem29 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem29 != null) {
                    if (mainItem29.ItemCatagory == 3) {
                        GlobalService.m14gI().do_Buy_Sell_Item(2, null, "", idSeller, mainItem29.f58Id, (byte) mainItem29.ItemCatagory);
                        break;
                    } else if (mainItem29.ItemCatagory == 7) {
                        GlobalService.m14gI().do_Buy_Sell_Item(2, null, "", idSeller, mainItem29.f58Id, (byte) mainItem29.ItemCatagory);
                        break;
                    } else if (mainItem29.ItemCatagory == 4) {
                        GlobalService.m14gI().do_Buy_Sell_Item(2, null, "", idSeller, mainItem29.f58Id, (byte) mainItem29.ItemCatagory);
                        break;
                    }
                }
                break;
            case 47:
                Item.VecItem_Sell_in_store.removeAllElements();
                Item.VecItemSell.removeAllElements();
                break;
            case 48:
                GlobalService.m14gI().do_Buy_Sell_Item(4, null, "", (short) 0, 0, (byte) 0);
                break;
            case 49:
                this.inputWorld = new InputDialog();
                this.inputWorld.setinfo(C0002T.nhapnoidung, new iCommand(C0002T.chat, 50, this), false, C0002T.textkenhthegioi);
                GameCanvas.currentDialog = this.inputWorld;
                break;
            case 50:
                this.textWorld = this.inputWorld.tfInput.getText();
                if (this.textWorld != null && this.textWorld.length() > 0) {
                    GameCanvas.start_Left_Dialog(new StringBuffer().append(C0002T.kenhthegioi).append(" (").append(C0002T.phi).append((int) PriceChatWorld).append(" ").append(C0002T.gem).append(")").append(C0002T.noidungnhusau).append("\n").append(this.textWorld).toString(), new iCommand(C0002T.chat, 51, this));
                    break;
                }
                break;
            case 51:
                GlobalService.m14gI().Chat_World(this.textWorld);
                GameCanvas.end_Dialog();
                break;
            case 52:
                MainItem mainItem30 = (MainItem) Item.VecInvetoryPlayer.elementAt(this.idSelect);
                if (mainItem30 != null) {
                    if (TabRebuildItem.itemRe != null) {
                        TabRebuildItem.itemRe = null;
                    }
                    GlobalService.m14gI().Hop_rac((byte) 0, (short) mainItem30.f58Id, (byte) mainItem30.ItemCatagory);
                }
                this.vecListCmd.removeAllElements();
                break;
            case 53:
                MainItem mainItem31 = (MainItem) Item.VecInvetoryPlayer.elementAt(this.idSelect);
                if (mainItem31 != null) {
                    GlobalService.m14gI().Hop_rac((byte) 1, (short) mainItem31.f58Id, (byte) mainItem31.ItemCatagory);
                }
                this.vecListCmd.removeAllElements();
                break;
            case 54:
                MainItem mainItem32 = (MainItem) Item.VecInvetoryPlayer.elementAt(this.idSelect);
                if (mainItem32 != null) {
                    TabRebuildItem.itemRe = mainItem32;
                    GlobalService.m14gI().Hop_rac((byte) 0, (short) mainItem32.f58Id, (byte) mainItem32.ItemCatagory);
                }
                this.vecListCmd.removeAllElements();
                break;
            case 55:
                this.inputDialog = new InputDialog();
                this.inputDialog.setinfo(new String[]{C0002T.nhapgiaban, C0002T.soluong}, this.cmdDaugia, (short) -1, (short) 0, C0002T.daugia);
                GameCanvas.currentDialog = this.inputDialog;
                break;
            case 56:
                this.currentTab = (byte) (this.currentTab + 1);
                if (this.currentTab > maxTab - 1) {
                    this.currentTab = (byte) 0;
                }
                if (!GameCanvas.isTouch) {
                    if (this.currentTab == 0) {
                        this.idSelect = 0;
                    }
                    if (this.currentTab == 1) {
                        this.idSelect = 42;
                        break;
                    }
                }
                break;
            case 57:
                MainItem mainItem33 = (MainItem) mvector.elementAt(this.idSelect);
                if (mainItem33 != null) {
                    GlobalService.m14gI().DoKhacItem((byte) 6, (byte) mainItem33.ItemCatagory, (short) mainItem33.f58Id);
                    break;
                }
                break;
        }
    }

    public mVector doMenu(Item item) {
        Item item2;
        mVector mvector = new mVector("TabShopNew menu7");
        if (this.typeTab == 9) {
            maxTab = (byte) (Player.maxChest / 42);
            if (maxTab == 1 && Item.VecChestPlayer.size() > 42) {
                maxTab = (byte) 2;
            }
        }
        if (this.typeTab == 0) {
            maxTab = (byte) (Player.maxInven / 42);
        }
        if (this.typeTab != 8 && maxTab > 1) {
            mvector.addElement(this.cmdNextInven);
        }
        if (this.isTypeShop == SHOP_NANG_CAP_MEDEL) {
            mvector.addElement(this.cmdHopAn);
            return mvector;
        }
        if (this.isTypeShop == SHOP_HOP_AN) {
            return mvector;
        }
        if (this.isTypeShop == SHOP_NANG_CAP_MEDEL) {
            return mvector;
        }
        if (GameScreen.player.isSelling()) {
            mvector.addElement(this.cmdNghiban);
            mvector.addElement(this.cmdChatWorld);
            return mvector;
        }
        if (this.isTypeShop == SHOP_STORE_OTHER_PLAYER) {
            mvector.addElement(this.cmdBuyItemOtherplayer);
            return mvector;
        }
        if (this.typeTab == 15) {
            mvector.addElement(this.cmdHoanThanh);
            mvector.addElement(this.cmdhuy);
            return mvector;
        }
        if (this.typeTab == 16) {
            if (Item.VecItemSell.size() > 0) {
                for (int i = 0; i < Item.VecItemSell.size(); i++) {
                    if (((MainItem) Item.VecItemSell.elementAt(i)).f58Id == item.f58Id) {
                        return mvector;
                    }
                }
            }
            if (item.ItemCatagory == 3) {
                mvector.addElement(this.cmdHoidaugia);
            } else {
                mvector.addElement(this.cmdbanNguyenLieu);
            }
        } else if (this.typeTab == 0 && !this.isShop_Other_Player) {
            if (this.isTypeShop == SHOP_STORE_OTHER_PLAYER) {
                mvector.addElement(this.cmdBuyItemOtherplayer);
            } else if (this.isTypeShop == SHOP_DUC_LO) {
                if (item.ItemCatagory == 7 && item.typeMaterial == Item.TYPE_BUA_HUYEN_BI) {
                    mvector.addElement(this.cmdBovao);
                }
                if (item.ItemCatagory == 3) {
                    mvector.addElement(this.cmdDuclo);
                }
            } else if (this.isTypeShop == SHOP_ANY_NGUYEN_LIEU) {
                if (item.ItemCatagory == 7) {
                    if (TabRebuildItem.vecGem.size() > 0 && ((MainItem) TabRebuildItem.vecGem.elementAt(0)).f58Id == item.f58Id) {
                        mvector.addElement(this.cmdlayracra);
                        return mvector;
                    }
                    mvector.addElement(this.cmdHoprac);
                }
            } else if (this.isTypeShop == SHOP_GHEP_NGOC) {
                if (item.ItemCatagory == 7 && item.typeMaterial == Item.TYPE_NGOC_KHAM) {
                    if (!TabRebuildItem.isKham(item)) {
                        mvector.addElement(this.cmdGhepNgoc);
                    }
                    if (TabRebuildItem.isKham(item)) {
                        mvector.addElement(this.cmdLayra);
                    }
                }
            } else if (this.isTypeShop == SHOP_KHAM_NGOC) {
                if (item.ItemCatagory == 3) {
                    if (!isTabHopNL && (TabRebuildItem.itemRe == null || TabRebuildItem.itemRe.f58Id != item.f58Id || TabRebuildItem.itemRe.ItemCatagory != item.ItemCatagory)) {
                        mvector.addElement(this.cmdKhamgoc);
                    }
                } else if (item.ItemCatagory == 7 && item.typeMaterial == 49) {
                    mvector.addElement(this.cmdBovao);
                    if (TabRebuildItem.isKham(item)) {
                        mvector.addElement(this.cmdLayra);
                    }
                }
            } else if (this.isTypeShop == INVEN_AND_REBUILD) {
                if (item.ItemCatagory == 3) {
                    if (!isTabHopNL) {
                        if (TabRebuildItem.itemRe == null || TabRebuildItem.itemRe.f58Id != item.f58Id || TabRebuildItem.itemRe.ItemCatagory != item.ItemCatagory) {
                            mvector.addElement(this.cmdRebuild);
                        } else {
                            mvector.addElement(this.cmdUnRebuild);
                        }
                    }
                } else if (item.ItemCatagory == 7) {
                    if (item.typeMaterial == 11) {
                        if (!isTabHopNL) {
                            if (!TabRebuildItem.isLucky) {
                                TabRebuildItem.itemDaMayMan = item;
                                mvector.addElement(this.cmdRebuild);
                            } else {
                                mvector.addElement(this.cmdUnRebuild);
                            }
                        }
                    } else if (MainObject.isMaHopNguyenLieu((short) item.f58Id) && isTabHopNL) {
                        if (TabRebuildItem.itemRe == null || TabRebuildItem.itemRe.f58Id != item.f58Id || TabRebuildItem.itemRe.ItemCatagory != item.ItemCatagory) {
                            mvector.addElement(this.cmdHopNguyeLieu);
                        } else {
                            mvector.addElement(this.cmdUnRebuild);
                        }
                    }
                }
            } else if (this.isTypeShop == INVEN_AND_REPLACE) {
                if (item.ItemCatagory == 3) {
                    mvector.addElement(this.cmdReplace);
                }
            } else if (this.isTypeShop == INVEN_AND_CHEST) {
                if (item.ItemCatagory != 5) {
                    if (item.ItemCatagory == 4 || item.ItemCatagory == 7) {
                        mvector.addElement(this.cmdSetPotionChest);
                    } else {
                        mvector.addElement(this.cmdSetChest);
                    }
                }
            } else if (this.isTypeShop == INVEN_AND_PET_KEEPER) {
                if (item.ItemCatagory == 3 && item.type_Only_Item == 14) {
                    mvector.addElement(this.cmdDepositPet);
                }
            } else if (this.isTypeShop == INVEN_AND_WING) {
                if (item.ItemCatagory == 3 && item.type_Only_Item == 7) {
                    mvector.addElement(this.cmdWing);
                }
            } else if (this.isTypeShop == INVEN_FOOD_PET) {
                mvector.addElement(this.cmdFoodPet);
            } else {
                if (GameCanvas.currentScreen == GameCanvas.shopNpc && item.canSell == 1) {
                    mvector.addElement(this.cmdHoiSell);
                    if (item.ItemCatagory == 3) {
                        mvector.addElement(this.cmdSellMore);
                    }
                }
                if (GameCanvas.currentScreen != GameCanvas.shopNpc) {
                    mvector.addElement(this.cmdSelect);
                    if (item.ItemCatagory == 4 && item.typePotion < 2) {
                        mvector.addElement(this.cmdSetKey);
                    }
                }
                if (GameCanvas.currentScreen == GameCanvas.AllInfo) {
                    mvector.addElement(this.cmdHoiXoaItem);
                }
            }
        } else if (this.typeTab == 9) {
            if (item.ItemCatagory == 4 || item.ItemCatagory == 7) {
                mvector.addElement(this.cmdGetPotionChest);
            } else {
                mvector.addElement(this.cmdGetChest);
            }
        } else if (this.typeTab != 15) {
            if (this.typeTab == 13) {
                if (this.isTypeShop == INVEN_AND_PET_KEEPER && item.ItemCatagory == 9) {
                    mvector.addElement(this.cmdPetFeed);
                    mvector.addElement(this.cmdWithdrawPet);
                }
            } else if (this.typeTab == 12) {
                mvector.addElement(this.cmdSelect);
            } else {
                this.cmdHoiMua.caption = C0002T.buy;
                if (this.IDTab == ReadMessenge.SHOP_ITEM_EVENT) {
                    this.cmdHoiMua.caption = this.nameCmdBuy;
                }
                if (item.ItemCatagory == 6 && item.priceItem <= 0) {
                    this.cmdHoiMua.caption = C0002T.use;
                }
                if (this.isTypeShop == WING) {
                    mvector.addElement(this.cmdCreateWing);
                } else if (this.isTypeShop != SHOP_VANTIEU && !this.isShop_Other_Player && ((item2 = (Item) this.vecShop.elementAt(this.idSelect)) != null || !item2.setNameNull())) {
                    if (item2.ItemCatagory == 4 || item2.ItemCatagory == 7) {
                        mvector.addElement(this.cmdMua1);
                        mvector.addElement(this.cmdMua10);
                        mvector.addElement(this.cmdMua30);
                        mvector.addElement(this.cmdMuaNhieu);
                    } else {
                        mvector.addElement(this.cmdHoiMua);
                    }
                }
                if (this.isTypeShop == SHOP_BANG) {
                    this.cmdHoiMua.caption = C0002T.select;
                    mvector.addElement(this.cmdNextIcon);
                }
            }
        }
        if (this.typeTab == 0) {
            mvector.addElement(this.cmdKhacItem);
        }
        return mvector;
    }

    @Override // Model.AvMain
    public void paint(mGraphics mgraphics) {
        mVector mvector;
        item_sell item_sellVar;
        if (this.typeTab == 15) {
            mvector = Item.VecItemSell;
        } else if (this.typeTab == 0 || this.typeTab == 16) {
            mvector = Item.VecInvetoryPlayer;
        } else if (this.typeTab == 9) {
            mvector = Item.VecChestPlayer;
        } else if (this.typeTab == 13) {
            mvector = Item.VecPetContainer;
        } else if (this.typeTab == 12) {
            mvector = Item.VecClanInvetory;
        } else {
            mvector = this.vecShop;
        }
        GameCanvas.resetTrans(mgraphics);
        mgraphics.setClip(this.xBegin - MainTabNew.wOne5, this.yBegin, MainTabNew.wblack + (MainTabNew.wOne5 * 2), (MainTabNew.hblack - (MainTabNew.wOne5 / 2)) + 1);
        mgraphics.saveCanvas();
        mgraphics.ClipRec(this.xBegin - MainTabNew.wOne5, this.yBegin, MainTabNew.wblack + (MainTabNew.wOne5 * 2), (MainTabNew.hblack - (MainTabNew.wOne5 / 2)) + 1);
        mgraphics.translate(-MainScreen.cameraSub.xCam, -MainScreen.cameraSub.yCam);
        int size = mvector.size();
        if (size > 42) {
            size = 42;
        }
        if (this.isShop) {
            size = this.vecShop.size();
        }
        int i = size * this.currentTab;
        for (int i2 = 0; i2 < size; i2++) {
            Item item = (Item) mvector.elementAt(i2 + i);
            if (item != null) {
                if (item.ItemCatagory == 7) {
                    MainItem material = Item.getMaterial(item.f58Id);
                    if (material != null) {
                        item.setinfo(material.itemName, material.imageId, 7, item.priceItem, item.priceType, material.content, (short) material.value, material.typeMaterial, (short) 1, material.canSell, material.canTrade);
                        item.setColorName(material.colorNameItem);
                        item.paintItem(mgraphics, this.xBegin + (MainTabNew.wOneItem / 2) + ((i2 % this.numW) * MainTabNew.wOneItem), this.yBegin + (MainTabNew.wOneItem / 2) + ((i2 / this.numW) * MainTabNew.wOneItem), MainTabNew.wOneItem, 0, 0);
                    } else {
                        Item.put_Material(item.f58Id);
                    }
                } else {
                    item.paintItem(mgraphics, this.xBegin + (MainTabNew.wOneItem / 2) + ((i2 % this.numW) * MainTabNew.wOneItem), this.yBegin + (MainTabNew.wOneItem / 2) + ((i2 / this.numW) * MainTabNew.wOneItem), MainTabNew.wOneItem, 0, 0);
                }
                if (item.timeUse > 0) {
                    mgraphics.drawRegion(AvMain.imgDelaySkill, 0, 0, MainTabNew.wOneItem - 1, MainTabNew.wOneItem - 1, 0, this.xBegin + (MainTabNew.wOneItem / 2) + ((i2 % this.numW) * MainTabNew.wOneItem), this.yBegin + (MainTabNew.wOneItem / 2) + ((i2 / this.numW) * MainTabNew.wOneItem), 3, true);
                }
                if (this.typeTab == 16 && !GameScreen.player.isSelling() && Item.VecItemSell.size() > 0) {
                    for (int i3 = 0; i3 < Item.VecItemSell.size(); i3++) {
                        if (((MainItem) Item.VecItemSell.elementAt(i3)).f58Id == item.f58Id) {
                            mgraphics.setColor(-2737107);
                            mgraphics.drawRect((((this.xBegin + (MainTabNew.wOneItem / 2)) + ((i2 % this.numW) * MainTabNew.wOneItem)) - (MainTabNew.wOneItem / 2)) + 4, (((this.yBegin + (MainTabNew.wOneItem / 2)) + ((i2 / this.numW) * MainTabNew.wOneItem)) - (MainTabNew.wOneItem / 2)) + 4, MainTabNew.wOneItem - 8, MainTabNew.wOneItem - 8, true);
                        }
                    }
                }
                if (this.isTypeShop == SHOP_NANG_CAP_MEDEL || this.isTypeShop == SHOP_ANY_NGUYEN_LIEU || this.isTypeShop == SHOP_KHAM_NGOC || this.isTypeShop == SHOP_GHEP_NGOC || this.isTypeShop == SHOP_DUC_LO) {
                    if (TabRebuildItem.itemRe != null && item.f58Id == TabRebuildItem.itemRe.f58Id && item.ItemCatagory == TabRebuildItem.itemRe.ItemCatagory) {
                        mgraphics.setColor(-397307);
                        mgraphics.drawRect((((this.xBegin + (MainTabNew.wOneItem / 2)) + ((i2 % this.numW) * MainTabNew.wOneItem)) - (MainTabNew.wOneItem / 2)) + 4, (((this.yBegin + (MainTabNew.wOneItem / 2)) + ((i2 / this.numW) * MainTabNew.wOneItem)) - (MainTabNew.wOneItem / 2)) + 4, MainTabNew.wOneItem - 8, MainTabNew.wOneItem - 8, true);
                    }
                    if (TabRebuildItem.vecGem.size() > 0) {
                        for (int i4 = 0; i4 < TabRebuildItem.vecGem.size(); i4++) {
                            MainItem mainItem = (MainItem) TabRebuildItem.vecGem.elementAt(i4);
                            mgraphics.setColor(-397307);
                            if (mainItem != null && ((item.typeMaterial == Item.TYPE_NGOC_KHAM || item.typeMaterial == Item.TYPE_BUA_HUYEN_BI || this.isTypeShop == SHOP_ANY_NGUYEN_LIEU) && item.f58Id == mainItem.f58Id && item.ItemCatagory == mainItem.ItemCatagory)) {
                                mgraphics.drawRect((((this.xBegin + (MainTabNew.wOneItem / 2)) + ((i2 % this.numW) * MainTabNew.wOneItem)) - (MainTabNew.wOneItem / 2)) + 4, (((this.yBegin + (MainTabNew.wOneItem / 2)) + ((i2 / this.numW) * MainTabNew.wOneItem)) - (MainTabNew.wOneItem / 2)) + 4, MainTabNew.wOneItem - 8, MainTabNew.wOneItem - 8, true);
                            }
                        }
                    }
                } else if (this.isTypeShop == INVEN_AND_REBUILD) {
                    if (TabRebuildItem.itemRe != null && ((item.f58Id == TabRebuildItem.itemRe.f58Id && item.ItemCatagory == TabRebuildItem.itemRe.ItemCatagory) || (item.ItemCatagory == 7 && item.typeMaterial == 11 && TabRebuildItem.isLucky))) {
                        mgraphics.setColor(-397307);
                        mgraphics.drawRect((((this.xBegin + (MainTabNew.wOneItem / 2)) + ((i2 % this.numW) * MainTabNew.wOneItem)) - (MainTabNew.wOneItem / 2)) + 4, (((this.yBegin + (MainTabNew.wOneItem / 2)) + ((i2 / this.numW) * MainTabNew.wOneItem)) - (MainTabNew.wOneItem / 2)) + 4, MainTabNew.wOneItem - 8, MainTabNew.wOneItem - 8, true);
                    }
                } else if (this.isTypeShop == INVEN_AND_REPLACE) {
                    if (TabRebuildItem.itemFree != null && item.f58Id == TabRebuildItem.itemFree.f58Id && item.ItemCatagory == TabRebuildItem.itemFree.ItemCatagory) {
                        mgraphics.setColor(-397307);
                        mgraphics.drawRect((((this.xBegin + (MainTabNew.wOneItem / 2)) + ((i2 % this.numW) * MainTabNew.wOneItem)) - (MainTabNew.wOneItem / 2)) + 4, (((this.yBegin + (MainTabNew.wOneItem / 2)) + ((i2 / this.numW) * MainTabNew.wOneItem)) - (MainTabNew.wOneItem / 2)) + 4, MainTabNew.wOneItem - 8, MainTabNew.wOneItem - 8, true);
                    }
                    if (TabRebuildItem.itemPlus != null && item.f58Id == TabRebuildItem.itemPlus.f58Id && item.ItemCatagory == TabRebuildItem.itemPlus.ItemCatagory) {
                        mgraphics.setColor(-2737107);
                        mgraphics.drawRect((((this.xBegin + (MainTabNew.wOneItem / 2)) + ((i2 % this.numW) * MainTabNew.wOneItem)) - (MainTabNew.wOneItem / 2)) + 4, (((this.yBegin + (MainTabNew.wOneItem / 2)) + ((i2 / this.numW) * MainTabNew.wOneItem)) - (MainTabNew.wOneItem / 2)) + 4, MainTabNew.wOneItem - 8, MainTabNew.wOneItem - 8, true);
                    }
                } else if (this.isTypeShop == INVEN_AND_WING && TabRebuildItem.itemWing != null && item.f58Id == TabRebuildItem.itemWing.f58Id && item.ItemCatagory == TabRebuildItem.itemWing.ItemCatagory) {
                    mgraphics.setColor(-397307);
                    mgraphics.drawRect((((this.xBegin + (MainTabNew.wOneItem / 2)) + ((i2 % this.numW) * MainTabNew.wOneItem)) - (MainTabNew.wOneItem / 2)) + 4, (((this.yBegin + (MainTabNew.wOneItem / 2)) + ((i2 / this.numW) * MainTabNew.wOneItem)) - (MainTabNew.wOneItem / 2)) + 4, MainTabNew.wOneItem - 8, MainTabNew.wOneItem - 8, true);
                }
                if (item.ItemCatagory == 4 && item.typePotion < 2 && this.typeTab == 0 && Player.timeDelayPotion[item.typePotion].value > 0) {
                    mgraphics.drawRegion(AvMain.imgDelaySkill, 0, 0, MainTabNew.wOneItem - 1, MainTabNew.wOneItem - 1, 0, this.xBegin + (MainTabNew.wOneItem / 2) + ((i2 % this.numW) * MainTabNew.wOneItem), this.yBegin + (MainTabNew.wOneItem / 2) + ((i2 / this.numW) * MainTabNew.wOneItem), 3, false);
                }
            }
        }
        mgraphics.setColor(MainTabNew.color[1]);
        mgraphics.drawRect(this.xBegin, this.yBegin, MainTabNew.wblack, MainTabNew.wOneItem * this.numH, true);
        for (int i5 = 0; i5 < this.numW / 2; i5++) {
            mgraphics.drawRect(this.xBegin + MainTabNew.wOneItem + (i5 * MainTabNew.wOneItem * 2), this.yBegin, MainTabNew.wOneItem, MainTabNew.wOneItem * this.numH, true);
        }
        for (int i6 = 0; i6 < this.numH / 2; i6++) {
            mgraphics.drawRect(this.xBegin, this.yBegin + MainTabNew.wOneItem + (i6 * MainTabNew.wOneItem * 2), MainTabNew.wblack, MainTabNew.wOneItem, true);
        }
        if (this.idSelect > -1 && MainTabNew.Focus == 1) {
            mgraphics.setColor(MainTabNew.color[2]);
            mgraphics.drawRect(this.xBegin + (((this.idSelect - (this.currentTab * 42)) % this.numW) * MainTabNew.wOneItem) + 1, this.yBegin + (((this.idSelect - (this.currentTab * 42)) / this.numW) * MainTabNew.wOneItem) + 1, MainTabNew.wOneItem - 2, MainTabNew.wOneItem - 2, true);
            mgraphics.setColor(MainTabNew.color[3]);
            mgraphics.drawRect(this.xBegin + (((this.idSelect - (this.currentTab * 42)) % this.numW) * MainTabNew.wOneItem), this.yBegin + (((this.idSelect - (this.currentTab * 42)) / this.numW) * MainTabNew.wOneItem), MainTabNew.wOneItem, MainTabNew.wOneItem, true);
        }
        mGraphics.resetTransAndroid(mgraphics);
        mgraphics.restoreCanvas();
        mgraphics.endClip();
        if (!GameCanvas.menu2.isShowMenu && GameCanvas.currentDialog == null && GameCanvas.subDialog == null && MainTabNew.Focus == 1 && MainTabNew.timePaintInfo > MainTabNew.timeRequest) {
            paintPopupContent(mgraphics, false);
            if (this.vecListCmd != null) {
                for (int i7 = 0; i7 < this.vecListCmd.size(); i7++) {
                    iCommand icommand = (iCommand) this.vecListCmd.elementAt(i7);
                    icommand.paint(mgraphics, icommand.xCmd, icommand.yCmd);
                }
            }
        }
        if (GameScreen.help.Step >= 0) {
            Item item2 = null;
            if (this.idSelect > -1 && MainTabNew.Focus == 1) {
                item2 = (Item) mvector.elementAt(this.idSelect);
            }
            if (!GameCanvas.menu2.isShowMenu && GameCanvas.currentDialog == null && GameCanvas.subDialog == null) {
                GameScreen.help.itemTabHelp(mgraphics, item2, this.typeTab);
            }
        }
        if (!GameCanvas.isSmallScreen && this.isTypeShop == TOC) {
            Item item3 = null;
            if (this.idSelect > -1 && MainTabNew.Focus == 1) {
                item3 = (Item) mvector.elementAt(this.idSelect);
            }
            int i8 = GameScreen.player.hair;
            if (item3 != null) {
                i8 = item3.imageId;
            }
            paintHairShop(mgraphics, i8);
        }
        if (!GameScreen.player.isSelling() && this.typeTab == 15 && this.idSelect >= 0 && this.idSelect < Item.VecItem_Sell_in_store.size() && (item_sellVar = (item_sell) Item.VecItem_Sell_in_store.elementAt(this.idSelect)) != null) {
            mFont.tahoma_7_yellow.drawString(mgraphics, new StringBuffer().append(C0002T.price).append(": ").append(MainItem.getDotNumber(item_sellVar.price)).append(" ").append(C0002T.coin).toString(), this.xBegin, this.yBegin + (MainTabNew.wOneItem * 6), 0, false);
        }
    }

    @Override // InterfaceComponents.MainTabNew, Model.AvMain
    public void update() {
        mVector mvector;
        if (this.typeTab != NORMAL && this.typeTab != 16 && this.typeTab != 9 && this.typeTab != 13 && this.currentTab != 0) {
            this.currentTab = (byte) 0;
        }
        if (GameScreen.help.Step > 0) {
            GameScreen.help.updateHelp();
        }
        if (MainTabNew.Focus == 1) {
            if (this.listContent != null) {
                this.listContent.moveCamera();
            }
            if (GameCanvas.isTouch) {
                this.list.moveCamera();
            } else {
                MainScreen.cameraSub.UpdateCamera();
            }
            if (this.typeTab == 15) {
                mvector = Item.VecItemSell;
            } else if (this.typeTab == 0 || this.typeTab == 16) {
                mvector = Item.VecInvetoryPlayer;
            } else if (this.typeTab == 9) {
                mvector = Item.VecChestPlayer;
            } else if (this.typeTab == 12) {
                mvector = Item.VecClanInvetory;
            } else {
                mvector = this.vecShop;
            }
            if (mvector.size() == 0) {
                MainTabNew.Focus = (byte) 0;
                return;
            }
            if (this.idSelect >= mvector.size()) {
                if (GameCanvas.isTouch) {
                    this.idSelect = -1;
                    this.vecListCmd = null;
                } else {
                    this.idSelect = mvector.size() - 1;
                }
            }
            if (this.typeTab != SHOP_BANG) {
                updateContent(mvector, this.idSelect);
            }
        } else {
            MainTabNew.timePaintInfo = 0;
        }
        if (this.currentTab == 0 && this.idSelect > 42 && !this.isShop) {
            this.idSelect = -1;
        }
    }

    public void updateContent(mVector mvector, int i) {
        if (MainTabNew.timePaintInfo < MainTabNew.timeRequest + 2) {
            MainTabNew.timePaintInfo++;
            if (MainTabNew.timePaintInfo == MainTabNew.timeRequest) {
                setPaintInfo();
            }
        }
        if (this.mContent == null && i >= 0 && i < mvector.size()) {
            Item item = (Item) mvector.elementAt(i);
            if (item.ItemCatagory != 5) {
                if (item.mcontent == null) {
                    if (item.timeupdateMore % 100 == 3) {
                        if (this.typeTab == 0 || this.typeTab == 16) {
                            GlobalService.m14gI().Item_More_Info((byte) 0, (byte) item.f58Id);
                        }
                        item.timeupdateMore++;
                        return;
                    }
                    item.timeupdateMore++;
                    return;
                }
                this.moreInfoconten = item.moreContenGem;
                this.mContent = item.mcontent;
                this.mcolor = item.mColor;
                setYCon(item);
            }
        }
    }

    @Override // Model.AvMain
    public void updatekey() {
        mVector mvector;
        if (this.typeTab == 15) {
            mvector = Item.VecItemSell;
        } else if (this.typeTab == 0 || this.typeTab == 16) {
            mvector = Item.VecInvetoryPlayer;
        } else if (this.typeTab == 9) {
            mvector = Item.VecChestPlayer;
        } else if (this.typeTab == 12) {
            mvector = Item.VecClanInvetory;
        } else {
            mvector = this.vecShop;
        }
        if (MainTabNew.Focus == 1) {
            int i = this.idSelect;
            boolean z = false;
            if (this.listContent != null) {
                if (GameCanvas.keyMyHold[2]) {
                    if (this.listContent.cmtoX > 0) {
                        this.listContent.cmtoX -= GameCanvas.hText;
                    } else {
                        this.listContent.cmtoX = 0;
                    }
                    GameCanvas.clearKeyHold(2);
                } else if (GameCanvas.keyMyHold[8]) {
                    if (this.listContent.cmtoX < this.listContent.cmxLim) {
                        this.listContent.cmtoX += GameCanvas.hText;
                    } else {
                        this.listContent.cmtoX = this.listContent.cmxLim;
                    }
                    GameCanvas.clearKeyHold(8);
                }
            } else if (GameCanvas.keyMyHold[2]) {
                this.idSelect -= this.numW;
                GameCanvas.clearKeyHold(2);
                z = true;
            } else if (GameCanvas.keyMyHold[8]) {
                this.idSelect += this.numW;
                GameCanvas.clearKeyHold(8);
                z = true;
            }
            if (GameCanvas.keyMyHold[4]) {
                if (this.idSelect % this.numW == 0 && this.currentTab == 0) {
                    MainTabNew.Focus = (byte) 0;
                } else {
                    this.idSelect--;
                }
                if (this.currentTab == 1 && this.idSelect == 41) {
                    this.currentTab = (byte) (this.currentTab - 1);
                }
                if (this.currentTab == 2 && this.idSelect == 82) {
                    this.currentTab = (byte) (this.currentTab - 1);
                }
                GameCanvas.clearKeyHold(4);
                z = true;
            } else if (GameCanvas.keyMyHold[6]) {
                this.idSelect++;
                GameCanvas.clearKeyHold(6);
                if (maxTab > 1 && this.idSelect > 0 && this.idSelect % 42 == 0) {
                    this.currentTab = (byte) (this.currentTab + 1);
                    if (this.currentTab > maxTab - 1) {
                        this.currentTab = (byte) 0;
                        this.idSelect = 0;
                    }
                }
                z = true;
            }
            if (z) {
                this.listContent = null;
                this.idSelect = resetSelect(this.idSelect, mvector.size() - 1, false);
                if (!GameCanvas.isTouch && (this.typeTab == 0 || this.typeTab == 16 || this.typeTab == 9 || this.typeTab == 15)) {
                    this.center = this.cmdMenuInven;
                }
                TabScreenNew.timeRepaint = 10;
            }
            if (i != this.idSelect) {
                MainScreen.cameraSub.moveCamera(0, ((this.idSelect / this.numW) - 1) * MainTabNew.wOneItem);
                MainTabNew.timePaintInfo = 0;
            }
        }
        super.updatekey();
    }

    @Override // InterfaceComponents.MainTabNew
    public void setPaintInfo() {
        mVector mvector;
        MainItem material;
        try {
            this.mContent = null;
            this.mSubContent = null;
            this.mPlusContent = null;
            if (this.typeTab == 15) {
                mvector = Item.VecItemSell;
            } else if (this.typeTab == 0 || this.typeTab == 16) {
                mvector = Item.VecInvetoryPlayer;
            } else if (this.typeTab == 9) {
                mvector = Item.VecChestPlayer;
            } else if (this.typeTab == 12) {
                mvector = Item.VecClanInvetory;
            } else {
                mvector = this.vecShop;
            }
            if (this.idSelect >= mvector.size() || this.idSelect < 0) {
                if (this.idSelect > mvector.size() - 1) {
                    this.idSelect = mvector.size() - 1;
                }
                MainTabNew.timePaintInfo = 0;
                return;
            }
            Item item = (Item) mvector.elementAt(this.idSelect);
            if (item != null && item.setNameNull()) {
                MainTabNew.timePaintInfo = 0;
                return;
            }
            if (item.ItemCatagory == 9) {
                MsgDialog.pet = (PetItem) item;
                this.isPet = true;
            } else {
                this.isPet = false;
            }
            this.name = item.itemName;
            this.colorName = item.colorNameItem;
            if (item.ItemCatagory == 7 && (material = Item.getMaterial(item.f58Id)) != null) {
                this.colorName = material.colorNameItem;
                if (this.typeTab == 15 && item.isSell) {
                    this.mPlusContent = item.mPlusContent;
                    this.mPlusColor = item.mPlusColor;
                }
            }
            this.moreInfoconten = item.moreContenGem;
            if (item.ItemCatagory == 3 || this.typeTab == 8) {
                this.mPlusContent = item.mPlusContent;
                this.mPlusColor = item.mPlusColor;
            }
            this.listContent = null;
            if (MainTabNew.longwidth > 0) {
                int i = 1;
                this.mContent = item.mcontent;
                this.mcolor = item.mColor;
                if (item.mcontent != null) {
                    i = 1 + this.mContent.length;
                }
                if (item.mPlusContent != null) {
                    i += item.mPlusContent.length;
                }
                if (i * GameCanvas.hText > MainTabNew.hMaxContent - this.hcmd) {
                    this.listContent = new ListNew(MainTabNew.xlongwidth, MainTabNew.ylongwidth, MainTabNew.longwidth, MainTabNew.hMaxContent, 0, 0, (i * GameCanvas.hText) - (MainTabNew.hMaxContent - this.hcmd));
                } else if (GameCanvas.isTouch) {
                    this.listContent = new ListNew(MainTabNew.xlongwidth, MainTabNew.ylongwidth, MainTabNew.longwidth, MainTabNew.hMaxContent, 0, 0, 0);
                }
                sosanh(item);
                return;
            }
            this.wContent = item.sizeW;
            setYCon(item);
            if (this.idSelect % this.numW < 2) {
                this.xCon = this.xBegin + (MainTabNew.wOneItem / 2) + ((this.idSelect % this.numW) * MainTabNew.wOneItem);
            } else if (this.idSelect % this.numW < 5) {
                this.xCon = ((this.xBegin + (MainTabNew.wOneItem / 2)) + ((this.idSelect % this.numW) * MainTabNew.wOneItem)) - (this.wContent / 2);
            } else {
                this.xCon = ((this.xBegin + (MainTabNew.wOneItem / 2)) + ((this.idSelect % this.numW) * MainTabNew.wOneItem)) - this.wContent;
            }
        } catch (Exception e) {
        }
    }

    public void setYCon(Item item) {
        int i = 0;
        if (MainScreen.cameraSub.yCam > 0) {
            i = MainScreen.cameraSub.yCam / MainTabNew.wOneItem;
        }
        int i2 = 1;
        this.mContent = item.mcontent;
        this.moreInfoconten = item.moreContenGem;
        this.mcolor = item.mColor;
        if (item.mcontent != null) {
            i2 = 1 + this.mContent.length;
        }
        if (item.mPlusContent != null) {
            i2 += item.mPlusContent.length;
        }
        if (this.idSelect / this.numW < (this.numHPaint / 2) + i) {
            this.yCon = this.yBegin + (((this.idSelect / this.numW) + 1) * MainTabNew.wOneItem) + 2;
            if ((this.yCon - MainScreen.cameraSub.yCam) + ((i2 + 1) * GameCanvas.hText) > GameCanvas.f181h - (GameCanvas.hCommand - 5)) {
                this.yCon = (GameCanvas.f181h - (GameCanvas.hCommand - 5)) - (((i2 + 1) * GameCanvas.hText) - MainScreen.cameraSub.yCam);
            }
        } else if (mSystem.isj2me) {
            int i3 = this.idSelect;
            if (this.currentTab > 0) {
                i3 -= 42;
            }
            this.yCon = this.yBegin + (((i3 / this.numW) + 1) * MainTabNew.wOneItem) + 2;
            if ((this.yCon - MainScreen.cameraSub.yCam) + ((i2 + 1) * GameCanvas.hText) > GameCanvas.f181h - (GameCanvas.hCommand - 5)) {
                this.yCon = (GameCanvas.f181h - (GameCanvas.hCommand - 5)) - (((i2 + 1) * GameCanvas.hText) - MainScreen.cameraSub.yCam);
            }
        } else {
            this.yCon = (((this.yBegin + (((this.idSelect / this.numW) + 1) * MainTabNew.wOneItem)) - 7) - (i2 * GameCanvas.hText)) - MainScreen.cameraSub.yCam;
            if (this.yCon - MainScreen.cameraSub.yCam < 6) {
                this.yCon = 6 + MainScreen.cameraSub.yCam;
            }
        }
        if (mSystem.isj2me && this.yCon >= GameCanvas.f181h / 4) {
            this.yCon = GameCanvas.f181h / 2;
        }
        if ((i2 + 1) * GameCanvas.hText > MainTabNew.hMaxContent - this.hcmd) {
            this.listContent = new ListNew(this.xCon, this.yCon, this.wContent, MainTabNew.hMaxContent, 0, 0, ((i2 + 1) * GameCanvas.hText) - (MainTabNew.hMaxContent - this.hcmd));
        }
        sosanh(item);
    }

    public void sosanh(Item item) {
        Item item2;
        if (this.typeTab == 0 && item.ItemCatagory == 3) {
            if ((item.classcharItem == 4 || item.classcharItem == GameScreen.player.clazz) && item.type_Only_Item < 12) {
                byte b = (byte) MainTemplateItem.mItem_Rotate_Tem_Equip[item.type_Only_Item];
                if (b == -1) {
                    int i = 0;
                    int i2 = 0;
                    Item item3 = (Item) Item.VecEquipPlayer.get("3");
                    Item item4 = (Item) Item.VecEquipPlayer.get("9");
                    if (item3 == null) {
                        item2 = item4;
                    } else if (item4 == null) {
                        item2 = item3;
                    } else {
                        for (int i3 = 0; i3 < item3.mInfo.length; i3++) {
                            i += item3.mInfo[i3].value;
                        }
                        for (int i4 = 0; i4 < item4.mInfo.length; i4++) {
                            i2 += item4.mInfo[i4].value;
                        }
                        if (i >= i2) {
                            item2 = item4;
                        } else {
                            item2 = item3;
                        }
                    }
                } else {
                    item2 = (Item) Item.VecEquipPlayer.get(new StringBuffer().append("").append((int) b).toString());
                }
                if (item2 != null && item2.type_Only_Item == item.type_Only_Item && this.mContent != null && item2.moreContenGem.size() <= 0) {
                    this.mSubContent = new String[this.mContent.length];
                    this.mSubColor = new int[this.mContent.length];
                    for (int i5 = 0; i5 < this.mSubContent.length; i5++) {
                        this.mSubContent[i5] = "";
                        this.mSubColor[i5] = 0;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= item2.mInfo.length) {
                                break;
                            }
                            if (item.mInfo[i5].f73id != item2.mInfo[i6].f73id) {
                                i6++;
                            } else {
                                int i7 = item.mInfo[i5].value - item2.mInfo[i6].value;
                                if (i7 >= 0) {
                                    this.mSubColor[i5] = 5;
                                    this.mSubContent[i5] = "+";
                                } else {
                                    this.mSubContent[i5] = "-";
                                    this.mSubColor[i5] = 6;
                                }
                                StringBuffer stringBuffer = new StringBuffer();
                                String[] strArr = this.mSubContent;
                                int i8 = i5;
                                strArr[i8] = stringBuffer.append(strArr[i8]).append(Item.getPercent(Item.isPercentInfoItem[item.mInfo[i5].f73id], CRes.abs(i7))).toString();
                                int width = mFont.tahoma_7_black.getWidth(new StringBuffer().append(new StringBuffer().append(Item.nameInfoItem[item.mInfo[i5].f73id]).append(": ").append(Item.getPercent(Item.isPercentInfoItem[item.mInfo[i5].f73id], item.mInfo[i5].value)).toString()).append(" ").append(this.mSubContent[i5]).toString());
                                if (this.wContent < width + 10) {
                                    this.wContent = width + 10;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // Model.AvMain
    public void updatePointer() {
        int size;
        boolean z = false;
        if (this.listContent != null && GameCanvas.isPoint(this.listContent.f152x, this.listContent.f153y, this.listContent.maxW, this.listContent.maxH)) {
            this.listContent.update_Pos_UP_DOWN();
            z = true;
        }
        if (GameCanvas.isTouch && !z) {
            this.list.update_Pos_UP_DOWN();
            MainScreen.cameraSub.yCam = this.list.cmx;
        }
        if (GameCanvas.isPointSelect(this.xBegin, this.yBegin, this.numW * MainTabNew.wOneItem, MainTabNew.hblack - (MainTabNew.wOne5 / 2)) && !z) {
            int i = ((GameCanvas.f184px - this.xBegin) / MainTabNew.wOneItem) + ((((GameCanvas.f185py - this.yBegin) + MainScreen.cameraSub.yCam) / MainTabNew.wOneItem) * this.numW);
            if (this.typeTab == 15) {
                size = Item.VecItemSell.size();
            } else if (this.typeTab == 0 || this.typeTab == 16) {
                size = Item.VecInvetoryPlayer.size();
            } else if (this.typeTab == 9) {
                size = Item.VecChestPlayer.size();
            } else if (this.typeTab == 12) {
                size = Item.VecClanInvetory.size();
            } else if (this.typeTab == 13) {
                size = Item.VecPetContainer.size();
            } else {
                size = this.vecShop.size();
            }
            if (i >= 0 && i < size) {
                GameCanvas.isPointerSelect = false;
                int i2 = this.idSelect;
                if (this.currentTab == 1) {
                    i2 -= 42;
                }
                if (i == i2) {
                    if (MainTabNew.longwidth == 0) {
                        if (this.typeTab == 0 || this.typeTab == 16 || this.typeTab == 9 || this.typeTab == 15 || this.typeTab == 12 || ((this.typeTab == 8 && this.isTypeShop == SHOP_BANG) || this.typeTab == 13)) {
                            this.cmdMenuInven.perform();
                        } else if (this.isTypeShop == WING) {
                            this.cmdCreateWing.perform();
                        } else {
                            this.cmdHoiMua.perform();
                        }
                    }
                } else {
                    MainTabNew.timePaintInfo = 0;
                    this.idSelect = i + (42 * this.currentTab);
                    if (this.currentTab == 0 && this.idSelect == 42) {
                        this.idSelect = -1;
                    }
                    if (this.currentTab == 1 && this.idSelect == 84) {
                        this.idSelect = -1;
                    }
                    if (this.currentTab == 3 && this.idSelect == 126) {
                        this.idSelect = -1;
                    }
                    if (this.isShop) {
                        this.idSelect = i;
                    }
                    cmdListBig();
                    this.listContent = null;
                }
                if (MainTabNew.Focus != 1) {
                    MainTabNew.Focus = (byte) 1;
                }
            } else {
                this.idSelect = -1;
                MainTabNew.timePaintInfo = 0;
                this.listContent = null;
            }
        }
        if (this.vecListCmd != null && MainTabNew.Focus == 1 && MainTabNew.timePaintInfo > MainTabNew.timeRequest) {
            for (int i3 = 0; i3 < this.vecListCmd.size(); i3++) {
                ((iCommand) this.vecListCmd.elementAt(i3)).updatePointer();
            }
        }
        super.updatePointer();
    }

    public void cmdListBig() {
        mVector mvector;
        if (MainTabNew.longwidth > 0 && GameCanvas.isTouch) {
            this.hcmd = 0;
            if (this.typeTab == 15) {
                mvector = Item.VecItemSell;
            } else if (this.typeTab == 0 || this.typeTab == 16) {
                mvector = Item.VecInvetoryPlayer;
            } else if (this.typeTab == 9) {
                mvector = Item.VecChestPlayer;
            } else {
                mvector = this.vecShop;
            }
            if (this.idSelect >= 0 && this.idSelect < mvector.size()) {
                this.vecListCmd = doMenu((Item) mvector.elementAt(this.idSelect));
                setPosCmd(this.vecListCmd);
                this.hcmd = ((this.vecListCmd.size() + 1) / 2) * iCommand.hButtonCmd;
            }
        }
    }

    public void setVecShop(mVector mvector) {
        this.vecShop.removeAllElements();
        this.vecShop = mvector;
    }
}
