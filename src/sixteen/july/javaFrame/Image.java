package sixteen.july.javaframe;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2016/7/21
 * Time: 9:27
 */
public class Image {


    private String imgDir; // 处理图片的路径
    private int width; // 原始图片的宽度
    private int height; // 原始图片的高度
    private int countHeight[]; // 竖坐标上分割点的个数
    private int countWidth[]; // 横坐标上分割点的个数


    private int rBound[];
    private int gBound[];
    private int bBound[];


    public Image(String imgDir) {
        this.imgDir = imgDir;
        rBound = new int[2];
        gBound = new int[2];
        bBound = new int[2];
    }


    /*
    * 初始化操作
    */
    private BufferedImage init() {


        File file = new File(getImgDir());


        if (!file.exists()) {
            return null;
        }
        BufferedImage bufImg = null;
        try {
            bufImg = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }


        int height = bufImg.getHeight();
        int width = bufImg.getWidth();
        countHeight = new int[height];
        countWidth = new int[width];
        this.setWidth(width);
        this.setHeight(height);

        return bufImg;
    }


    /**
     * 功能说明： 切割图片
     *
     * @param cutDirection
     *            切割方向
     * @param scale
     *            像素点跟相对与宽度或者高度的倍数
     * @return
     */
    public String cutBigImg(boolean cutDirection, float scale)
            throws IOException {

        BufferedImage bufImg = init();
        if (null == bufImg) {
            return "处理失败!";
        }
        scanImgForGetCountHW(width, height, bufImg, cutDirection);


        Map<Integer, Integer> mapLine;
        mapLine = getImgSplitLine(cutDirection, scale);


        // for (int i = 1; i <= mapLine.size(); i++) {
        // System.out.println("mapline " + mapLine.get(i));
        // }


        if (null == mapLine) {
            return "处理失败！";
        }
        outputProcessedImg(bufImg, mapLine, cutDirection);


        return "切割成功!";
    }


    /**
     * 功能说明： 取得图片横向或者纵向上的点数
     *
     * @param width
     *            图片的宽度
     * @param height
     *            图片高度
     * @param bufImg
     *            图片在内存的缓存
     * @param scanDirection
     *            true:按横向扫描 false:按纵向扫描
     * @return
     */
    private int[][] scanImgForGetCountHW(int width, int height,
                                         BufferedImage bufImg, boolean scanDirection) {
        int result[][] = new int[width][height];
        int innerMax;
        int outerMax;
        if (scanDirection) {
            innerMax = width;
            outerMax = height;
        } else {
            innerMax = height;
            outerMax = width;
        }
        // 将在范围内的点存入数组中
        for (int i = 0; i < outerMax; i++) {
            for (int j = 0; j < innerMax; j++) {
                // 去除alpha通道的值即透明度的分量
                if (scanDirection) {
                    int pixel = bufImg.getRGB(j, i) & 0xFFFFFF;
                    result[j][i] = pixel;
                    if (getRGBBoolean(pixel)) {
                        countHeight[i] += 1;
                    }
                } else {
                    int pixel = bufImg.getRGB(i, j) & 0xFFFFFF;
                    result[i][j] = pixel;
                    if (getRGBBoolean(pixel)) {
                        countWidth[i] += 1;
                    }
                }


            }
        }


        return result;
    }


    /**
     *
     * @param pixel
     *            像素值
     *
     * @return 如果该像素在范围内怎返回true,否则返回false。
     */
    private boolean getRGBBoolean(int pixel) {
        int[] rgb = new int[3];
        rgb[0] = (pixel & 0xff0000) >> 16;
        rgb[1] = (pixel & 0xff00) >> 8;
        rgb[2] = (pixel & 0xff);
        // System.out.println("rgb 1: "+rgb[0]+" 2: "+rgb[1]+" 3: "+rgb[2]);
        return (rgb[0] > rBound[0] && rgb[0] < rBound[1] && rgb[1] > gBound[0]
                && rgb[1] < gBound[1] && rgb[2] > bBound[0] && rgb[2] < bBound[1]);
    }


