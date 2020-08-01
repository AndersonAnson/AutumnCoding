package swordToOffer;

public class RectCover {
    public int rectCover(int target) {
//    用递归 定义初始值 和递归出口
        if (target <= 2) {
            return target;
        } else {
            return rectCover(target - 1) + rectCover(target - 2);
        }
    }
}
