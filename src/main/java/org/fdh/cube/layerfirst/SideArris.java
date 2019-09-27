package org.fdh.cube.layerfirst;

import org.fdh.cube.model.Colors;

/** 边块和角块的状态，读取颜色遵从优先级：上下>前后>左右，
 *  */
public class SideArris {
    public Colors[] WhiteRed=new Colors[]{Colors.白,Colors.红};
    public Colors[] RedWhite=new Colors[]{Colors.红,Colors.白};
    public Colors[] WhiteGreen=new Colors[]{Colors.白,Colors.绿};
    public Colors[] GreenWhite=new Colors[]{Colors.绿,Colors.白};
    public Colors[] WhiteBlue=new Colors[]{Colors.白,Colors.蓝};
    public Colors[] BlueWhite=new Colors[]{Colors.白,Colors.绿};
} 