    /**
     * 功能说明： 设置所取边界的rgb各个分量的范围
     *
     * @param rLower
     *            红色下界
     * @param rUpper
     *            红色上界
     * @param gLower
     *            绿色下界
     * @param gUpper
     *            绿色上界
     * @param bLower
     *            蓝色下界
     * @param bUpper
     *            蓝色上界
     */
    public void setCloseColorRGB(int rLower, int rUpper, int gLower,
                                 int gUpper, int bLower, int bUpper) {
        rBound[0] = rLower;
        rBound[1] = rUpper;
        gBound[0] = gLower;
        gBound[1] = gUpper;
        bBound[0] = bLower;
        bBound[1] = bUpper;
    }


    /**
     * 功能说明： 获取图片的切割线
     *
     * @param lineDirection
     *            true:取得每行匹配的像素数，false:取得每列匹配的像素数
     * @param scale
     *            scale的值小于1大于0
     * @return
     */
    private Map<Integer, Integer> getImgSplitLine(boolean lineDirection,
                                                  float scale) {
        Map<Integer, Integer> mapLine = new HashMap<Integer, Integer>();


        int preheight = 0, maxcount = 0, cnt = 0, length, boundary;
        int count[];


        if (lineDirection) {
            length = countHeight.length;
            count = countHeight;
            boundary = (int) (width * scale);
        } else {
            length = countWidth.length;
            count = countWidth;
            boundary = (int) (height * scale);
        }
        // System.out.println("boundary : "+boundary);
        // 剔除相邻的边界点,Map中存放的是可以做为边界区分的点
        for (int i = 1; i < length; i++) {
            // System.out.println("count ："+count[i]);
            if (count[i] > boundary) {
                if (preheight == i - 1) {
                    if (count[i] > maxcount) {
                        mapLine.put(cnt, i);
                        maxcount = count[i];
                    }
                } else {
                    cnt++;
                    // System.out.println("i : "+i);
                    mapLine.put(cnt, i);
                    maxcount = count[i];
                }
                preheight = i;
            }


        }


        return mapLine;
    }


    /**
     * 功能说明： 根据切割点，切割图片
     *
     * @param srcImg
     *            原图buff
     * @param mapLine
     *            切割线
     * @throws IOException
     */
    private void outputProcessedImg(BufferedImage srcImg,
                                    Map<Integer, Integer> mapLine, boolean direction)
            throws IOException {
        BufferedImage image = null;
        String fileName;
        File subfile;
        for (int i = 1; i <= mapLine.size(); i++) {
            if (i == 1) {
                if (direction) {
                    image = srcImg.getSubimage(0, 0, width,
                            (int) mapLine.get(i));
                } else {
                    image = srcImg.getSubimage(0, 0, (int) mapLine.get(i),
                            height);
                }
                fileName = "F:\\test\\map_" + i + ".jpg";
                subfile = new File(fileName);
                ImageIO.write(image, "JPEG", subfile);
            } else {
                int y = (int) mapLine.get(i - 1);
                int hei = mapLine.get(i) - mapLine.get(i - 1);
                if (direction) {
                    image = srcImg.getSubimage(0, y, width, hei);
                } else {
                    image = srcImg.getSubimage(y, 0, hei, height);
                }
                fileName = "F:\\test\\map_" + i + ".jpg";
                subfile = new File(fileName);
                ImageIO.write(image, "JPEG", subfile);
            }


        }
        System.out.println("test3");
    }


    public String getImgDir() {
        return imgDir;
    }


    public void setImgDir(String imgDir) {
        this.imgDir = imgDir;
    }


    public int getWidth() {
        return width;
    }


    public void setWidth(int width) {
        this.width = width;
    }


    public int getHeight() {
        return height;
    }


    public void setHeight(int height) {
        this.height = height;
    }


}